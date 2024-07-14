package Projekt.projekcik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class ProjekcikApplication implements CommandLineRunner {

	@Autowired
	private PacjenciRepository pacjenciRepository;

	@Autowired
	private KontoPacjentaRepository kontoPacjentaRepository;


	@Autowired
	private AdresRepository adresRepository;


	@Autowired
	private ZakładanieKontaPacjenta zakładanieKontaPacjenta;


	@Autowired
	private UmawianieWizyty umawianieWizyty;

	@Autowired
	private PrzekladanieWizyty przekladanieWizyty;

	@Autowired
	private Menu menu;

	public static void main(String[] args) {
		SpringApplication.run(ProjekcikApplication.class, args);
	}

	@Override
	public void run(String[] args){
		menu.wyswietlMenu();

	}
}
