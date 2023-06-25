import java.util.HashMap;
public class GodVedomost {
    public YearlyReport yReport;


    public GodVedomost(YearlyReport yReport) {
          this.yReport = yReport;
    }

    public HashMap zapolnitVedom(){
        // приводим данные из годового отчета к едному формату ведомости
        HashMap<Integer, Vedomost> yearVed = new HashMap<>();
        Vedomost baza1 = new Vedomost();
        baza1.expenses = 0;
        baza1.incomes = 0;
        // сначала заполним нулями
        for (PodItog tek : yReport.monthsItog) {
            yearVed.put(tek.month, baza1);
        }
        // теперь заполним значенями из годового отчета
        for (Integer kluch : yearVed.keySet()){
            Vedomost baza = new Vedomost();
            baza.expenses = 0;
            baza.incomes = 0;
            for (PodItog tek : yReport.monthsItog) {
                if (kluch.equals(tek.month)) {
                    if (tek.isExpense) {
                        baza.expenses += tek.amount;
                    } else {
                        baza.incomes += tek.amount;
                    }
                }
            }
            yearVed.put(kluch, baza);
        }
        return yearVed;
    }
}
