package tests;

import org.junit.jupiter.api.Test;

import static tests.testdata.TestData.*;

public class PracticeFormPositiveTests extends TestBase {
    @Test
    void successFillAllFieldsTest() {
        registrationPage.openPracticeForm()
                .removeBanner()
                .typeFirstName(studentFirstName)
                .typeLastName(studentLastName)
                .typeEmail(studentEmail)
                .setGender(studentMaleGender)
                .typePhone(studentNumber)
                .setDateOfBirth(studentBirthDay, studentBirthMonth, studentBirthYear)
                .typeSubject(studentSubject)
                .setHobby(studentHobby)
                .uploadPicture(studentPictureFile)
                .typeAddress(studentAddress)
                .setStateAndCity(studentState, studentCity)
                .submitForm();

        registrationPage.checkResultHeader(successHeader)
                .checkResult("Student Name", studentFirstName + " " + studentLastName)
                .checkResult("Student Email", studentEmail)
                .checkResult("Gender", studentMaleGender)
                .checkResult("Mobile", studentNumber)
                .checkResult("Date of Birth", studentBirthDay + " " + studentBirthMonth + "," + studentBirthYear)
                .checkResult("Subjects", studentSubject)
                .checkResult("Hobbies", studentHobby)
                .checkResult("Picture", studentPictureFile)
                .checkResult("Address", studentAddress)
                .checkResult("State and City", studentState + " " + studentCity);
    }

    @Test
    void successFillObligatoryFieldsTest() {
        registrationPage.openPracticeForm()
                .removeBanner()
                .typeFirstName(studentFirstName)
                .typeLastName(studentLastName)
                .setGender(studentMaleGender)
                .typePhone(studentNumber)
                .submitForm();

        registrationPage.checkResultHeader(successHeader)
                .checkResult("Student Name", studentFirstName + " " + studentLastName)
                .checkResult("Gender", studentMaleGender)
                .checkResult("Mobile", studentNumber);
    }
}