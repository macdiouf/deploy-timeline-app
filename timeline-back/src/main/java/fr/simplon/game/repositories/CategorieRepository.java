package fr.simplon.game.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.simplon.game.entities.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {

}
