package logic;

import model.DayType;

import java.util.*;

public class WeatherResult {
    public static double getAvgTemperature(List<DayType> dayTypeList) {
        return dayTypeList.stream().mapToInt(DayType::getTemperature).average().getAsDouble();
    }

    public static int getQuantityDaysTempAboveAvg(List<DayType> dayTypeList) {
        double avgTemperature = WeatherResult.getAvgTemperature(dayTypeList);
        return Math.toIntExact(dayTypeList.stream()
                .map(DayType::getTemperature)
                .filter(integer -> integer > avgTemperature).count());
    }

    public static int getQuantityDaysTempBelowZero(List<DayType> dayTypeList) {
        return Math.toIntExact(dayTypeList.stream()
                .map(DayType::getTemperature)
                .filter(integer -> integer < 0)
                .count());

    }

    public static List<DayType> getThreeHottestDays(List<DayType> dayTypeList) {
        List<DayType> hottestDay = new ArrayList<>();
        dayTypeList.sort(Comparator.comparingDouble(DayType::getTemperature));
        Collections.reverse(dayTypeList);
        hottestDay.add(dayTypeList.get(0));
        hottestDay.add(dayTypeList.get(1));
        hottestDay.add(dayTypeList.get(2));
        return hottestDay;
    }

}
