package unitTests;

import backend.databases.PersonsDatabase;
import backend.databases.controllers.PersonsController;
import backend.entry.person.PersonEntry;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertSame;

@RunWith(PowerMockRunner.class)
@PrepareForTest(PersonsController.class)
public class PersonsControllerUnitTest {
    @Before
    public void initialize()
    {
    }

    @Test
    public void t_creatEntry()
    {
        PersonsDatabase mock_db = Mockito.mock(PersonsDatabase.class);
        PersonEntry mock_person = Mockito.mock(PersonEntry.class);


        PersonsController personsControllerUnderTest = new PersonsController(mock_db);
        personsControllerUnderTest.createEntry(mock_person);
        Mockito.verify(mock_db, Mockito.times(1)).addEntry(mock_person);
    }

    @Test
    public void t_removeEntry()
    {
        PersonsDatabase mock_db = Mockito.mock(PersonsDatabase.class);
        PersonEntry mock_person = Mockito.mock(PersonEntry.class);
        PersonEntry mock_person2 = Mockito.mock(PersonEntry.class);


        PersonsController personsControllerUnderTest = new PersonsController(mock_db);
        personsControllerUnderTest.createEntry(mock_person);
        Mockito.verify(mock_db, Mockito.times(1)).addEntry(mock_person);
        personsControllerUnderTest.createEntry(mock_person2);
        Mockito.verify(mock_db, Mockito.times(1)).addEntry(mock_person2);

        personsControllerUnderTest.removeEntry(mock_person);
        Mockito.verify(mock_db, Mockito.times(1)).removeEntry(mock_person);
        personsControllerUnderTest.removeEntry(mock_person2);
        Mockito.verify(mock_db, Mockito.times(1)).removeEntry(mock_person2);
    }

    @Test
    public void t_getAllEntries()
    {
        PersonsDatabase personDatabase = PersonsDatabase.getInstance();
        PersonEntry person1 = new PersonEntry("Bob");
        PersonEntry person2 = new PersonEntry("Karl");


        PersonsController personsControllerUnderTest = new PersonsController(personDatabase);
        personsControllerUnderTest.createEntry(person1);
        personsControllerUnderTest.createEntry(person2);


        Assert.assertSame(personDatabase.getDB(), personsControllerUnderTest.getAllEntries());
    }
}
