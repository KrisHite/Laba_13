package Tasks;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task_6{
    private static final Object lock = new Object();
    private static int number = 0;
    public static void main(String[] args) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        System.out.print("Введите колличество чисел в массиве: ");
        int arrOfNums = in.nextInt();

        int[] array = new int[arrOfNums];
        for(int i = 0; i < arrOfNums; i++){
            array[i] = random.nextInt(1000);
        }
        System.out.println(Arrays.toString(array));

        Thread core1 = new Thread(() -> {
            for (int i = 0; i < (array.length/4); i++){
                number += array[i];
            }
        });

        Thread core2 = new Thread(() -> {
            for (int i = (array.length/4); i < 2 * (array.length/4); i++){

            }
        });

        Thread core3 = new Thread(() -> {
            for (int i = 2 * (array.length/4); i < 3 * (array.length/4); i++){
                number += array[i];
            }
        });

        Thread core4 = new Thread(() -> {
            for (int i = 3 * (array.length/4); i < array.length; i++){
                number += array[i];
            }
        });
        core1.start();
        core2.start();
        core3.start();
        core4.start();
        core1.join();
        core2.join();
        core3.join();
        core4.join();
        System.out.println("Сумма чисел равна: " + number);
    }
}
//6. Напишите функцию, которая суммирует элементы в массиве целых чисел при помощи многопоточности.
// Количество потоков должно быть равно количеству ядер процессора.
// AMD A4 (4 Core)