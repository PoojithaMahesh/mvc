package studente3.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import studente3.dto.Student;

@Repository
public class StudentDao {
	
	@Autowired
	 private EntityManager entityManager;
  
	public void saveStudent(Student student) {
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.persist(student);
	entityTransaction.commit();	
	}

	public List<Student> getAllStudents() {
	   Query query=entityManager.createQuery("Select u from Student u");
		return query.getResultList();
	}

	
	
	
}
