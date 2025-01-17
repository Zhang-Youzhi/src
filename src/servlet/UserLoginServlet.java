package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User2;
import service.User2Service;

public class UserLoginServlet extends HttpServlet {

	private User2Service userService = new User2Service();
	/**
	 * Constructor of the object.
	 */
	public UserLoginServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User2 user = new User2();
		user.setUsername(username);
		user.setPassword(password);
		User2 u = userService.queryUser(user);
		if(u==null){
			String path="/index.jsp";
			RequestDispatcher requestDispatcher=request.getRequestDispatcher(path);
			requestDispatcher.forward(request,response);
			
		}else{
			String path="UserQueryAllServlet";
			RequestDispatcher requestDispatcher=request.getRequestDispatcher(path);
			requestDispatcher.forward(request,response);
		}
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}