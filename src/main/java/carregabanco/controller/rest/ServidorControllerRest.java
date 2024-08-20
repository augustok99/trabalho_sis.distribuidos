package carregabanco.controller.rest;

import java.util.ArrayList;
import java.util.List;

import carregabanco.model.ServidorModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping
    public ResponseEntity<ServidorModel> salvar(@RequestBody ServidorModel servidor) {
        try {
            servidorDao.persist(servidor);
            return new ResponseEntity<ServidorModel>(servidor, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<ServidorModel>(servidor, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
