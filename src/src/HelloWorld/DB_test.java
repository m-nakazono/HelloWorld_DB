package src.HelloWorld;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DB_test extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	     response.setContentType("text/html; charset=UTF-8");
	     PrintWriter out = response.getWriter();
	       out.println("<html>");
	       out.println("<head>");
	       out.println("<title>DB_test</title>");
	       out.println("</head>");
	       out.println("<body>");

	       try {
			    Class.forName("com.mysql.cj.jdbc.Driver");
			    java.sql.Connection conn =
	            DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root"," sep2019.1173-nakaono-H10.1210 ");
			    String sql = "select * from helloworld;";
			    java.sql.Statement statement = conn.createStatement(30,0,0);
			    ResultSet resultSet = statement.executeQuery(sql);
			    while(resultSet.next()) {
			    	out.println("<p>"+resultSet.getString("") +"</p>");
			    }
		        }catch(Exception e) {
		        	out.println(e.getMessage());
		        }
		       out.println("</body>");
	           out.println("</html>");
	          }
}
