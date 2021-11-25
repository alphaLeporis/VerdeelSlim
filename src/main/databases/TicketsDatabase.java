package databases;

public class TicketsDatabase {

    private static TicketsDatabase instance;
    static {
        instance = new TicketsDatabase();
    }
}
