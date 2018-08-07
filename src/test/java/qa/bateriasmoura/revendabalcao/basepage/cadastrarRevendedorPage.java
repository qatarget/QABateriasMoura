package qa.bateriasmoura.revendabalcao.basepage;


import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import qa.bateriasmoura.core.DSL;
import qa.bateriasmoura.core.DriverFactory;

public class cadastrarRevendedorPage {
	
	private DSL dsl = new DSL();
	
	public void url(String url) 
	{
		dsl.maximizaJanela();
		DriverFactory.getDriver().get(url);
	}
	
	public void SetClicarBotao() 
	{
		dsl.clicarBotaoBy(By.className("btn-moura"));
	}
	
	public void AguardarCarregarPagina(int tempo) throws InterruptedException 
	{
		dsl.esperaCarregar(tempo);
	}
	
	public void SetClicarBotaoBuscarCNPJ() 
	{
		dsl.clicarBotaoBy(By.id("buscar-cnpj"));
	}
	
	public void SetMensagemAlerta(String texto) 
	{
		assertEquals(texto, dsl.obterTexto(By.id("swal2-content")));
	}
	
	public void SetClicarBotaoConfirma()
	{
		dsl.clicarBotaoBy(By.className("swal2-confirm"));
	}
	
	public void SetEscreveCNPJ() 
	{
		dsl.escreveId("cnpj", dsl.gerarcnpj(false));
	}
	
	public void SetNomeFantasia() 
	{
		dsl.escreveId("nomeFantasia", dsl.geraEmpresaAleatorio());
	}
	
	public void SetRazaoSocial() 
	{
		WebElement nomeFantasia = DriverFactory.getDriver().findElement(By.id("nomeFantasia"));
		String textoColetado = nomeFantasia.getAttribute("value");
		
		WebElement razaoSocial = DriverFactory.getDriver().findElement(By.id("razaoSocial"));
		razaoSocial.clear();
		razaoSocial.sendKeys(textoColetado);
	}
	
	
	
	
	
	

}
