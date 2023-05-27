package br.com.fatecararas.f290_si_ds2_suggestionbox_ct.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fatecararas.f290_si_ds2_suggestionbox_ct.model.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    
}
