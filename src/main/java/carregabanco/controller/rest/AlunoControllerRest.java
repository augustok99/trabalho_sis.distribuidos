package carregabanco.controller.rest;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import carregabanco.model.AlunoModel;
import carregabanco.repository.AlunoDao;

@RestController
@RequestMapping("/aluno")
public class AlunoControllerRest {
	AlunoDao alunoDao = AlunoDao.getInstance();
	
	@GetMapping
	public ResponseEntity<List<AlunoModel>> retornaAlunos() {
		List<AlunoModel> listaDeAlunos = new ArrayList<AlunoModel>();
		try {
			listaDeAlunos = alunoDao.findAll();
			return new ResponseEntity<List<AlunoModel>>(listaDeAlunos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<AlunoModel>>(listaDeAlunos, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping
	public ResponseEntity<AlunoModel> salvar(@RequestBody AlunoModel aluno) {
		try {
			alunoDao.persist(aluno);
			return new ResponseEntity<AlunoModel>(aluno, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<AlunoModel>(aluno, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
