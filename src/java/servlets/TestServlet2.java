
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String myParam = request.getParameter("param");
        
        if( myParam != null ){
            getServletContext().getRequestDispatcher("/WEB-INF/alternate.jsp").forward(request,response);
            return;
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/test.jsp").forward(request,response);
            return;
        }
        
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
