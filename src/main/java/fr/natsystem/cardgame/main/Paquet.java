package fr.natsystem.cardgame.main;

import fr.natsystem.cardgame.entites.Carte;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Paquet {

    private List<Carte> paquet;

    public Paquet() {
        this.paquet = new ArrayList<>(52);
    }

}
