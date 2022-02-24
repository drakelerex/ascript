/*
    Realizado por Andrew Emerick
    24/2/22
    Cambia cosos a UTF-8 y vice versa
*/

package ascript;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ascript {

    static void eFile(String fileName){
        try{
            FileInputStream inFile = new FileInputStream(fileName);
            long i=0;
            String s="";
            while((i=inFile.read())!=-1)   
                s += i+"/";
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
            int i=0;
            String s="";
            while((i=inFile.read())!=-1)
                s += (char)i;
            inFile.close();
            String[] byteString = s.split("/");
            int size = byteString.length;
            byte[] asciiBytes = new byte[size];
            for(i=0;i<size;i++)
                asciiBytes[i] = Byte.parseByte(byteString[i]);
            FileOutputStream fileOut = new FileOutputStream("output.txt");
            fileOut.write(asciiBytes);
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
        System.out.print("Do you want to encrypt or decrypt this file? ");
        boolean answer = vampire.nextLine().toLowerCase().startsWith("d");

        if(answer)
            dFile(fileName);
        else
            eFile(fileName);

        vampire.close();
    }
}