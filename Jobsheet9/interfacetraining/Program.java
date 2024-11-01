package Jobsheet9.interfacetraining;

public class Program {
    public static void main(String[] args) {
        Rector MrRector = new Rector();

        // Udergraduated2 undergraduated = new Udergraduated2("Charlie");
        Udergraduated udergraduatedCumlaude = new Udergraduated("Joe");
        Postgraduated postgraduatedCumlaude = new Postgraduated("Ben");

        // MrRector.giveCumlaudeCertificate(undergraduated);
        // MrRector.giveCumlaudeCertificate(udergraduatedCumlaude);
        // MrRector.giveCumlaudeCertificate(postgraduatedCumlaude);

        MrRector.giveCertificateOfTopStudent(udergraduatedCumlaude);
        MrRector.giveCertificateOfTopStudent(postgraduatedCumlaude);
    }
}