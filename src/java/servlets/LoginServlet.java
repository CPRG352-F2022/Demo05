
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();

        String logout = request.getParameter("logout");
        if(logout != null){
            session.invalidate();
            session = request.getSession();
        }
        
        String username = (String)session.getAttribute("username");
        if( username != null){
            response.sendRedirect("average");
            return;
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/loginForm.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        
        //validation
        if( username == null || username.equals("") ){
            getServletContext().getRequestDispatcher("/WEB-INF/loginForm.jsp").forward(request, response);
            return;
        }
        
        // user is now logged in
        HttpSession session = request.getSession();
        session.setAttribute("username", username);

        response.sendRedirect("test2?param");
        return;
        
    }

}
