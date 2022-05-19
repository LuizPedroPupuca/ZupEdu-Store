package br.com.zup.edu.store;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class DownloadController {

    public final AplicativoRepository aplicativoRepository;

    public DownloadController(AplicativoRepository aplicativoRepository) {
        this.aplicativoRepository = aplicativoRepository;
    }

    @PatchMapping("{id}/aplicativo/download")
    public ResponseEntity<?> atualiza(@PathVariable Long id){
        Aplicativo aplicativo = aplicativoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nâo existe este aplicativo cadastrado"));
        aplicativo.aumentaQtdeDownloads();
        aplicativoRepository.save(aplicativo);

        return ResponseEntity.ok().body(aplicativo.getLink());
    }
}
