package pl.akademiaqa.handlers.bug;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.akademiaqa.dto.BugDto;

@AllArgsConstructor
@Getter
@Setter
public class BugPayload {

    private BugDto bug;

    public BugDto getDefaultBug() {
        bug.setTitle("Default bug title");
        bug.setDescription("Default bug description");
        bug.setEmployeeId(1);
        bug.setStatus("open");

        return bug;
    }

}
