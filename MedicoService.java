package br.com.hospital.api.service;

import br.com.hospital.api.model.Medico;
import br.com.hospital.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    MedicoRepository medicoRepository;

    public void create(Medico medico){
        medicoRepository.save(medico);
    }
    public List<Medico> findAll() {
        return medicoRepository.findAll();
    }
    public Optional<Medico> findById(Long id){
        return medicoRepository.findById(id);
    }

    public void update(Long id, Medico medico) {

        Optional<Medico> medicoFromDb = medicoRepository.findById(id);

        if (medicoFromDb.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "O médico não foi encontrado no banco de dados.");
        }
        Medico medicoUpdated = medicoFromDb.get();
        medicoUpdated.setName(medico.getName());
    }
    public void deleteById(Long id) {
        medicoRepository.deleteById(id);
    }

}
