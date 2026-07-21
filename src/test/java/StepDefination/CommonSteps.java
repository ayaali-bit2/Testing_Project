package StepDefination;

import Hooks.Hook;
import io.cucumber.java.en.Given;

public class CommonSteps {

    @Given("the user is on the automationexercise.com home page")
    public void theUserIsOnTheAutomationexerciseComHomePage() {
        if (Hook.driver == null) {
            throw new IllegalStateException("WebDriver is not initialized");
        }
        String expectedUrl = "https://automationexercise.com/";
        if (!expectedUrl.equals(Hook.driver.getCurrentUrl())) {
            Hook.driver.get(expectedUrl);
            Hook.driver.manage().window().maximize();
        }
    }
}
