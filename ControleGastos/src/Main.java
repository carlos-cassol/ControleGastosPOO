import Entities.Enums.PaymentMethod;
import Entities.Enums.SpendingTypes;
import Entities.Ganhos;
import Entities.Gastos;
import Entities.Person;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        boolean valorValido = false;
        Person person = new Person();
        int optFinal = 0;
        boolean isFecharPrograma = false;

        while(option < 6){
            valorValido = false;
            System.out.println("Gestão Financeira");
            System.out.println("-----------------");
            System.out.println("1 - Adicionar Gasto");
            System.out.println("2 - Adicionar Ganho");
            System.out.println("3 - Relatório da Gastos");
            System.out.println("4 - Relatório de Ganhos");
            System.out.println("5 - Relatório Mensal");
            System.out.println("6 - Sair");


            while (!valorValido) {
                System.out.println("Escolha uma opção: ");
                if (sc.hasNextInt()) {
                    option = sc.nextInt();
                    valorValido = true;
                } else {
                    System.out.println("Valor inválido. Digite novamente: ");
                    sc.next();
                }
            }

            switch (option){
                case (1) :
                    //--------------------Nome do gasto
                    System.out.println("Digite o nome do gasto: ");
                    String nomeGasto = sc.next();


                    //----------------------Tipo do gasto

                    int tipoGasto = 0;
                    valorValido = false;
                    while (!valorValido) {
                        System.out.println("Digite o tipo do gasto: \n" +
                                "1 - Casa\n" +
                                "2 - Alimentacao\n" +
                                "3 - Mercado\n" +
                                "4 - Lazer\n" +
                                "5 - Outros");

                        if (sc.hasNextInt()) {
                            tipoGasto = sc.nextInt();
                            valorValido = true;
                        } else {
                            System.out.println("Valor inválido. Digite novamente: ");
                            sc.next();
                        }
                    }
                    SpendingTypes nomeTipoGasto = SpendingTypes.fromValue(tipoGasto);

                    //---------------data do gasto
                    LocalDate localDate = LocalDate.of(2023, 5, 3);
                    Date dateTime = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
                    System.out.print("Digite a data do gasto (dd/MM/yyyy): ");
                    String inputDate = sc.next();

                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");


                    try {
                        dateTime = dateFormat.parse(inputDate);
                    }catch (ParseException e){
                        System.out.println("Data inválida. Digite no formato dd/MM/yyyy.");
                    }

                    //---------------Valor do Gasto
                    System.out.print("Digite o valor do gasto: ");
                    double value = sc.nextDouble();


                    //----------------Tipo do gasto
                    int valorMetodoPagamento = 0;
                    valorValido = false;
                    while (!valorValido) {
                        System.out.println("Digite a forma de pagamento: \n" +
                                "1 - Debito\n" +
                                "2 - Credito\n" +
                                "3 - Dinheiro\n" +
                                "4 - Pix");

                        if (sc.hasNextInt()) {
                            valorMetodoPagamento = sc.nextInt();
                            valorValido = true;
                        } else {
                            System.out.println("Valor inválido. Digite novamente: ");
                            sc.next();
                        }
                    }
                    PaymentMethod tipoPagamento = PaymentMethod.fromValue(valorMetodoPagamento);

                    //
                    Gastos gastos = new Gastos(nomeGasto, nomeTipoGasto, dateTime, value, tipoPagamento);
                    person.AddSpending(gastos);

                    System.out.println("\n\n1 - Voltar\n" +
                            "2 - Sair");
                    optFinal = sc.nextInt();
                    if (optFinal == 1){break;}
                    else {
                        isFecharPrograma = true;
                        break;
                    }


                //----------------------------------------------------------------------------------------------------------


                case(2):
                    //--------------------Nome do Ganho
                    System.out.println("Digite o nome do Ganho: ");
                    String nomeGanho = sc.next();


                    //----------------------Tipo do Ganho

                    int tipoGanho = 0;
                    valorValido = false;
                    while (!valorValido) {
                        System.out.println("Digite o tipo do Ganho: \n" +
                                "1 - Pix\n" +
                                "2 - Transferência\n" +
                                "3 - Dinheiro");

                        if (sc.hasNextInt()) {
                            tipoGanho = sc.nextInt();
                            valorValido = true;
                        } else {
                            System.out.println("Valor inválido. Digite novamente: ");
                            sc.next();
                        }
                    }
                    SpendingTypes nomeTipoGanho = SpendingTypes.fromValue(tipoGanho);


                    //---------------data do Ganho
                    LocalDate dataLocal = LocalDate.of(2023, 5, 3);
                    Date dateTimaGain = Date.from(dataLocal.atStartOfDay(ZoneId.systemDefault()).toInstant());
                    System.out.print("Digite a data do Ganho (dd/MM/yyyy): ");
                    String inputData = sc.next();

                    SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");


                    try {
                        dateTimaGain = formatoData.parse(inputData);
                    }catch (ParseException e){
                        System.out.println("Data inválida. Digite no formato dd/MM/yyyy.");
                    }

                    //---------------Valor do Ganho
                    System.out.print("Digite o valor do Ganho: ");
                    double valor = sc.nextDouble();

                    Ganhos gain = new Ganhos(nomeGanho, nomeTipoGanho, dateTimaGain, valor);
                    person.AddGain(gain);


                    System.out.println("\n\n1 - Voltar\n" +
                            "2 - Sair");
                    optFinal = sc.nextInt();
                    if (optFinal == 1){break;}
                    else {
                        isFecharPrograma = true;
                        break;
                    }
                    //------------------------------------------------------------------------------------------------------

                case(3):

                    System.out.println("Segue relatorio dos gastos: \n\n\n");

                    List<Gastos> listaGastos = person.SpendingsOverview();

                    for (Gastos valoresGastos : listaGastos){
                        System.out.println(valoresGastos);
                        System.out.println("------------------------");
                    }
                    System.out.println("\n\n1 - Voltar\n" +
                            "2 - Sair");
                    optFinal = sc.nextInt();
                    if (optFinal == 1){break;}
                    else {
                        isFecharPrograma = true;
                        break;
                    }


                case (4):

                    System.out.println("Segue relatorio dos ganhos: \n\n\n");

                    List<Ganhos> listaGanhos = person.GainsOverview();

                    for (Ganhos valoresGanhos : listaGanhos){
                        System.out.println(valoresGanhos);
                        System.out.println("------------------------");
                    }
                    System.out.println("\n\n1 - Voltar\n" +
                            "2 - Sair");
                    optFinal = sc.nextInt();
                    if (optFinal == 1){break;}
                    else {
                        isFecharPrograma = true;
                        break;
                    }

                case(5):

                    List<Ganhos> listaValoresGanhos = person.GainsOverview();
                    double totalGanhos = 0;
                    double totalGastos = 0;
                    for (Ganhos valoresGanhos : listaValoresGanhos){
                        totalGanhos += valoresGanhos.getGainValue();
                    }

                    List<Gastos> listaValoresGastos = person.SpendingsOverview();

                    for (Gastos valoresGastos : listaValoresGastos){
                        totalGastos += valoresGastos.getSpendingValue();
                    }

                    System.out.println("O total gasto no mês foi: " + totalGastos);
                    System.out.println("O total ganho no mês foi: " + totalGanhos);

                    System.out.println("O mês fechou com um total de: " + (totalGanhos - totalGastos));
                    System.out.println("\n\n1 - Voltar\n" +
                            "2 - Sair");
                    optFinal = sc.nextInt();
                    if (optFinal == 1){break;}
                    else {
                        isFecharPrograma = true;
                        break;
                    }
                case(6):
                    isFecharPrograma = true;
            }

            for (int i = 0; i < 20; i++){
                System.out.println("\n\n");
            }

            if (isFecharPrograma){
                System.out.println("O programa foi finalizado.");
                break;
            }

        }

    }
}