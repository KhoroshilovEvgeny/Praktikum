import java.util.ArrayList;
import java.util.HashMap;

public class Checker {
    public ArrayList<MonthlyReport> mReports;
    public YearlyReport yReport;



    public Checker(ArrayList<MonthlyReport> mReports, YearlyReport yReport) {
        this.mReports = mReports;
        this.yReport = yReport;
    }


    public boolean check() {
        boolean check = true;
        // приводим данные из отчетов по месяцам к единому формату ведомости
        HashMap<Integer, Vedomost> monthVed = new HashMap<>();
        for (int i = 1; i <= mReports.size(); i++){
            Vedomost baza = new Vedomost();
            baza.expenses = 0;
            baza.incomes = 0;

            MonthlyReport vrem = mReports.get(i-1);
            for (Transaction tek : vrem.transactions) {
                if (tek.isExpense) {
                    baza.expenses += tek.quantity * tek.unitPrice;
                } else {
                    baza.incomes += tek.quantity * tek.unitPrice;
                }
            }
            monthVed.put(i, baza);
        }


        // приводим данные из годового отчета к едному формату ведомости
        HashMap<Integer, Vedomost> yearVed = new HashMap<>();
        GodVedomost godVedomost = new GodVedomost(yReport);
        yearVed = godVedomost.zapolnitVedom();


        // сверяем две ведомости
        for (Integer mes : monthVed.keySet()) {
            Vedomost izMonthVed = monthVed.get(mes);
            Vedomost izYearVed = yearVed.get(mes);
            int expIzMonthVed = izMonthVed.expenses;
            int incIzMonthVed = izMonthVed.incomes;
            int expIzYearVed = izYearVed.expenses;
            int incIzYearVed = izYearVed.incomes;
            if ((expIzMonthVed != expIzYearVed) || (incIzMonthVed != incIzYearVed)) {
                System.out.println(" В месяце " + mes + " выявлено не соответствие между месячным и годовым отчетами.");
                check = false;
            }
        }
        return check;
    }

}