package service;

import model.DayType;

import java.util.*;
import java.util.stream.Collectors;

public class WeatherService {
    public double getAvgTemperature(List<DayType> dayTypeList) {
        return dayTypeList.stream()
                .mapToInt(DayType::getTemperature)
                .average().getAsDouble();
    }

    public int getDaysQuantityTempAboveAvg(List<DayType> dayTypeList) {
        WeatherService weatherService = new WeatherService();
        double avgTemperature = weatherService.getAvgTemperature(dayTypeList);
        return Math.toIntExact(dayTypeList.stream()
                .map(DayType::getTemperature)
                .filter(integer -> integer > avgTemperature).count());
    }

    public int getDaysQuantityTempBelowZero(List<DayType> dayTypeList) {
        return Math.toIntExact(dayTypeList.stream()
                .map(DayType::getTemperature)
                .filter(integer -> integer < 0)
                .count());

    }

    public List<DayType> getThreeHottestDays(List<DayType> dayTypeList) {
        return dayTypeList.stream()
                .sorted((x, y) -> y.getTemperature() - x.getTemperature())
                .limit(3).collect(Collectors.toList());
    }

}
