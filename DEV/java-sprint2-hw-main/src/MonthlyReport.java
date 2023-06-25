import  java.util.ArrayList;
public class MonthlyReport {

    ArrayList<Transaction> transactions = new  ArrayList<>();
    public MonthlyReport(ArrayList<String> lines) {
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            Transaction tekTransaction = new Transaction(line);
            transactions.add(tekTransaction);

        }

    }

    public void pechatOtchet(){
        int maxIncome = 0;
        int maxExpense = 0;
        int tekVal;
        String maxIncomeName = "", maxExpenseName = "";
        for (Transaction transaction : this.transactions) {
            tekVal = transaction.quantity * transaction.unitPrice;
            if (transaction.isExpense) {
                if (tekVal > maxExpense) {
                    maxExpense = tekVal;
                    maxExpenseName = transaction.name;
                }
            } else {
                if (tekVal > maxIncome) {
                    maxIncome = tekVal;
                    maxIncomeName = transaction.name;
                }
            }
        }
        System.out.println("Самый прибыльный товар - " + maxIncomeName + " на сумму " + maxIncome);
        System.out.println("Самая большая трата - " + maxExpenseName + " на сумму " + maxExpense);

    }
}
