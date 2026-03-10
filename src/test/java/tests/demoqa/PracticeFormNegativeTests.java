package tests.demoqa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.demoqa.testdata.TestData.*;

public class PracticeFormNegativeTests extends TestBase {
    @Test
    void withoutFirstNameFieldTest() {
        $("#lastName").setValue(studentLastName);
        $("#genterWrapper").$(byText(studentFemaleGender)).click();
        $("#userNumber").setValue(studentNumber);
        $("#submit").click();

        $("#firstName").shouldHave(cssValue("border-color", invalidColour));
    }

    @Test
    void withoutLastNameFieldTest() {
        $("#firstName").setValue(studentFirstName);
        $("#genterWrapper").$(byText(studentFemaleGender)).click();
        $("#userNumber").setValue(studentNumber);
        $("#submit").click();

        $("#lastName").shouldHave(cssValue("border-color", invalidColour));
    }

    @Test
    void withoutPhoneFieldTest() {
        $("#firstName").setValue(studentFirstName);
        $("#lastName").setValue(studentLastName);
        $("#genterWrapper").$(byText(studentFemaleGender)).click();
        $("#submit").click();

        $("#userNumber").shouldHave(cssValue("border-color", invalidColour));
    }

    @Test
    void withoutGenderFieldTest() {
        $("#firstName").setValue(studentFirstName);
        $("#lastName").setValue(studentLastName);
        $("#userNumber").setValue(studentNumber);
        $("#submit").click();

        $("#genterWrapper").$(byText(studentMaleGender)).shouldHave(cssValue("border-color", invalidColour));
        $("#genterWrapper").$(byText(studentFemaleGender)).shouldHave(cssValue("border-color", invalidColour));
        $("#genterWrapper").$(byText(studentOtherGender)).shouldHave(cssValue("border-color", invalidColour));
    }
}