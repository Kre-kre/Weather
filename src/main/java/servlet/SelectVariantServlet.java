package servlet;

import helper.models.DaysHolder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.WeatherService;
import model.DayType;

import java.io.IOException;
import java.util.List;


@WebServlet("/SelectVariant")
public class SelectVariantServlet extends HttpServlet {
    private final DaysHolder daysHolder = new DaysHolder();
    private final WeatherService weatherService = new WeatherService();
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
        request.setAttribute("variantType", variant);

        String month = request.getParameter("monthType");
        List<DayType> dayTypeList = daysHolder.getDayTypes(month);

        if (variant.equals("a")) {
            String result = String.valueOf(weatherService.getAvgTemperature(dayTypeList));
            request.setAttribute("result", result);
            request.getRequestDispatcher("result_a.jsp").forward(request, response);
        } else if (variant.equals("b")) {
            String result = String.valueOf(weatherService.getDaysQuantityTempAboveAvg(dayTypeList));
            request.setAttribute("result", result);
            request.getRequestDispatcher("result_b.jsp").forward(request, response);
        } else if (variant.equals("c")) {
            String result = String.valueOf(weatherService.getDaysQuantityTempBelowZero(dayTypeList));
            request.setAttribute("result", result);
            request.getRequestDispatcher("result_c.jsp").forward(request, response);
        } else {
            String result = String.valueOf(weatherService.getThreeHottestDays(dayTypeList));
            request.setAttribute("result", result);
            request.getRequestDispatcher("result_d.jsp").forward(request, response);
        }
    }
}
