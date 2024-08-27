package carregabanco.controller.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import carregabanco.model.AlunoModel;
import carregabanco.repository.AlunoDao;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoControllerRest {
	AlunoDao alunoDao = AlunoDao.getInstance();

	@GetMapping
	public ResponseEntity<List<AlunoModel>> retornaAlunos() {
		try {
			List<AlunoModel> listaDeAlunos = alunoDao.findAll();
			return new ResponseEntity<>(listaDeAlunos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<AlunoModel> retornaPorid(@PathVariable Long id) {
		try {
			AlunoModel aluno = alunoDao.findById(id);
			if (aluno != null) {
				return new ResponseEntity<>(aluno, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<AlunoModel>> retornaPorNome(@PathVariable String nome) {
		try {
			List<AlunoModel> alunos = alunoDao.findByNome(nome);
			return new ResponseEntity<>(alunos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/curso/{curso}")
	public ResponseEntity<List<AlunoModel>> retornaPorCurso(@PathVariable String curso) {
		try {
			List<AlunoModel> alunos = alunoDao.findByCurso(curso);
			return new ResponseEntity<>(alunos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/cidade/{cidade}")
	public ResponseEntity<List<AlunoModel>> retornaPorCidade(@PathVariable String cidade) {
		try {
			List<AlunoModel> alunos = alunoDao.findByCidade(cidade);
			return new ResponseEntity<>(alunos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping
	public ResponseEntity<AlunoModel> salvarAluno(@RequestBody AlunoModel aluno) {
		try {
			alunoDao.persist(aluno);
			return new ResponseEntity<>(aluno, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<AlunoModel> editarAluno(@PathVariable Long id, @RequestBody AlunoModel novoAluno) {
		try {
			AlunoModel aluno = alunoDao.findById(id);
			if (aluno != null) {
				aluno.setCampus(novoAluno.getCampus());
				aluno.setPolo(novoAluno.getPolo());
				aluno.setEmail_institucional(novoAluno.getEmail_institucional());
				aluno.setIdade(novoAluno.getIdade());
				aluno.setSexo(novoAluno.getSexo());
				aluno.setNome_estudante(novoAluno.getNome_estudante());
				aluno.setCoordenacao(novoAluno.getCoordenacao());
				aluno.setCurso(novoAluno.getCurso());
				aluno.setSituacao(novoAluno.getSituacao());
				aluno.setPeriodo_entrada(novoAluno.getPeriodo_entrada());
				aluno.setData_conclusao(novoAluno.getData_conclusao());
				aluno.setCidade(novoAluno.getCidade());

				alunoDao.merge(aluno);
				return new ResponseEntity<>(aluno, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> removerAluno(@PathVariable Long id) {
		try {
			AlunoModel aluno = alunoDao.findById(id);
			if (aluno != null) {
				alunoDao.remove(aluno);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}