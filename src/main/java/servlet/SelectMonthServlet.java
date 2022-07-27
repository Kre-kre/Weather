package servlet;

import Helper.models.UnMarshaller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.MonthNameType;
import model.MonthType;

import java.io.IOException;
import java.util.*;

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
        String month = request.getParameter("month");
        request.setAttribute("monthType", month);
        request.getRequestDispatcher("/selectVariant.jsp").forward(request, response);
    }
}
