import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        // константы
        final String fileName = "singlePass.txt";
        final int DEL_14 = 14;
        final int DEL_2 = 2;
        final int DEL_7 = 7;
        final int NET_OTVETA = -1;

        // максимумы среди ранее прочитанных чисел
        int maxVse = NET_OTVETA;
        int maxChet = NET_OTVETA;
        int maxSem = NET_OTVETA;
        int maxChetyrnadcat = NET_OTVETA;

        // макс подходящее произведение
        int otvet = NET_OTVETA;

        try (Scanner skaner = new Scanner(new File(fileName))) {

            // однопроходное чтение последовательности
            while (skaner.hasNextInt()) {
                int num = skaner.nextInt();

                // случ1 - число кратно 14, подходит любой партнёр
                if (num % DEL_14 == 0) {
                    if (maxVse != NET_OTVETA) {
                        otvet = Math.max(otvet, num * maxVse);
                    }
                }

                // случ2 - число кратно 7, нужен чётный партнёр
                else if (num % DEL_7 == 0) {
                    if (maxChet != NET_OTVETA) {
                        otvet = Math.max(otvet, num * maxChet);
                    }
                }

                // случ3 - число чётное, нужен партнёр, кратный 7
                else if (num % DEL_2 == 0) {
                    if (maxSem != NET_OTVETA) {
                        otvet = Math.max(otvet, num * maxSem);
                    }
                }

                // случ4 - число не кратно ни 2, ни 7
                else {
                    if (maxChetyrnadcat != NET_OTVETA) {
                        otvet = Math.max(otvet, num * maxChetyrnadcat);
                    }
                }

                // обновляем максимумы после проверки пар, число не буд исп дважды
                maxVse = Math.max(maxVse, num);

                if (num % DEL_2 == 0) {
                    maxChet = Math.max(maxChet, num);
                }

                if (num % DEL_7 == 0) {
                    maxSem = Math.max(maxSem, num);
                }

                if (num % DEL_14 == 0) {
                    maxChetyrnadcat =
                            Math.max(maxChetyrnadcat, num);
                }
            }
        }
        // рез
        if (otvet == NET_OTVETA) {
            System.out.println("Подходящее число R не найдено: -1");
        } else {
            System.out.println("Максимальное число R, кратное 14: "
                    + otvet);
        }
    }
}
