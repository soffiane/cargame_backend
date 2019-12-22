package fr.natsystem.cardgame.entites;

import fr.natsystem.cardgame.validator.EnumValidator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Carte implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    @NotNull
    @NotEmpty(message = "la couleur de la carte doit etre renseignée")
    @EnumValidator(enumClazz = Couleur.class)
    private String couleur;

    @Column
    @NotNull
    @NotEmpty(message = "la valeur de la carte doit etre renseignée")
    @EnumValidator(enumClazz = Valeur.class)
    private String valeur;

    @Column
    private String img;

    public Carte(Couleur couleur, Valeur valeur, String img) {
        this.couleur = couleur.toString();
        this.valeur = valeur.toString();
        this.img = img;
    }

    @Override
    public String toString() {
        return "Carte { "+valeur+" de "+couleur+" nom_image : "+img+" }";
    }
}
