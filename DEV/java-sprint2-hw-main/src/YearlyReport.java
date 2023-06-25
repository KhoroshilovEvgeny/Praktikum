import java.util.ArrayList;
import java.util.HashMap;

public class YearlyReport {
    ArrayList<PodItog> monthsItog = new ArrayList<>();

    public YearlyReport(ArrayList<String> lines) {
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            PodItog tekPodItog = new PodItog(line);
            monthsItog.add(tekPodItog);

        }

    }


    public void pechatOtchet(String god){
        System.out.println("В годовом отчете за " + god + " год содержаться следующие данные:");

        // приводим данные из годового отчета к едному формату ведомости
        HashMap<Integer, Vedomost> yearVed = new HashMap<>();
        GodVedomost godVedomost = new GodVedomost(this);
        yearVed = godVedomost.zapolnitVedom();


        Vedomost vedomost = new Vedomost();
        int averageIncome = 0;
        int averageExpense = 0;
        for (int i = 1; i <= yearVed.size(); i++ ){
            vedomost = yearVed.get(i);
            System.out.println("Прибыль по месяцу " + i + " составила " + (vedomost.incomes - vedomost.expenses));
            averageIncome += vedomost.incomes;
            averageExpense += vedomost.expenses;
        }
        averageIncome /= yearVed.size();
        averageExpense /= yearVed.size();
        System.out.println("Средний расход за все имеющиеся операции в году составил " + averageExpense);
        System.out.println("Средний доход за все имющиеся операции в году составил " + averageIncome);

    }
}

