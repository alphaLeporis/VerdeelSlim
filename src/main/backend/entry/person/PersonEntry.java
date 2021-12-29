package backend.entry.person;

import backend.entry.DatabaseEntry;

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

    public double getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(double netAmount) {
        this.netAmount = netAmount;
    }

    public void addAmountPaid(double amountPaid){
        this.amountPaid += amountPaid;
    }

    public void addAmountBorrowed(double amountBorrowed){
        this.amountBorrowed += amountBorrowed;
    }

    public void reduceAmountPaid(double amountPaid){
        this.amountPaid -= amountPaid;
    }

    public void reduceAmountBorrowed(double amountBorrowed){
        this.amountBorrowed -= amountBorrowed;
    }

    public void calcNetAmount(){
        this.netAmount = this.amountPaid-this.amountBorrowed;
    }


    @Override
    public String toString() {
        return "PersonEntry{" +
                "name='" + name + '\'' +
                ", amountPaid=" + amountPaid +
                ", amountBorrowed=" + amountBorrowed +
                ", netAmount=" + netAmount +
                '}';
    }
}
