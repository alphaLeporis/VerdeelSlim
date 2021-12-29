package backend.entry.tickets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import static java.lang.Math.random;
import static java.lang.Math.round;

public class TicketSplitMap {
    private final HashMap<String, Double> splitMap;

    public TicketSplitMap() {
        this.splitMap = new HashMap<>();
    }


    public HashMap<String, Double> getSplitMap() {
        return splitMap;
    }

// --Commented out by Inspection START (26/12/2021, 23:19):
//    public void setSplitMap(HashMap<String, Double> splitMap) {
//        this.splitMap = splitMap;
//    }
// --Commented out by Inspection STOP (26/12/2021, 23:19)

    public void addName(String name, double value){
        this.splitMap.put(name, value);
    }

    public double getName(String name){
        return this.splitMap.get(name);
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
