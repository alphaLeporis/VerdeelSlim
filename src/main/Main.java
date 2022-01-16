import backend.calculator.BillCalculator;
import backend.databases.PersonsDatabase;
import backend.databases.TicketsDatabase;
import backend.databases.controllers.PersonsController;
import backend.databases.controllers.TicketsController;
import backend.entry.person.PersonEntry;
import backend.entry.tickets.TicketEntry;
import backend.entry.tickets.TicketFactory;
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
        PersonsController personsController = new PersonsController(PersonsDatabase.getInstance());
        TicketsController ticketsController = new TicketsController(TicketsDatabase.getInstance());
        TicketFactory ticketFactory = new TicketFactory();

        PersonEntry person1 = new PersonEntry("Bob");
        PersonEntry person2 = new PersonEntry("Karl");
        PersonEntry person3 = new PersonEntry("Charel");

        personsController.createEntry(person1);
        personsController.createEntry(person2);
        personsController.createEntry(person3);


        TicketEntry ticket1 = ticketFactory.getTicket("Pretpark", "Amusement", 100.4, person1);
        TicketEntry ticket2= ticketFactory.getTicket("Diner", "Restaurant", 234.25, person1);
        TicketEntry ticket3 = ticketFactory.getTicket("Movies", "Amusement", 453.13, person3);
        ticketsController.createEntry(ticket1);
        ticketsController.createEntry(ticket2);
        ticketsController.createEntry(ticket3);

        BillCalculator billCalculator = BillCalculator.getInstance();
        billCalculator.calculateBill();
    }
}
