package pl.akademiaqa.cucumber.steps.employee;

import io.cucumber.java.en.When;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import pl.akademiaqa.api.context.Context;
import pl.akademiaqa.api.employee.DeleteEmployeeRequest;

@RequiredArgsConstructor
public class DeleteEmployeeSteps {

    private final Context context;
    private final DeleteEmployeeRequest deleteEmployeeRequest;

    @When("User deletes existing employee")
    public void user_deletes_existing_employee() {

        String employeeId = context.getEmployeeResponse().getId();
        Response response = deleteEmployeeRequest.deleteEmployee(employeeId);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.SC_OK);
    }

}
