package fr.simplon.game.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.simplon.game.entities.Carte;

public interface CarteRepository extends JpaRepository<Carte, Long> {

}
