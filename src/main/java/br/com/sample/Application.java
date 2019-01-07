package br.com.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import br.com.sample.model.Produto;
import br.com.sample.services.ProdutoService;

@SpringBootApplication
@Import(br.com.sample.config.MvcConfiguration.class)
public class Application implements CommandLineRunner{

	@Autowired
    ProdutoService produtoService;
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		produtoService.add(new Produto("Châteauneuf-du-Pape AOC La Bernardine", "511.03", "M. Chapoutier", "França", "Rhône", "2015", "Tinto", "Grenache com pequena parte de Syrah e Mourvèdre", "14.5", "750ml"));
		produtoService.add(new Produto("Montes Cabernet Sauvignon Reserva", "92.95", "Vinã Montes", "Chile", "Chile", "2016", "Tinto", "Cabernet Sauvignon (85%) e Merlot (15%)", "14", "750ml"));
		produtoService.add(new Produto("Sassoalloro IGT", "291.84", "Castello di Montepò / Jacopo Biondi Santi", "Itália", "Toscana", "2015", "Tinto", "Sangiovese Grosso (Brunello)", "13.5", "750ml"));
		produtoService.add(new Produto("Domaine Tournon Mathilda Shiraz", "161.95", "M. Chapoutier", "Austrália", "Austrália", "2013", "Tinto", "Shiraz (100%)", "14", "750ml"));
		produtoService.add(new Produto("Alamos Malbec", "80.77", "Alamos - Catena Zapata", "Argentina" ,"Mendoza", "2017", "Tinto", "Malbec(100%)", "13", "750ml"));
		produtoService.add(new Produto("Altano", "97.01", "Altano / Symington", "Portugal", "Douro", "2015", "Tinto", "Tinta Roriz, Touriga Franca, Tinta Barroca", "13.5", "750ml"));
		produtoService.add(new Produto("La Ciboise Luberon AOC", "109.19", "M. Chapoutier", "França", "Rhône", "2016", "Tinto", "Grenache 60%, Syrah 40%", "14", "750ml"));
		produtoService.add(new Produto("Vallontano Tempranillo Rosé", "66.9", "Vallontano", "Brasil", "Vale dos Vinhedos", "2018", "Rosado", "Tempranillo", "11.5", "750ml"));
		produtoService.add(new Produto("Vallontano Chardonnay", "69.9", "Vallontano", "Brasil", "Vale dos Vinhedos", "2017", "Branco Seco", "Chardonnay(100%)", "12", "750ml"));
		produtoService.add(new Produto("Zeltinger Riesling S-O Kabinett", "202.54", "Selbach Oster", "Alemanha", "Alemanha", "2014", "Branco Seco", "Riesling", "11", "750ml"));
	}
}


