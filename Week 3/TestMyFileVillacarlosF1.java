import java.io.*;
import java.util.*;

public class TestMyFileVillacarlosF1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        MyFileVillacarlosF1 mf = new MyFileVillacarlosF1();
        AirlineFileVillacarlos airline = new AirlineFileVillacarlos();

        System.out.print("Enter an input file name: ");
        String inputFile = sc.nextLine();
        System.out.print("Enter an output file name: ");
        String outputFile = sc.nextLine();

        System.out.printf("Created the %s file?: %s", inputFile,mf.createFile(inputFile)?"yes":"no");
        System.out.printf("\nCreated the %s file?: %s", outputFile,mf.createFile(outputFile)?"yes":"no");

        //Assigning Seats to the Airlines
        System.out.println("\nInput seats: ");
        for(int i=0;i<airline.getSize();i++){
            airline.assignSeat(sc.nextInt());
        }

        System.out.printf("\nWrite to %s file?: %s", inputFile,mf.writeToFile(inputFile,airline.toString())?"yes":"no");
        System.out.printf("\nRead from %s file?: %s", inputFile,mf.readFromFile(inputFile)?"yes":"no");

        String output = "";
        for(int i =0; i < airline.getSize();i++){
            if(airline.getSeats(i)== 1){
                output += airline.boardPass(i);
            }
        }
        output+=airline.Exit();
        System.out.printf("\nWrote to %s file?: %s", outputFile,mf.writeToFile(outputFile,output)?"yes":"no");

        //Creating a file in the method since the method createFile returns a boolean value
        //this is just to check if all the methods are working.
        File myFile = new File("VillacarlosFile.txt");
        myFile.createNewFile();
        System.out.printf("\nIs %s a file: %s", myFile.getName(), mf.isFile(myFile)?"yes":"no");

        File myDir = new File("VillacarlosDir");
        myDir.mkdir();
        System.out.printf("\nIs %s a directory: %s", myDir.getName(), mf.isDirectory(myDir)?"yes":"no");

        System.out.printf("\nIs %s file deleted: %s", myFile.getName(), mf.delete(myFile)?"yes":"no");


    }
}


