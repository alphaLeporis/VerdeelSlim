package databases.entry;

import java.util.HashMap;

public class TicketSplitMap {
    private boolean isPercentage;
    private HashMap<String, Double> splitMap;

    public TicketSplitMap() {
        this.isPercentage = false;
        this.splitMap = new HashMap<>();
    }

    public boolean isPercentage() {
        return isPercentage;
    }

    public void setPercentage(boolean percentage) {
        isPercentage = percentage;
    }

    public HashMap<String, Double> getSplitMap() {
        return splitMap;
    }

    public void setSplitMap(HashMap<String, Double> splitMap) {
        this.splitMap = splitMap;
    }

    public void addName(String name, double value){
        this.splitMap.put(name, value);
    }
}
