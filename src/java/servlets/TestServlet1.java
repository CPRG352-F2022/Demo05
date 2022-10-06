package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TestServlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String requestAttribute = "This is an attribite in the request object.";
        String sessionAttribute = "This is an attribute in the session object.";
        
        request.setAttribute("reqAttr", requestAttribute);
        
        HttpSession session = request.getSession();
        
        session.setAttribute("sessionAttr", sessionAttribute);

        getServletContext().getRequestDispatcher("/WEB-INF/test.jsp").forward(request,response);
        return;
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
