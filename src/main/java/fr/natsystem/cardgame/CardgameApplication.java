package fr.natsystem.cardgame;

import fr.natsystem.cardgame.entites.Carte;
import fr.natsystem.cardgame.entites.Couleur;
import fr.natsystem.cardgame.entites.Valeur;
import fr.natsystem.cardgame.main.Paquet;
import fr.natsystem.cardgame.services.CarteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class CardgameApplication {

	@Autowired
	private CarteService carteService;

	public static void main(String[] args) {
		SpringApplication.run(CardgameApplication.class, args);
	}

	@PostConstruct
	public void init() throws Exception {
		Paquet paquet = new Paquet();
		for(Couleur couleur : Couleur.values()){
			for(Valeur valeur : Valeur.values()){
				paquet.getPaquet().add(new Carte(couleur,valeur,valeur+"_"+couleur));
			}
		}
		paquet.getPaquet().stream().forEach(System.out::println);
		carteService.saveAll(paquet.getPaquet());

	}

}
