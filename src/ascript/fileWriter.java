package ascript;

import java.nio.charset.StandardCharsets;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class fileWriter {
    
    static void eFile(String fileName){
        try{
            FileInputStream inFile = new FileInputStream(fileName);
            long i=0;
            String s="";
            while((i=inFile.read())!=-1)   
                s += i+"/";
            System.out.println("File written: "+fileName);
            inFile.close();
            FileOutputStream fileOut = new FileOutputStream(fileName);
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
            FileOutputStream fileOut = new FileOutputStream(fileName);
            fileOut.write(asciiBytes); // with just one write command, bufferedWriter would be worse
            System.out.println("File written: "+fileName);
            fileOut.close();
        } catch(IOException e){
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }
}
