package br.com.senac.service;


import br.com.senac.entity.Aluno;
import br.com.senac.repository.AlunoRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepo;

    public List<Aluno> listaTodosAlunos(){
        return alunoRepo.findAll();
    }

    public Aluno buscarPorId(Integer id) throws ObjectNotFoundException {
        Optional<Aluno> aluno = alunoRepo.findById(id);
        return aluno.orElseThrow(() -> new ObjectNotFoundException(null, "Aluno não encontrado."));
    }

    public Aluno salvar(Aluno aluno) {
        return alunoRepo.save(aluno);
    }

    public void excluir(Integer id) {
        alunoRepo.deleteById(id);
    }

    public Aluno alterar(Aluno objAluno) {
        Aluno aluno = buscarPorId(objAluno.getNome());
        return salvar(aluno);
    }

}
