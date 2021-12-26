package databases.entry;

import databases.PersonsDatabase;

import static java.lang.Math.*;

public abstract class TicketEntry extends DatabaseEntry {
    private final String ticketType;
    private double price;
    private PersonEntry paidBy;
    private TicketSplitMap ticketSplitMap;
    private final PersonsDatabase personsDatabase;

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
        this.divideEvenly();
    }

    public void divideEvenly(){
        for (String entry: this.personsDatabase.getDB().keySet()){
            this.ticketSplitMap.addName(entry, round((this.price/this.personsDatabase.getDB().size())*100.0)/100.0);
        }
        double sum = this.ticketSplitMap.sum();
        if(abs(sum-this.price) > 0.00001){
            this.ticketSplitMap.addCorrection(round((this.price-sum)*100.0)/100.0);
        }
    }

    public String getTicketType() {
        return ticketType;
    }

    public double getPrice() {
        return price;
    }

// --Commented out by Inspection START (26/12/2021, 23:19):
//    public void setPrice(double price) {
//        this.price = price;
//    }
// --Commented out by Inspection STOP (26/12/2021, 23:19)

    public PersonEntry getPaidBy() {
        return paidBy;
    }

    public void setAmount(PersonEntry person, double amount){
        this.ticketSplitMap.getSplitMap().put(person.getName(), amount);
    }

    public boolean checkPriceIsPaid(){
        double sum = 0;
        for(double part: this.ticketSplitMap.getSplitMap().values()){
            sum += part;
        }
        return(abs(sum-this.price) < 0.00001);
    }

// --Commented out by Inspection START (26/12/2021, 23:19):
//    public void setPaidBy(PersonEntry paidBy) {
//        this.paidBy = paidBy;
//    }
// --Commented out by Inspection STOP (26/12/2021, 23:19)

    public TicketSplitMap getTicketSplitMap() {
        return ticketSplitMap;
    }

// --Commented out by Inspection START (26/12/2021, 23:19):
//    public void setTicketSplitMap(TicketSplitMap ticketSplitMap) {
//        this.ticketSplitMap = ticketSplitMap;
//    }
// --Commented out by Inspection STOP (26/12/2021, 23:19)

    @Override
    public String toString() {
        return "TicketEntry{" +
                "name='" + name + '\'' +
                ", ticketType='" + ticketType + '\'' +
                ", price=" + price +
                ", paidBy=" + paidBy +
                ", ticketSplitMap=" + ticketSplitMap +
                '}';
    }
}
