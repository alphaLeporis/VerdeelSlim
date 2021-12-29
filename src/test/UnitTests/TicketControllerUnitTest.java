package UnitTests;

import backend.databases.PersonsDatabase;
import backend.databases.TicketsDatabase;
import backend.databases.controllers.PersonsController;
import backend.databases.controllers.TicketsController;
import backend.entry.person.PersonEntry;
import backend.entry.tickets.TicketEntry;
import backend.entry.tickets.TicketFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(PersonsController.class)
public class TicketControllerUnitTest {
    @Before
    public void initialize()
    {
    }

    @Test
    public void t_creatEntry() throws Exception
    {
        TicketsDatabase mock_db = Mockito.mock(TicketsDatabase.class);
        TicketEntry mock_ticket = Mockito.mock(TicketEntry.class);


        TicketsController ticketsControllerUnderTest = new TicketsController(mock_db);
        ticketsControllerUnderTest.createEntry(mock_ticket);
        Mockito.verify(mock_db, Mockito.times(1)).addEntry(mock_ticket);
    }

    @Test
    public void t_removeEntry() throws Exception
    {
        TicketsDatabase mock_db = Mockito.mock(TicketsDatabase.class);
        TicketEntry mock_ticket = Mockito.mock(TicketEntry.class);
        TicketEntry mock_ticket2 = Mockito.mock(TicketEntry.class);


        TicketsController ticketsControllerUnderTest = new TicketsController(mock_db);
        ticketsControllerUnderTest.createEntry(mock_ticket);
        Mockito.verify(mock_db, Mockito.times(1)).addEntry(mock_ticket);
        ticketsControllerUnderTest.createEntry(mock_ticket2);
        Mockito.verify(mock_db, Mockito.times(1)).addEntry(mock_ticket2);

        ticketsControllerUnderTest.removeEntry(mock_ticket);
        Mockito.verify(mock_db, Mockito.times(1)).removeEntry(mock_ticket);
        ticketsControllerUnderTest.removeEntry(mock_ticket2);
        Mockito.verify(mock_db, Mockito.times(1)).removeEntry(mock_ticket2);
    }

    @Test
    public void t_getAllEntries() throws Exception
    {
        PersonsDatabase personDatabase = PersonsDatabase.getInstance();
        PersonsController personsController = new PersonsController(personDatabase);
        TicketsDatabase ticketDatabase = TicketsDatabase.getInstance();
        TicketsController ticketsControllerUnderTest = new TicketsController(ticketDatabase);
        TicketFactory ticketFactory = new TicketFactory();
        PersonEntry person1 = new PersonEntry("Bob");
        PersonEntry person2 = new PersonEntry("Karl");
        personsController.createEntry(person1);
        personsController.createEntry(person2);

        TicketEntry ticket1 = ticketFactory.getTicket("Pretpark", "Amusement", 100.4, person1);
        TicketEntry ticket2 = ticketFactory.getTicket("Diner", "Restaurant", 234.25, person2);


        ticketsControllerUnderTest.createEntry(ticket1);
        ticketsControllerUnderTest.createEntry(ticket2);


        Assert.assertSame(ticketDatabase.getDB(), ticketsControllerUnderTest.getAllEntries());
    }
}
