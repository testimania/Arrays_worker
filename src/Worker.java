import java.util.Arrays;

public class Worker {

    public static void main(String[] args) {

        Tester tester = new Tester(5);
        tester.doTest();

//        System.out.println();
//        Generator generator = new Generator();
////        System.out.println( Arrays.toString (new int[5]));
//        int[] res1 = generator.getIntArray(30);
////            System.out.println( Arrays.toString(res1) );
//            Sorter.sortByMaxMin(res1);
//            Sorter.sort1(res1);
//            System.out.println("Sorted array:");
//            System.out.println( Arrays.toString(res1) );
//
//        int[] res3 = generator.getIntArray(30);
////            printArray2( res3);
//            Sorter.sortByMaxMin(res3);
//            Sorter.sortByStep(res3);
//            printArray2( res3);
    }

    private static void printArray(int[] intArray) {
        if (intArray == null)
            System.out.println(" Wrong parameter.");
        else{
            StringBuffer stringBuffer = new StringBuffer("[");
            for (int i = 0; i < intArray.length - 1; i++) {
                stringBuffer.append(intArray[i] + " ,");
            }
            stringBuffer.append( intArray[intArray.length-1] + "]");
            System.out.println("Sorted array:");
            System.out.println(stringBuffer);
        }
    }
    private static void printArray2(int[] intArray) {
        if (intArray == null)
            System.out.println(" Wrong parameter.");
        else{
            String arr = new String("[");
            for (int i = 0; i < intArray.length; i++) {
                arr += intArray[i] + " ,";
            }
            System.out.println("Sorted array:");
            System.out.println(arr.substring(0, arr.length()-2) + "]");
        }
    }




}
