package databases.entry;

public abstract class DatabaseEntry {
    protected String name;

    public DatabaseEntry(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public DatabaseEntry() {
    }
}
