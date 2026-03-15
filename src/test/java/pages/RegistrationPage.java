package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    CalendarComponent calendar = new CalendarComponent();

    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement emailInput = $("#userEmail");
    private SelenideElement genderContainer = $("#genterWrapper");
    private SelenideElement phoneInput = $("#userNumber");
    private SelenideElement subjectsInput = $("#subjectsInput");
    private SelenideElement hobbiesContainer = $("#hobbiesWrapper");
    private SelenideElement pictureUpload = $("#uploadPicture");
    private SelenideElement addressInput = $("#currentAddress");
    private SelenideElement stateSelect = $("#state");
    private SelenideElement citySelect = $("#city");
    private SelenideElement stateCityContainer = $("#stateCity-wrapper");

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage typeEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderContainer.$(byText(value)).click();

        return this;
    }

    public RegistrationPage typePhone(String value) {
        phoneInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);

        return this;
    }

    public RegistrationPage typeSubject(String value) {
        subjectsInput.setValue(value);

        return this;
    }

    public RegistrationPage setHobby(String value) {
        hobbiesContainer.setValue(value);

        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        pictureUpload.setValue(value);

        return this;
    }

    public RegistrationPage typeAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        stateSelect.click();
        stateCityContainer.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        citySelect.click();
        stateCityContainer.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setStateAndCity(String state, String city) {
        setState(state);
        setCity(city);

        return this;
    }


    public RegistrationPage checkResult(String key, String value) {

        return this;
    }
}
