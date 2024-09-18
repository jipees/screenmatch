package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var cosumoApi = new CosumoApi();
		var json = cosumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=b85fa84d");

		System.out.println(json);

		// json = cosumoApi.obterDados("https://coffee.alexflipnote.dev/random.json");
		// System.out.println(json);
		ConverteDados converso = new ConverteDados();
		DadosSerie dados = converso.obterDados(json, DadosSerie.class);
		System.out.println(dados);

	}

}
