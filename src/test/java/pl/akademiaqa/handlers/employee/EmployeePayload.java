package pl.akademiaqa.handlers.employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.akademiaqa.dto.AddressDto;
import pl.akademiaqa.dto.CompanyDto;
import pl.akademiaqa.dto.EmployeeDto;

@AllArgsConstructor
@Getter
@Setter
public class EmployeePayload {

    private final EmployeeDto employee;
    private final AddressDto address;
    private final CompanyDto company;

    public EmployeeDto getDefaultEmployee() {

        employee.setFirstName("Tester");
        employee.setLastName("Testowy");
        employee.setUsername("TesterTestowy");
        employee.setEmail("tester@testers.test");
        employee.setPhone("111-111-111");
        employee.setWebsite("www.testersltd.test");
        employee.setRole("QA");
        employee.setType("B2B");

        address.setStreet("ul. Testowa");
        address.setSuite("1/1");
        address.setCity("Testowo Wielkie");
        address.setZipcode("11-111");
        employee.setAddress(address);

        company.setCompanyName("Testers Ltd");
        company.setCompanyPhone("111-111-111");
        company.setTaxNumber("111TST");
        employee.setCompany(company);

        return employee;
    }
}
