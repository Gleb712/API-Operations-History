import java.util.Scanner;

public class Main {
    // Make 'operations' array static
    private static Operation[] operations = new Operation[100]; // Предположим, у нас не более 100 операций

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Создание массивов для хранения данных по операциям и клиентам
        Customer[] customers = new Customer[10]; // Предположим, у нас не более 10 клиентов
        int[][] statement = new int[10][10]; // Предположим, у нас не более 10 клиентов и 10 операций для каждого

        // Ввод информации о клиентах через консоль
        for (int i = 0; i < customers.length; i++) {
            System.out.println("Введите информацию о клиенте с id " + (i + 1) + ":");
            System.out.print("Имя: ");
            String name = scanner.nextLine();
            System.out.print("Адрес: ");
            String address = scanner.nextLine();
            customers[i] = new Customer(i + 1, name, address);
        }

        // Ввод информации о операциях и их принадлежности клиентам
        for (int i = 0; i < operations.length; i++) {
            System.out.println("Введите информацию об операции с id " + (i + 1) + ":");
            System.out.print("Описание: ");
            String description = scanner.nextLine();
            System.out.print("Сумма: ");
            double amount = Double.parseDouble(scanner.nextLine());
            System.out.print("Дата: ");
            String date = scanner.nextLine();

            operations[i] = new Operation(description, amount, date);

            // Принадлежность операции клиенту
            System.out.print("Введите id клиента для принадлежности операции (1-" + customers.length + "): ");
            int clientId = Integer.parseInt(scanner.nextLine()) - 1;

            statement[clientId][i] = i + 1;
        }

        // Вывод операций клиента в консоль
        System.out.println("Введите id клиента для вывода операций (1-" + customers.length + "): ");
        int clientIdToPrint = Integer.parseInt(scanner.nextLine()) - 1;

        Operation[] customerOperations = getOperations(statement, clientIdToPrint);
        System.out.println("Операции клиента " + customers[clientIdToPrint].getName() + ":");
        for (Operation operation : customerOperations) {
            operation.print(operation);
            System.out.println();
        }

        // Закрытие Scanner
        scanner.close();
    }

    // Метод поиска всех операций клиента
    public static Operation[] getOperations(int[][] statement, int clientId) {
        int[] operationIds = statement[clientId];
        Operation[] customerOperations = new Operation[operationIds.length];

        for (int i = 0; i < operationIds.length; i++) {
            int operationId = operationIds[i];
            customerOperations[i] = operationId != 0 ? operations[operationId - 1] : null;
        }

        return customerOperations;
    }
}