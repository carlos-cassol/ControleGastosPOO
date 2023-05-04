package Entities;

import Entities.Enums.PaymentMethod;
import Entities.Enums.SpendingTypes;
import java.util.Date;

public class Gastos {

    private String SpendingName;
    private SpendingTypes SpendingType;
    private Date SpendingDate;
    private Double SpendingValue;
    private PaymentMethod PaymentMethod;

    //Getters
    public String getSpendingName(){
        return SpendingName;
    }
    public SpendingTypes getSpendingType(){ return SpendingType; }
    public Date getSpendingDate(){
        return SpendingDate;
    }
    public double getSpendingValue(){
        return SpendingValue;
    }
    public PaymentMethod getPaymentMethod(){
        return  PaymentMethod;
    }

    //set
    public Gastos (String spendingName, SpendingTypes spendingType, Date spendingDate, Double spendingValue, PaymentMethod paymentMethod){
        SpendingName = spendingName;
        SpendingType = spendingType;
        SpendingDate = spendingDate;
        SpendingValue = spendingValue;
        PaymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Nome do gasto: " + SpendingName + ", Tipo do gasto: " + SpendingType + ", Data do gasto: " + SpendingDate + ", Valor do gasto: " + SpendingValue + ", Método de pagamento: " + PaymentMethod;
    }
}
