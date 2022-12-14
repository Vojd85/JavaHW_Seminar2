/*Реализуйте алгоритм сортировки пузырьком числового массива, 
результат после каждой итерации запишите в лог-файл. */

package HomeWorks.Seminar2;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;


import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task2 {
    public static void main(String[] args) throws SecurityException, IOException {
        Logger logger = Logger.getLogger(Task2.class.getName());
        FileHandler fh = new FileHandler("C:/Users/Вождь/Desktop/SecondQuarter/Java/HomeWorks/Seminar2/log.txt");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        int[] arr = new int[] {2, 54, 34, 98, 5, 7, 3, 11, 74, 44, 2, 6};
        logger.info("Init: " + Arrays.toString(arr));
        int tempI = 0;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j]>arr[j+1]) {
                    tempI = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tempI;
                }
            }
            String arrLog = Arrays.toString(arr);
            logger.info(arrLog);
        }
    }
    // static void printArray(int[] n) {
    //     for (int i = 0; i < n.length; i++) {
    //         System.out.printf("%d ",n[i]);
    //     }
    // }
}
