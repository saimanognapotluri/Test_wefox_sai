package StepDefinitions;


import com.test.base.BaseSetup;
import com.test.module.LegoScenarioUtility;
import com.test.util.Utilities;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
/**
 * This class has all the Step Definitions related to portal landing page
 * these utility classes can be used by feature files to complete the test case flow
 * Feature files class path: (<current project directory>/src/test/resources/Features)
 * 
 * @return null
 */
public class LegoScenarioSteps extends BaseSetup {

	LegoScenarioUtility legoPage = new LegoScenarioUtility(driver);

	@Given("I navigate to Lego site")
	public void legoNavigate() throws InterruptedException {

		String legoLandingPage = prop.getProperty("LegoLandingPage");
		legoPage.LegoNavigate(legoLandingPage);
	}

	@When("add filters for the products displayed")
	public void applyFilters() {
		legoPage.applyFilters();

	}

	@Then("verify the number of results")
	public void verifyProductResults() {
		legoPage.verifyProductNumberOfResults();

	}

	@Then("check article name and price")
	public void checkProductDetails() {
		legoPage.checkProductDetails();

	}

	@Then("add the product to cart verify details and proceed to checkout")
	public void addToCartVerifyAndCheckout() {
		legoPage.addToCartVerifyAndCheckout();

	}

}

