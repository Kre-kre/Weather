package Helper.models;

import model.DayType;
import model.MonthType;
import model.Year;

import java.util.ArrayList;
import java.util.List;

public class DaysHolder {
    private static final Year year = UnMarshaller.getYear();

    public static List<DayType> getDayTypes(String month) {
        assert year != null;
        List<MonthType> monthTypes = year.getMonth();
        List<DayType> dayTypeList = new ArrayList<>();
        for (MonthType monthType : monthTypes) {
            if (monthType.getMonthName().name().equals(month)) {
                dayTypeList.addAll(monthType.getDay());
            }
        }
        return dayTypeList;
    }
}
