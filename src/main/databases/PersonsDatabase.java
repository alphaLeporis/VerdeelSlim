package databases;

public class PersonsDatabase {

    private static PersonsDatabase instance;
    static {
        instance = new PersonsDatabase();
    }

}
