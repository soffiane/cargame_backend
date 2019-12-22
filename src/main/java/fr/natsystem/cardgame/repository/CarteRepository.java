package fr.natsystem.cardgame.repository;

import fr.natsystem.cardgame.entites.Carte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CarteRepository extends JpaRepository<Carte, Long> {
    @Query(value = "select * from Carte ORDER BY rand() limit 1", nativeQuery = true)
    Carte getRandomCard();
}
