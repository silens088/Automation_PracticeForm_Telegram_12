package vitalii.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    @DisplayName("PracticeFormTest_1")
    void fillPracticeForm() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form")); //проверка текста на старнице
        $(".main-header").shouldHave(text("Practice Form"));

        $("[id=firstName]").setValue("Piter");
        $("#lastName").setValue("Parker");
        $("#userEmail").setValue("PParker@gmail.com");

        $("[id=genterWrapper]").$(byText("Male")).click(); //выбор радиобатона - по тексту
        $("#genterWrapper").$(byText("Other")).click();

        $("#userNumber").setValue("1234567889");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("November"); //.class - через точку!
        $(".react-datepicker__year-select").selectOption("1990"); //.class - через точку!
        $(".react-datepicker__day--025:not(.react-datepicker__day--outside-month)").click();

//        //альтернативный выбор. $$ - выбор по контейнеру
//        $$(".react-datepicker__day--030").filter(not(cssClass("react-datepicker__day--outside-month"))).first().click();
//        $("[aria-label=\"Choose Monday, October 11th, 2021\"]").click();
//        $x("//*[contains(@aria-label, \"October 11th, 2021\")]").click();

        $("#subjectsInput").setValue("hindi").pressEnter();

        $("#hobbiesWrapper").$(byText("Reading")).click(); //поиск в контейнере по тексту
        $("#hobbiesWrapper").$(byText("Music")).doubleClick();

        $("#uploadPicture").uploadFile(new File("src/test/resources/img/cat.jpeg"));
        //$("#uploadPicture").uploadFromClasspath("img/cat.jpeg"); //из директории

        $("#currentAddress").setValue("Lenina str 1").scrollTo();

        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Panipat")).scrollTo().click();

        $("#submit").click(); //подтвердить выбор

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Student Name"),text("Piter Parker")); //через запятую
//        $(".table-responsive").shouldHave(exactText("Student Name"),text("Piter Parker")); exactText не работает
        $(".table-responsive").shouldHave(text("Student Email"),text("PParker@gmail.com"));
        $(".table-responsive").$(byText("Subjects"))
                .parent().shouldHave(text("Hindi")); //поднимаемся к родителю и ищем сверху по тексту.

    }
}

