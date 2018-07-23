package qa.target.bateriasmoura.core;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.Random;


public class DSL {
	
	private WebDriver driver;
	
	public DSL(WebDriver driver) {
		this.driver = driver;
	}
	
	private int randomiza(int n) {
        int ranNum = (int) (Math.random() * n);
		return ranNum;
	}

	private int mod(int dividendo, int divisor) {
		return (int) Math.round(dividendo - (Math.floor(dividendo / divisor) * divisor));
	}

	
	/********* CNPJ, CPF, Pessoa, Empresa e E-mail ************/
	
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

		int d2 = d1 * 2 + n9 * 3 + n8 * 4 + n7 * 5 + n6 * 6 + n5 * 7 + n4 * 8 + n3 * 9 + n2 * 10 + n1 * 11;

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
		int n9 = 0; //randomiza(n);
		int n10 = 0; //randomiza(n);
		int n11 = 0; //randomiza(n);
		int n12 = 1; //randomiza(n);
		int d1 = n12 * 2 + n11 * 3 + n10 * 4 + n9 * 5 + n8 * 6 + n7 * 7 + n6 * 8 + n5 * 9 + n4 * 2 + n3 * 3 + n2 * 4 + n1 * 5;

		d1 = 11 - (mod(d1, 11));

		if (d1 >= 10)
			d1 = 0;

		int d2 = d1 * 2 + n12 * 3 + n11 * 4 + n10 * 5 + n9 * 6 + n8 * 7 + n7 * 8 + n6 * 9 + n5 * 2 + n4 * 3 + n3 * 4 + n2 * 5 + n1 * 6;

		d2 = 11 - (mod(d2, 11));

		if (d2 >= 10)
			d2 = 0;

		String retorno = null;

		if (comPontos)
			retorno = "" + n1 + n2 + "." + n3 + n4 + n5 + "." + n6 + n7 + n8 + "/" + n9 + n10 + n11 + n12 + "-" + d1 + d2;
		else
			retorno = "" + n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8 + n9 + n10 + n11 + n12 + d1 + d2;

