package com.epam.training.garden.service;

import java.util.Objects;

public class Result {
    public double area;
    public double waterAmount;
    public boolean areaOk;
    public boolean waterOk;

    public Result(double area, double waterAmount, boolean areaOk, boolean waterOk) {
        this.area = area;
        this.waterAmount = waterAmount;
        this.areaOk = areaOk;
        this.waterOk = waterOk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Result)) return false;
        Result result = (Result) o;
        return Double.compare(result.area, area) == 0 && Double.compare(result.waterAmount, waterAmount) == 0 && areaOk == result.areaOk && waterOk == result.waterOk;
    }

    @Override
    public int hashCode() {
        return Objects.hash(area, waterAmount, areaOk, waterOk);
    }

    @Override
    public String toString() {
        return "Result{" +
                "area=" + area +
                ", waterAmount=" + waterAmount +
                ", areaOk=" + areaOk +
                ", waterOk=" + waterOk +
                '}';
    }
}

