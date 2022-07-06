package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.steps.StepsForDemoQa;

@Tag("tests practice form")
public class TestDemoQa extends TestBase {

    @Test
    @DisplayName("Проверка заполнения формы automation-practice-form")
    void practiceForm() {
        StepsForDemoQa steps = new StepsForDemoQa();

        steps.openPage();
        steps.setFirstName();
        steps.setLastName();
        steps.setuserEmail();
        steps.setGender();
        steps.setNumber();
        steps.setDateOfBirth();
        steps.setSubjects();
        steps.setHobby();
        steps.setLoad();
        steps.setAddress();
        steps.setState();
        steps.setCity();
        steps.pressSub();
        steps.checkResult();
    }
}
