package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User2;
import service.User2Service;

public class UserRegisterServlet extends HttpServlet {

	
	private User2Service userService = new User2Service();
	/**
	 * Constructor of the object.
	 */
	public UserRegisterServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User2 user = new User2(username, password);
		boolean flag = userService.addUser(user);
		if(flag){
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else{
			response.getWriter().print("注册失败,三秒钟自动跳转到注册界面");
			response.setHeader("Refresh","3;url=http://127.0.0.1:8080/tongxunlu/view/register.jsp"); 
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
