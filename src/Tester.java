import java.util.Arrays;

public class Tester {

    int counter;

    public static void main(String[] args) {
        Tester tester = new Tester(5);
        tester.doTest();
    }

//    make the test n times
     void doTest() {
        for (int i = 0; i < this.counter; i++) {
            System.out.println( "result ( ms ) :" +  this.testTime() );
        }
    }

    public Tester() {
        this.counter = 5;
    }

    public Tester(int counter) {
        this.counter = counter;
    }

    //    измерить время между началом и концом процесса в миллисекундах
    public long testTime(){
        long result, timeOfBegin, timeOfEnd;
        timeOfBegin = System.currentTimeMillis();

//      process
        doProcess();

        timeOfEnd = System.currentTimeMillis();
        result = ( timeOfEnd - timeOfBegin);
        return result;
    }

    private void doProcess(){
        Generator generator = new Generator();
        int[] res0 = generator.getIntArray(10000);
            Sorter.sortByStep(res0);
//        Sorter.sortByBubble(res0);

/*
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
*/
    }

}
