package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {
    public void checkPracticeFormResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));
    }

    public void checkTextBoxResult(String key, String value) {
        $("#output").$(byText(key)).parent().shouldHave(text(value));
    }
}