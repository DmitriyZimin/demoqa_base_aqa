package tests.demoqa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests extends TestBase {
    @Test
    void successFillFormTest() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue("Petr");
        $("[id=lastName]").setValue("Ivanov");
        $("[id=userEmail]").setValue("test@test.com");
        $("[id=gender-radio-1]").click();
        $("[id=userNumber]").setValue("9058795412");
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__year-select").$(byText("1974")).click();
        $(".react-datepicker__month-select").$(byText("January")).click();
        $(".react-datepicker__month").$(byText("20")).click();
        $("[id=uploadPicture]").uploadFromClasspath("testPicture.png");
        $("[id=subjectsInput]").setValue("Maths").pressEnter();
        $("[id=hobbies-checkbox-2]").click();
        $("[id=currentAddress]").setValue("Testovskaya street, 18");
        $("[id=state]").click();
        $("[id=state]").$(byText("NCR")).click();
        $("[id=city]").click();
        $("[id=city]").$(byText("Delhi")).click();
        $("[id=submit]").click();

        $("[id=example-modal-sizes-title-lg]").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Petr Ivanov"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("test@test.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("9058795412"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("20 January,1974"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Maths"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Reading"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("testPicture.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Testovskaya street, 18"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Delhi"));
    }
}