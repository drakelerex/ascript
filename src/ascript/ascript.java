/*
    Realizado por Andrew Emerick
    24/2/22
    Cambia frases a UTF-8 y vice versa
*/

package ascript;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ascript {

    static void encrypt(String sentence){
        byte[] asciiByte=sentence.getBytes(StandardCharsets.UTF_8);
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

    static void eFile(String fileName){
        try{
            FileInputStream inFile = new FileInputStream(fileName);
            long i=0;
            String s="";
            while((i=inFile.read())!=-1){    
                s += i+"/";
            }
            System.out.println("File Written to output.txt");
            inFile.close();
            FileOutputStream fileOut = new FileOutputStream("output.txt");
            byte[] sArray = s.getBytes(StandardCharsets.UTF_8);
            fileOut.write(sArray);
            fileOut.close();
        } catch(IOException e){
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }

    static void dFile(String fileName){
        try{
            FileInputStream inFile = new FileInputStream(fileName);
            long ix=0;
            String s="";
            while((ix=inFile.read())!=-1){
                s += (char)ix;
            }
            String[] byteString = s.split("/");
            int size = byteString.length;
            byte[] asciiBytes = new byte[size];
            for(int i=0;i<size;i++){
                asciiBytes[i] = Byte.parseByte(byteString[i]);
            }
            String fContent="";
            for(int i=0;i<asciiBytes.length;i++){
                fContent += (char)asciiBytes[i];
            }
            byte[] sArray = fContent.getBytes(StandardCharsets.UTF_8);
            FileOutputStream fileOut = new FileOutputStream("output.txt");
            fileOut.write(sArray);
            fileOut.close();
        } catch(IOException e){
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }
      public static void main(String[] args) throws Exception {
        Scanner vampire = new Scanner(System.in);
        System.out.println("Enter a file name: ");
        String fileName = vampire.nextLine();
        dFile(fileName);
        vampire.close();
    }
}
