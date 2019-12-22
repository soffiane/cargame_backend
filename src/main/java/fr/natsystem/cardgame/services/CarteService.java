package fr.natsystem.cardgame.services;

import fr.natsystem.cardgame.entites.Carte;
import fr.natsystem.cardgame.repository.CarteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarteService {
    private final CarteRepository carteRepository;

    public List<Carte> findAll() {
        return carteRepository.findAll();
    }

    public Optional<Carte> findById(Long id) {
        return carteRepository.findById(id);
    }

    public void saveAll(List<Carte> paquet) {
        carteRepository.saveAll(paquet);
    }

    public Carte getRandomCard() {
        return carteRepository.getRandomCard();
    }
}
