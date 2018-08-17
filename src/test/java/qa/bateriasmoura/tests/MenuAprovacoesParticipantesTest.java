package qa.bateriasmoura.tests;

import org.junit.Test;
import org.openqa.selenium.By;

import qa.bateriasmoura.core.BasePage;

public class MenuAprovacoesParticipantesTest extends BasePage {
	
	@Test
	public void ConfirmaBalconista() throws InterruptedException {
		
	 escreveTexto(By.name("cnpj") , "01098290000110");
     escreveTexto(By.name("senha") ,"000110");
     clicarBotaoBy(By.className("btn-primary"));
     esperaCarregar(1000);
     clicarBotaoBy(By.className("caret"));
     clicarBotaoBy(By.xpath("//*[@href = '#/admin-distribuidor/cadastros']"));
     esperaCarregar(1000);
     clicarBotaoBy(By.className("pull-right"));
	}
	

}
