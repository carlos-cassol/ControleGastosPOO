package Entities.Enums;

public enum SpendingTypes {
    Casa(1), Alimentacao(2), Mercado(3), Lazer(4), Outros(5);

    private int value;

    SpendingTypes(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    public static SpendingTypes fromValue(int value){
        for(SpendingTypes spending : SpendingTypes.values()) {
        if (spending.getValue() == value) {
            return spending;
            }
        }
        throw new IllegalArgumentException("Valor Inválido: " + value);
    }
}
