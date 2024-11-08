package Jobsheet10;

public class Tester1 {
    public static void main(String[] args) {
        PermanentEmployee pEmp = new PermanentEmployee("Didik", 500);
        InternshipEmplyoyee iEmp = new InternshipEmplyoyee("Sunarto", 5);
        ElectricityBill eBill = new ElectricityBill(5, "A-1");

        @SuppressWarnings("unused")
        Employee e;
        @SuppressWarnings("unused")
        Payable p;
        e = pEmp;
        e = iEmp;
        p = pEmp;
        p = eBill;
    }
}
