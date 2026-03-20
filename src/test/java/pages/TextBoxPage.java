package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.RemoveBannerComponent;
import pages.components.ResultTableComponent;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {
    ResultTableComponent resultTable = new ResultTableComponent();
    RemoveBannerComponent adBanner = new RemoveBannerComponent();

    public static String TEXT_BOX_PATH = "/text-box";
    private final SelenideElement userNameInput = $("#userName");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement permanentAddressInput = $("#permanentAddress");
    private final SelenideElement submitForm = $("#submit");

    public TextBoxPage openTextBox() {
        open(TEXT_BOX_PATH);

        return this;
    }

    public TextBoxPage removeBanner() {
        adBanner.removeBanner();

        return this;
    }

    public TextBoxPage typeFullName(String value) {
        userNameInput.setValue(value);

        return this;
    }

    public TextBoxPage typeEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public TextBoxPage typeCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPage typePermanentAddress(String value) {
        permanentAddressInput.setValue(value);

        return this;
    }

    public void submitForm() {
        submitForm.click();

    }

    public TextBoxPage checkResult(String key, String value) {
        resultTable.checkTextBoxResult(key, value);

        return this;
    }
}
