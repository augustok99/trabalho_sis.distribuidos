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

	public AlunoModel getById(final long id) {
		return entityManager.find(AlunoModel.class, id);
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
			AlunoModel aluno = getById(id);
			remove(aluno);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}