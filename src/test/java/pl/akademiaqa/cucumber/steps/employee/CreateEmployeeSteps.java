package pl.akademiaqa.cucumber.steps.employee;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import pl.akademiaqa.api.context.Context;
import pl.akademiaqa.api.employee.CreateEmployeeRequest;
import pl.akademiaqa.handlers.employee.EmployeePayload;
import pl.akademiaqa.handlers.employee.EmployeeResponse;

@RequiredArgsConstructor
public class CreateEmployeeSteps {

    private final CreateEmployeeRequest createEmployeeRequest;
    private final EmployeePayload employeePayload;
    private final Context context;

    @When("User creates new employee")
    public void user_creates_new_employee() {
        EmployeeResponse employeeResponse = createDefaultEmployee();
        Assertions.assertThat(employeePayload.getDefaultEmployee().getFirstName())
                .isEqualTo(employeeResponse.getFirstName());
    }

    @Given("Employee already exists")
    public void employee_already_exists() {
        createDefaultEmployee();
    }

    private EmployeeResponse createDefaultEmployee() {
        EmployeeResponse employeeResponse = createEmployeeRequest.createEmployee(employeePayload.getDefaultEmployee());
        context.setEmployeeResponse(employeeResponse);
        return employeeResponse;
    }

}
