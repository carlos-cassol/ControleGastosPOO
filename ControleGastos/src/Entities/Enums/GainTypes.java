package Entities.Enums;

public enum GainTypes {
    Pix(1), Transferencia(2), Dinheiro(3);

    private int value;

    GainTypes(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    public static GainTypes fromValue(int value){
        for(GainTypes method : GainTypes.values()) {
            if (method.getValue() == value) {
                return method;
            }
        }
        throw new IllegalArgumentException("Valor Inválido: " + value);
    }
}
