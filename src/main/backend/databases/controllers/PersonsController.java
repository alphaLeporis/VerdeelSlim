package backend.databases.controllers;

import backend.databases.PersonsDatabase;
import backend.entry.person.PersonEntry;
import backend.exception.PersonHasDebtException;


import java.util.HashMap;

public class PersonsController implements Controller<PersonEntry>
{
    private final PersonsDatabase db;

    public PersonsController(PersonsDatabase db)
    {
        this.db = db;
    }

    @Override
    public void createEntry(PersonEntry entry) {
        this.db.addEntry(entry);
    }

    @Override
    public void removeEntry(PersonEntry entry) {
        entry.calcNetAmount();
        if (entry.getNetAmount() == 0) {
            this.db.removeEntry(entry);
        } else {
            try {
                throw new PersonHasDebtException(entry.getName()+" has unsettled debt!");
            } catch (PersonHasDebtException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public HashMap<String, PersonEntry> getAllEntries() {
        return db.getDB();
    }
}
