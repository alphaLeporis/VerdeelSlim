package backend.entry.tickets;

import backend.databases.PersonsDatabase;
import backend.entry.DatabaseEntry;
import backend.entry.person.PersonEntry;

import static java.lang.Math.*;

public abstract class TicketEntry extends DatabaseEntry {
    private final String ticketType;
    private final double price;
    private final PersonEntry paidBy;
    private final TicketSplitMap ticketSplitMap;
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

    public TicketSplitMap getTicketSplitMap() {
        return ticketSplitMap;
    }

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
