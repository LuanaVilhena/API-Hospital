package br.com.hospital.api.controller;

import br.com.hospital.api.model.Medico;
import br.com.hospital.api.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    MedicoService medicoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Medico medico) {
        medicoService.create(medico);
    }
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Medico> findAll() {
        return medicoService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Medico> findById(@PathVariable Long id) {
        return medicoService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody Medico medico, @PathVariable Long id) {
        medicoService.update(id, medico);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        medicoService.deleteById(id);
    }
}
