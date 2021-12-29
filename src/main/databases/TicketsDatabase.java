package databases;

import databases.entry.DatabaseEntry;
import databases.entry.TicketEntry;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;


public class TicketsDatabase extends Database<TicketEntry>{
    private static final CSVHandler<TicketEntry> handler;
    private static final TicketsDatabase instance;
    static {
        instance = new TicketsDatabase();
        handler = new CSVHandler<>();
    }

    public static TicketsDatabase getInstance() {
        return instance;
    }

    private final HashMap<String, TicketEntry> db;

    private final PropertyChangeSupport changes = new PropertyChangeSupport(this);

    public TicketsDatabase() {
        this.db = new HashMap<>();
    }

    @Override
    public void addEntry(DatabaseEntry entry) {
        this.db.put(entry.getName(), (TicketEntry) entry);
        this.addDebstToPersons((TicketEntry) entry);
        save();
    }

    @Override
    public void removeEntry(DatabaseEntry entry) {
        this.removeDebstFromPersons((TicketEntry) entry);
        this.db.remove(entry.getName());
        save();
    }

    @Override
    public DatabaseEntry getEntry(String name) {
        return this.db.get(name);
    }

    @Override
    public HashMap<String, TicketEntry> getDB() {
        return this.db;
    }

    @Override
    void addListeners(PropertyChangeListener observer) {
        this.changes.addPropertyChangeListener(observer);
    }

    @Override
    void save() {
        try {
            handler.writeHashMapToCsv(this.db);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addDebstToPersons(TicketEntry ticket){
        PersonsDatabase personsDatabase = PersonsDatabase.getInstance();
        personsDatabase.getDB().get(ticket.getPaidBy().getName()).addAmountPaid(ticket.getPrice());
        for (String name : ticket.getTicketSplitMap().getSplitMap().keySet()) {
            personsDatabase.getDB().get(name).addAmountBorrowed(ticket.getTicketSplitMap().getSplitMap().get(name));
        }
    }

    public void removeDebstFromPersons(TicketEntry ticket){
        PersonsDatabase personsDatabase = PersonsDatabase.getInstance();
        personsDatabase.getDB().get(ticket.getPaidBy().getName()).reduceAmountPaid(ticket.getPrice());
        for (String name : ticket.getTicketSplitMap().getSplitMap().keySet()) {
            personsDatabase.getDB().get(name).reduceAmountBorrowed(ticket.getTicketSplitMap().getSplitMap().get(name));
        }

    }
}
