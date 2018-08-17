package qa.bateriasmoura.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import static qa.bateriasmoura.core.DriverFactory.getDriver;

public class BasePage {

	private int randomiza(int n) {
		int ranNum = (int) (Math.random() * n);
		return ranNum;
	}

	private int mod(int dividendo, int divisor) {
		return (int) Math.round(dividendo - (Math.floor(dividendo / divisor) * divisor));
	}

	/******** CNPJ, CPF, Pessoa, Empresa e E-mail ***********/

	/**
	 * Gera CPF Aleat�rio com pontos ou sem pontos.
	 * 
	 * @param comPontos
	 * @return
	 */
	public String geracpf(boolean comPontos) {
		int n = 9;
		int n1 = randomiza(n);
		int n2 = randomiza(n);
		int n3 = randomiza(n);
		int n4 = randomiza(n);
		int n5 = randomiza(n);
		int n6 = randomiza(n);
		int n7 = randomiza(n);
		int n8 = randomiza(n);
		int n9 = randomiza(n);
		int d1 = n9 * 2 + n8 * 3 + n7 * 4 + n6 * 5 + n5 * 6 + n4 * 7 + n3 * 8 + n2 * 9 + n1 * 10;

		d1 = 11 - (mod(d1, 11));

		if (d1 >= 10)
			d1 = 0;

		int d2 = d1 * 2 + n9 * 3 + n8 * 4 + n7 * 5 + n6 * 6 + n5 * 7 + n4 * 8 + n3 * 9 + n2 * 10 + n1 + 11;

		d2 = 11 - (mod(d2, 11));

		String retorno = null;

		if (d2 >= 10)
			d2 = 0;
		retorno = "";

		if (comPontos)
			retorno = "" + n1 + n2 + n3 + '.' + n4 + n5 + n6 + '.' + n7 + n8 + n9 + '-' + d1 + d2;
		else
			retorno = "" + n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8 + n9 + d1 + d2;

		return retorno;
	}

	/***
	 * Gera CNPJ com pontos ou sem Pontos.
	 * 
	 * @param comPontos
	 * @return
	 */
	public String gerarcnpj(boolean comPontos) {
		int n = 9;
		int n1 = randomiza(n);
		int n2 = randomiza(n);
		int n3 = randomiza(n);
		int n4 = randomiza(n);
		int n5 = randomiza(n);
		int n6 = randomiza(n);
		int n7 = randomiza(n);
		int n8 = randomiza(n);
		int n9 = 0; // randomiza(n);
		int n10 = 0; // randomiza(n);
		int n11 = 0; // randomiza(n);
		int n12 = 1; // randomiza(n);
		int d1 = n12 * 2 + n11 * 3 + n10 * 4 + n9 * 5 + n8 * 6 + n7 * 7 + n6 * 8 + n5 * 9 + n4 * 2 + n3 * 3 + n2 * 4
				+ n1 * 5;

		d1 = 11 - (mod(d1, 11));

		if (d1 >= 10)
			d1 = 0;

		int d2 = d1 * 2 + n12 * 3 + n11 * 4 + n10 * 5 + n9 * 6 + n8 * 7 + n7 * 8 + n6 * 9 + n5 * 2 + n4 * 3 + n3 * 4
				+ n2 * 5 + n1 * 6;

		d2 = 11 - (mod(d2, 11));

		if (d2 >= 10)
			d2 = 0;

		String retorno = null;

		if (comPontos)
			retorno = "" + n1 + n2 + "." + n3 + n4 + n5 + "." + n6 + n7 + n8 + "/" + n9 + n10 + n11 + n12 + "-" + d1
					+ d2;
		else
			retorno = "" + n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8 + n9 + n10 + n11 + n12 + d1 + d2;

		return retorno;
	}

