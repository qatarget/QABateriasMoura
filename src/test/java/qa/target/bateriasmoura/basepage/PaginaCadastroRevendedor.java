package qa.target.bateriasmoura.basepage;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.sun.org.apache.bcel.internal.generic.Select;
import qa.target.bateriasmoura.core.DSL;

import org.junit.Assert;
import org.junit.Before;




public class PaginaCadastroRevendedor {
	
	
	private DSL dsl;
	private WebDriver driver;
	
	@Before
	public void inicializa() throws InterruptedException{
		
		driver = new FirefoxDriver();
		driver = new FirefoxDriver();
		driver.get("http://server.target1.com.br:9020/#/portal/home");
		Thread.sleep(500);
		dsl = new DSL(driver);
	}
	
	/* @After
	public void finaliza(){
		driver.quit();
	}*/
	

	
	@Test
	@Ignore
	public void pesquisaRevendedor() throws InterruptedException  {		
		
		dsl.clicarBotaoClass("btn-moura");
		dsl.clicarBotaoId("buscar-cnpj");
		String texto = driver.findElement(By.className("swal2-content")).getText();
		Assert.assertEquals("Digite um CNPJ Válido para continuar", texto);
		driver.findElement(By.className("swal2-confirm")).click();
		dsl.escreverId("cnpj", dsl.gerarcnpj(false));
		dsl.clicarBotaoId("buscar-cnpj");
		Thread.sleep(1000);
		
		
	}
	
	
	@Test
	public void cadastrandoRevendedorCompleto() throws InterruptedException  {
		
		dsl.clicarBotaoClass("btn-moura");
		dsl.escreverId("cnpj", dsl.gerarcnpj(false));
		dsl.clicarBotaoId("buscar-cnpj");
		Thread.sleep(500);
		dsl.escreverId("nomeFantasia", dsl.geraEmpresaAleatorio());
		dsl.escreverId("razaoSocial", dsl.geraEmpresaAleatorio());
		dsl.escreverId("cep", "04456140");
		dsl.escreverId("numero", "17");
		dsl.escreverId("email", dsl.geraEmailAleatorio());
		dsl.escreverId("telefone", "1235809975");
		dsl.selecionarComboAjax("select2-hidden-accessible", "Baterias Moura");	
		dsl.isCheckMarcadoComEspaco("regulamento");		
		
	}

}