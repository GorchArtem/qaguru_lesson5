package lesson_6_allure.steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;


import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {

    @Step("Open general page")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Find repository {repository}")
    public void searchForRepository(String repository) {
        $("[data-test-selector=nav-search-input]").click();
        $("[data-test-selector=nav-search-input]").sendKeys(repository);
        $("[data-test-selector=nav-search-input]").submit();
    }

    @Step("Step to repository {repository}")
    public void goToRepository(String repository) {
        $(linkText(repository)).click();
    }

    @Step("Open Issues tab")
    public void openIssueTab() {
        $(partialLinkText("Issues")).click();
    }

    @Step("Assert Issues number {number}")
    public void shouldSeeIssueNumber(int number) {
        $(withText("#" + number)).should(Condition.visible);
    }
}
