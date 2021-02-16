/*Problem: Cellphone
 ** @Author: Villacarlos, Ada Pauline P.
 ** @Date: February 16, 2021
 */

import java.io.*;
import java.util.*;

public class TestCellphoneVillacarlos {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        boolean ans=true;
        int choice;
        int check=0;
        try{
            CellPhone[] cp = new CellPhone[0];
            //Serialization file create
            File cellphoneFile = new File("Cellphone.txt");
            do{
                menu();
                choice = sc.nextInt();
                switch (choice){
                    case 1:     System.out.print("\nEnter the number of phones: ");
                                int n = sc.nextInt();
                                cp = new CellPhone[n];
                                cp = inputPhone(cp);
                                break;
                    case 2:
                            System.out.print("\nWhat cellphone index do you want to check? (Starts at 0): ");
                            check = sc.nextInt();
                            if(check<cp.length)
                                checkCellphone(cp[check]);
                            else
                                System.out.println("Not available");
                            break;
                    case 3:
                            //Serialization continuation
                            FileOutputStream fileOutput = new FileOutputStream(cellphoneFile);
                            ObjectOutputStream objOutput = new ObjectOutputStream(fileOutput);
                            objOutput.writeObject(cp);
                            cp = null;
                            System.out.println("\nSuccessfully serialized");
                            break;
                    case 4:
                            FileInputStream fileInput = new FileInputStream(cellphoneFile);
                            ObjectInputStream objectInputStream = new ObjectInputStream(fileInput);
                            cp = (CellPhone[]) objectInputStream.readObject();
                            System.out.println("\nSuccessfully deserialized");
                            break;
                    case 5:     System.out.println();
                            int i=0;
                            if(cp.length!=0){
                                for (CellPhone cellphone: cp){
                                    System.out.println("Phone no." + i++ + cellphone);
                                }
                            } else
                                System.out.println("Please input a cellphone");

                            break;

                    case 6:     ans =false;
                                break;
                    default:
                        System.out.println("Please enter the correct input");
                }
            }while(ans);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    private static void checkCellphone(CellPhone cellPhone) {
        Scanner sc = new Scanner(System.in);
        int ans =0;
        float duration = 0;
        boolean flag=true;
        do{
            System.out.println("\nSUBMENU");
            System.out.println("[7] Check Call Cost");
            System.out.println("[8] Call");
            System.out.println("[9] Text");
            System.out.println("[10] Check if it is Lowbat");
            System.out.println("[11] Exit Sub-menu");
            System.out.print("Please enter your choice: ");
            ans = sc.nextInt();
            switch (ans){
                case 7:
                                System.out.print("Input duration: ");
                                duration = sc.nextFloat();
                                System.out.println("Call Cost: " + cellPhone.callCost(duration));
                                break;
                case 8:         System.out.print("Input duration: ");
                                duration = sc.nextFloat();
                                if (cellPhone.call(duration))
                                    System.out.println("successful");
                                else
                                    System.out.println("failed");
                                break;
                case 9:         if (cellPhone.text())
                                    System.out.println("successful");
                                else
                                    System.out.println("failed");
                                break;
                case 10:        if (cellPhone.isLowBat())
                                    System.out.println("Low Battery");
                                else
                                    System.out.println("Charged");
                                break;
                case 11:        flag=false;
            }
        }while (flag);

    }

    private static void menu() {
        System.out.println("\nMENU");
        System.out.println("[1] Input Cellphones");
        System.out.println("[2] Check Cellphone Methods");
        System.out.println("[3] Serialized Cellphones");
        System.out.println("[4] Deserialized Cellphones");
        System.out.println("[5] Display Output");
        System.out.println("[6] Exit");
        System.out.print("Please enter your choice: ");
    }

    public static CellPhone[] inputPhone(CellPhone[] cp){
        String name="";
        String brand="";
        int ans=0;
        float load=0;
        float talkTime = 0;
        float ratePerText = 0;
        float ratePerMinute=0;
        Scanner sc = new Scanner(System.in);

        for(int i=0;i<cp.length;i++){
            sc.nextLine();
            System.out.print("Enter phone name: ");
            name = sc.nextLine();
            System.out.print("Enter phone brand: ");
            brand = sc.nextLine();
            System.out.print("Do you want to input load? (1/0): ");
            ans = sc.nextInt();
            if(ans==1){
                System.out.print("Enter load: ");
                load = sc.nextFloat();
            }
            System.out.print("Enter talk time: ");
            talkTime = sc.nextFloat();
            System.out.print("Enter rate per minute: ");
            ratePerMinute = sc.nextFloat();
            System.out.print("Enter rate per text: ");
            ratePerText = sc.nextFloat();

            if(ans==1)
                cp[i] = new CellPhone(name,brand,load,talkTime,ratePerMinute,ratePerText);
            else
                cp[i] = new CellPhone(name,brand,talkTime,ratePerMinute,ratePerText);
            System.out.println();
        }
        return cp;
    }


}
