package Entities;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private List<Ganhos> TotalGains;
    private List<Gastos> Spendings;

    public Person(){
        Spendings = new ArrayList<>();
        TotalGains = new ArrayList<>();
    }
    public void AddGain(Ganhos gain){
        TotalGains.add(gain);
    }
    public void AddSpending(Gastos spendings){
        Spendings.add(spendings);
    }
    public double AllGains() {
        double amount = 0;
        for (Ganhos gains: TotalGains) {
            amount += gains.getGainValue();
        }
        return amount;
    }

    public double AllSpending() {
        double amount = 0;
        for (Gastos spendings : Spendings){
            amount += spendings.getSpendingValue();
        }
        return amount;
    }

    public List<Gastos> SpendingsOverview(){
        return Spendings;
    }

    public List<Ganhos> GainsOverview(){
        return TotalGains;
    }
}
