package ru.projects.helpers.assert_helper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static ru.projects.utils.JsonMethods.checkValidJson;

import com.fasterxml.classmate.types.ResolvedPrimitiveType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.imifou.jsonschema.module.addon.AddonModule;
import com.github.victools.jsonschema.generator.Option;
import com.github.victools.jsonschema.generator.OptionPreset;
import com.github.victools.jsonschema.generator.SchemaGenerator;
import com.github.victools.jsonschema.generator.SchemaGeneratorConfig;
import com.github.victools.jsonschema.generator.SchemaGeneratorConfigBuilder;
import com.github.victools.jsonschema.generator.SchemaVersion;
import com.github.victools.jsonschema.module.jackson.JacksonModule;
import com.github.victools.jsonschema.module.javax.validation.JavaxValidationModule;
import com.google.common.io.Files;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.validation.constraints.Null;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import ru.projects.entities.EntityData;
import ru.projects.providers.EntityProvider;
import ru.projects.utils.StringUtils;
import ru.yandex.qatools.allure.annotations.Parameter;
import ru.yandex.qatools.allure.annotations.Step;

public class AssertHelper {
    private static final Logger LOGGER = LogManager.getLogger(AssertHelper.class);

    @Step("Check response")
    public static void checkResponse(Response response, int... expCode) {
        checkResponse(response, ContentType.JSON, expCode);
    }

    @Step("Check response code")
    public static void checkResponse(Response response, @Parameter int expCode) {
        response.then().assertThat().statusCode(expCode);
    }

    public static void checkResponse(Response response, ContentType contentType, int... expCode) {
        LOGGER.debug("Asserting response code...");
        checkResponseCode(response, expCode);
        checkResponseContentType(response, contentType);
    }

    @Step("Check response code")
    public static void checkResponseCode(Response response, int... codes) {
        LOGGER.debug("Asserting response code...");
        Matcher[] arr = Arrays.stream(codes).mapToObj(Matchers::is).toArray(Matcher[]::new);
        response.then().assertThat().statusCode(Matchers.anyOf(arr));
    }

    @Step("Check response content type")
    public static void checkResponseContentType(Response response, @Parameter ContentType expectedContentType) {
        LOGGER.debug("Asserting response content type...");
        response.then().assertThat().contentType(expectedContentType);
    }

    @Deprecated
    public static void checkResponseJsonSchemaOld(Response response, Class<?> clazz) {
        LOGGER.debug("Asserting response json schema...");
        String expectedSchema = getJsonSchema(clazz, true);
        checkResponseJsonSchema(response, expectedSchema);
    }

    public static void checkResponseJsonSchema(Response response, Class<?> clazz) {
        LOGGER.debug("Asserting response json schema...");
        String expectedSchema = getJsonSchema(clazz, false);
        checkResponseJsonSchema(response, expectedSchema);
    }

    @Step("Check response matches json schema")
    public static void checkResponseJsonSchema(Response response, @Parameter String schema) {
        LOGGER.debug("Entity schema is:" + schema);
        response.then().assertThat().body(matchesJsonSchema(schema));
    }

    public static void checkResponseJsonSchema(Response response, File file) {
        LOGGER.debug("Asserting response json schema...");
        String expectedJsonSchema = null;
        try {
            expectedJsonSchema = Files.toString(file, Charset.defaultCharset());
        } catch (IOException e) {
            LOGGER.fatal(e.getMessage());
            e.printStackTrace();
        }
        checkResponseJsonSchema(response, expectedJsonSchema);
    }

    @Step("Check response code, json validity and json schema by class of response param")
    public static void checkAllResponseParams(Response response, int statusCode, Class<?> jsonSchema) {
        assertStatus(response, statusCode);
        assertJsonIsValid(response);
        checkResponseJsonSchema(response, jsonSchema);
    }

    @Step("Check URL is valid")
    public static void checkUrl(String url) {
        boolean isValid;

        LOGGER.debug("Try creating a valid URL");
        try {
            new URL(url).toURI();
            isValid = true;
            LOGGER.debug("Url is invalid");
        } catch (Exception e) {
            LOGGER.fatal("Url is invalid: ", e);
            isValid = false;
        }

        assertTrue(isValid, "URL is invalid");
    }

