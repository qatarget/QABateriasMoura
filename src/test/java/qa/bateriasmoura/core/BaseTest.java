package qa.bateriasmoura.core;

import static qa.bateriasmoura.core.DriverFactory.getDriver;
import java.io.File;
import java.io.IOException;


import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import qa.bateriasmoura.page.LoginPage;

public class BaseTest extends BasePage{
	
	@Rule
	public TestName testName = new TestName();

	private LoginPage page = new LoginPage();

	@Before
	public void inicializa() throws InterruptedException {
		page.acessarTelaInicial();
		page.SetEscreverLogin("01098290000110");
		page.SetEscreverSenha("000110");
		page.SetEntrar();
	}

	
}
