package servlet;

import Helper.models.DaysHolder;
import Helper.models.UnMarshaller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logic.WeatherResult;
import model.DayType;
import model.MonthType;

import java.io.IOException;
import java.util.List;


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
        request.setAttribute("variantType", variant);

        String month = request.getParameter("monthType");
        List<DayType> dayTypeList = DaysHolder.getDayTypes(month);

        if (variant.equals("a")) {
            String result = String.valueOf(WeatherResult.getAvgTemperature(dayTypeList));
            request.setAttribute("result", result);
            request.getRequestDispatcher("result_a.jsp").forward(request, response);
        } else if (variant.equals("b")) {
            String result = String.valueOf(WeatherResult.getQuantityDaysTempAboveAvg(dayTypeList));
            request.setAttribute("result", result);
            request.getRequestDispatcher("result_b.jsp").forward(request, response);
        } else if (variant.equals("c")) {
            String result = String.valueOf(WeatherResult.getQuantityDaysTempBelowZero(dayTypeList));
            request.setAttribute("result", result);
            request.getRequestDispatcher("result_c.jsp").forward(request, response);
        } else {
            String result = String.valueOf(WeatherResult.getThreeHottestDays(dayTypeList));
            request.setAttribute("result", result);
            request.getRequestDispatcher("result_d.jsp").forward(request, response);
        }
    }
}
