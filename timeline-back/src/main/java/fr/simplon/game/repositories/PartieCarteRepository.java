package fr.simplon.game.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.simplon.game.entities.PartieCarte;
import fr.simplon.game.entities.PartieCartePK;

public interface PartieCarteRepository extends JpaRepository<PartieCarte, PartieCartePK> {

}
