package databases.entry;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import static java.lang.Math.random;
import static java.lang.Math.round;

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

    public double sum(){
        double sum = 0;
        for(Double amount: this.splitMap.values()){
            sum += amount;
        }
        return sum;
    }

    public void addCorrection(double correction){
        Set<String> keys = this.splitMap.keySet();
        ArrayList<String> keyArr = new ArrayList<>(keys);
        int randIndex = (int)(random() * (keys.size()));
        this.splitMap.put(keyArr.get(randIndex), round((this.splitMap.get(keyArr.get(randIndex))+correction)*100.0)/100.0);
    }
}
