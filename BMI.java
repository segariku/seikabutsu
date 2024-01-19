import java.util.Scanner;
import java.text.DecimalFormat;

public class Bmi {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= 2; i++) {
            System.out.println(i + "人目の方は自身の身長を入力してください。(例: 175cmの場合1.75)");
            double height = scanner.nextDouble();

            System.out.println(i + "人目の方は自身の体重を入力してください。");
            double weight = scanner.nextDouble();

            double bmi = weight / (height * height);

            System.out.print(i + "人目の方のBMIは");
            System.out.print(String.format("%.2f", bmi));
            System.out.println("です。");

            if (bmi < 18.5) {
                System.out.println("やせ型です。");
            } else if (bmi < 25) {
                System.out.println("標準体重です。維持していきましょう。");
            } else if (bmi < 30) {
                System.out.println("肥満1度です。改善しましょう。");
            } else if (bmi < 35) {
                System.out.println("肥満2度です。改善しましょう。");
            } else if (bmi < 40) {
                System.out.println("肥満3度です。改善してください。");
            } else {
                System.out.println("肥満4度です。改善しなさい。");
            }

        }
    }
}
