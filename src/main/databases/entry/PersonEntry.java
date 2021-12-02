package databases.entry;

import java.util.Comparator;

public class PersonEntry extends DatabaseEntry {
    private double amountPaid;
    private double amountBorrowed;
    private double netAmount;

    public PersonEntry(String name) {
        super(name);
        this.amountBorrowed = 0;
        this.amountPaid = 0;
        this.netAmount = 0;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public double getAmountBorrowed() {
        return amountBorrowed;
    }

    public double getNetAmount() {
        return netAmount;
    }

    public void setAmountBorrowed(double amountBorrowed) {
        this.amountBorrowed = amountBorrowed;
    }

    public void addAmountPaid(double amountPaid){
        this.amountPaid += amountPaid;
    }

    public void addAmountBorrowed(double amountBorrowed){
        this.amountBorrowed += amountBorrowed;
    }

    public void calcNetAmount(){
        this.netAmount = this.amountPaid-this.amountBorrowed;
    }


}
