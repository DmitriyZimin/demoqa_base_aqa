package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests extends TestBase{
    @Test
    void successFillFormTest(){
        open("/automation-practice-form");
        $("[id=firstName]").setValue("Petr");
    }
}
