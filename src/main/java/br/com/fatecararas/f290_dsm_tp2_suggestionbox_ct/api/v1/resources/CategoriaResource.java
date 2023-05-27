package br.com.fatecararas.f290_dsm_tp2_suggestionbox_ct.api.v1.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fatecararas.f290_dsm_tp2_suggestionbox_ct.model.entities.Categoria;
import br.com.fatecararas.f290_dsm_tp2_suggestionbox_ct.services.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaResource {

    @Autowired
    private CategoriaService service;

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/todas")
    public List<Categoria> getCategoria() {
        return service.buscarTodas();
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<Categoria> criar(@RequestBody Categoria categoria) {

        Categoria novaCategoria = service.criar(categoria);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(novaCategoria.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }
}
