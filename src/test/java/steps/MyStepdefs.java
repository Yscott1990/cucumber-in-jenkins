package steps;

import au.com.yb.bound.MainApp;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class MyStepdefs {

    private MainApp mainApp = new MainApp();
    private CountDownLatch latch;

    public MyStepdefs() {
        this.latch = new CountDownLatch(1);
    }

    @Given("^I have MainApp running$")
    public void iHaveMainAppRunning() {
        // nothing here
        mainApp.start();
    }


    @When("^I set value to (\\d+)$")
    public void iSetValueTo(int arg0) throws Throwable {
        mainApp.updateTargetVal(arg0);
    }


    @And("^I wait for (\\d+) seconds$")
    public void iWaitForSeconds(int delay) throws InterruptedException {
        latch.await(delay, TimeUnit.SECONDS);
    }

    @Then("^I should have (\\d+)$")
    public void iShouldHave(int val) throws Throwable {
        Assert.assertEquals(mainApp.getResult(), val);
    }
}
