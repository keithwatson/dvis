package com.datavisualisation.startup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.datavisualisation.Server;

/**
 * Servlet run at the startup of the web container.
 * @author Keith Watson
 *
 */

@WebServlet(name = "StartupServlet", urlPatterns = "/StartupServlet", loadOnStartup = 1)
public class StartupServlet extends HttpServlet {

	private static final long serialVersionUID = -561192619657678196L;


	@Override
	public void init() throws ServletException {
		Server.setServerRoot(this.getServletContext().getRealPath("/"));
	}


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
	}

}