	/***
	 * Gera Nomes e Sobrenomes aleatoriamente.
	 * 
	 * @return
	 */
	public String geraNomeAleatorio() {
		String[] nomes = { "Antonio", "Rafael", "Bruno", "Marcelo", "Alberto", "Pedro", "Anderson", "Airton", "Sidney",
				"Wilson", "Carlos", "C�ndido", "Hugo", "Jo�o", "Mauro", "Leonardo", "Natanael", "Reinaldo", "Orlando",
				"Tiago", "Gildo", "Alfredo", "Maur�cio", "Jurandir", "Paulo", "Juv�ncio", "Daniel", "Jair", "Juvenal",
				"Jorge", "Agiliza", "Alessandro", "Alexandre", "Aline", "Ana Paula", "Andressa", "Antonia", "Camila",
				"Carolina", "Cileia", "Debora", "Edna", "Ellen", "Eveline", "Fabio", "Fernanda", "Gesiele", "Hellen",
				"Isabela", "Joice", "Joseense" };
		String[] sobrenomes = { "Afonso", "Balera", "Seco", "Vieira", "Mendes", "Miyahira", "Garcia", "Cunha", "Santos",
				"Fl�vio" };
		String[] ultimoNome = { "Magalh�es", "Alves", "Silva", "Pereira", "Mathias", "Camargo", "Moraes", "Rodrigues",
				"Fonseca", "Azevedo" };
		String[] tag = { "TARGET QA" };
		StringBuilder nomeAleatorio = new StringBuilder();
		nomeAleatorio.append(nomes[new Random().nextInt(50)]).append(" ").append(sobrenomes[new Random().nextInt(9)])
				.append(" de ").append(ultimoNome[new Random().nextInt(9)]).append("")
				.append(tag[new Random().nextInt(1)]).append("");
		return nomeAleatorio.toString();
	}

	/***
	 * Gera nome de empresas aleatoriamente
	 * 
	 * @return
	 */
	public String geraEmpresaAleatorio() {
		String[] empresa = { "Col�gio Adventista de Sorocaba", "Col�gio Vincere", "Col�gio Polit�cnico de Sorocaba",
				"Objetivo Sorocaba - unidade Centro", "Col�gio Talentos International", "Col�gio Salesiano S�o Jos�",
				"Col�gio Dom Aguirre", "Col�gio Primeiro Mundo", "Col�gio Humanus", "Col�gio Ser",
				"Col�gio Tableau - Sorocaba", "Col�gio Sorocaba", "Col�gio Veritas", "Col�gio Renascer",
				"Col�gio M�ltiplo Sorocaba", "Col�gio Ivo de Almeida", "Col�gio Uirapuru", "COC Sorocaba",
				"Col�gio O Farol" };
		String[] sociedade = { "LTDA", "ME", "EIRELI", "S/A", "EPP" };
		String[] tag = { "TARGET QA" };
		StringBuilder empresaAleatorio = new StringBuilder();
		empresaAleatorio.append(empresa[new Random().nextInt(18)]).append(" ")
				.append(sociedade[new Random().nextInt(4)]).append(" ").append(tag[new Random().nextInt(1)]).append("");
		return empresaAleatorio.toString();
	}

	/***
	 * Gera e-mail aleatoriamente
	 * 
	 * @return
	 */
	public String GeraEmailAleatorio() {
		String[] nomes = { "administracao", "adgomes", "afpres", "estagio", "ferramentaria", "alberflex", "figueiredo",
				"bastos", "atendimento", "medeiros", "cerac", "cityrh", "comercial", "financeiro", "contabilidade",
				"rh", "dp", "tecnologia", "consultoria", "contato", "curriculos", "cursos", "design", "cv",
				"diretoriabrasilmarcas", "disk", "eadiaurora", "easyte", "emprego", "exportacao" };
		String[] arroba = { "@" };
		String[] tag = { "targetqa" };
		String[] complemento = { ".com.br" };
		StringBuilder emailAleatorio = new StringBuilder();
		emailAleatorio.append(nomes[new Random().nextInt(29)]).append(arroba[new Random().nextInt(1)])
				.append(tag[new Random().nextInt(1)]).append(complemento[new Random().nextInt(1)]);
		return emailAleatorio.toString();
	}

	/***
	 * Gera estado aleatoriamente.
	 * 
	 * @return
	 */
	public String geraEstadoAleatorio() {
		String[] estados = { "Acre", "Alagoas", "Amap�", "Amazonas", "Bahia", "Cear�", "Distrito Federal",
				"Esp�rito Santo", "Goi�s", "Maranh�o", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Paran�",
				"Para�ba", "Par�", "Pernambuco", "Piau�", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul",
				"Rond�nia", "Roraima", "Santa Catarina", "Sergipe", "S�o Paulo", "Tocantins" };
		String[] tag = { "TARGET QA" };
		StringBuilder estadosAleatorio = new StringBuilder();
		estadosAleatorio.append(estados[new Random().nextInt(26)]).append(" ").append(tag[new Random().nextInt(1)])
				.append("");
		return estadosAleatorio.toString();
	}

