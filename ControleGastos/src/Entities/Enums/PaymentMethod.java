package Entities.Enums;

public enum PaymentMethod {
    Debito(1), Credito(2), Dinheiro(3), Pix(4);

    private int value;

    PaymentMethod(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    public static PaymentMethod fromValue(int value){
        for(PaymentMethod method : PaymentMethod.values()) {
            if (method.getValue() == value) {
                return method;
            }
        }
        throw new IllegalArgumentException("Valor Inválido: " + value);
    }
}
