package pl.akademiaqa.cucumber.steps.bug;

import io.cucumber.java.en.Then;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import pl.akademiaqa.api.bug.ReadBugRequest;
import pl.akademiaqa.api.context.Context;
import pl.akademiaqa.handlers.bug.BugResponse;

@RequiredArgsConstructor
public class ReadBugSteps {

    private final Context context;
    private final ReadBugRequest readBugRequest;

    @Then("Bug status is closed")
    public void bug_status_is_closed() {

        String bugId = context.getBugResponse().getId();
        BugResponse bugResponse = readBugRequest.readBug(bugId);

        Assertions.assertThat(bugResponse.getStatus()).isEqualTo("closed");
    }

}
