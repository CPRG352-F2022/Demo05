package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AverageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the session object
        HttpSession session = request.getSession();
        // Check the operation parameter if the user wants to reset
        String operation = request.getParameter("operation");
        if( operation != null && operation.equals("reset") ){
            // invalidate the session
            // destroy the session and any attributes that the session currently holds
            session.invalidate();
            // call upon a new session
            session = request.getSession();
        }
        
        // Attempt to retrieve the numberlist from the session
        ArrayList<Integer> numberList = (ArrayList<Integer>)session.getAttribute("numberList");
        // if a numberlist does not exist in the session yet, create a new one
        if (numberList == null) numberList = new ArrayList<>();
        
        // if the user has entered a number, add it to the number list
        if( request.getParameter("number") != null ){
            int number = Integer.parseInt( request.getParameter("number") );
            numberList.add(number);
            // and save the numberlist back to the session
            session.setAttribute("numberList", numberList);
        }
        
        // math time!
        double average = 0.0;
        for( int number : numberList ){
            average += number;
        }
        if( numberList.size() > 0 ){
            average /= numberList.size();
        }
        
        
        // store the average in the request object
        request.setAttribute("average", average);
        
        getServletContext().getRequestDispatcher("/WEB-INF/average.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // nothing here
    }

}
