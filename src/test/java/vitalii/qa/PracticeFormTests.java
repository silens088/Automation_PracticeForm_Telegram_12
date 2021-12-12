package vitalii.qa;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static vitalii.qa.TestData.randomEmail;

public class PracticeFormTests extends TestBase {

    @Owner("velichkovv")
    @Test
    @DisplayName("test for fill PracticeForm")
    void fillPracticeForm() {

        registrationPage.openPage();
        //registrationPage.typeFirstName("Piter");
        registrationPage.typeFirstName(randomName);
        registrationPage.typeLastName("Parker");
        //registrationPage.typeEmail("PParker@gmail.com");
        registrationPage.typeEmail(randomEmail);
        registrationPage
                .selectGender("Male")
                .selectGender("Other");
        //registrationPage.typeNumber("2224449991");
        registrationPage.typeNumber(randomTelephone);
        //registrationPage.selectDateOfBirth("November", "1991", "28"); //работает
        registrationPage.calendar.setName("25", "1991", "November"); //запуск через компонент календарь
        registrationPage.typeSubjects("hindi");
        registrationPage
                .selectHobbies("Reading")
                .selectHobbies("Music");
        registrationPage.uploadPicture();
        registrationPage.typeAddress("Lenina str 1");
        registrationPage.selectStateSity("Haryana", "Panipat");
        registrationPage.selectSubmit();
        registrationPage
                .checkResultsValue("Student Name", randomName + " Parker")
                .checkResultsValue("Student Email", randomEmail)
                .checkResultsValue("Gender", "Other")
                .checkResultsValue("Mobile", randomTelephone)
                .checkResultsValue("Date of Birth", "25 November,1991")
                .checkResultsValue("Subjects", "Hindi")
                .checkResultsValue("Hobbies", "Reading, Music")
                .checkResultsValue("Picture", "cat.jpeg")
                .checkResultsValue("Address", "Lenina str 1")
                .checkResultsValue("State and City", "Haryana Panipat");
    }
}
