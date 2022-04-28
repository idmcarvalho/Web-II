package br.com.senac.resource;


import br.com.senac.entity.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorResource {

    @Autowired
    private ProfessorService professorService;

    //@GetMapping
    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<List<Professor>> listarProfessores() {
        return ResponseEntity.ok().body(professores);
    }
}
