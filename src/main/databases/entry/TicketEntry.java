package databases.entry;

public abstract class TicketEntry extends DatabaseEntry {
    private String ticketType;
    protected double price;
    protected PersonEntry paidBy;

    public TicketEntry(String ticketType, double price, PersonEntry paidBy) {
        super(price)
        this.ticketType = ticketType;
        this.paidBy = paidBy;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public PersonEntry getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(PersonEntry paidBy) {
        this.paidBy = paidBy;
    }
}
