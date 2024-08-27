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

    public boolean removerPorID(Long id) {
        ServidorDao servidorDao = ServidorDao.getInstance();
        ServidorModel servidor = servidorDao.findById(id);
        if (servidor != null) {
            servidorDao.removeById(id);
            return true;
        }
        return false;
    }

    public void editar(ServidorModel servidor) {
        ServidorDao servidorDao = ServidorDao.getInstance();
        servidorDao.merge(servidor);
    }

    public ServidorModel buscarPorId(Long id) {
        ServidorDao servidorDao = ServidorDao.getInstance();
        return servidorDao.findById(id);
    }

    public List<ServidorModel> buscarPorNome(String nome) {
        ServidorDao servidorDao = ServidorDao.getInstance();
        return servidorDao.findByNome(nome);
    }

    public List<ServidorModel> buscarPorCargo(String cargo) {
        ServidorDao servidorDao = ServidorDao.getInstance();
        return servidorDao.findByCargo(cargo);
    }

    public List<ServidorModel> buscarPorSetor(String setor) {
        ServidorDao servidorDao = ServidorDao.getInstance();
        return servidorDao.findBySetor(setor);
    }
}