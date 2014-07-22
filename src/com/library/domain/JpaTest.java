package com.library.domain;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.library.domain.*;

public class JpaTest {

	private EntityManager manager;


	public JpaTest(EntityManager manager) {

	this.manager = manager;

	}
	

public static void main(String[] args) {

EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");

EntityManager manager = factory.createEntityManager();

JpaTest test = new JpaTest(manager);

EntityTransaction tx = manager.getTransaction();

tx.begin();

try {

test.createMembers();

} catch (Exception e) {

e.printStackTrace();

}

tx.commit();


//test.listEmployees();


System.out.println(".. done");

}



private void createMembers() {



/*int numOfEmployees = manager.createQuery("Select a From Employee a", Employee.class).getResultList().size();



if (numOfEmployees == 0) {



Department department = new Department("java");



manager.persist(department);*/



manager.persist(new Member("M001","buddhini","samarakkody","815614151v"));


}





private void listMembers() {




/*List<Employee> resultList = manager.createQuery("Select a From Employee a", Employee.class).getResultList();




System.out.println("num of employess:" + resultList.size());




for (Employee next : resultList) {




System.out.println("next employee: " + next);





}*/




}
}
