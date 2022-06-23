package ru.projects.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.Arrays;

public class JsonConverter {

    public static <T> String toJsonString(T t, String... excludeField) {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(t.getClass(), new DefaultSerializer(t.getClass(), excludeField));
        objectMapper.registerModule(module);
        try {
            return objectMapper.writeValueAsString(t);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T fromJson(String jsonString, Class<T> clazz) {
        return new Gson().fromJson(jsonString, clazz);
    }

    public static class DefaultSerializer<T> extends StdSerializer<T> {
        private String[] fields;

        protected DefaultSerializer(Class<T> t, String... excludeField) {
            super(t);
            fields = excludeField;
        }

        @Override
        public void serialize(T t, JsonGenerator gen, SerializerProvider provider) throws IOException {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            JsonNode jsonNode = objectMapper.valueToTree(t);
            TreeNode treeNode = jsonNode;
            if (fields.length > 0) {
                if (jsonNode.isArray()) {
                    ArrayNode inputListNode = JsonNodeFactory.instance.arrayNode();
                    for (JsonNode objNode : jsonNode) {
                        ObjectNode jsonObject = (ObjectNode) objNode;
                        Arrays.stream(fields).forEach(jsonObject::remove);
                        inputListNode.add(jsonObject);
                    }
                    treeNode = inputListNode;
                } else if (jsonNode.isObject()) {
                    ObjectNode jsonObject = (ObjectNode) jsonNode;
                    Arrays.stream(fields).forEach(jsonObject::remove);
                    treeNode = jsonObject;
                }
            }
            gen.writeTree(treeNode);
        }
    }
}
