package HomeWork1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class StringRevers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        for (String retval : s.split(" ")) {
            retval = new StringBuffer(retval).reverse().toString();
            System.out.print(retval + " ");
        }
    }
}
