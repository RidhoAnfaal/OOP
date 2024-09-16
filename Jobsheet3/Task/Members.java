package Jobsheet3.Task;

public class Members {
    private String ktp;
    private String name;
    private int loanLimit;
    private int loanAmount;

    public Members(String ktp, String name, int loanLimit) {
        this.ktp = ktp;
        this.name = name;
        this.loanLimit = loanLimit;
        this.loanAmount = 0;
    }

    public String getKtp() {
        return ktp;
    }

    public String getName() {
        return name;
    }

    public int getLoanLimit() {
        return loanLimit;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public void borrow(int amount) {
        if (amount <= loanLimit - loanAmount) {
            loanAmount += amount;
            System.out.println("Loan successful");
        } else {
            System.out.println("Loan amount exceeds limit");
        }
    }

    public void installments(int amount) {
        if (amount <= loanAmount * 0.1) {
            System.out.println("Sorry, installments must be 10% of the loan amount");
        } else if (amount <= loanAmount) {
            loanAmount -= amount;
            System.out.println("Installment payment successful");
        } else {
            System.out.println("Installment payment amount exceeds current loan amount");
        }
    }
}