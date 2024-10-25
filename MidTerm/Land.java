package MidTerm;

public class Land {
    private Crop crop;
    private boolean hasCrop;
    private boolean isBought;
    private int price;
    private int landNumber;

    public Land(int price, int landNumber) {
        this.hasCrop = false;
        this.isBought = false;
        this.price = price;
        this.landNumber = landNumber;
    }

    public void buyLand(Player player) {
        if (!isBought) {
            if (player.getGold() >= price) {
                player.reduceGold(price);
                isBought = true;
                System.out.println("You have successfully bought land " + landNumber + "!\n");
            } else {
                System.out.println("You don't have enough gold to buy this land.\n");
            }
        } else {
            System.out.println("This land is already bought.\n");
        }
    }

    public void plantCrop(Crop crop) {
        if (isBought) {
            if (!hasCrop) {
                this.crop = crop;
                crop.plant();
                hasCrop = true;
            } else {
                System.out.println("There's already a crop growing on this land.\n");
            }
        } else {
            System.out.println("You need to buy the land first.\n");
        }
    }

    public void water() {
        if (hasCrop) {
            crop.water();
        } else {
            System.out.println("No crop to water.\n");
        }
    }

    public void fertilize() {
        if (hasCrop) {
            crop.fertilize();
        } else {
            System.out.println("No crop to fertilize.\n");
        }
    }

    public void controlPests() {
        if (hasCrop) {
            crop.controlPests();
        } else {
            System.out.println("No crop to control pests on.\n");
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
        System.out.println("");
    }

    public boolean hasCrop() {
        return hasCrop;
    }

    public boolean isBought() {
        return isBought;
    }

    public int getLandNumber() {
        return landNumber;
    }
}
