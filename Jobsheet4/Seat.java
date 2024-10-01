package Jobsheet4;

public class Seat {
    private String number;
    private Passenger passenger;

    public Seat(String number) {
        this.number = number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return this.number;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Passenger getPassenger() {
        return this.passenger;
    }

    public String info() {
        String info = "";
        info += "Number: " + number + "\n";
        if (this.passenger != null) {
            info += "Passenger: " + passenger.info() + "\n";
        }
        return info;
    }
}
