package Jobsheet4;

public class MainExperiment4 {
    public static void main(String[] args) {
        Passenger p = new Passenger("12345", "Mr. Krab");
        Carriage carriage = new Carriage("A", 10);
        carriage.setPassenger(p, 1);
        System.out.println(carriage.info());

        Passenger budi = new Passenger("67890", "Budi");
        carriage.setPassenger(budi, 1);

    }
}
