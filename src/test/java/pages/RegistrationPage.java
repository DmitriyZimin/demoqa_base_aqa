package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RemoveBannerComponent;
import pages.components.ResultTableComponent;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    CalendarComponent calendar = new CalendarComponent();
    ResultTableComponent resultTable = new ResultTableComponent();
    RemoveBannerComponent adBanner = new RemoveBannerComponent();

    public static String PRACTICE_FORM_PATH = "/automation-practice-form";
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement genderContainer = $("#genterWrapper");
    private final SelenideElement phoneInput = $("#userNumber");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement hobbiesContainer = $("#hobbiesWrapper");
    private final SelenideElement pictureUpload = $("#uploadPicture");
    private final SelenideElement addressInput = $("#currentAddress");
    private final SelenideElement stateSelect = $("#state");
    private final SelenideElement citySelect = $("#city");
    private final SelenideElement stateCityContainer = $("#stateCity-wrapper");
    private final SelenideElement submitForm = $("#submit");
    private final SelenideElement successResultHeader = $("#example-modal-sizes-title-lg");

    public RegistrationPage openPracticeForm() {
        open(PRACTICE_FORM_PATH);
        adBanner.removeBanner();

        return this;
    }

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
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobby(String value) {
        hobbiesContainer.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        pictureUpload.uploadFromClasspath(value);

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

    public void submitForm() {
        submitForm.click();

    }

    public RegistrationPage checkResultHeader(String value) {
        successResultHeader.shouldHave(text(value));

        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        resultTable.checkPracticeFormResult(key, value);

        return this;
    }

    public RegistrationPage checkResultWithoutFirstName(String key, String value) {
        firstNameInput.shouldHave(cssValue(key, value));

        return this;
    }

    public RegistrationPage checkResultWithoutLastName(String key, String value) {
        lastNameInput.shouldHave(cssValue(key, value));

        return this;
    }

    public RegistrationPage checkResultWithoutPhone(String key, String value) {
        phoneInput.shouldHave(cssValue(key, value));

        return this;
    }

    public RegistrationPage checkGender(String gender, String key, String value) {
        genderContainer.$(byText(gender)).shouldHave(cssValue(key, value));

        return this;
    }
}
