package ru.projects.utils;

import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.util.Collection;
import java.util.Iterator;

import ru.projects.entities.EntityData;
import ru.projects.entities.JsonConverter;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringUtils {

    public static MapDifference<String, Object> getDifferenceBetweenEntities(EntityData entityData, EntityData entityData1) {
        Gson g = new Gson();
        Type mapType = new TypeToken<Map<String, Object>>() {
        }.getType();
        Map<String, Object> firstMap = g.fromJson(JsonConverter.toJsonString(entityData), mapType);
        Map<String, Object> secondMap = g.fromJson(JsonConverter.toJsonString(entityData1), mapType);
        return Maps.difference(firstMap, secondMap);
    }

    public static String sqlFormattedList(List<String> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("('");
        for (String i : list) {
            sb.append(i + "','");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append(")");
        return sb.toString();
    }
}