		return retorno;
	}
	
	
	public String geraNomeAleatorio()
    {
        String[] nomes = { "Antonio", "Rafael", "Bruno", "Marcelo", "Alberto", "Pedro", "Anderson", "Airton", "Sidney", "Wilson", "Carlos", "C�ndido", "Hugo", "Jo�o", "Mauro", "Leonardo", "Natanael", "Reinaldo", "Orlando", "Tiago", "Gildo", "Alfredo", "Maur�cio", "Jurandir", "Paulo", "Juv�ncio", "Daniel", "Jair", "Juvenal", "Jorge" };
        String[] sobrenomes = { "Afonso", "Balera", "Seco", "Vieira", "Mendes", "Miyahira", "Garcia", "Cunha", "Santos", "Fl�vio" };
        String[] ultimoNome = { "Magalh�es", "Alves", "Silva", "Pereira", "Mathias", "Camargo", "Moraes", "Rodrigues", "Fonseca", "Azevedo" };

        StringBuilder nomeAleatorio = new StringBuilder();

        nomeAleatorio.append(nomes[new Random().nextInt(29)])
                     .append(" ")
                     .append(sobrenomes[new Random().nextInt(9)])
                     .append(" de ")
                     .append(ultimoNome[new Random().nextInt(9)])
                     .append(" ")
                     .append(this.hashCode());

        return nomeAleatorio.toString();
    }
	
	
	public String geraEmpresaAleatorio()
    {
        String[] nomes = { "atendimento","contato", "orcamento", "despesa", "RH", "dp", "recursos.humanos", "deposito", "gerente", "gestor", "diretoria", "almoxarifado", "balconista"};
        String[] sobrenomes = { "Auto", "Lar", "Seco", "Vieira", "Mendes", "Miyahira", "Garcia", "Cunha", "Santos", "Fl�vio" };
        String[] ultimoNome = { "LTDA", "ME", "EIRELI", "S/A", "EPP" };

        StringBuilder empresaAleatorio = new StringBuilder();

        empresaAleatorio.append(nomes[new Random().nextInt(13)])
                     .append(" ")
                     .append(sobrenomes[new Random().nextInt(9)])
                     .append(" ")
                     .append(ultimoNome[new Random().nextInt(5)])
                     .append(" ")
                     .append(this.hashCode());

        return empresaAleatorio.toString();
    }
	
	public String geraEmailAleatorio()
    {
        String[] nomes = { "A Rates", "Integrid", "Sun", "J & J", "Grill", "Grafic", "TOP GUN", "Balon Balon", "Destiny", "The Angels", "Quantum", "Place", "Unconventional", "Metro", "Samurai", "Simpson", "Natanael", "Wall", "Orlando", "Street", "Gildo", "Coca", "MicroL", "Jurask", "UMO", "ARDIDAS", "WeDoLogos", "CaraLivro", "Juvenal", "DEMINU" };
        String[] arroba = {"@"} ;
        String[] ultimoNome = { "Auto", "Lar", "Seco", "Vieira", "Mendes", "Miyahira", "Garcia", "Cunha", "Santos", "Fl�vio", "LTDA", "ME", "EIRELI", "S/A", "EPP" };
        String[] complemento = {".com.br"};

        StringBuilder emailAleatorio = new StringBuilder();

        emailAleatorio.append(nomes[new Random().nextInt(29)])
                      .append(arroba[new Random().nextInt(1)])
                      .append(ultimoNome[new Random().nextInt(5)])
                      .append(complemento[new Random().nextInt(1)]);
                      

        return emailAleatorio.toString();
    }
	
	
	/********* TextField e TextArea ************/
    
    public void escrever(By by, String texto){
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(texto);
    }

	
	public void escreverNaClasse(String nome_classe, String texto) {
		escrever(By.className(nome_classe), texto);
	}

	public void escreverId(String id_campo, String texto){
        escrever(By.id(id_campo), texto);
    }
    
    public String obterValorCampo(String id_campo) {
        return driver.findElement(By.id(id_campo)).getAttribute("value");
    }
    
    public String obterValorTexto(String id_campo) {
    	
    	return driver.findElement(By.id(id_campo)).getText();
    	
    }
    
    public void checarCampoObrigatorio (String texto, String id_campo) {
    	Assert.assertEquals(texto, obterTexto(id_campo));
    }
    
   
	
	/********* Radio e Check ************/
    
    
    public void clicarRadio(By by) {
        driver.findElement(by).click();
    }
  	
    
	public void clicarRadioId(String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public boolean isRadioMarcado(String id){
		return driver.findElement(By.id(id)).isSelected();
	}
	
	
	public void clicarCheckId(String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public boolean isCheckMarcado(String id){
		return driver.findElement(By.id(id)).isSelected();
	}
	
	public void isCheckMarcadoComEspaco(String id) {		
		driver.findElement(By.id(id)).sendKeys(Keys.SPACE);
	}
	
	/********* Combo ************/
	
	public void selecionarComboAjax (String class_campo, String texto) {
		
		WebElement combo = driver.findElement(By.className(class_campo));
		combo.sendKeys(Keys.SPACE);
		combo.findElement(By.tagName(texto)).submit();
		
		
	}
	
	public void selecionarCombo(String id, String valor) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}
	
	public void deselecionarCombo(String id, String valor) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		combo.deselectByVisibleText(valor);
	}

	public String obterValorCombo(String id) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}
	
	public List<String> obterValoresCombo(String id) {
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		List<String> valores = new ArrayList<String>();
		for(WebElement opcao: allSelectedOptions) {
			valores.add(opcao.getText());
		}
		return valores;
	}
	
	public int obterQuantidadeOpcoesCombo(String id){
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		return options.size();
	}
	
	public boolean verificarOpcaoCombo(String id, String opcao){
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		for(WebElement option: options) {
			if(option.getText().equals(opcao)){
				return true;
			}
		}
		return false;
	}
	
	public void selecionarComboPrime(String radical, String valor) {
		clicarRadio(By.xpath("//*[@id='"+radical+"_input']/../..//span"));
		clicarRadio(By.xpath("//*[@id='"+radical+"_items']//li[.='"+valor+"']"));
	}
	
	public void selecionarComboPorVisibleText(String id_campo, String texto)
    {

        new Select(driver.findElement(By.id(id_campo)))
        .selectByVisibleText(texto);

    }
	
		
	/********* Botao ************/
	
	public void clicarBotaoBy(By by) {
		driver.findElement(by).click();
	}
	
	public void clicarBotaoId(String id) {
		clicarBotaoBy(By.id(id));
	}
	
	public void clicarBotaoClass(String classe) {
		driver.findElement(By.className(classe)).click();
	}
	
	public String obterValueElemento(String id) {
		return driver.findElement(By.id(id)).getAttribute("value");
	}
	
	public void clicarBotaoPorTexto(String texto){
		clicarBotaoBy(By.xpath("//button[.='"+texto+"']"));
	}
	
	
	/********* Link ************/
	
	public void clicarLink(String link) {
		driver.findElement(By.linkText(link)).click();
	}
	
	/********* Textos ************/
	
	public String obterTexto(By by) {
		return driver.findElement(by).getText();
	}
	
	public String obterTexto(String id) {
		return obterTexto(By.id(id));
	}
	
	/********* Alerts ************/
	
	public String alertaObterTexto(){
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}
	
	public String alertaObterTextoEAceita(){
		Alert alert = driver.switchTo().alert();
		String valor = alert.getText();
		alert.accept();
		return valor;
		
	}
	
	public String alertaObterTextoENega(){
		Alert alert = driver.switchTo().alert();
		String valor = alert.getText();
		alert.dismiss();
		return valor;
		
	}
	
	public void alertaEscrever(String valor) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(valor);
		alert.accept();
	}
	
	/********* Frames e Janelas ************/
	
	public void entrarFrame(String id) {
		driver.switchTo().frame(id);
	}
	
	public void sairFrame(){
		driver.switchTo().defaultContent();
	}
	
	public void trocarJanela(String id) {
		driver.switchTo().window(id);
	}
	
	/************** JS *********************/
	
	public Object executarJS(String cmd, Object... param) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript(cmd, param);
	}
	
	/************** Tabela *********************/
	
	public WebElement obterCelula(String colunaBusca, String valor, String colunaBotao, String idTabela){
		
		//procurar coluna do registro
		WebElement tabela = driver.findElement(By.xpath("//*[@id='"+idTabela+"']"));
		int idColuna = obterIndiceColuna(colunaBusca, tabela);
		
		//encontrar a linha do registro
		int idLinha = obterIndiceLinha(valor, tabela, idColuna);
		
		//procurar coluna do botao
		int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);
		
		//clicar no botao da celula encontrada
		WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColunaBotao+"]"));
		return celula;
	}
	
	public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela){
		WebElement celula = obterCelula(colunaBusca, valor, colunaBotao, idTabela);
		celula.findElement(By.xpath(".//input")).click();
		
	}

	protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));
		int idLinha = -1;
		for(int i = 0; i < linhas.size(); i++) {
			if(linhas.get(i).getText().equals(valor)) {
				idLinha = i+1;
				break;
			}
		}
		return idLinha;
	}

	protected int obterIndiceColuna(String coluna, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
		int idColuna = -1;
		for(int i = 0; i < colunas.size(); i++) {
			if(colunas.get(i).getText().equals(coluna)) {
				idColuna = i+1;
				break;
			}
		}
		return idColuna;
	}
}