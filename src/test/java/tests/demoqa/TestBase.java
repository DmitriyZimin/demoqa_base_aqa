package tests.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;


public class TestBase {
    public static String PRACTICE_FORM_PATH = "/automation-practice-form";

    @BeforeAll
    static void setupSelenideConfig() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @BeforeEach
    void openPracticeForm() {
        open(PRACTICE_FORM_PATH);
        removeBanner();
    }

    private void removeBanner() {
        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                """);
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}