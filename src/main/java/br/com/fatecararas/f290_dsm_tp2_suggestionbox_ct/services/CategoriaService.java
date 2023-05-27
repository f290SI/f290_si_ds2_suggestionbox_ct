package br.com.fatecararas.f290_dsm_tp2_suggestionbox_ct.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.fatecararas.f290_dsm_tp2_suggestionbox_ct.model.entities.Categoria;
import br.com.fatecararas.f290_dsm_tp2_suggestionbox_ct.repositories.CategoriaRepository;

@Service
public class CategoriaService {

    private CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public List<Categoria> buscarTodas() {
        return repository.findAll();
    }

    public Categoria criar(Categoria categoria) {
        return repository.save(categoria);
    }

    public void apagar(Integer id) {
        repository.deleteById(id);
    }

    public Categoria buscarPorId(Integer id) {
        Optional<Categoria> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new RuntimeException("Categoria não encontrada. ID: " + id);
        }
        return optional.get();
    }

}
