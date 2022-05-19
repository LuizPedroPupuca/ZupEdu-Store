package br.com.zup.edu.store;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
public class AplicativoController {

    public final AplicativoRepository aplicativoRepository;

    public AplicativoController(AplicativoRepository aplicativoRepository) {
        this.aplicativoRepository = aplicativoRepository;
    }

    @PostMapping("aplicativo")
    public ResponseEntity<?> cadastra(@RequestBody AplicativoRequest aplicativoRequest, UriComponentsBuilder uriComponentsBuilder){
        Aplicativo aplicativo = aplicativoRequest.toModel();
        aplicativoRepository.save(aplicativo);

        URI location = uriComponentsBuilder.path("/video/{id}")
                .buildAndExpand(aplicativo.getId())
                .toUri();

        return ResponseEntity.created(location).build();

    }

    @PatchMapping("{id}/aplicativo")
    public ResponseEntity<?> atualiza(@RequestBody AplicativoRequest aplicativoRequest, @PathVariable Long id){
        Aplicativo aplicativo = aplicativoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nâo existe este aplicativo cadastrado"));
        aplicativo.atualiza(aplicativoRequest);
        aplicativoRepository.save(aplicativo);

        return ResponseEntity.noContent().build();
    }
}
