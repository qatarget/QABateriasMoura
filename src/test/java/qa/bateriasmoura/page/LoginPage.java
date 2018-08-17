package qa.bateriasmoura.page;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import qa.bateriasmoura.core.BasePage;
import static qa.bateriasmoura.core.DriverFactory.getDriver;

public class LoginPage extends BasePage{
	
	public void SetEscreverLogin(String cnpj) {
		escrever(By.Name("cnpj"), cnpj);
	}
	
	public void SetEscreverSenha(String senha) {
		escrever(By.name("senha"), senha);
	}
	
	public void SetEntrar() {
		clicarBotaoClass("btn-primary");
	}
	
	public void acessarTelaInicial() {
		getDriver().get("http://server.target1.com.br:9020/#/admin-distribuidor/login");
	}

	
}
