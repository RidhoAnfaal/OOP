package Jobsheet10.Exercise2;

public class Manusia {
    public void nyalakanPerangkat(Elektronik perangkat) {
        if (perangkat instanceof TelevisiJadul) {
            TelevisiJadul tvJadul = (TelevisiJadul) perangkat;
            System.out.println("Nyalakan televisi jadul dengan input : " + tvJadul.getModelInput());
            System.out.println("Voltase televisi: " + tvJadul.getVoltase());
        } else if (perangkat instanceof TelevisiModern) {
            TelevisiModern tvModern = (TelevisiModern) perangkat;
            System.out.println("Nyalakan televisi modern dengan input: " + tvModern.getModelInput());
            System.out.println("Voltase televisi: " + tvModern.getVoltase());
        }
    }
}