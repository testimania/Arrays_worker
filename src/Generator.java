import java.util.Arrays;
import java.util.Random;

// создает целочисленный сассив длиной ло 100 и заполняет рандомно от 0 до указанной верхней границы
public class Generator {

    public static void main(String[] args) {
        Generator g = new Generator();
        int[] n = g.getIntArray(10);
        System.out.println( Arrays.toString(n));
    }

    public int[] getIntArray( int length){
        if (length <= 0)
            length = 100;
        int[] intArray = new int[length];
        if (fillArrayByRandom(intArray, 10))
            return intArray;
        else
            return null;
    }

    public int[] getIntArray( int length, int bound){
        if (length <= 0)
            length = 100;
        int[] intArray = new int[length];
        if (fillArrayByRandom(intArray, bound))
            return intArray;
        else
            return null;
    }

    protected boolean fillArrayByRandom(int[] intArray, int bound){
        boolean result = false;

        if (intArray == null || bound < 1) {
            System.out.println("Wrong parameter(s).");
            return false;
        }
        Random random = new Random();
            for (int i = 0; i < intArray.length; i++) {
                intArray[i] = random.nextInt(bound);
            }

        return result;
    }

}




