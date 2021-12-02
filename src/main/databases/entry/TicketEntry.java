package databases.entry;

import databases.PersonsDatabase;

public abstract class TicketEntry extends DatabaseEntry {
    private String ticketType;
    private double price;
    private PersonEntry paidBy;
    private TicketSplitMap ticketSplitMap;
    private PersonsDatabase personsDatabase;

    public TicketEntry(String name, String ticketType, double price, PersonEntry paidBy) {
        super(name);
        this.ticketType = ticketType;
        this.paidBy = paidBy;
        this.ticketSplitMap = new TicketSplitMap();
        this.personsDatabase = PersonsDatabase.getInstance();
        this.price = price;
        this.initializeMap();
    }

    public void initializeMap(){
        for (String entry: this.personsDatabase.getDB().keySet()){
                this.ticketSplitMap.addName(entry, this.price/this.personsDatabase.getDB().size());
        }
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

    public TicketSplitMap getTicketSplitMap() {
        return ticketSplitMap;
    }

    public void setTicketSplitMap(TicketSplitMap ticketSplitMap) {
        this.ticketSplitMap = ticketSplitMap;
    }
}
