import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileReader fileReader = new FileReader();
        String fileName;
        ArrayList<String> lines = new ArrayList<>(List.of(""));

        ArrayList<MonthlyReport> mReports = new ArrayList<>();
        YearlyReport yReport = new YearlyReport(lines);
        boolean flagMonth = false;
        boolean flagYear = false;
        String god = "2021";


        while (true) {
            printMenu();
            int userInput = scanner.nextInt();

            if (userInput == 1) {
                for (int i = 1; i <=3 ; i++) {
                    fileName = "m." + god + "0" + i + ".csv";
                    lines = fileReader.readFileContents(fileName);
                    MonthlyReport tekMonthReport = new MonthlyReport(lines);
                    mReports.add(tekMonthReport);
                }
                flagMonth = true;

            } else if (userInput == 2) {
                lines = fileReader.readFileContents("y." + god + ".csv");
                yReport = new YearlyReport(lines);
                flagYear = true;


            } else if (userInput == 3) {
                if (!flagMonth) {
                    System.out.println("Перед проведением сверки необходимо загрузить из файлов месячные отчеты.");
                }
                if (!flagYear) {
                    System.out.println("Перед проведением сверки необходимо загрузить из файла годовой отчет.");
                }
                if (flagMonth && flagYear) {
                    Checker checker = new Checker(mReports, yReport);
                    if (checker.check()) {
                        System.out.println("Сверка месячных и годового отчетов проведена успешно.");
                    }

                }



            } else if (userInput == 4) {
                if (!flagMonth) {
                    System.out.println("Перед проведением сверки необходимо загрузить из файлов месячные отчеты.");
                } else {
                    for (int i = 0; i < mReports.size(); i++) {
                        System.out.println("Название месяца " + (i + 1) );
                        mReports.get(i).pechatOtchet();
                        System.out.println();
                    }

                }


            } else if (userInput == 5) {
                if (!flagYear) {
                    System.out.println("Для печати данных годового отчета необходимо загрузить из файла годовой отчет.");
                } else {
                    yReport.pechatOtchet(god);
                }

            }  else if (userInput == 0) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }
    }



    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию обо всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");

        System.out.println("0 - Выход");
    }
}

