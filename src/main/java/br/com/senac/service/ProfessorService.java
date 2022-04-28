package br.com.senac.service;


import br.com.senac.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepo;

    public List<Professor> listaTodosProfessores() {
        return professorRepo.findAll();
    }

}
