package qa.bateriasmoura.core;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class DSL {

	private int randomiza(int n) {
		int ranNum = (int) (Math.random() * n);
		return ranNum;
	}

	private int mod(int dividendo, int divisor) {
		return (int) Math.round(dividendo - (Math.floor(dividendo / divisor) * divisor));
	}

	/******** CNPJ, CPF, Pessoa, Empresa e E-mail ***********/

	/**
	 * Gera CPF Aleatório com pontos ou sem pontos.
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

	public String geraNomeAleatorio() {
		String[] nomes = { "Antonio", "Rafael", "Bruno", "Marcelo", "Alberto", "Pedro", "Anderson", "Airton", "Sidney",
				"Wilson", "Carlos", "Cândido", "Hugo", "João", "Mauro", "Leonardo", "Natanael", "Reinaldo", "Orlando",
				"Tiago", "Gildo", "Alfredo", "Maurício", "Jurandir", "Paulo", "Juvêncio", "Daniel", "Jair", "Juvenal",
				"Jorge", "Agiliza", "Alessandro", "Alexandre", "Aline", "Ana Paula", "Andressa", "Antonia", "Camila",
				"Carolina", "Cileia", "Debora", "Edna", "Ellen", "Eveline", "Fabio", "Fernanda", "Gesiele", "Hellen",
				"Isabela", "Joice", "Joseense" };
		String[] sobrenomes = { "Afonso", "Balera", "Seco", "Vieira", "Mendes", "Miyahira", "Garcia", "Cunha", "Santos",
				"Flávio" };
		String[] ultimoNome = { "Magalhães", "Alves", "Silva", "Pereira", "Mathias", "Camargo", "Moraes", "Rodrigues",
				"Fonseca", "Azevedo" };
		String[] tag = { "TARGET QA" };
		StringBuilder nomeAleatorio = new StringBuilder();
		nomeAleatorio.append(nomes[new Random().nextInt(50)]).append(" ").append(sobrenomes[new Random().nextInt(9)])
				.append(" de ").append(ultimoNome[new Random().nextInt(9)]).append("")
				.append(tag[new Random().nextInt(1)]).append("");
		return nomeAleatorio.toString();
	}

	public String geraEmpresaAleatorio() {
		String[] empresa = { "Colégio Adventista de Sorocaba", "Colégio Vincere", "Colégio Politécnico de Sorocaba",
				"Objetivo Sorocaba - unidade Centro", "Colégio Talentos International", "Colégio Salesiano São José",
				"Colégio Dom Aguirre", "Colégio Primeiro Mundo", "Colégio Humanus", "Colégio Ser",
				"Colégio Tableau - Sorocaba", "Colégio Sorocaba", "Colégio Veritas", "Colégio Renascer",
				"Colégio Múltiplo Sorocaba", "Colégio Ivo de Almeida", "Colégio Uirapuru", "COC Sorocaba",
				"Colégio O Farol" };
		String[] sociedade = { "LTDA", "ME", "EIRELI", "S/A", "EPP" };
		String[] tag = { "TARGET QA" };
		StringBuilder empresaAleatorio = new StringBuilder();
		empresaAleatorio.append(empresa[new Random().nextInt(18)]).append(" ")
				.append(sociedade[new Random().nextInt(4)]).append(" ").append(tag[new Random().nextInt(1)]).append("");
		return empresaAleatorio.toString();
	}

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

	public String geraEstadoAleatorio() {
		String[] estados = { "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal",
				"Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Paraná",
				"Paraíba", "Pará", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul",
				"Rondônia", "Roraima", "Santa Catarina", "Sergipe", "São Paulo", "Tocantins" };
		String[] tag = { "TARGET QA" };
		StringBuilder estadosAleatorio = new StringBuilder();
		estadosAleatorio.append(estados[new Random().nextInt(26)]).append(" ").append(tag[new Random().nextInt(1)])
				.append("");
		return estadosAleatorio.toString();
	}

	public String GeraMunicipioAleatorio() {
		String[] municipio = { "Abadia dos Dourados", "Abaeté", "Abre-Campo", "Acaiaca", "Açucena", "Água Boa",
				"Água Comprida", "Aguanil", "Águas Formosas", "Águas Vermelhas", "Aimorés", "Aiuruoca", "Alagoa",
				"Albertina", "Além Paraíba", "Alfenas", "Alfredo Vasconcelos", "Almenara", "Alpercata" };
		String[] tag = { "TARGET QA" };
		StringBuilder estadosAleatorio = new StringBuilder();
		estadosAleatorio.append(municipio[new Random().nextInt(26)]).append(" ").append(tag[new Random().nextInt(1)])
				.append("");
		return estadosAleatorio.toString();
	}

	public String GeraRegiaoAleatorio() {
		String[] regiao = { "Norte", "Nordeste", "Centro-Oeste", "Sudeste", "Sul" };
		String[] tag = { "TARGET QA" };
		StringBuilder regiaoAleatorio = new StringBuilder();
		regiaoAleatorio.append(regiao[new Random().nextInt(5)]).append(" ").append(tag[new Random().nextInt(1)])
				.append("");
		return regiaoAleatorio.toString();
	}

	public String geraDepartamentoAleatorio() {
		String[] departamento = { "Financeiro", "RH", "Comercial", "Tecnologia", "Administrativo", "Produção",
				"Controladoria Auditoria", "Contas a Pagar", "Tesouraria", "Contas a Receber", "Orçamentos",
				"Analise de Crédito", "Cobrança", "Relações com Mercadorias", "Manutenção", "Suprimentos", "PCP",
				"Engenharia Desenvolvimento de Novos Produtos", "Logistica estocagem prod. acabado",
				"Controle de Qualidade", "Planejamento / Controle", "Suporte a Clientes", "Marketing", "Contabilidade",
				"Faturamento Livros Fiscais", "Controle Patrimonial", "Importação", "Relações Publicas", "Vendas",
				"Exportação" };
		String[] tag = { "TARGET QA" };
		StringBuilder departamentoAleatorio = new StringBuilder();
		departamentoAleatorio.append(departamento[new Random().nextInt(30)]).append(" ")
				.append(tag[new Random().nextInt(1)]).append("");
		return departamentoAleatorio.toString();
	}

	public String GeraMesorregiaoAleatorio() {
		String[] mesorregiao = { "Agreste Alagoano", "Agreste Paraibano", "Agreste Pernambucano", "Agreste Potiguar",
				"Agreste Sergipano", "Araraquara/Central Paulista", "Araçatuba", "Assis", "Baixadas Litorâneas",
				"Baixo Amazonas", "Bauru", "Borborema", "Campinas", "Campo das Vertentes", "Central Espírito-Santense",
				"Central Mineira", "Central Potiguar", "Centro Amazonense", "Centro de Goiás", "Centro Fluminense",
				"Centro Maranhense", "Centro Ocidental Paranaense", "Centro Ocidental Rio-Grandense",
				"Centro Oriental Paranaense", "Centro Oriental Rio-Grandense", "Centro-Norte Baiano",
				"Centro-Norte de Mato Grosso do Sul", "Centro - Norte Piauiense", "Centro - Sul Baiano",
				"Centro - Sul Cearense", "Centro - Sul Mato - Grossense", "Centro - Sul Paranaense", "Distrito Federal",
				"Extremo Oeste Baiano", "Grande Florianópolis", "Itapetininga", "Jaguaribe", "Jequitinhonha",
				"Leste Alagoano", "Leste de Goiás", "Leste de Mato Grosso do Sul", "Leste Maranhense", "Leste Potiguar",
				"Leste Rondoniense", "Leste Sergipano", "Litoral Norte Espírito - Santense", "Litoral Sul Paulista",
				"Macro Metropolitana Paulista", "Madeira - Guaporé", "Marajó", "Marília", "Mata Paraibana",
				"Mata Pernambucana", "Metropolitana de Belo Horizonte", "Metropolitana de Belém",
				"Metropolitana de Curitiba", "Metropolitana de Fortaleza", "Metropolitana de Porto Alegre",
				"Metropolitana de Salvador", "Metropolitana de São Paulo", "Metropolitana do Recife",
				"Metropolitana do Rio de Janeiro", "Nordeste Baiano", "Nordeste Mato-Grossense", "Nordeste Paraense",
				"Nordeste Rio-Grandense", "Noroeste Cearense", "Noroeste de Goiás", "Noroeste de Minas",
				"Noroeste Espírito-Santense", "Noroeste Fluminense", "Noroeste Paranaense", "Noroeste Rio-Grandense",
				"Norte Amazonense", "Norte Catarinense", "Norte Cearense", "Norte Central Paranaense", "Norte de Goiás",
				"Norte de Minas", "Norte de Roraima", "Norte do Amapá", "Norte Fluminense", "Norte Maranhense",
				"Norte Mato-Grossense", "Norte Piauiense", "Norte Pioneiro Paranaense", "Ocidental do Tocantins",
				"Oeste Catarinense", "Oeste de Minas", "Oeste Maranhense", "Oeste Paranaense", "Oeste Potiguar",
				"Oriental do Tocantins", "Pantanais Sul - Mato - Grossenses", "Piracicaba", "Presidente Prudente",
				"Ribeirão Preto", "Serrana", "Sertão Alagoano", "Sertão Paraibano", "Sertão Pernambucano",
				"Sertão Sergipano", "Sertões Cearenses", "Sudeste Mato-Grossense", "Sudeste Paraense",
				"Sudeste Paranaense", "Sudeste Piauiense", "Sudeste Rio-Grandense", "Sudoeste Amazonense",
				"Sudoeste de Mato Grosso do Sul", "Sudoeste Mato - Grossense", "Sudoeste Paraense",
				"Sudoeste Paranaense", "Sudoeste Piauiense", "Sudoeste Rio-Grandense", "Sul Amazonense", "Sul Baiano",
				"Sul Catarinense", "Sul Cearense", "Sul de Roraima", "Sul do Amapá", "Sul e Sudoeste de Minas",
				"Sul Espírito - Santense", "Sul Fluminense", "Sul Goiano", "Sul Maranhense",
				"São Francisco Pernambucano", "São José do Rio Preto", "Triângulo Mineiro e Alto Paranaíba",
				"Vale do Acre", "Vale do Itajaí", "Vale do Juruá", "Vale do Mucuri", "Vale do Paraíba Paulista",
				"Vale do Rio Doce", "Vale São - Franciscano da Bahia", "Zona da Mata", "Matão" };
		String[] tag = { "TARGET QA" };
		StringBuilder mesorregiaoAleatorio = new StringBuilder();
		mesorregiaoAleatorio.append(mesorregiao[new Random().nextInt(137)]).append(" ")
				.append(tag[new Random().nextInt(1)]).append("");
		return mesorregiaoAleatorio.toString();
	}

	public void esperaCarregar(int tempo) throws InterruptedException {

		Thread.sleep(tempo);

	}

	public void escreveId(String id_campo, String texto) {
		escreveTexto(By.id(id_campo), texto);
	}

	public void escreveTexto(By by, String texto) {

		DriverFactory.getDriver().findElement(by).sendKeys(texto);
	}

	public void clicarBotaoBy(By by) {
		DriverFactory.getDriver().findElement(by).click();
	}

	/***
	 * maximizar Browser
	 */
	public void maximizaJanela() {

		DriverFactory.getDriver().manage().window().maximize();
	}

	/***
	 * Executa rolagem da página. Exemplo: RolarPagina("scroll(0,650)");
	 * 
	 * @param rolagem
	 */
	public void RolarPagina(String rolagem) {
		((JavascriptExecutor) DriverFactory.getDriver()).executeScript("scroll(0,400)");
	}

}
