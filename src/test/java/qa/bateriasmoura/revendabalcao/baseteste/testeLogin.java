package qa.bateriasmoura.revendabalcao.baseteste;

import org.junit.Test;
import qa.bateriasmoura.revendabalcao.basepage.loginPage;

public class testeLogin {
	
	private loginPage page = new loginPage();
	
	@Test
	public void DeveRealizarAcessoSistema() throws InterruptedException {
		
		
		page.url("http://server.target1.com.br:9020/#/portal/home");
		page.AguardaCarregarPagina(1000);
		page.SetEscreveUsuario("34213205860");
		page.SetEscreveSenha("123456");
		page.SetClicaBotaoEnviar();
		page.AguardaCarregarPagina(1000);
		page.SetvalidarAcesso("Olá");
	}

}
