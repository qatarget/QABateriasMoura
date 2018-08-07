package qa.bateriasmoura.revendabalcao.basepage;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import qa.bateriasmoura.core.DSL;
import qa.bateriasmoura.core.DriverFactory;


public class loginPage {

	private DSL dsl = new DSL();
	
	public void SetEscreveUsuario(String usuario) 
	{
		dsl.escreveId("login-user", usuario);
	}
	
	public void SetEscreveSenha(String senha) 
	{
		dsl.escreveId("login-password", senha);		
	}
	
	public void SetClicaBotaoEnviar() 
	{
		dsl.clicarBotaoBy(By.id("enviar-login"));
	}
	
	public void AguardaCarregarPagina(int tempo) throws InterruptedException {
		dsl.esperaCarregar(tempo);
	}
	
	public void url(String url) 
	{
		dsl.maximizaJanela();
		DriverFactory.getDriver().get(url);
	}
	
	public void SetvalidarAcesso(String texto) {
		
		assertEquals(texto, dsl.obterTexto(By.xpath("//span[contains(text(),'Olá')]")));
	}
	

}
