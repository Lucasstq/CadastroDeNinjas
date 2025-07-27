package dev.java10x.CadastroDeNinjas.ninja.repository;

import dev.java10x.CadastroDeNinjas.ninja.ninjaModel.NinjaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NinjaRepository extends JpaRepository<NinjaModel, Long> {
}
