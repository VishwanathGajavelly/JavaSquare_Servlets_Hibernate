package servlet_Hibernate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Servlet implementation class JavaSquare_Servlet_Hibernate
 */
public class JavaSquare_Servlet_Hibernate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() {
			System.out.println("Started Execution");
		
		}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out;
		
		//name
		String name = request.getParameter("name");

		//email
		String email = request.getParameter("email");
		
		//how
		String how = request.getParameter("how");
		
		//subject
		String subject = request.getParameter("subject");
		
		//message
		String message = request.getParameter("message");
		
	
		FeedbackModel fb = new FeedbackModel();
		fb.setName(name);
		fb.setEmail(email);
		fb.setHow(how);
		fb.setSubject(subject);
		fb.setMessage(message);
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		s.save(fb);
		
		Transaction t = s.beginTransaction();
		t.commit();
		
		System.out.println("DATA SUCCESSFULLY INSERTED");
		
		
		/*out = response.getWriter();
		out.println("<html> <body>");
		out.println("<font color = 'red' size = '15' > ");
		out.println("<center> THANKS FOR THE FEEDBACK </center>");
		out.println("<a href='index.html'>  Go back </a>");
		out.println("</body> </html> " );
		
		*/
		
		request.setAttribute("message", message);
	    request.getRequestDispatcher("./success.jsp").forward(request, response);
		
	    System.out.println("Data Entered Successfully");
		

		s.evict(fb);
		s.close();
		sf.close();
		
		
	
	}

}
