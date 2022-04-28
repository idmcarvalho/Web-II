package br.com.senac.service;


import br.com.senac.repository.DisciplinaRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepo;

    public List<Disciplina> listaTodasDisciplinas() {
        return disciplinaRepo.findAll();
    }

    public Disciplina buscarPorId(Integer id) throws ObjectNotFoundException {
        Optional<Disciplina> disciplina = disciplinaRepo.findById(id);
        return disciplina.orElseThrow(() -> new ObjectNotFoundException(null, "Disciplina não encontrada."));
    }

    public void excluir(Integer id) {
        disciplinaRepo.deleteById(id);
    }

    public Disciplina alterar(Disciplina objDisciplina) {
        Disciplina discilplina = buscarPorId(objDisciplina.getId());
        discilplina.setNome(objDisciplina.getNome());
        return salvar(disciplina);

    }
}
