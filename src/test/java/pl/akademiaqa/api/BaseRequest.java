package pl.akademiaqa.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import pl.akademiaqa.url.JsonServerURLs;

public class BaseRequest {

    public RequestSpecification requestSetup()
    {
        return new RequestSpecBuilder()
                .setBaseUri(JsonServerURLs.BASE_URL)
                .setContentType(ContentType.JSON)
                .build();
    }

}
