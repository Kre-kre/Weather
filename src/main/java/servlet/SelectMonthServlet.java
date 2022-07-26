package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.MonthType;
import model.Year;


import java.io.IOException;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

@WebServlet("/SelectMonth")
public class SelectMonthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        List<MonthType> monthTypes = Objects.requireNonNull(UnMarshal.getYear()).getMonth();
//        for (MonthType monthType : monthTypes) {
//            String month = String.valueOf(monthType.getMonthName());
//            request.setAttribute("monthChoice",month);
//        }
        String month = request.getParameter("month");
        request.setAttribute("monthType",month);

        request.getRequestDispatcher("/selectVariant.jsp").forward(request, response);
    }
}
