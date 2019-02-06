package fr.simplon.game.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.simplon.game.entities.Partie;

public interface PartieRepository extends JpaRepository<Partie, Long> {

}
