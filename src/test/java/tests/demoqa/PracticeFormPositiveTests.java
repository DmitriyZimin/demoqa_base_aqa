package tests.demoqa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.demoqa.testdata.TestData.*;

public class PracticeFormPositiveTests extends TestBase {
    @Test
    void successFillAllFieldsTest() {
        open(urlPracticeForm);
        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                """);
        $("[id=firstName]").setValue(studentFirstName);
        $("[id=lastName]").setValue(studentLastName);
        $("[id=userEmail]").setValue(studentEmail);
        $("[id=genterWrapper]").$(byText(studentMaleGender)).click();
        $("[id=userNumber]").setValue(studentNumber);
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__year-select").$(byText(studentBirthYear)).click();
        $(".react-datepicker__month-select").$(byText(studentBirthMonth)).click();
        $(".react-datepicker__month").$(byText(studentBirthDay)).click();
        $("[id=uploadPicture]").uploadFromClasspath(studentPictureFile);
        $("[id=subjectsInput]").setValue(studentSubject).pressEnter();
        $("[id=hobbiesWrapper]").$(byText(studentHobby)).click();
        $("[id=currentAddress]").setValue(studentAddress);
        $("[id=state]").click();
        $("[id=state]").$(byText(studentState)).click();
        $("[id=city]").click();
        $("[id=city]").$(byText(studentCity)).click();
        $("[id=submit]").click();

        $("[id=example-modal-sizes-title-lg]").shouldHave(text(successHeader));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(studentFirstName + " " + studentLastName));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(studentEmail));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(studentMaleGender));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(studentNumber));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text(studentBirthDay + " " + studentBirthMonth + "," + studentBirthYear));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text(studentSubject));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text(studentHobby));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text(studentPictureFile));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text(studentAddress));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text(studentState + " " + studentCity));
    }

    @Test
    void successFillObligatoryFieldsTest() {
        open(urlPracticeForm);
        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                """);
        $("[id=firstName]").setValue(studentFirstName);
        $("[id=lastName]").setValue(studentLastName);
        $("[id=genterWrapper]").$(byText(studentFemaleGender)).click();
        $("[id=userNumber]").setValue(studentNumber);
        $("[id=submit]").click();

        $("[id=example-modal-sizes-title-lg]").shouldHave(text(successHeader));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(studentFirstName + " " + studentLastName));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(studentFemaleGender));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(studentNumber));
    }
}