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

    public ServidorModel findById(final long id) {
        try {
            return entityManager.find(ServidorModel.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
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
            ServidorModel servidor = findById(id);
            remove(servidor);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public List<ServidorModel> findByNome(String nome) {
        return entityManager.createQuery("FROM ServidorModel WHERE nome_servidor LIKE :nome")
                .setParameter("nome", "%" + nome + "%")
                .getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<ServidorModel> findByCargo(String cargo) {
        return entityManager.createQuery("FROM ServidorModel WHERE cargo LIKE :cargo")
                .setParameter("cargo", "%" + cargo + "%")
                .getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<ServidorModel> findBySetor(String setor) {
        return entityManager.createQuery("FROM ServidorModel WHERE setor_lotacao LIKE :setor")
                .setParameter("setor", "%" + setor + "%")
                .getResultList();
    }

}