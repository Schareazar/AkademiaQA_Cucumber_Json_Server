package pl.akademiaqa.cucumber.steps.transformers;


import io.cucumber.java.DataTableType;
import pl.akademiaqa.dto.BugDto;

import java.util.Map;

public class BugDataTable {

    @DataTableType
    public BugDto transform(Map<String, String> dataTable) {
        BugDto bugDto = new BugDto();
        bugDto.setTitle(dataTable.get("title"));
        bugDto.setDescription(dataTable.get("description"));
        bugDto.setEmployeeId(Integer.parseInt(dataTable.get("employeeId")));
        bugDto.setStatus(dataTable.get("status"));

        return bugDto;
    }

}
