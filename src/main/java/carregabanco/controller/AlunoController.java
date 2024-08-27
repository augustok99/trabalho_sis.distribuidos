package carregabanco.controller;

import java.util.List;

import carregabanco.model.AlunoModel;
import carregabanco.repository.AlunoDao;

public class AlunoController {

	public void inserir(AlunoModel aluno) {
		AlunoDao alunoDao = AlunoDao.getInstance();
		alunoDao.persist(aluno);
	}

	public List<AlunoModel> buscar() {
		AlunoDao alunoDao = AlunoDao.getInstance();
		return alunoDao.findAll();
	}

	public boolean removerPorID(Long id) {
		AlunoDao alunoDao = AlunoDao.getInstance();
		AlunoModel aluno = alunoDao.findById(id);
		if (aluno != null) {
			alunoDao.removeById(id);
			return true;
		}
		return false;
	}

	public void editar(AlunoModel aluno) {
		AlunoDao alunoDao = AlunoDao.getInstance();
		alunoDao.merge(aluno);
	}

	public AlunoModel buscarPorId(Long id) {
		AlunoDao alunoDao = AlunoDao.getInstance();
		return alunoDao.findById(id);
	}

	public List<AlunoModel> buscarPorNome(String nome) {
		AlunoDao alunoDao = AlunoDao.getInstance();
		return alunoDao.findByNome(nome);
	}

	public List<AlunoModel> buscarPorCurso(String curso) {
		AlunoDao alunoDao = AlunoDao.getInstance();
		return alunoDao.findByCurso(curso);
	}

	public List<AlunoModel> buscarPorCidade(String cidade) {
		AlunoDao alunoDao = AlunoDao.getInstance();
		return alunoDao.findByCidade(cidade);
	}
}
