package serenitybdd.Autotest.WebMyPham.features.search;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.ClearCookiesPolicy;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import serenitybdd.Autotest.WebMyPham.steps.serenity.LoginSteps;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("data/login.csv")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Login {

	@Managed(uniqueSession = true, clearCookies = ClearCookiesPolicy.Never)
	public WebDriver webdriver;

	String testcase, email, password, result;

	@Qualifier
	public String qualifier() {
		return this.testcase;
	}

	@Steps
	public LoginSteps login;

	@Test
    public void SignUp_testcase() {
		login.openPage();
		login.enterEmail(email);
		login.enterPassword(password);
		login.clickLoginButton();
        if( email.equalsIgnoreCase("") || password.equalsIgnoreCase("")){
        	login.check_login_fail(result);
        }
        else if(!email.equalsIgnoreCase("") && !email.contains("@")) {
        	login.check_email_fail(result);
        }
        else {
        	login.check_login_sucsess(result);
        }
    }

}