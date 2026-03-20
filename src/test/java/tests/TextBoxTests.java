package tests;

import org.junit.jupiter.api.Test;

import static tests.testdata.TestData.*;

public class TextBoxTests extends TestBase {
    @Test
    void successFillAllFieldsTest() {
        textBoxPage.openTextBox()
                .removeBanner()
                .typeFullName(userFirstName + " " + userLastName)
                .typeEmail(userEmail)
                .typeCurrentAddress(userCurrentAddress)
                .typePermanentAddress(userPermanentAddress)
                .submitForm();

        textBoxPage.checkResult("Name:", userFirstName + " " + userLastName)
                .checkResult("Email:", userEmail)
                .checkResult("Current Address :", userCurrentAddress)
                .checkResult("Permananet Address :", userPermanentAddress);
    }
}
