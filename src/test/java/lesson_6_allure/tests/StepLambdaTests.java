package lesson_6_allure.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class StepLambdaTests {

    private static final String REEPOSITORY = "eroshenkoam/allure-example";
    private static final Integer ISSUE_NUMBER = 66;

    @Test
    public void testGithub() {
        step("Open general page", () -> {
            open("https://github.com");
        });
        step("Find repository " + REEPOSITORY, () -> {
            $("[data-test-selector=nav-search-input]").click();
            $("[data-test-selector=nav-search-input]").sendKeys(REEPOSITORY);
            $("[data-test-selector=nav-search-input]").submit();
        });
        step("Step to repository" + REEPOSITORY, () -> {
            $(linkText("eroshenkoam/allure-example")).click();
        });
        step("Open Issues tab " + REEPOSITORY, () -> {
            $(partialLinkText("Issues")).click();
        });
        step("Assert Issues number " + ISSUE_NUMBER, () -> {
            $(withText("#" + ISSUE_NUMBER)).should(Condition.visible);
        });
    }
}
