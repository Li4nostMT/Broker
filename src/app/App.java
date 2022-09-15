package app;

import java.util.Scanner;

public class App {

    static String brokerName;
    static String email;
    static String phone;
    static String productName;
    static int quantity;
    static double price;
    static String roundBonus;
    static ProductA product;
    static BrokerA broker;
    static String infoBroker;
    static String infoProduct;
    static Scanner scanner;

    public static void main(String[] args) {
        doInputs();
        showData(processData());
    }

    private static void doInputs() {
        scanner = new Scanner(System.in);
        System.out.println("Введите имя брокера: ");
        brokerName = scanner.nextLine();
        System.out.println("Введите телефон брокера: ");
        phone = scanner.nextLine();
        System.out.println("Введите почту брокера: ");
        email = scanner.nextLine();

        System.out.println("Введите наименование продукта: ");
        productName = scanner.nextLine();
        System.out.println("Введите количество продукта: ");
        quantity = scanner.nextInt();
        System.out.println("Введите цену продукта: ");
        price = scanner.nextDouble();
        scanner.close();

    }


    private static String processData() {
        broker = new BrokerA(brokerName, phone, email);
        infoBroker = broker.infoBroker();
        product = new ProductA(productName, quantity, price);
        infoProduct = product.infoProduct();
        double sales = product.calcSales(quantity, price);
        roundBonus = Rounder.roundValue(broker.calcCommission(sales));
        return infoBroker + infoProduct + "\nБонус (грн.): " + roundBonus;
    }

    private static void showData(String output) {
        System.out.println(output);
    }
}
