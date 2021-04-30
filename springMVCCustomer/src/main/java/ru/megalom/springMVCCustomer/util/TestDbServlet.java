package ru.megalom.springMVCCustomer.util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
    private static final long serialVersionUID =1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        //setup connection variables
        String user="root";
        String password="javaee";
        String jdbcUrl="jdbc:postgresql://localhost:5432/customer";
        String driver="org.postgresql.Driver";
        Connection connection=null;
        //get connection to database
        try{
            PrintWriter printWriter=response.getWriter();
            printWriter.println("Connecting to database: "+jdbcUrl);
            Class.forName(driver);
            connection=DriverManager.getConnection(jdbcUrl,user,password);
            printWriter.println("Connection successful!");

        }
        catch (Exception e){
            e.printStackTrace();
            throw new ServletException(e);
        }
        finally {
            if(connection!=null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
