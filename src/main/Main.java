import calculator.BillCalculator;
import databases.Database;
import databases.PersonsDatabase;
import databases.TicketsDatabase;
import databases.controllers.PersonsController;
import databases.controllers.TicketsController;
import databases.entry.PersonEntry;
import databases.entry.TicketEntry;
import databases.entry.tickets.TicketFactory;
import gui.Display;

public class Main
{
    public static void main(String[] args)
    {
        Main main = new Main();
    }

    public Main()
    {
        System.out.println("VerdeelSlim is starting...");
        run();


        Display display = new Display();
    }

    public void run()
    {
        Database personDatabase = PersonsDatabase.getInstance();
        PersonsController personsController = new PersonsController(personDatabase);
        Database ticketDatabase = TicketsDatabase.getInstance();
        TicketsController ticketsController = new TicketsController(ticketDatabase);
        TicketFactory ticketFactory = new TicketFactory();

        PersonEntry person1 = new PersonEntry("Bob");
        PersonEntry person2 = new PersonEntry("Karl");
        PersonEntry person3 = new PersonEntry("Charel");

        personsController.createEntry(person1);
        personsController.createEntry(person2);
        personsController.createEntry(person3);


        TicketEntry ticket1 = ticketFactory.getTicket("Pretpark", "Amusement", 100.4, person1);
        TicketEntry ticket2= ticketFactory.getTicket("Diner", "Restaurant", 234.25, person1);
        ticketsController.createEntry(ticket1);
        ticketsController.createEntry(ticket2);

        BillCalculator billCalculator = new BillCalculator();
        billCalculator.calculateBill();
    }
}
