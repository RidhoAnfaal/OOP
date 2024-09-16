package Jobsheet3.Task;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Members donny = new Members("111333444", "Donny", 5000000);
        Scanner sc = new Scanner(System.in);

        System.out.println("Member name: " + donny.getName());
        System.out.println("Loan limit : " + donny.getLoanLimit());

        System.out.print("\nBorrow money : ");
        donny.borrow(sc.nextInt());
        System.out.println("Current loan amount : " + donny.getLoanAmount());

        System.out.print("\nBorrow money : ");
        donny.borrow(sc.nextInt());
        System.out.println("Current loan amount : " + donny.getLoanAmount());

        System.out.print("\nPay installments : ");
        donny.installments(sc.nextInt());
        System.out.println("Current loan amount : " + donny.getLoanAmount());

        System.out.print("\nPay installments : ");
        donny.installments(sc.nextInt());
        System.out.println("Current loan amount : " + donny.getLoanAmount());

        System.out.print("\nPay installments : ");
        donny.installments(sc.nextInt());
        System.out.println("Current loan amount : " + donny.getLoanAmount());

        sc.close();
    }
}