package StepDefination;

import Hooks.Hook;
import Pages.TestCasesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestCasesSteps {

    private TestCasesPage testCasesPage;

    @When("they click the Test Cases navigation link")
    public void theyClickTheTestCasesNavigationLink() {
        testCasesPage = new TestCasesPage(Hook.driver);
        testCasesPage.testCasesButtonFun();
    }

    @Then("the Test Cases page should load successfully")
    public void theTestCasesPageShouldLoadSuccessfully() {
        testCasesPage.verifyTestCasesButtonFun();
    }

    @And("the \"Test Cases\" heading should be visible")
    public void theTestCasesHeadingShouldBeVisible() {
        testCasesPage.verifyTestCasesButtonFun();
    }
}
