/*
    Realizado por Andrew Emerick
    25/2/22
    Cambia cosos a UTF-8 y viceversa
*/

package ascript;

import java.util.Scanner;

public class ascript {
    public static void main(String[] args) throws Exception {
        //fileWriter fileIO = new fileWriter(); not needed, since static methods don't need an object declaration
        Scanner vampire = new Scanner(System.in);
        System.out.println("Enter a file name: ");
        String fileName = vampire.nextLine();
        System.out.print("Do you want to encrypt or decrypt this file? ");
        boolean answer = vampire.nextLine().toLowerCase().startsWith("d");

        if(answer)
            fileWriter.dFile(fileName);
        else
            fileWriter.eFile(fileName);

        vampire.close();
    }
}