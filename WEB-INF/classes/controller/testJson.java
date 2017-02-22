package controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import tool.ReceiveJson;

public class testJson extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public testJson() {
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

		//String json = ReceiveJson.receiveJsons(request);
		//response.getWriter().println(json);
//		Set<String> set = request.getParameterMap().keySet();
//		Iterator it = set.iterator();
//		String i = (String)it.next();
//		JSONArray json = JSONArray.fromObject(i);
//		JSONObject jo = json.getJSONObject(0);
//		String tel = (String)jo.get("tel");
//		String pword = (String)jo.get("pword");
//		response.getWriter().println(tel);
//		response.getWriter().println(pword);
		System.out.println(request.getLocalAddr());
		System.out.println(request.getLocalName());
		String uri = request.getRequestURI();
		//String path=uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		System.out.println(uri);
		System.out.println(request.getLocalPort());
		//System.out.println(request.);
		String json = ReceiveJson.receiveJsons(request);
		System.out.println(json);
		response.getWriter().println(json);
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

		System.out.println(request.getLocalAddr());
		System.out.println(request.getLocalName());
		String uri = request.getRequestURI();
		//String path=uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
		System.out.println(uri);
		System.out.println(request.getLocalPort());
		//System.out.println(request.);
		String json = ReceiveJson.receiveJsons(request);
		System.out.println(json);
		response.getWriter().println(json);
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
