package databases.entry;

import java.util.Comparator;

public class PersonEntryComparator implements Comparator<PersonEntry> {
    @Override
    public int compare(PersonEntry o1, PersonEntry o2) {
        return Double.compare(o1.getNetAmount(), o2.getNetAmount());
    }
}
