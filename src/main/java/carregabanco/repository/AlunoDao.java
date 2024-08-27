package carregabanco.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import carregabanco.model.AlunoModel;

public class AlunoDao {

    private static AlunoDao instance;
    protected EntityManager entityManager;

    private AlunoDao() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudHibernatePU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public static AlunoDao getInstance() {
        if (instance == null) {
            instance = new AlunoDao();
        }
        return instance;
    }

    public AlunoModel findById(final long id) {
        try {
            return entityManager.find(AlunoModel.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public List<AlunoModel> findAll() {
        return entityManager.createQuery("FROM " + AlunoModel.class.getName()).getResultList();
    }

    public void persist(AlunoModel aluno) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(aluno);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(AlunoModel aluno) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(aluno);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(AlunoModel aluno) {
        try {
            entityManager.getTransaction().begin();
            aluno = entityManager.find(AlunoModel.class, aluno.getIdPessoa());
            entityManager.remove(aluno);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(final long id) {
        try {
            AlunoModel aluno = findById(id);
            remove(aluno);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public List<AlunoModel> findByNome(String nome) {
        return entityManager.createQuery("FROM AlunoModel WHERE nome_estudante LIKE :nome")
                .setParameter("nome", "%" + nome + "%")
                .getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<AlunoModel> findByCurso(String curso) {
        return entityManager.createQuery("FROM AlunoModel WHERE curso LIKE :curso")
                .setParameter("curso", "%" + curso + "%")
                .getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<AlunoModel> findByCidade(String cidade) {
        return entityManager.createQuery("FROM AlunoModel WHERE cidade LIKE :cidade")
                .setParameter("cidade", "%" + cidade + "%")
                .getResultList();
    }
}