    public static <E extends EntityData> void compareDbObjectWithDto(EntityData data, Class<E> providerClass) {
        EntityProvider<E> provider = new EntityProvider<>(providerClass);
        E dtoObject = provider.getById(data.getId());
        Assert.assertEquals(dtoObject, data);
    }

    @Step("Assert response status")
    public static void assertStatus(Response response, @Parameter int respCode) {
        int code = response.getStatusCode();
        Assert.assertEquals(code, respCode, response.asString() + " Response code is wrong");
    }

    @Step("Assert response json is valid")
    public static void assertJsonIsValid(Response response) {
        boolean result = checkValidJson(response.asString());
        if (!result) {
            LOGGER.debug("Ошибка в методе assertJsonIsValid");
        }
        assertTrue(result, "Json is invalid " + response.asString());
    }

    @Step("Assert that entities are equal")
    public static <T extends EntityData> void assertEquals(@Parameter T fromResponse, @Parameter T fromBD) {
        if (!fromResponse.equals(fromBD)) {
            LOGGER.fatal("Assertion failed!");
            throw new AssertionError("Two entities are not equals. "
                    + StringUtils.getDifferenceBetweenEntities(fromResponse, fromBD));
        } else LOGGER.debug("assertion passed!");
    }

    @Step("Assert equals")
    public static <T> void assertEquals(@Parameter T expected, @Parameter T actual) {
        Assert.assertEquals(expected, actual, String.format(" %s, is not equal to %s", expected.toString(), actual.toString()));
    }

    @Step("{1}")
    public static void assertTrue(boolean condition, String msg) {
        Assert.assertTrue(condition, msg);
    }

    @Step("{1}")
    public static void assertFalse(boolean condition, String msg) {
        Assert.assertFalse(condition, msg);
    }

    @Step("Assert that string contains some text")
    public static void assertContains(String parameter, String text) {

        if (!parameter.toLowerCase().contains(text.toLowerCase())) {
            LOGGER.fatal("Assertion failed! " + parameter + " does not contain " + text);
            throw new AssertionError("Text is not the same");
        } else LOGGER.debug("Assertion passed! " + parameter + " contains " + text);
    }

    private static String getJsonSchema(Class<?> clazz, boolean isOld) {
        ObjectMapper objectMapper = new ObjectMapper();
        SchemaGeneratorConfigBuilder configBuilder = new SchemaGeneratorConfigBuilder(objectMapper,
                SchemaVersion.DRAFT_2019_09, OptionPreset.PLAIN_JSON);
        addNullToEnum(configBuilder);
        configBuilder.with(new AddonModule())
                .with(Option.NONSTATIC_NONVOID_NONGETTER_METHODS)
                .with(new JacksonModule())
                .with(new JavaxValidationModule());
        if (!isOld) {
            configBuilder.with(Option.FORBIDDEN_ADDITIONAL_PROPERTIES_BY_DEFAULT);
        }
        configBuilder.forMethods()
                .withIgnoreCheck(method -> method.getAnnotation(JsonProperty.class) == null)
                .withPropertyNameOverrideResolver(method -> method.getAnnotation(JsonProperty.class).value());
        SchemaGeneratorConfig config = configBuilder.build();
        SchemaGenerator generator = new SchemaGenerator(config);
        JsonNode jsonSchema = generator.generateSchema(clazz);
        return jsonSchema.toString().replaceAll("\\(\\)", "");
    }

    private static void addNullToEnum(SchemaGeneratorConfigBuilder configBuilder) {
        configBuilder.forFields().withTargetTypeOverridesResolver((field) -> {
            if (field.getType().getErasedType().isEnum()) {
                if (field.getAnnotation(Null.class) != null) {
                    return Stream.of(field.getType(), ResolvedPrimitiveType.all().get(0))
                            .map(specificSubtype -> field.getContext().resolve(specificSubtype))
                            .collect(Collectors.toList());
                }
            }
            return null;
        });
    }
}