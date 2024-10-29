package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.UserService;

public class addservlet extends HttpServlet {

	
	private UserService userService = new UserService();
	/**
	 * Constructor of the object.
	 */
	public addservlet() {
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
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String[] hobbys = request.getParameterValues("hobby");
		String job = request.getParameter("job");
		String info = request.getParameter("info");
		User user = new User(null, name, sex, Arrays.toString(hobbys), info, job);
		boolean flag = userService.addUser(user);
		if(flag){
			String path="UserQueryAllServlet";
			RequestDispatcher requestDispatcher=request.getRequestDispatcher(path);
			requestDispatcher.forward(request,response);
		}else{
			response.getWriter().print("添加失败,三秒钟自动跳转到添加界面");
			response.setHeader("Refresh","3;url=http://127.0.0.1:8080/tongxunlu/view/add.jsp"); 
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
