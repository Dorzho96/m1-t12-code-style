import java.util.Scanner;


public class DepositCalculator {

    double CalculateComplexPercent(double a, double y, int d) {
        double pay = a*Math.pow((1 + y / 12), 12 *d);

        return roundToNumber(pay, 2);
    }

    double CalculateSimplePercent(double amount,double yearRate, int depositPeriod) {
         return roundToNumber(amount + amount * yearRate * depositPeriod, 2);
    }

    double roundToNumber(double value,int places) {
        double scale = Math.pow(10, places);

        return Math.round(value * scale) / scale;
    }

    void getResultOfTheDeposit() {
        Scanner scanner = new Scanner(System.in);
        int period;
        int action;

        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        double resultToDeposit = 0;
        if (action == 1) {
            resultToDeposit = CalculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            resultToDeposit = CalculateComplexPercent(amount, 0.06, period);
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + resultToDeposit);
    }

    public static void main(String[] args) {
        new DepositCalculator().getResultOfTheDeposit();
    }

}
