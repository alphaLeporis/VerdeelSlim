package databases;

import databases.entry.DatabaseEntry;
import org.supercsv.io.CsvListWriter;
import org.supercsv.io.ICsvListWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.StringWriter;
import java.util.Map;

public class CSVHandler<T> {
    public CSVHandler() {}


    public void writeHashMapToCsv(Map<String, T> map) throws Exception {
        StringWriter output = new StringWriter();
        try (ICsvListWriter listWriter = new CsvListWriter(output,
                CsvPreference.STANDARD_PREFERENCE)){
            for (Map.Entry<String, T> entry : map.entrySet()){
                listWriter.write(entry.getKey(), entry.getValue());
            }
        }

        System.out.println(output);
    }
}
