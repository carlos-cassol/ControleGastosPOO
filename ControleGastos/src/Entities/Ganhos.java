package Entities;

import Entities.Enums.SpendingTypes;
import java.util.Date;


public class Ganhos {
        private String GainName;
        private SpendingTypes GainType;
        private Date GainDate;
        private Double GainValue;

        public double getGainValue() { return  GainValue; }
        public Date getGainDate() {
            return GainDate;
        }
        public SpendingTypes getSpendingTypes() {
            return GainType;
        }
        public String getGainName(){ return GainName; }
        public Ganhos (String spendingName, SpendingTypes spendingType, Date spendingDate, Double spendingValue){
            GainName = spendingName;
            GainType = spendingType;
            GainDate = spendingDate;
            GainValue = spendingValue;
        }

        @Override
        public String toString() {
            return "Nome do gasto: " + GainName + ", Tipo do gasto: " + GainType + ", Data do gasto: " + GainDate + ", Valor do gasto: " + GainValue;
        }
}

