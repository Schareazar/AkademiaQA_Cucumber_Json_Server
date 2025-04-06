package pl.akademiaqa.api.employee;

import lombok.RequiredArgsConstructor;
import pl.akademiaqa.api.BaseRequest;
import pl.akademiaqa.dto.EmployeeDto;
import pl.akademiaqa.handlers.employee.EmployeeResponse;
import pl.akademiaqa.url.JsonServerURLs;

import static io.restassured.RestAssured.given;

@RequiredArgsConstructor
public class UpdateEmployeeRequest {

    private final BaseRequest baseRequest;

    public EmployeeResponse updateEmployee(String employeeId, EmployeeDto changedEmployee)
    {
        return
                given()
                        .spec(baseRequest.requestSetup())
                        .body(changedEmployee)
                        .when()
                        .put(JsonServerURLs.getEmployeePath(employeeId))
                        .then()
                        .statusCode(200)
                        .log().ifError()
                        .extract()
                        .response()
                        .as(EmployeeResponse.class);
    }

}
