package pl.akademiaqa.cucumber.steps.bug;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import pl.akademiaqa.api.bug.ReadBugRequest;
import pl.akademiaqa.api.context.Context;
import pl.akademiaqa.handlers.bug.BugResponse;

import java.util.List;

@RequiredArgsConstructor
public class ReadBugSteps {

    private final Context context;
    private final ReadBugRequest readBugRequest;

    private List<BugResponse> bugResponseListBefore;

    @Then("Bug status is closed")
    public void bug_status_is_closed() {

        String bugId = context.getBugResponse().getId();
        BugResponse bugResponse = readBugRequest.readBug(bugId);

        Assertions.assertThat(bugResponse.getStatus()).isEqualTo("closed");
    }

    @Given("User reads bug list")
    public void user_reads_bug_list() {
        bugResponseListBefore = readBugRequest.readAllBugs();
    }

    @Then("User can see all created bugs on bug list")
    public void user_can_see_all_created_bugs_on_bug_list() {
        List<BugResponse> bugResponseListAfter = readBugRequest.readAllBugs();

        Assertions.assertThat(bugResponseListAfter).hasSizeGreaterThan(bugResponseListBefore.size());
        Assertions.assertThat(bugResponseListAfter).containsAll(context.getBugResponseList());
    }

}
