package pl.akademiaqa.api.bug;

import lombok.RequiredArgsConstructor;
import pl.akademiaqa.api.BaseRequest;
import pl.akademiaqa.dto.BugDto;
import pl.akademiaqa.handlers.bug.BugResponse;
import pl.akademiaqa.handlers.bug.UpdateBugResponse;
import pl.akademiaqa.url.JsonServerURLs;

import static io.restassured.RestAssured.given;

@RequiredArgsConstructor
public class UpdateBugRequest {

    private final BaseRequest baseRequest;

    public BugResponse updateBug(String bugId, BugDto bug) {
        return given()
                .spec(baseRequest.requestSetup())
                .body(bug)
                .when()
                .put(JsonServerURLs.getBugPath(bugId))
                .then()
                .statusCode(200)
                .log().ifError()
                .extract()
                .response()
                .as(UpdateBugResponse.class);
    }
}
