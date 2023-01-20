package atmproject;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {

    private int accountNumber;
    private int pinNumber;
    private double checkingBalance;
    private double savingBalance;


    Scanner input = new Scanner(System.in);

    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");


    public int getAccountNumber(){
        return accountNumber;
    }
    public void setAccountNumber(int accountNumber){
        this.accountNumber = accountNumber;
    }

    public int getPinNumber(){
        return pinNumber;
    }
    public void setPinNumber(int pinNumber){
        this.pinNumber = pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }
    public void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }
    public void setSavingBalance(double savingBalance) {
        this.savingBalance = savingBalance;
    }

    public Scanner getInput() {
        return input;
    }
    public void setInput(Scanner input) {
        this.input = input;
    }


    //calculate the checking balance after withdraw
    private double calculateCheckingBalanceAfterWithdraw(double amount){
        checkingBalance = checkingBalance - amount;
        return checkingBalance;
    }
    //Calculate the checking balance after deposit
    private double calculateCheckingBalanceAfterDeposit(double amount){
        checkingBalance = checkingBalance + amount;
        return checkingBalance;
    }


    //calculate the saving balance after withdraw
    private double calculateSavingBalanceAfterWithdraw(double amount){
        savingBalance = savingBalance - amount;
        return savingBalance;
    }
    //calculate the saving balance after deposit
    private double calculateSavingBalanceAfterDeposit(double amount){
        savingBalance = savingBalance + amount;
        return savingBalance;
    }


    //Interact with the customer to withdraw from checking account
    public void getCheckingWithdraw(){
        System.out.println("Your checking balance is : " +moneyFormat.format(checkingBalance));
        System.out.println("Enter the amount you would like to withdraw!");
        double amount = input.nextDouble();//400
        if(amount <= 0){
            System.out.println("Negative or zero amount is not acceptable!");
            getCheckingWithdraw();
        }else if (checkingBalance >= amount){
            calculateCheckingBalanceAfterWithdraw(amount);
            System.out.println("This is your remaining balance: "+moneyFormat.format(checkingBalance));
        }else {
            System.out.println("you do not have enough money!");
        }
    }
    //interact with customer to deposit money to s=checking account
    public void getCheckingDeposit(){
        System.out.println("Your checking balance is : " +moneyFormat.format(checkingBalance));
        System.out.println("Enter the amount you would like to deposit!");
        double amount = input.nextDouble();
        if(amount <= 0){
            System.out.println("Negative or zero amount is not acceptable!");
            getCheckingDeposit();
        }else{
            calculateCheckingBalanceAfterDeposit(amount);
            System.out.println();
            System.out.println("Here is your remaining balance: "+ moneyFormat.format(checkingBalance));
        }
    }


    //Interact with customer to withdraw from saving account
    public void getSavingWithdraw(){
        System.out.println("Your saving balance is : " + moneyFormat.format(savingBalance));
        System.out.println("Enter the amount you would like to withdraw!");
        double amount = input.nextDouble();
        if(amount <= 0){
            System.out.println("Negative or zero amount is not acceptable!");
            getSavingWithdraw();
        }else if(savingBalance >= amount){
            calculateSavingBalanceAfterWithdraw(amount);
            System.out.println("Your remaining balance is : " + moneyFormat.format(savingBalance));
        }else {
            System.out.println("you do not have enough money!");
        }
    }
    //Interact with customer to deposit to saving account
    public void getSavingDeposit(){
        System.out.println("Your saving balance is: "+ moneyFormat.format(savingBalance));
        System.out.println("Enter the amount you would like to deposit!");
        double amount = input.nextDouble();
        if(amount <= 0){
            System.out.println("Negative or zero amount is not acceptable!");
            getSavingDeposit();
        }else {
            calculateSavingBalanceAfterDeposit(amount);
            System.out.println("Your remaining balance is: "+ moneyFormat.format(savingBalance));
        }
    }
}