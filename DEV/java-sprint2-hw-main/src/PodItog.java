public class PodItog {
    int month;
    int amount;
    Boolean isExpense;

    public PodItog(String line) {
        String[] parts = line.split(",");
        this.month = Integer.parseInt(parts[0]);
        this.amount = Integer.parseInt(parts[1]);
        this.isExpense = Boolean.parseBoolean(parts[2]);
    }
}
