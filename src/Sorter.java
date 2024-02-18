import java.util.Arrays;
// different methods to sort the int array

public class Sorter {

    // using the lib function
    public static void sort1( int[] arr){
        Arrays.sort(arr);
    }

    // algorithm: get min and max values (indexes) and ...
    // TODO: 03.02.2024
    public static void sortByMaxMin( int[] arrToSort){
        int minValue, maxValue, currentValue;
        int minValueIndex, maxValueIndex;
        minValue = maxValue = arrToSort[0];
        for (int i = 0; i < arrToSort.length; i++) {
            currentValue = arrToSort[i];
            if (currentValue < minValue)
                minValue = currentValue;
            if (currentValue > maxValue)
                maxValue = currentValue;
        }
        System.out.println( "For array: " + Arrays.toString(arrToSort));
        System.out.println(" minValue: " + minValue + "  maxValue: " + maxValue);
    }

    // algorithm:   move bigger value to right and repeat on the rest of array
    public static void sortByStep( int[] arrToSort){
        int currentValue, currentValuePlusOne, shift;
        // exterior loop
        for (shift = 1; shift < arrToSort.length-2 ; shift++) {
            // interior loop
            for (int i = 0; i < arrToSort.length-shift; i++) {
                currentValue = arrToSort[i];
                currentValuePlusOne = arrToSort[i+1];
                    if (currentValue > currentValuePlusOne){
                        arrToSort[i] = currentValuePlusOne;
                        arrToSort[i+1] = currentValue;
                    }
            }
        }
    }

    public static void sortByBubble( int[] sample){

        // выставляем признак "обмена" переменных в true, чтобы начать цикл
        boolean changed = true;

        // цикл длится до тех пор, пока при проверке массива ни одного обмена не произошло
        while (changed) {
            // Надеемся, что обмена данных не будет
            changed = false;
            // Проходим по всему массиву
            for (int i = 0; i < sample.length - 1; i++) {
                // Если впереди стоящее число больше, чем следующее - меняем
                // их местами и выставляем признак, что был обмен
                if (sample[i] > sample[i + 1]) {
                    // Производим обмен с использованием дополнительной переменной
                    int tmp = sample[i];
                    sample[i] = sample[i + 1];
                    sample[i + 1] = tmp;
                    // Выставляем признак обмена в true
                    changed = true;
                }
            }
        }
        // Выводим отсортрованный массив
//            System.out.println(Arrays.toString(sample));

    }



    // end of class
}
