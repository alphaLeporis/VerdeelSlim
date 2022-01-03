package integration;

import backend.calculator.BillCalculator;
import backend.databases.PersonsDatabase;
import backend.databases.TicketsDatabase;
import backend.databases.controllers.PersonsController;
import backend.databases.controllers.TicketsController;
import backend.entry.person.PersonEntry;
import backend.entry.tickets.TicketEntry;
import backend.entry.tickets.TicketFactory;
import backend.exception.PersonHasDebtException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class CreationIntegrationTest {
    @Before
    public void initialize() {

    }

    @Test
    public void t_addPerson() throws Exception {
        PersonsController personsController = new PersonsController(PersonsDatabase.getInstance());

        personsController.createEntry(new PersonEntry("Bob"));
        personsController.createEntry(new PersonEntry("Lisa"));
        personsController.createEntry(new PersonEntry("Noa"));
    }

    @Test
    public void t_removePerson() throws Exception {
        PersonsController personsController = new PersonsController(PersonsDatabase.getInstance());

        PersonEntry person1 = new PersonEntry("Bob");
        personsController.createEntry(person1);
        personsController.removeEntry(person1);
    }

    @Test
    public void t_addTicket() throws Exception {
        PersonsController personsController = new PersonsController(PersonsDatabase.getInstance());
        TicketsController ticketsController = new TicketsController(TicketsDatabase.getInstance());
        TicketFactory ticketFactory = new TicketFactory();

        PersonEntry person1 = new PersonEntry("Bob");
        personsController.createEntry(person1);

        TicketEntry ticket1 = ticketFactory.getTicket("Pretpark", "Amusement", 100.4, person1);
        ticketsController.createEntry(ticket1);
    }

    @Test
    public void t_removeTicket() throws Exception {
        PersonsController personsController = new PersonsController(PersonsDatabase.getInstance());
        TicketsController ticketsController = new TicketsController(TicketsDatabase.getInstance());
        TicketFactory ticketFactory = new TicketFactory();

        PersonEntry person1 = new PersonEntry("Bob");
        personsController.createEntry(person1);

        TicketEntry ticket1 = ticketFactory.getTicket("Pretpark", "Amusement", 100.4, person1);
        ticketsController.createEntry(ticket1);
        ticketsController.removeEntry(ticket1);
    }

    @Test
    public void t_calculateBill() throws Exception {
        PersonsController personsController = new PersonsController(PersonsDatabase.getInstance());
        TicketsController ticketsController = new TicketsController(TicketsDatabase.getInstance());
        TicketFactory ticketFactory = new TicketFactory();
        BillCalculator billCalculator = BillCalculator.getInstance();

        PersonEntry person1 = new PersonEntry("Bob");
        PersonEntry person2 = new PersonEntry("Lisa");

        personsController.createEntry(person1);
        personsController.createEntry(person2);

        TicketEntry ticket1 = ticketFactory.getTicket("Pretpark", "Amusement", 100.4, person1);
        TicketEntry ticket2 = ticketFactory.getTicket("Diner", "Restaurant", 234.25, person2);
        ticketsController.createEntry(ticket1);
        ticketsController.createEntry(ticket2);
        billCalculator.calculateBill();
    }

    @Test
    public void t_reCalculateBill() throws Exception {
        PersonsController personsController = new PersonsController(PersonsDatabase.getInstance());
        TicketsController ticketsController = new TicketsController(TicketsDatabase.getInstance());
        TicketFactory ticketFactory = new TicketFactory();
        BillCalculator billCalculator = BillCalculator.getInstance();

        PersonEntry person1 = new PersonEntry("Bob");
        PersonEntry person2 = new PersonEntry("Lisa");

        personsController.createEntry(person1);
        personsController.createEntry(person2);

        TicketEntry ticket1 = ticketFactory.getTicket("Pretpark", "Amusement", 100.4, person1);
        TicketEntry ticket2 = ticketFactory.getTicket("Diner", "Restaurant", 234.25, person2);
        ticketsController.createEntry(ticket1);
        ticketsController.createEntry(ticket2);
        billCalculator.calculateBill();

        TicketEntry ticket3 = ticketFactory.getTicket("Movies", "Amusement", 453.13, person2);
        ticketsController.createEntry(ticket3);
        billCalculator.calculateBill();
    }

    @Test
    public void t_removePersonInDebt() {
        PersonsController personsController = new PersonsController(PersonsDatabase.getInstance());
        TicketsController ticketsController = new TicketsController(TicketsDatabase.getInstance());
        TicketFactory ticketFactory = new TicketFactory();
        BillCalculator billCalculator = BillCalculator.getInstance();

        PersonEntry person1 = new PersonEntry("Bob");
        PersonEntry person2 = new PersonEntry("Lisa");

        personsController.createEntry(person1);
        personsController.createEntry(person2);

        TicketEntry ticket1 = ticketFactory.getTicket("Pretpark", "Amusement", 100.4, person1);
        TicketEntry ticket2 = ticketFactory.getTicket("Diner", "Restaurant", 234.25, person2);
        ticketsController.createEntry(ticket1);
        ticketsController.createEntry(ticket2);
        billCalculator.calculateBill();

        TicketEntry ticket3 = ticketFactory.getTicket("Movies", "Amusement", 453.13, person2);
        ticketsController.createEntry(ticket3);
        billCalculator.calculateBill();

        personsController.removeEntry(person1); // Dit zou een exception moeten geven
    }

}
