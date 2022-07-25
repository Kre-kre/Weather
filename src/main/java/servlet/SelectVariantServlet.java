package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/SelectVariant")
public class SelectVariantServlet extends HttpServlet {
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
        String variant = request.getParameter("variant");
        request.setAttribute("variantType",variant);
        if (variant.equals("a")){
            request.getRequestDispatcher("resulta.jsp").forward(request, response);
        } else if (variant.equals("b")){
            request.getRequestDispatcher("resultb.jsp").forward(request, response);
        } else if (variant.equals("c")){
            request.getRequestDispatcher("resultc.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("resultd.jsp").forward(request, response);
        }
    }
}
