import java.io.*;
import java.util.*;

public class MyFileVillacarlosF1 {
    private String filename;

    public boolean createFile(String filename) throws Exception{
        File myFile = new File(filename);
       	return myFile.createNewFile();
    }

    public boolean isFile(File file) {
        return file.isFile();
    }

    public boolean delete(File file) {
        return file.delete();
    }

    public boolean isDirectory(File file){
        return file.isDirectory();
    }

    public boolean writeToFile(String filename, String airline) {
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
            bw.write(airline);
            bw.close();
            return true;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean readFromFile(String filename){
        int seatNo = 0;
        int seat;
        try{
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String str = br.readLine();
//          System.out.println("\n" + str);
            StringTokenizer st = new StringTokenizer(str," ");
            System.out.println("\nSeats Taken: ");
            System.out.println("First Class");
            while(st.hasMoreTokens()){
                if(seatNo == 5)
                    System.out.println("\nEconomy Class");
                seat = Integer.parseInt(st.nextToken());
                System.out.print(" [" + seat + "]");
                seatNo++;
            }
            return true;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
