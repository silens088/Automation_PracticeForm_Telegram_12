package vitalii.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPage;

//Файл с общими вещами
public class TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
        //Configuration.startMaximized = false;
        //Configuration.browserSize = "1366x768";
    }

}
