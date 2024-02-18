import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTac {
    // TODO: 10.02.2024  
    final static int MAP_SIZE = 3;
    
    static private int SIZE = 3;
    static private final char EMPTY = '-';
    static private final char HUMAN = 'X';
    static private final char AI = 'O';

    static private char[][] MAP;
    static Scanner in = new Scanner(System.in);
    static int stepsCounter = 0;


    public static void main(String[] args) {
        beginTheGame();
    }

    private static void beginTheGame() {
        //ini
        initializeGame();
        // show
        printMap();

        while (true) {
            //
            humanStep();
            printMap();

            if (isEnd()){
                System.out.println("End of game. Human win.");
                System.exit(0);
            }

            //
            aiStep();
            printMap();

            if (isEnd()){
                System.out.println("End of game. AU win.");
                System.exit(0);
            }
        }
    }

    private static void initializeGame() {
        int size = 0;
        do {
            System.out.println(" Set the SIZE of game field from 3 to 9:");
            if (in.hasNextInt()){
                size = in.nextInt();
            } else
                in.next();
        } while ( size <3 || size >9);


        // ini
        MAP = new char[SIZE][SIZE];
        for (int i = 0; i < MAP.length; i++) {
            for (int j = 0; j < MAP[i].length; j++) {
                MAP[i][j] = EMPTY;
            }
        }
//        MAP[1][1] = AI;
    }

    private static void aiStep() {
        Random random =  new Random();
        int x,y;

        do {
            x = random.nextInt(3);
            y = random.nextInt(3);
        } while (! ( isStepValid(x,y) && isStepEnabled(x,y)));
        System.out.println("x:" + (x+1) + " y: " + (y +1));
        MAP[x][y] = AI;
        stepsCounter++;
    }

    private static boolean isEnd() {

        boolean win = false;
        // TODO: 09.02.2024
        if (win){
            return true;
        }

        boolean noWin = false;
        if (stepsCounter == SIZE*SIZE)
            noWin = true;
        // TODO: 09.02.2024
        if (noWin){
            System.out.println(" Nobody wins!!");
            System.exit(0);
        }

        return false;
    }

    private static void humanStep() {
        // invitation for human
        System.out.println(" Make your move human..");

        int intX;
        int intY;

        do {
            System.out.println(" X is ..");
            intX = in.nextInt()-1;
            System.out.println(" Y is ..");
            intY = in.nextInt()-1;

            if (isStepValid(intX,intY)){
                if (isStepEnabled(intX,intY)){
                    break;
                } else {
                    System.out.println(" Input Error, cell is in use -  repeat please.");
                }
            } else {
                System.out.println(" Input Error, repeat please.");
            }

        } while (true);

        MAP[intX][intY] = HUMAN;
        stepsCounter++;


    }

    private static boolean isStepValid( int intx, int inty) {
        return intx >= 0 && intx <3 && inty >= 0 && inty <3;
    }

    private static boolean isStepEnabled(int intX, int intY) {
        return MAP[intX][intY] == EMPTY;
    }

    private static void printMap() {
        // show
        System.out.println("  " + " 1 2 3");
        for (int i = 0; i < MAP.length; i++) {
            System.out.printf("%2d %s %s %s %n", i+1,MAP[i][0],MAP[i][1],MAP[i][2]  );
        }
    }

    // проверка линий на победный паттерн символа, исходя из координат последнего хода
    private static boolean checkTheLines(int[][] matrix, int pattern_length, int symbol, int x, int y){
        // определим четыре опорные координаты:
        int x1, x2, y1, y2;
        x1 = x - (pattern_length - 1);
        y1 = y - (pattern_length - 1);
        x2 = x + (pattern_length - 1);
        y2 = y + (pattern_length - 1);
        // убираем выходы за нулевые координаты
        if (x1 < 0 ) x1 =0 ;
        if (y1 < 0 ) y1 =0 ;
        if (x2 < 0 ) x2 =0 ;
        if (y2 < 0 ) y2 =0 ;
        // убираем выходы за пределы поля
        if (x1 >= MAP_SIZE ) x1 = MAP_SIZE - 1 ;
        if (y1 >= MAP_SIZE ) y1 = MAP_SIZE - 1 ;
        if (x2 >= MAP_SIZE ) x2 = MAP_SIZE - 1 ;
        if (y2 >= MAP_SIZE ) y2 = MAP_SIZE - 1 ;

        // System.out.println(" четыре опорные координаты: " +x1 + " - " + y1 + " - " + x2 + " - " + y2);

        // горизонталь:
        if (pattern_length == countTheLine(matrix, x2 - x1 + 1, symbol, x1, y, 1, 0))
            return  true;

        // вертикаль:
        if (pattern_length == countTheLine(matrix, y2 - y1 + 1, symbol, x, y1, 0, 1))
            return  true;

        //  диагональ / :
        if (pattern_length == countTheLine(matrix, x2 - x1 + 1, symbol, x1, y2, 1, -1))
            return  true;

        //  диагональ \ :
        if (pattern_length == countTheLine(matrix, x2 - x1 + 1, symbol, x1, y1, 1, 1))
            return  true;

        return false;
    }

    // вспомогательная функция возвращает максимальное кол-во непрерывных знаков на линии
    private static int countTheLine(int[][] matrix, int seq_length, int symbol, int x0, int y0, int x_step, int y_step  ){
        //  int[] line = new int[seq_length];
        int count = 0; int max = 0;
        for (int i = 0; i < seq_length; i++) {
            if (matrix[y0][x0] == symbol) {
                count++;
                if (count > max)  max = count;
            } else {
                count = 0;
            }
            y0 += y_step; x0 += x_step;
        }
        return max;
    }

}
