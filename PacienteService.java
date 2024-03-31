package br.com.hospital.api.service;

import br.com.hospital.api.model.Paciente;
import br.com.hospital.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

public class PacienteService {
    @Autowired
    PacienteRepository pacienteRepository;

    public void create(Paciente paciente){
        pacienteRepository.save(paciente);
    }
    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }
    public Optional<Paciente> findById(Long id){
        return pacienteRepository.findById(id);
    }

    public void update(Long id, Paciente paciente) {

        Optional<Paciente> pacienteFromDb = pacienteRepository.findById(id);

        if (pacienteFromDb.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "O paciente não foi encontrado no banco de dados.");
        }
        Paciente pacienteUpdated = pacienteFromDb.get();
        pacienteUpdated.setName(paciente.getName());
    }
    public void deleteById(Long id) {
        pacienteRepository.deleteById(id);
    }

}
