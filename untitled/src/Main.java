import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Создайте массив объектов Operation для 5 транзакций
        Operation[] transactions = new Operation[5];

        // Ввод информации через консоль для 5 транзакций
        for (int i = 0; i < 5; i++) {
            System.out.println("Введите информацию для транзакции " + (i + 1) + ":");

            // Используйте конструктор с аргументами для создания объекта Operation
            System.out.print("Описание: ");
            String description = scanner.nextLine();

            System.out.print("Сумма: ");
            double amount = Double.parseDouble(scanner.nextLine());

            System.out.print("Дата: ");
            String date = scanner.nextLine();

            transactions[i] = new Operation(description, amount, date);
        }

        // Вывод информации о каждой транзакции используя метод print
        System.out.println("Информация о транзакциях:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Транзакция " + (i + 1) + ":");
            transactions[i].print(transactions[i]);
            System.out.println();
        }

        // Закрытие Scanner
        scanner.close();
    }
}
