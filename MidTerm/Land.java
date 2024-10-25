package MidTerm;

public class Land {
    private Crop crop;
    private boolean hasCrop;

    public Land() {
        hasCrop = false;
    }

    public void crop(Crop crop) {
        if (hasCrop) {
            System.out.println("There's already a Crop here.");
        } else {
            this.crop = crop;
            crop.crop();
            hasCrop = true;
        }
    }

    public void water() {
        if (hasCrop) {
            crop.water();
        } else {
            System.out.println("No Crop to water.");
        }
    }

    public void harvest(Player player) {
        if (hasCrop && crop.isReadyToHarvest()) {
            System.out.println("Harvesting " + crop.getName() + "...");
            player.addCropToInventory(crop.getName());
            crop.reset();
            hasCrop = false;
        } else {
            System.out.println("Crop is not ready for harvest.");
        }
    }

    public boolean hasCrop() {
        return hasCrop;
    }

    public Crop getCrop() {
        return crop;
    }

    public void nextDay() {
        if (hasCrop) {
            crop.nextDay();
        }
    }
}