	/**
	 * Gera municipio aleatoriamente.
	 * 
	 * @return
	 */
	public String GeraMunicipioAleatorio() {
		String[] municipio = { "Abadia dos Dourados", "Abaet�", "Abre-Campo", "Acaiaca", "A�ucena", "�gua Boa",
				"�gua Comprida", "Aguanil", "�guas Formosas", "�guas Vermelhas", "Aimor�s", "Aiuruoca", "Alagoa",
				"Albertina", "Al�m Para�ba", "Alfenas", "Alfredo Vasconcelos", "Almenara", "Alpercata" };
		String[] tag = { "TARGET QA" };
		StringBuilder estadosAleatorio = new StringBuilder();
		estadosAleatorio.append(municipio[new Random().nextInt(26)]).append(" ").append(tag[new Random().nextInt(1)])
				.append("");
		return estadosAleatorio.toString();
	}

	/***
	 * Gera regi�o aleatoriamente.
	 * 
	 * @return
	 */
	public String GeraRegiaoAleatorio() {
		String[] regiao = { "Norte", "Nordeste", "Centro-Oeste", "Sudeste", "Sul" };
		String[] tag = { "TARGET QA" };
		StringBuilder regiaoAleatorio = new StringBuilder();
		regiaoAleatorio.append(regiao[new Random().nextInt(5)]).append(" ").append(tag[new Random().nextInt(1)])
				.append("");
		return regiaoAleatorio.toString();
	}

	/***
	 * Gera departamento comercial aleatoriamente
	 * 
	 * @return
	 */
	public String GeraDepartamentoAleatorio() {
		String[] departamento = { "Financeiro", "RH", "Comercial", "Tecnologia", "Administrativo", "Produ��o",
				"Controladoria Auditoria", "Contas a Pagar", "Tesouraria", "Contas a Receber", "Or�amentos",
				"Analise de Cr�dito", "Cobran�a", "Rela��es com Mercadorias", "Manuten��o", "Suprimentos", "PCP",
				"Engenharia Desenvolvimento de Novos Produtos", "Logistica estocagem prod. acabado",
				"Controle de Qualidade", "Planejamento / Controle", "Suporte a Clientes", "Marketing", "Contabilidade",
				"Faturamento Livros Fiscais", "Controle Patrimonial", "Importa��o", "Rela��es Publicas", "Vendas",
				"Exporta��o" };
		String[] tag = { "TARGET QA" };
		StringBuilder departamentoAleatorio = new StringBuilder();
		departamentoAleatorio.append(departamento[new Random().nextInt(30)]).append(" ")
				.append(tag[new Random().nextInt(1)]).append("");
		return departamentoAleatorio.toString();
	}

