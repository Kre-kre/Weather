package helper.models;

import helper.UnMarshaller;
import model.DayType;
import model.Year;

import java.util.ArrayList;
import java.util.List;


public class DaysHolder {
    private static final Year year = UnMarshaller.getYear();

    public List<DayType> getDayTypes(String month) {
        assert year != null;
        List<DayType> dayTypeList = new ArrayList<>();
        year.getMonth().forEach(monthType ->
        {
            if (monthType.getMonthName().name().equalsIgnoreCase(month)) {
                dayTypeList.addAll(monthType.getDay());
            }
        });
        return dayTypeList;
    }
}
