package lesson.qa.guru;

import com.codeborne.selenide.Condition;
import lesson.qa.guru.steps.WebSteps;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class StepAnnotatedTests {

    private static final String REEPOSITORY = "eroshenkoam/allure-example";
    private static final Integer ISSUE_NUMBER = 66;

    private WebSteps steps = new WebSteps();

    @Test
    public void testGithub(){
        steps.openMainPage();
        steps.searchForRepository(REEPOSITORY);
        steps.goToRepository(REEPOSITORY);
        steps.openIssueTab();
        steps.shouldSeeIssueNumber(ISSUE_NUMBER);

    }
}
