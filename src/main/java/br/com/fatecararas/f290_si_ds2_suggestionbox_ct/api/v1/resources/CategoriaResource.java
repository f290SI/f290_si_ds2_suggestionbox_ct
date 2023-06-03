package br.com.fatecararas.f290_si_ds2_suggestionbox_ct.api.v1.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fatecararas.f290_si_ds2_suggestionbox_ct.model.entities.Categoria;
import br.com.fatecararas.f290_si_ds2_suggestionbox_ct.repositories.CategoriaRepository;
import br.com.fatecararas.f290_si_ds2_suggestionbox_ct.services.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaResource {

    @Autowired
    private CategoriaService service;
    @Autowired
    private CategoriaRepository repository;

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/todas")
    public List<Categoria> getCategorias() {
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

    @PutMapping("/{id}")
    public Categoria atualizar(@PathVariable("id") Integer id,
            @RequestBody Categoria categoria) {
        return service.atualizar(id, categoria);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable("id") Integer id) {
        service.apagar(id);
    }

    @GetMapping("/{id}")
    public Categoria buscarPorId(@PathVariable("id") Integer id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer id) {
        Optional<Categoria> optional = repository.findById(id);
        if(optional.isPresent()) {
            return ResponseEntity.ok().body(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
