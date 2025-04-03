package pl.akademiaqa.cucumber.steps.employee;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import pl.akademiaqa.api.context.Context;
import pl.akademiaqa.api.employee.ReadEmployeeRequest;
import pl.akademiaqa.handlers.employee.EmployeeResponse;

import java.util.List;

@RequiredArgsConstructor
public class ReadEmployeeSteps {

    private final ReadEmployeeRequest readEmployeeRequest;
    private final Context context;
    private List<EmployeeResponse> allEmployeesBefore;
    private List<EmployeeResponse> allEmployeesAfter;

    @Given("User reads employee list")
    public void user_reads_employee_list() {
        allEmployeesBefore = readEmployeeRequest.readAllEmployees();
    }

    @Then("User can see created employee on employee list")
    public void user_can_see_created_employee_on_employee_list() {
        allEmployeesAfter = readEmployeeRequest.readAllEmployees();

        Assertions.assertThat(allEmployeesAfter).hasSizeGreaterThan(allEmployeesBefore.size());
        Assertions.assertThat(allEmployeesAfter).contains(context.getEmployeeResponse());
    }

}
