package pl.akademiaqa.cucumber.steps.bug;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import pl.akademiaqa.api.bug.CreateBugRequest;
import pl.akademiaqa.api.context.Context;
import pl.akademiaqa.dto.BugDto;
import pl.akademiaqa.handlers.bug.BugPayload;
import pl.akademiaqa.handlers.bug.BugResponse;

import java.util.List;

@RequiredArgsConstructor
public class CreateBugSteps {

    private final CreateBugRequest createBugRequest;
    private final BugPayload bugPayload;
    private final Context context;

    @Given("Bug already exists")
    public void bug_already_exists() {
        BugDto defaultBug = bugPayload.getDefaultBug();
        BugResponse bugResponse = createBugRequest.createBug(defaultBug);

        Assertions.assertThat(bugResponse.getTitle()).isEqualTo(bugPayload.getDefaultBug().getTitle());
        Assertions.assertThat(bugResponse.getStatus()).isEqualTo(bugPayload.getDefaultBug().getStatus());

        context.setBugResponse(bugResponse);
        context.setBug(defaultBug);
    }

    @When("User creates multiple bugs")
    public void user_creates_multiple_bugs(List<BugDto> bugs) {

        for (BugDto bug : bugs) {
            BugResponse bugResponse = createBugRequest.createBug(bug);
            Assertions.assertThat(bugResponse.getTitle()).isEqualTo(bug.getTitle());
            context.addBugToList(bug);
            context.addBugResponseToList(bugResponse);
        }
    }
}
