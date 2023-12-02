public class Operation {
    private String description;
    private double amount;
    private String date;

    // Конструктор без аргументов
    public Operation() {
    }

    // Конструктор со всеми полями
    public Operation(String description, double amount, String date) {
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

    // Геттеры и сеттеры (их можно автоматически сгенерировать в среде разработки)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    // Метод для вывода информации об операции в консоль
    public void print(Operation operation) {
        System.out.println("Описание: " + operation.getDescription());
        System.out.println("Сумма: " + operation.getAmount());
        System.out.println("Дата: " + operation.getDate());
    }
}