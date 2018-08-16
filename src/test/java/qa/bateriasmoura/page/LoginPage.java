package qa.bateriasmoura.page;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;

import qa.bateriasmoura.core.BasePage;

public class LoginPage extends BasePage{
	
	public void SetEscreverLogin() {
		escrever(By.Name("cnpj"), "01098290000110");
	}
	
	public void SetEscreverSenha() {
		escrever(By.name("senha"), "000110");
	}
	
	public void SetEntrar() {
		clicarBotaoClass("btn-primary");
	}

	public void SetVerificaAcesso() {
		
		assertTrue(ObterTextoCampoClassName("col-md-12").StartsWith("ADMIN - DISTRIBUIDOR"));
	}
}
