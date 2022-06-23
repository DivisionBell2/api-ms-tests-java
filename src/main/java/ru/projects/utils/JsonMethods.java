package ru.projects.utils;

import com.google.gson.*;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class JsonMethods {

    @Step("Assert body param {1}")
    public static String getResponseParam(Response httpResponce, String param) {
        JsonObject response = new Gson().fromJson(httpResponce.asString(), JsonObject.class);
        return response.get(param).getAsString();
    }

    static class Gen<T> {
        private T value = null;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }

    public static JsonObject responseToJson(String param) {
        JsonObject elementJson = null;
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(param);
        elementJson = new Gson().fromJson(element, JsonObject.class);
        return elementJson;
    }

    public static JsonArray responseToJsonArray(String param) {
        JsonArray elementArray = null;
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(param);
        elementArray = element.getAsJsonArray();
        return elementArray;
    }

    public static <T> Gen<?> isJson(String param) throws JsonIOException {
        try {
            Gen<JsonObject> jsonObjectGen;
            jsonObjectGen = new Gen<>();
            jsonObjectGen.setValue(responseToJson(param));
            return jsonObjectGen;
        } catch (JsonSyntaxException jsonSyntaxexception) {
            try {
                Gen<JsonArray> jsonArrayGen;
                jsonArrayGen = new Gen<>();
                jsonArrayGen.setValue(responseToJsonArray(param));
                return jsonArrayGen;
            } catch (JsonIOException jsonIOException) {
                System.out.print(jsonIOException.getMessage());
                return null;
            } catch (Exception exception) {
                System.out.print(exception.getMessage());
                return null;
            }
        } catch (JsonIOException ex1) {
            System.out.print("Syntax error");
            return null;
        }
    }

    public static boolean checkValidJson(String param) {
        return isJson(param) != null;
    }
}

