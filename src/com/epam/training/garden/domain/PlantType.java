package com.epam.training.garden.domain;

import java.util.Objects;

public class PlantType {
    public String name;
    public double area;
    public  double waterAmount;

    public PlantType(String name, double area, double waterAmount) {
        this.name = name;
        this.area = area;
        this.waterAmount = waterAmount;
    }

    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }

    public double getWaterAmount() {
        return waterAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlantType)) return false;
        PlantType plantType = (PlantType) o;
        return Double.compare(plantType.area, area) == 0 && Double.compare(plantType.waterAmount, waterAmount) == 0 && Objects.equals(name, plantType.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, area, waterAmount);
    }

    @Override
    public String toString() {
        return "PlantType{" +
                "name='" + name + '\'' +
                ", area=" + area +
                ", waterAmount=" + waterAmount +
                '}';
    }
}
