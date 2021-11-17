package lesson.qa.guru;

import lesson.qa.guru.steps.WebSteps;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class StepAnnotatedTests {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final Integer ISSUE_NUMBER = 66;

    private WebSteps steps = new WebSteps();

    @Test
    public void testGithub(){
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openIssueTab();
        steps.shouldSeeIssueNumber(ISSUE_NUMBER);

    }
}
