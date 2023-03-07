package com.example.Repository;

import com.example.Entity.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@Repository
public interface AdresseRepo extends JpaRepository<Adresse,Integer> {
}
