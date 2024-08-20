package carregabanco.controller;

import java.util.List;

import carregabanco.model.AlunoModel;
import carregabanco.model.ServidorModel;
import carregabanco.repository.AlunoDao;
import carregabanco.repository.ServidorDao;

public class ServidorController {

    public void inserir(ServidorModel servidor) {
        ServidorDao servidorDao = ServidorDao.getInstance();
        servidorDao.persist(servidor);
    }

    public List<ServidorModel> buscar() {
        ServidorDao servidorDao = ServidorDao.getInstance();
        return servidorDao.findAll();
    }

    public void removerPorID(Long id) {
        ServidorDao servidorDao = ServidorDao.getInstance();
        servidorDao.removeById(id);
    }

    public void editar(ServidorModel servidor) {
        ServidorDao servidorDao = ServidorDao.getInstance();
        servidorDao.merge(servidor);;
    }
}