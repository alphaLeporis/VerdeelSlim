package calculator;

import databases.PersonsDatabase;
import databases.TicketsDatabase;
import databases.entry.PersonEntry;
import databases.entry.PersonEntryComparator;
import databases.entry.TicketEntry;

import java.util.*;

import static java.lang.Math.abs;

public class BillCalculator {

    private HashMap<String, ArrayList<Map.Entry<String, Double>>> debtsList;

    public BillCalculator() {
    }

    public HashMap<String, ArrayList<Map.Entry<String, Double>>> getDebtsList() {
        return debtsList;
    }

    public void calculateBill() {
        PersonsDatabase personsDatabase = PersonsDatabase.getInstance();
        TicketsDatabase ticketsDatabase = TicketsDatabase.getInstance();

        for (TicketEntry ticket : ticketsDatabase.getDB().values()) {
            personsDatabase.getDB().get(ticket.getPaidBy().getName()).addAmountPaid(ticket.getPrice());
            for (String name : ticket.getTicketSplitMap().getSplitMap().keySet()) {
                personsDatabase.getDB().get(name).addAmountBorrowed(ticket.getTicketSplitMap().getSplitMap().get(name));
                personsDatabase.getDB().get(name).calcNetAmount();
            }
        }
         debtCalculator();
    }

    public void debtCalculator(){
        List<PersonEntry> personsDatabase = new ArrayList<>(PersonsDatabase.getInstance().getDB().values());
        personsDatabase.sort(new PersonEntryComparator());
        HashMap<String, ArrayList<Map.Entry<String, Double>>> debts = new HashMap<>();
        for(String elem: PersonsDatabase.getInstance().getDB().keySet()){
                debts.put(elem, new ArrayList<>());
        }
        int debtsSettled = 0;
        int fixedSize = personsDatabase.size();
        while(debtsSettled != fixedSize){
            double netAmount1 = personsDatabase.get(personsDatabase.size()-1).getNetAmount();
            double netAmount2 = personsDatabase.get(0).getNetAmount();
            if(netAmount1 == 0.0){
                personsDatabase.remove(personsDatabase.size()-1);
                debtsSettled++;
                continue;
            }
            if(netAmount2 == 0.0){
                personsDatabase.remove(0);
                debtsSettled++;
                continue;
            }
            double debtAmount = Math.round((abs(netAmount1)-abs(netAmount2)) * 100.0) / 100.0;
            String name1 = personsDatabase.get(personsDatabase.size()-1).getName(); //Person with the lowest debt
            String name2 = personsDatabase.get(0).getName(); //Person with the highest debt
            if(debtAmount < 0.0){ //Person with most debt has more debt than person with the least debt has to receive
                debts.get(name2).add(Map.entry(name1,numberRounder(-1*abs(netAmount1))));
                debts.get(name1).add(Map.entry(name2, numberRounder(abs(netAmount1))));
                personsDatabase.get(personsDatabase.size()-1).setNetAmount(0);
                personsDatabase.get(0).setNetAmount(-1*(abs(netAmount2)-abs(netAmount1)));
                personsDatabase.remove(personsDatabase.size()-1);
                debtsSettled++;
            }
            else if(debtAmount > 0.1){ //Person with most debt can't pay the full amount the person with the least debt should get back
                debts.get(name2).add(Map.entry(name1, numberRounder(-1*abs(netAmount2))));
                debts.get(name1).add(Map.entry(name2, numberRounder(abs(netAmount2))));
                personsDatabase.get(personsDatabase.size()-1).setNetAmount(abs(netAmount1)-abs(netAmount2));
                personsDatabase.get(0).setNetAmount(0);
                personsDatabase.remove(0);
                debtsSettled++;
            }
            else if(debtAmount == 0){
                debts.get(name2).add(Map.entry(name1, numberRounder(-1*abs(netAmount2))));
                debts.get(name1).add(Map.entry(name2, numberRounder(abs(netAmount2))));
                personsDatabase.get(personsDatabase.size()-1).setNetAmount(0);
                personsDatabase.get(0).setNetAmount(0);
                personsDatabase.remove(0);
                personsDatabase.remove(personsDatabase.size()-1);
                debtsSettled += 2;
            }
        }
        this.debtsList = debts;
    }

    public Double numberRounder(double number){
        return Math.round(number*100.0)/100.0;
    }
}
