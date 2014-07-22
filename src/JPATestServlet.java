

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.library.domain.*;

/**
 * Servlet implementation class JPATestServlet
 */
@WebServlet("/JPATestServlet")
public class JPATestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JPATestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");

		manager = factory.createEntityManager();

		EntityTransaction tx = manager.getTransaction();

		tx.begin();

		try {

		//createMembers();       

		} catch (Exception e) {

		e.printStackTrace();

		}

		tx.commit();


		listMembers(response);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/success.jsp");
        dispatcher.forward(request, response);   


		System.out.println(".. done");

		}
	

private void createMembers() {



/*int numOfEmployees = manager.createQuery("Select a From Employee a", Employee.class).getResultList().size();



if (numOfEmployees == 0) {



Department department = new Department("java");



manager.persist(department);*/



manager.persist(new Member("M003","buddhini3","samarakkody2","815614151v"));


}





private void listMembers(HttpServletResponse response){




List<Member> resultList = manager.createQuery("Select a From com.library.domain.Member a", Member.class).getResultList();




System.out.println("num of members:" + resultList.size());




for (Member next : resultList) {
	
	try{

	PrintWriter out = response.getWriter();
	out.println(next.getFirstName());
	}
	catch(IOException e) {
		e.printStackTrace();
	}


System.out.println("next member: " + next.getFirstName());





}




}

}
