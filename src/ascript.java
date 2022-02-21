/*
    Realizado por Andrew Emerick
    12/2/22
    Cambiar frases a ASCII igual y vice versa
*/

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ascript {

    static void encrypt(String sentence){
        byte[] asciiByte=sentence.getBytes(StandardCharsets.UTF_8);
        /*for(byte charVal=0; charVal<sentence.length(); charVal++)
            System.out.print((byte)sentence.charAt(charVal)+"/");*/
        for(byte i=0;i<asciiByte.length;i++)
            System.out.print(asciiByte[i]+"/");
    }

    static void decrypt(String sentence){
        String[] byteString = sentence.split("/");
        int size = byteString.length;
        byte[] asciiBytes = new byte[size];
        for(int i=0;i<size;i++){
            asciiBytes[i] = Byte.parseByte(byteString[i]);
        }
        for(byte i=0;i<asciiBytes.length;i++){
            System.out.print((char)asciiBytes[i]);
        }
    }
      public static void main(String[] args) throws Exception {
        try (Scanner vampire = new Scanner(System.in)) {
            System.out.println("Enter a sentence: ");
            String sentence = vampire.nextLine();

            System.out.println("Do you want to encrypt? If yes then enter true, if no then enter false. ");

            if(vampire.nextBoolean()){
                encrypt(sentence);
            } else {
                decrypt(sentence);
            }
        }
    }
}
