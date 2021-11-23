package lesson.qa.guru;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideTests {
    SelenideElement gitInput = $("[data-test-selector=nav-search-input]");

    @Test
    public void testGithub() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        gitInput.click();
        gitInput.sendKeys("eroshenkoam/allure-example");
        gitInput.submit();

        $(linkText("eroshenkoam/allure-example")).click();
        $(partialLinkText("Issues")).click();
        $(withText("66")).should(Condition.visible);
    }
}
