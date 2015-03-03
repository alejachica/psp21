package edu.uniandes.ecos.psp21.vista;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import edu.uniandes.ecos.psp21.controlador.Controlador;

/**
 * Clase que muestra el resultado en heroku del valor de X para el calculo de la integral numerica.
 */
public class App extends HttpServlet {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (req.getRequestURI().endsWith("/db")) {
			showDatabase(req, resp);
		} else {
			showHome(req, resp);
		}
	}

	/**
	 * Metodo que permite mostrar el inicio de la aplicacion.
	 * @param req request  
	 * @param resp response
	 * @throws ServletException Excepcion al ejecutar la peticion
	 * @throws IOException Excepcion al ejecutar la peticion
	 */
	private void showHome(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter pw = resp.getWriter();
		pw.write("<html>");
		pw.println("<h2>PSP2.1 Program!</h2>");
		pw.println("Ingrese los de datos de prueba. \n");

		pw.println("<h3>Test 1</h3>");
		pw.println("x = 1.0");
		pw.println("dof = 6");
		pw.println("NumSeg = 10");
		pw.println("Valor esperado integral = 0.20");

		pw.println("<h3>Test 2</h3>");
		pw.println("x = 1.0");
		pw.println("dof = 15");
		pw.println("NumSeg = 10");
		pw.println("Valor esperado integral = 0.45");

		pw.println("<h3>Test 3</h3>");
		pw.println("x = 1.0");
		pw.println("dof = 4");
		pw.println("NumSeg = 10");
		pw.println("Valor esperado integral = 0.495");
		
		pw.println("<h3></h3>");

		pw.write("<form action=\"calc\" method=\"post\"> \n" + "    Valor de X: <input type=\"text\" name=\"calc\">\n"
				+ "    Valor de dof: <input type=\"text\" name=\"dof\">\n"
				+ "    Valor de numSeg: <input type=\"text\" name=\"num\">\n"
				+ "    Valor esperado integral: <input type=\"text\" name=\"valEsp\">\n"
				+ "    <input type=\"submit\" value=\"Calc\">\n" + "</form> ");
		pw.write("</html>");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String x = req.getParameter("calc");
		String dof = req.getParameter("dof");
		String numSeg = req.getParameter("num");
		String valEsp = req.getParameter("valEsp");

		Controlador c = new Controlador();
		String resultado = c.realizarCalculos(Double.valueOf(dof), Integer.valueOf(numSeg), Double.valueOf(x), Double.valueOf(valEsp));

		resp.getWriter().print("Entrega PSP2 - Alejandra Chica\n" + "El valor de X es: " + resultado);
	}

	/**
	 * Metodo de prueba de BD.
	 * @param req request  
	 * @param resp response
	 * @throws ServletException Excepcion al ejecutar la peticion
	 * @throws IOException Excepcion al ejecutar la peticion
	 */
	private void showDatabase(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connection = null;
		try {
			connection = getConnection();

			Statement stmt = connection.createStatement();
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
			stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
			ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

			String out = "Hello!\n";
			while (rs.next()) {
				out += "Read from DB: " + rs.getTimestamp("tick") + "\n";
			}

			resp.getWriter().print(out);
		} catch (Exception e) {
			resp.getWriter().print("There was an error: " + e.getMessage());
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	/**
	 * Metodo de prueba de conexion.
	 * @return Conexion solicitada.
	 * @throws URISyntaxException Excepcion al ejecutar la consulta.
	 * @throws SQLException Excepcion al ejecutar la consulta.
	 */
	private Connection getConnection() throws URISyntaxException, SQLException {
		URI dbUri = new URI(System.getenv("DATABASE_URL"));

		String username = dbUri.getUserInfo().split(":")[0];
		String password = dbUri.getUserInfo().split(":")[1];
		int port = dbUri.getPort();

		String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ":" + port + dbUri.getPath();

		return DriverManager.getConnection(dbUrl, username, password);
	}

	/**
	 * Metodo que permite ejecutar una aplicacion Java.
	 * @param args Argumentos de java
	 * @throws Exception Excepcion al ejecutar la peticion.
	 */
	public static void main(String[] args) throws Exception {

//		 Server server = new Server(8081);
		Server server = new Server(Integer.valueOf(System.getenv("PORT")));
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/");
		server.setHandler(context);
		context.addServlet(new ServletHolder(new App()), "/*");
		server.start();
		server.join();
	}
}
