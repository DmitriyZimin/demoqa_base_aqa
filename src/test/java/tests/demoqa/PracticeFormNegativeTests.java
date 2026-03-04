package tests.demoqa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormNegativeTests extends TestBase {
    @Test
    void withoutFirstNameFieldTest() {
        open("/automation-practice-form");
        $("[id=lastName]").setValue("Ivanov");
        $("[id=gender-radio-2]").click();
        $("[id=userNumber]").setValue("9058795412");
        $("[id=submit]").click();

        $("[id=firstName]").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void withoutLastNameFieldTest() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue("Petr");
        $("[id=gender-radio-2]").click();
        $("[id=userNumber]").setValue("9058795412");
        $("[id=submit]").click();

        $("[id=lastName]").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void withoutPhoneFieldTest() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue("Petr");
        $("[id=lastName]").setValue("Ivanov");
        $("[id=gender-radio-2]").click();
        $("[id=submit]").click();

        $("[id=userNumber]").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void withoutGenderFieldTest() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue("Petr");
        $("[id=lastName]").setValue("Ivanov");
        $("[id=userNumber]").setValue("9058795412");
        $("[id=submit]").click();

        $("[id=gender-radio-1]").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("[id=gender-radio-2]").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("[id=gender-radio-3]").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }
}