package vitalii.qa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PracticeFormTests extends TestBase {

    @Test
    @DisplayName("PracticeForm_1")
    void fillPracticeForm() {

        registrationPage.openPage();
        registrationPage.typeFirstName("Piter");
        registrationPage.typeLastName("Parker");
        registrationPage.typeEmail("PParker@gmail.com");
        registrationPage
                .selectGender("Male")
                .selectGender("Other");
        registrationPage.typeNumber("2224449991");
        registrationPage.selectDateOfBirth("November", "1991", "28");
        registrationPage.typeSubjects("hindi");
        registrationPage
                .selectHobbies("Reading")
                .selectHobbies("Music");
        registrationPage.uploadPicture();
        registrationPage.typeAddress("Lenina str 1");
        registrationPage.selectStateSity("Haryana", "Panipat");
        registrationPage.selectSubmit();
        registrationPage
                .checkResultsValue("Student Name", "Piter Parker")
                .checkResultsValue("Student Email", "PParker@gmail.com")
                .checkResultsValue("Gender", "Other")
                .checkResultsValue("Mobile", "2224449991")
                .checkResultsValue("Date of Birth", "28 November,1991")
                .checkResultsValue("Subjects", "Hindi")
                .checkResultsValue("Hobbies", "Reading, Music")
                .checkResultsValue("Picture", "cat.jpeg")
                .checkResultsValue("Address", "Lenina str 1")
                .checkResultsValue("State and City", "Haryana Panipat");
    }
}
