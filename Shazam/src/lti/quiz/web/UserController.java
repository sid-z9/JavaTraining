package lti.quiz.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lti.quiz.bean.ForgetBean;
import lti.quiz.bean.LoginBean;
import lti.quiz.bean.RegisterBean;
import lti.quiz.service.UserService;
import lti.quiz.service.UserServiceImpl;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/user.quiz")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService service;

	@Override
	public void init() throws ServletException {

		service = new UserServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Referer gives the url of the header
		String referer = request.getHeader("referer");

		// creates a fresh new session in the server if no session id found in request
		// header
		// otherwise old session identified by id in request header
		HttpSession session = request.getSession();
		
		
		if(request.getParameter("logout") != null) {
			// User request to logout
			session.invalidate(); 	// destroying session
			response.sendRedirect("login.jsp"); 	// send user to login page
		}
		else if (referer.contains("login")) {
			// Request is for login authentication
			LoginBean login = new LoginBean();

			String userName = request.getParameter("email");
			login.setEmail(userName);

			String pass = request.getParameter("password");
			login.setPassword(pass);

			// if(userName.equals(login.getEmail()) && pass.equals(login.getPassword()))
			// response.sendRedirect("home.jsp");
			//
			RegisterBean user = service.authenticate(login);
			if (user != null) {
				// Login successful

				// sets the attribute as user for identification
				session.setAttribute("USER", user);
				response.sendRedirect("dashboard.jsp");
			} else
				response.sendRedirect("login.jsp?invalid=yes");
		} else if (referer.contains("register")) {
			// Request is for new user registration
			RegisterBean register = new RegisterBean();

			String email = request.getParameter("email");
			String pass = request.getParameter("password");
			String answer = request.getParameter("secque");
			// String profile = "images/deadpool.jpeg";

			register.setEmail(email);
			register.setPassword(pass);
			register.setAnswer(answer);
			// register.setProfile(profile);

			boolean b = service.register(register);
			if (b == true) {

				response.sendRedirect("login.jsp");
			} else
				response.sendRedirect("register.jsp");
		} else if (referer.contains("forget")) {
			// Request is to validate user
			ForgetBean forget = new ForgetBean();

			forget.setEmail(request.getParameter("email"));
			forget.setAnswer(request.getParameter("secque"));

			if (service.validate(forget)) {
				// in order to remember email
				session.setAttribute("EMAIL", forget.getEmail());
				response.sendRedirect("change.jsp");
			} else
				response.sendRedirect("forget.jsp");
		} else if (referer.contains("change")){
			// Request to change password
			LoginBean change = new LoginBean();

			change.setPassword(request.getParameter("password"));
			change.setEmail((String) session.getAttribute("EMAIL")); // session.getAttribute return and object, hence
																		// typecasted to String

			if (service.update(change)) {
				// session.setAttribute("EMAIL", null);		// setAttribute() to null and removeAttribute() are same
				session.removeAttribute("EMAIL");
				response.sendRedirect("login.jsp");
			} else
				response.sendRedirect("change.jsp");
		} else
		{
			session.getAttribute("EMAIL");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
