/*
    Realizado por Andrew Emerick
    12/2/22
    Cambiar frases a ASCII igual y vice versa
*/

import java.util.Scanner;

public class App {

    static void encrypt(String sentence){
        for(byte charVal=0; charVal<sentence.length(); charVal++) {
            System.out.print((byte)sentence.charAt(charVal)+"/");
        }
    }

    static void decrypt(String sentence){
        /*String[] byteString = sentence.split("/");
        byte[] ascii = new byte[];
        System.out.print(ascii[1]);*/
    }
      public static void main(String[] args) throws Exception {
        try (Scanner vampire = new Scanner(System.in)) {

            System.out.println("Enter a sentence: ");
            String sentence = vampire.nextLine();

            decrypt(sentence);
        }
    }
}
