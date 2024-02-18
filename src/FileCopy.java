import java.io.*;
import java.util.Arrays;

public class FileCopy {

    public static void main(String[] args) throws IOException {

        InputStream in = new FileInputStream("in.txt");
        OutputStream out = new FileOutputStream("out.txt");
        OutputStream out2 = new FileOutputStream("out2.txt");
        int nextByte;
//            System.out.println(" tranferred: " + in.transferTo(out2));

//        byte[] INN =  in.readAllBytes();
//        System.out.println(        Arrays.toString(INN));

        while ( true){
            nextByte = in.read();
            if (nextByte == -1){
                break;
            }
            out.write(nextByte);
        }

        in.close(); out.close();out2.close();
    }

}
