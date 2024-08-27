package carregabanco.controller.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import carregabanco.model.ServidorModel;
import carregabanco.repository.ServidorDao;

@RestController
@RequestMapping("/servidor")
public class ServidorControllerRest {
    ServidorDao servidorDao = ServidorDao.getInstance();

    @GetMapping
    public ResponseEntity<List<ServidorModel>> retornaServidores() {
        List<ServidorModel> listaDeServidores = new ArrayList<ServidorModel>();
        try {
            listaDeServidores = servidorDao.findAll();
            return new ResponseEntity<List<ServidorModel>>(listaDeServidores, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<ServidorModel>>(listaDeServidores, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<ServidorModel> retornaPorid(@PathVariable Long id) {
        try {
            ServidorModel servidor = servidorDao.findById(id);
            if (servidor != null) {
                return new ResponseEntity<>(servidor, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<ServidorModel>> retornaPorNome(@PathVariable String nome) {
        try {
            List<ServidorModel> servidores = servidorDao.findByNome(nome);
            return new ResponseEntity<>(servidores, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/cargo/{cargo}")
    public ResponseEntity<List<ServidorModel>> retornaPorCargo(@PathVariable String cargo) {
        try {
            List<ServidorModel> servidores = servidorDao.findByCargo(cargo);
            return new ResponseEntity<>(servidores, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/setor/{setor}")
    public ResponseEntity<List<ServidorModel>> retornaPorSetor(@PathVariable String setor) {
        try {
            List<ServidorModel> servidores = servidorDao.findBySetor(setor);
            return new ResponseEntity<>(servidores, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<ServidorModel> salvarServidor(@RequestBody ServidorModel servidor) {
        try {
            servidorDao.persist(servidor);
            return new ResponseEntity<ServidorModel>(servidor, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<ServidorModel>(servidor, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServidorModel> editarServidor(@PathVariable Long id, @RequestBody ServidorModel novoServidor) {
        try {
            ServidorModel servidor = servidorDao.findById(id);
            if (servidor != null) {
                servidor.setNome_servidor(novoServidor.getNome_servidor());
                servidor.setEmail_contato(novoServidor.getEmail_contato());
                servidor.setCargo(novoServidor.getCargo());
                servidor.setCampus_lotacao(novoServidor.getCampus_lotacao());
                servidor.setSetor_lotacao(novoServidor.getSetor_lotacao());

                servidorDao.merge(servidor);
                return new ResponseEntity<>(servidor, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerServidor(@PathVariable Long id) {
        try {
            ServidorModel aluno = servidorDao.findById(id);
            if (aluno != null) {
                servidorDao.remove(aluno);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
