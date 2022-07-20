package model;

public class Day {
    private int temperature;


    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Day temperature: " + temperature;
    }
}
