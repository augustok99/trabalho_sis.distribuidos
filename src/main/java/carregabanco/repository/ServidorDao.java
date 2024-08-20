package carregabanco.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import carregabanco.model.ServidorModel;

public class ServidorDao {

    private static ServidorDao instance;
    protected EntityManager entityManager;

    private ServidorDao() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudHibernatePU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public static ServidorDao getInstance() {
        if (instance == null) {
            instance = new ServidorDao();
        }
        return instance;
    }

    public ServidorModel getById(final long id) {
        return entityManager.find(ServidorModel.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<ServidorModel> findAll() {
        return entityManager.createQuery("FROM " + ServidorModel.class.getName()).getResultList();
    }

    public void persist(ServidorModel servidor) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(servidor);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(ServidorModel servidor) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(servidor);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(ServidorModel servidor) {
        try {
            entityManager.getTransaction().begin();
            servidor = entityManager.find(ServidorModel.class, servidor.getIdPessoa());
            entityManager.remove(servidor);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(final long id) {
        try {
            ServidorModel servidor = getById(id);
            remove(servidor);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}