package databases.entry;

public class PersonEntry extends DatabaseEntry {
    private double amountPaid;
    private double amountBorrowed;

    public PersonEntry(String name) {
        super(name);
        this.amountBorrowed = 0;
        this.amountPaid = 0;
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

    public void setAmountBorrowed(double amountBorrowed) {
        this.amountBorrowed = amountBorrowed;
    }

    public void addAmountPaid(double amountPaid){
        this.amountPaid += amountPaid;
    }

    public void addAmountBorrowed(double amountBorrowed){
        this.amountBorrowed += amountBorrowed;
    }
}
