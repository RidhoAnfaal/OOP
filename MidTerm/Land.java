package MidTerm;

import java.util.ArrayList;
import java.util.List;

public class Land {
    String soilType;
    int size; // in meters
    List<Crop> crops;

    public Land(String soilType, int size) {
        this.soilType = soilType;
        this.size = size;
        this.crops = new ArrayList<>();
    }

    public void plant(Crop crop) {
        crops.add(crop);
        System.out.println("Planted " + crop.name);
        System.out.println("");
    }

    public void water(Crop crop) {
        crop.water();
    }

    public void fertilize(Crop crop) {
        System.out.println("Fertilized " + crop.name);
        System.out.println("");
    }

    public void pestControl(Crop crop) {
        crop.getSick(); // pest control
        System.out.println("Pest control applied on " + crop.name);
        System.out.println("");
    }

    public List<Crop> getCrops() {
        return crops;
    }
}