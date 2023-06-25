public class Transaction {
    String name;
    Boolean isExpense;
    int quantity;
    int unitPrice;

    public Transaction(String line) {
        String[] parts = line.split(",");
        this.name = parts[0];
        this.isExpense = Boolean.parseBoolean(parts[1]);
        this.quantity = Integer.parseInt(parts[2]);
        this.unitPrice = Integer.parseInt(parts[3]);
    }
}
