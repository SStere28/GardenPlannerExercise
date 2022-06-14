package com.epam.training.garden.service;

import com.epam.training.garden.domain.GardenProperties;
import com.epam.training.garden.domain.PlantType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GardenService {

    GardenProperties gardenProperties;

    public GardenService() {
    }

    public List<PlantType> getPlantTypes() {
        List<PlantType> plantTypes = new ArrayList<>();
        plantTypes.add(new PlantType("Corn", 0.4, 10));
        plantTypes.add(new PlantType("Pumkin", 2, 5));
        plantTypes.add(new PlantType("Grape", 3, 5));
        plantTypes.add(new PlantType("Tomato", 0.3, 10));
        plantTypes.add(new PlantType("Cucumber", 0.4, 10));

        return plantTypes;
    }

    private Optional<PlantType> isPlantPresent(String name) {
        return getPlantTypes().stream().filter(p -> p.getName().equals(name)).findFirst();
    }

    public void setGardenProperties(GardenProperties gardenProperties) {
        this.gardenProperties = gardenProperties;
    }

    public Result evaluatePlan(Map<String, Integer> items) {


        double area = 0;
        double waterAmount = 0;

        try {

            for (Map.Entry<String, Integer> entry : items.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                Optional<PlantType> plantType = isPlantPresent(key);
                if (plantType.isEmpty())
                    throw new IllegalArgumentException("Unknown plant: " + key);
                area += plantType.get().area * value;
                waterAmount += plantType.get().waterAmount * value;

            }



        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }


        return new Result(
                area,
                waterAmount,
                area < gardenProperties.area,
                waterAmount < gardenProperties.waterSupply);
    }
}
