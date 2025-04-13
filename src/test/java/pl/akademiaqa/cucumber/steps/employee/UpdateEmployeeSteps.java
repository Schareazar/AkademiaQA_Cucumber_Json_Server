package pl.akademiaqa.cucumber.steps.employee;

import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import pl.akademiaqa.api.context.Context;
import pl.akademiaqa.api.employee.UpdateEmployeeRequest;
import pl.akademiaqa.handlers.employee.EmployeePayload;
import pl.akademiaqa.handlers.employee.EmployeeResponse;

@RequiredArgsConstructor
public class UpdateEmployeeSteps {

    private final EmployeePayload employeePayload;
    private final Context context;
    private final UpdateEmployeeRequest updateEmployeeRequest;


    @When("User changes employees e-mail address")
    public void user_changes_employees_e_mail_address() {
        EmployeeResponse employeeResponse = updateEmployeeRequest.updateEmployee(context.getEmployeeResponse().getId(),employeePayload.getChangedEmployee());
        context.setEmployeeResponse(employeeResponse);
        Assertions.assertThat(context.getEmployeeResponse().getEmail()).isEqualTo(employeePayload.getChangedEmployee().getEmail());
    }

}
