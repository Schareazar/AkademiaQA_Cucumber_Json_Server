package pl.akademiaqa.cucumber.steps.bug;

import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import pl.akademiaqa.api.bug.UpdateBugRequest;
import pl.akademiaqa.api.context.Context;
import pl.akademiaqa.dto.BugDto;
import pl.akademiaqa.handlers.bug.BugResponse;

@RequiredArgsConstructor
public class UpdateBugSteps {

    private final Context context;
    private final UpdateBugRequest updateBugRequest;

    @When("User closes existing bug")
    public void user_closes_existing_bug() {

        String bugId = context.getBugResponse().getId();
        BugDto updatedBug = context.getBug();
        updatedBug.setStatus("closed");

        BugResponse bugResponse = updateBugRequest.updateBug(bugId, updatedBug);

        Assertions.assertThat(bugResponse.getTitle()).isEqualTo(updatedBug.getTitle());
        Assertions.assertThat(bugResponse.getStatus()).isEqualTo(updatedBug.getStatus());
    }

}
