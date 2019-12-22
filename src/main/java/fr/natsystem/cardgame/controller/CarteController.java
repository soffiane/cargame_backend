package fr.natsystem.cardgame.controller;

import fr.natsystem.cardgame.entites.Carte;
import fr.natsystem.cardgame.services.CarteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cards")
@CrossOrigin(origins = "http://localhost:4200")
public class CarteController {

    @Autowired
    private CarteService carteService;

    /**
     * Lister toutes les cartes.
     *
     * @return la liste des cartes
     */
    @GetMapping("")
    public ResponseEntity getAllCards() {
        ResponseEntity responseEntity = null;
        List<Carte> users = carteService.findAll();
        if (users.isEmpty()) {
            responseEntity = ResponseEntity.noContent().build();
        } else {
            responseEntity = ResponseEntity.ok(users);
        }
        return responseEntity;
    }

    /**
     * Recuperer une carte.
     *
     * @return la carte
     */
    @GetMapping("/{id}")
    public ResponseEntity getCard(@PathVariable(value = "id") final Long id) {
        Optional<Carte> carte =
                carteService
                        .findById(id);
        if (!carte.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carte.get());
    }

    /**
     * Prendre une carte au hasard.
     *
     * @return la carte tirée au hasard
     */
    @GetMapping("/random")
    public ResponseEntity getRandomCard() {
        ResponseEntity responseEntity = null;
        List<Carte> cartes = carteService.findAll();
        if (cartes.isEmpty()) {
            responseEntity = ResponseEntity.noContent().build();
        } else {
            responseEntity = ResponseEntity.ok(carteService.getRandomCard());
        }
        return responseEntity;
    }

}
