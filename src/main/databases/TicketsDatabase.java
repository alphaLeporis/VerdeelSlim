package databases;

import databases.entry.PersonEntry;
import databases.entry.TicketEntry;

import java.util.HashMap;

public class TicketsDatabase {

    private static TicketsDatabase instance;
    static {
        instance = new TicketsDatabase();
    }

    public static TicketsDatabase getInstance() {
        return instance;
    }

    private final HashMap<String, TicketEntry> db;

    public TicketsDatabase() {
        this.db = new HashMap<>();
    }
}