	/***
	 * Gera mesorregi�o aleatoriamente.
	 * 
	 * @return
	 */
	public String GeraMesorregiaoAleatorio() {
		String[] mesorregiao = { "Agreste Alagoano", "Agreste Paraibano", "Agreste Pernambucano", "Agreste Potiguar",
				"Agreste Sergipano", "Araraquara/Central Paulista", "Ara�atuba", "Assis", "Baixadas Litor�neas",
				"Baixo Amazonas", "Bauru", "Borborema", "Campinas", "Campo das Vertentes", "Central Esp�rito-Santense",
				"Central Mineira", "Central Potiguar", "Centro Amazonense", "Centro de Goi�s", "Centro Fluminense",
				"Centro Maranhense", "Centro Ocidental Paranaense", "Centro Ocidental Rio-Grandense",
				"Centro Oriental Paranaense", "Centro Oriental Rio-Grandense", "Centro-Norte Baiano",
				"Centro-Norte de Mato Grosso do Sul", "Centro - Norte Piauiense", "Centro - Sul Baiano",
				"Centro - Sul Cearense", "Centro - Sul Mato - Grossense", "Centro - Sul Paranaense", "Distrito Federal",
				"Extremo Oeste Baiano", "Grande Florian�polis", "Itapetininga", "Jaguaribe", "Jequitinhonha",
				"Leste Alagoano", "Leste de Goi�s", "Leste de Mato Grosso do Sul", "Leste Maranhense", "Leste Potiguar",
				"Leste Rondoniense", "Leste Sergipano", "Litoral Norte Esp�rito - Santense", "Litoral Sul Paulista",
				"Macro Metropolitana Paulista", "Madeira - Guapor�", "Maraj�", "Mar�lia", "Mata Paraibana",
				"Mata Pernambucana", "Metropolitana de Belo Horizonte", "Metropolitana de Bel�m",
				"Metropolitana de Curitiba", "Metropolitana de Fortaleza", "Metropolitana de Porto Alegre",
				"Metropolitana de Salvador", "Metropolitana de S�o Paulo", "Metropolitana do Recife",
				"Metropolitana do Rio de Janeiro", "Nordeste Baiano", "Nordeste Mato-Grossense", "Nordeste Paraense",
				"Nordeste Rio-Grandense", "Noroeste Cearense", "Noroeste de Goi�s", "Noroeste de Minas",
				"Noroeste Esp�rito-Santense", "Noroeste Fluminense", "Noroeste Paranaense", "Noroeste Rio-Grandense",
				"Norte Amazonense", "Norte Catarinense", "Norte Cearense", "Norte Central Paranaense", "Norte de Goi�s",
				"Norte de Minas", "Norte de Roraima", "Norte do Amap�", "Norte Fluminense", "Norte Maranhense",
				"Norte Mato-Grossense", "Norte Piauiense", "Norte Pioneiro Paranaense", "Ocidental do Tocantins",
				"Oeste Catarinense", "Oeste de Minas", "Oeste Maranhense", "Oeste Paranaense", "Oeste Potiguar",
				"Oriental do Tocantins", "Pantanais Sul - Mato - Grossenses", "Piracicaba", "Presidente Prudente",
				"Ribeir�o Preto", "Serrana", "Sert�o Alagoano", "Sert�o Paraibano", "Sert�o Pernambucano",
				"Sert�o Sergipano", "Sert�es Cearenses", "Sudeste Mato-Grossense", "Sudeste Paraense",
				"Sudeste Paranaense", "Sudeste Piauiense", "Sudeste Rio-Grandense", "Sudoeste Amazonense",
				"Sudoeste de Mato Grosso do Sul", "Sudoeste Mato - Grossense", "Sudoeste Paraense",
				"Sudoeste Paranaense", "Sudoeste Piauiense", "Sudoeste Rio-Grandense", "Sul Amazonense", "Sul Baiano",
				"Sul Catarinense", "Sul Cearense", "Sul de Roraima", "Sul do Amap�", "Sul e Sudoeste de Minas",
				"Sul Esp�rito - Santense", "Sul Fluminense", "Sul Goiano", "Sul Maranhense",
				"S�o Francisco Pernambucano", "S�o Jos� do Rio Preto", "Tri�ngulo Mineiro e Alto Parana�ba",
				"Vale do Acre", "Vale do Itaja�", "Vale do Juru�", "Vale do Mucuri", "Vale do Para�ba Paulista",
				"Vale do Rio Doce", "Vale S�o - Franciscano da Bahia", "Zona da Mata", "Mat�o" };
		String[] tag = { "TARGET QA" };
		StringBuilder mesorregiaoAleatorio = new StringBuilder();
		mesorregiaoAleatorio.append(mesorregiao[new Random().nextInt(137)]).append(" ")
				.append(tag[new Random().nextInt(1)]).append("");
		return mesorregiaoAleatorio.toString();
	}

	/***
	 * Espera a p�gina carregar conforme o tempo informado em milesegundos.
	 * 
	 * @param tempo
	 * @throws InterruptedException
	 */
	public void esperaCarregar(int tempo) throws InterruptedException {

		Thread.sleep(tempo);

	}

	/***
	 * Escreve no campo informado.
	 * 
	 * @param by
	 * @param texto
	 */
	public void escreveTexto(By by, String texto) {

		getDriver().findElement(by).sendKeys(texto);
	}

	/***
	 * Escreve no campo informado por id.
	 * 
	 * @param id_campo
	 * @param texto
	 */
	public void escreveId(String id_campo, String texto) {
		escreveTexto(By.id(id_campo), texto);
	}

	/***
	 * Clica no bot�o via comando By Ex By.xpath("campo").
	 * 
	 * @param by
	 */
	public void clicarBotaoBy(By by) {
		getDriver().findElement(by).click();
	}

	/***
	 * maximizar Browser
	 */
	public void maximizaJanela() {

		getDriver().manage().window().maximize();
	}

	/***
	 * Executa rolagem da p�gina. Exemplo: RolarPagina("scroll(0,650)");
	 * 
	 * @param rolagem
	 */
	public void RolarPagina(String rolagem) {
		((JavascriptExecutor) getDriver()).executeScript("scroll(0,400)");
	}

	/***
	 * Gera t�tulos aleatorios.
	 * 
	 * @return
	 */
	public String GerarTituloAleatorio() {
		String[] Titulo = { "CNA na Escola p�blica", "CNA Go", "Don't Bee Loro", " CNA Portal Corporativo" };

		StringBuilder TituloAleatorio = new StringBuilder();
		TituloAleatorio.append(Titulo[new Random().nextInt(4)]).append(" ");
		return TituloAleatorio.toString();
	}

}
