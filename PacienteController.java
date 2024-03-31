package br.com.hospital.api.controller;

import br.com.hospital.api.model.Paciente;
import br.com.hospital.api.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Paciente paciente) {
        pacienteService.create(paciente);
    }


    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Paciente> findAll() {
        return pacienteService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Paciente> findById(@PathVariable Long id) {
        return pacienteService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody Paciente paciente, @PathVariable Long id) {
        pacienteService.update(id, paciente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        pacienteService.deleteById(id);
    }
}
