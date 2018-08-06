package qa.bateriasmoura.revendabalcao.baseteste;

import org.junit.Test;

import qa.bateriasmoura.revendabalcao.basepage.cadastrarRevendedor;


public class testeCadaastroRevenda {

	private cadastrarRevendedor page = new cadastrarRevendedor();

	@Test
	public void CadastrarRevenda() throws InterruptedException {

		page.url("http://server.target1.com.br:9020/#/portal/home");
		page.AguardarCarregarPagina(3000);
		page.SetClicarBotao();
		page.AguardarCarregarPagina(3000);
		page.SetClicarBotaoBuscarCNPJ();
		page.AguardarCarregarPagina(3000);
		page.SetMensagemAlerta("Digite um CNPJ válido para continuar");
		page.AguardarCarregarPagina(1000);
		page.SetClicarBotaoConfirma();
		

	}

}
