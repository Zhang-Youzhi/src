package servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.UserService;

public class UserUpdateServlet extends HttpServlet {

	
	private UserService userService = new UserService();
	/**
	 * Constructor of the object.
	 */
	public UserUpdateServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		User user  = userService.queryUser(Integer.parseInt(id));
		request.setAttribute("user", user);
		request.getRequestDispatcher("/view/update.jsp").forward(request, response);
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
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String[] hobbys = request.getParameterValues("hobby");
		String job = request.getParameter("job");
		String info = request.getParameter("info");
		User user = new User(Integer.parseInt(id), name, sex, Arrays.toString(hobbys), info, job);
		boolean flag = userService.updateUser(user);
		if(flag){
			request.getRequestDispatcher("/UserQueryAllServlet").forward(request, response);
		}
	}

	public void init() throws ServletException {
		
	}

}
