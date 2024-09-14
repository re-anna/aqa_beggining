package org.example.task1.Bank;

public class BankAccount implements Printable {
    private String accountNumber;
    private int balance;

    //setter
    public void setBalance(int balance){
        this.balance = balance;
    }

    //getter
    public int getBalance(){
        return this.balance;
    }

    @Override
    public void print() {
        System.out.println("Баланс равен " + this.balance);
    }
}
