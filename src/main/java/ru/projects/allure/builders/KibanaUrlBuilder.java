package ru.projects.allure.builders;

import io.restassured.RestAssured;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class KibanaUrlBuilder {

    private static String resultUrl = ""
            + "refreshInterval:(display:Off,pause:!f,value:0),\n"
            + "time:(from:'%s',to:'%s'))&_a=(columns:!(message,program,_id,_index),filters:!(),\n"
            + "index:AWBvZKJndU_4pJHJSc9C,interval:auto,query:(language:lucene,query:'program:ks8_%s'),sort:!(timestamp,desc))";

    public static String getUrl() {
        String url = RestAssured.baseURI;
        String serviceName = url.substring(url.lastIndexOf("/") + 1, url.indexOf("."));
        ZonedDateTime currentDateTime = ZonedDateTime.now().minusHours(3);
        ZonedDateTime from = currentDateTime.minusSeconds(2);
        ZonedDateTime to = currentDateTime.plusSeconds(2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        return String.format(resultUrl, from.format(formatter), to.format(formatter), serviceName);
    }
}
