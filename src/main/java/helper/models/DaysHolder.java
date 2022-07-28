package helper.models;

import helper.UnMarshaller;
import model.DayType;
import model.MonthType;
import model.Year;

import java.util.ArrayList;
import java.util.List;

public class DaysHolder {
    private static final Year year = UnMarshaller.getYear();

    public List<DayType> getDayTypes(String month) {
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
