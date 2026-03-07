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
        $("#firstName").setValue(studentFirstName);
        $("#lastName").setValue(studentLastName);
        $("#userEmail").setValue(studentEmail);
        $("#genterWrapper").$(byText(studentMaleGender)).click();
        $("#userNumber").setValue(studentNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").$(byText(studentBirthYear)).click();
        $(".react-datepicker__month-select").$(byText(studentBirthMonth)).click();
        $(".react-datepicker__month").$(byText(studentBirthDay)).click();
        $("#uploadPicture").uploadFromClasspath(studentPictureFile);
        $("#subjectsInput").setValue(studentSubject).pressEnter();
        $("#hobbiesWrapper").$(byText(studentHobby)).click();
        $("#currentAddress").setValue(studentAddress);
        $("#state").click();
        $("#state").$(byText(studentState)).click();
        $("#city").click();
        $("#city").$(byText(studentCity)).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text(successHeader));
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
        $("#firstName").setValue(studentFirstName);
        $("#lastName").setValue(studentLastName);
        $("#genterWrapper").$(byText(studentFemaleGender)).click();
        $("#userNumber").setValue(studentNumber);
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text(successHeader));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(studentFirstName + " " + studentLastName));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(studentFemaleGender));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(studentNumber));
    }
}