package tests.demoqa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.demoqa.testdata.TestData.*;

public class PracticeFormNegativeTests extends TestBase {
    @Test
    void withoutFirstNameFieldTest() {
        open(urlPracticeForm);
        $("[id=lastName]").setValue(studentLastName);
        $("[id=genterWrapper]").$(byText(studentFemaleGender)).click();
        $("[id=userNumber]").setValue(studentNumber);
        $("[id=submit]").click();

        $("[id=firstName]").shouldHave(cssValue("border-color", invalidColour));
    }

    @Test
    void withoutLastNameFieldTest() {
        open(urlPracticeForm);
        $("[id=firstName]").setValue(studentFirstName);
        $("[id=genterWrapper]").$(byText(studentFemaleGender)).click();
        $("[id=userNumber]").setValue(studentNumber);
        $("[id=submit]").click();

        $("[id=lastName]").shouldHave(cssValue("border-color", invalidColour));
    }

    @Test
    void withoutPhoneFieldTest() {
        open(urlPracticeForm);
        $("[id=firstName]").setValue(studentFirstName);
        $("[id=lastName]").setValue(studentLastName);
        $("[id=genterWrapper]").$(byText(studentFemaleGender)).click();
        $("[id=submit]").click();

        $("[id=userNumber]").shouldHave(cssValue("border-color", invalidColour));
    }

    @Test
    void withoutGenderFieldTest() {
        open(urlPracticeForm);
        $("[id=firstName]").setValue(studentFirstName);
        $("[id=lastName]").setValue(studentLastName);
        $("[id=userNumber]").setValue(studentNumber);
        $("[id=submit]").click();

        $("[id=genterWrapper]").$(byText(studentMaleGender)).shouldHave(cssValue("border-color", invalidColour));
        $("[id=genterWrapper]").$(byText(studentFemaleGender)).shouldHave(cssValue("border-color", invalidColour));
        $("[id=genterWrapper]").$(byText(studentOtherGender)).shouldHave(cssValue("border-color", invalidColour));
    }
}