package demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by simon on 10/13/15.
 */
@WebServlet(name = "Connect")
public class Connect extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e){
            out.println("Can't load database driver");
        }

        Connection conn = null;

        try {
           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "");
        } catch (SQLException e) {
            out.println("Can't connect to database.");
            return;
        }

        out.println("Connected to database.");


        try {
            conn.close();
        } catch (SQLException e) {
            out.println("Disconnect to database.");
        }

    }



}
