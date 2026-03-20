package tests;

import org.junit.jupiter.api.Test;

import static tests.testdata.TestData.*;

public class PracticeFormNegativeTests extends TestBase {
    @Test
    void withoutFirstNameFieldTest() {
        registrationPage.openPracticeForm()
                .removeBanner()
                .typeLastName(studentLastName)
                .setGender(studentFemaleGender)
                .typePhone(studentNumber)
                .submitForm();

        registrationPage.checkResultWithoutFirstName("border-color", invalidColour);
    }

    @Test
    void withoutLastNameFieldTest() {
        registrationPage.openPracticeForm()
                .removeBanner()
                .typeFirstName(studentFirstName)
                .setGender(studentFemaleGender)
                .typePhone(studentNumber)
                .submitForm();

        registrationPage.checkResultWithoutLastName("border-color", invalidColour);
    }

    @Test
    void withoutPhoneFieldTest() {
        registrationPage.openPracticeForm()
                .removeBanner()
                .typeFirstName(studentFirstName)
                .typeLastName(studentLastName)
                .setGender(studentFemaleGender)
                .submitForm();

        registrationPage.checkResultWithoutPhone("border-color", invalidColour);
    }

    @Test
    void withoutGenderFieldTest() {
        registrationPage.openPracticeForm()
                .removeBanner()
                .typeFirstName(studentFirstName)
                .typeLastName(studentLastName)
                .typePhone(studentNumber)
                .submitForm();

        registrationPage.checkGender(studentMaleGender, "border-color", invalidColour);
        registrationPage.checkGender(studentFemaleGender, "border-color", invalidColour);
        registrationPage.checkGender(studentOtherGender, "border-color", invalidColour);
    }
}