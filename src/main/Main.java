import calculator.BillCalculator;
import databases.PersonsDatabase;
import databases.TicketsDatabase;
import databases.controllers.PersonsController;
import databases.controllers.TicketsController;
import databases.entry.PersonEntry;
import databases.entry.TicketEntry;
import databases.entry.tickets.TicketFactory;
import gui.Display;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main
{

    //ToDo: Toevoegen van een db observer -> opslagen
    //ToDo: Nakijken of we al de factory patterns hebben
    //ToDo: Tests schrijven


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
        PersonsDatabase personDatabase = PersonsDatabase.getInstance();
        PersonsController personsController = new PersonsController(personDatabase);
        TicketsDatabase ticketDatabase = TicketsDatabase.getInstance();
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
        TicketEntry ticket3 = ticketFactory.getTicket("Movies", "Amusement", 453.13, person3);
        ticketsController.createEntry(ticket1);
        ticketsController.createEntry(ticket2);
        ticketsController.createEntry(ticket3);

        BillCalculator billCalculator = new BillCalculator();
        billCalculator.calculateBill();
        HashMap<String, ArrayList<Map.Entry<String, Double>>> debts =billCalculator.getDebtsList();
        for(Map.Entry<String, ArrayList<Map.Entry<String, Double>>> entry: debts.entrySet()){
            for(Map.Entry<String, Double> set: entry.getValue()){
                System.out.println(entry.getKey() + " gets/gives  to  " + set.getKey() + " amount: " + set.getValue());
            }
        }
    }
}
