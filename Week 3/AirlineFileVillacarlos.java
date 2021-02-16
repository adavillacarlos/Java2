import java.util.*;

public class AirlineFileVillacarlos {
    private int size = 10;
    private int[] seats;
    private int seat;
    private int seatType;

    public AirlineFileVillacarlos() {
        seats = new int[size];
        initializeSeat();
    }

    public int getSeats(int i) {
        return seats[i];
    }

    public void setSeats(int[] seats) {
        this.seats = seats;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void initializeSeat(){
        for(int i=0;i<size;i++)
            seats[i]=0;
    }

    public void display(){
        for(int i=0 ; i<size ; i++){
            System.out.printf("[%d] ", seats[i]);
            if(i==size/2-1)
                System.out.println();
        }
    }

    public int assignSeat(int seatType){
        int move;
        switch (seatType){
            case 1:         seat = assignFirstClass();
                            break;
            case 2:         seat = assignEconomy();
                            break;
        }
//        if(seat == -1){
//            move = moveSeat(seatType);
//            if(move==-1)
//                return move;
//            return assignSeat(move);
//        }
        return seat;
    }

    public int assignFirstClass(){
        for(int i=0;i<size/2;i++){
            if(seats[i]==0){
                seats[i]=1;
                return i+1;
            }
        }
        return -1;
    }

    public int assignEconomy(){
        for(int i=size/2; i<size; i++ ){
            if(seats[i]==0){
                seats[i]=1;
                return i+1;
            }
        }
        return -1;
    }

    public String boardPass(int seat){
        String ans ="";
        ans+="\n\nBOARDING PASS";
        if(seat<5)
            ans+="\nFirst Class";
        else
            ans+="\nEconomy Class";
        ans+="\nSeat Number: " + (seat+1);
        return ans;
    }

    public int moveSeat(int seatType){
        Scanner sc = new Scanner(System.in);
        if (seatType==1){
            System.out.print("Would you like to transfer to Economy Class? (y/n): ");
            seatType = 2;
        } else {
            System.out.print("Would you like to transfer to First Class? (y/n): ");
            seatType = 1;
        }
        char ans = sc.next().charAt(0);
        if (ans=='n')
            seatType = -1;

        return seatType;
    }

    public int choice(){
        Scanner sc = new Scanner(System.in);
        int seatType;
        System.out.println("\nPlease type 1 for first class");
        System.out.println("Please type 2 for economy class");
        System.out.println("Please type 3 for exit");
        System.out.print("Please pick now: ");
        seatType = sc.nextInt();
        if(seatType == 1 || seatType == 2)
            return seatType;
        else
            System.out.println("Please enter a valid class");
        return -1;
    }

    public String Exit(){
        return "\nNext flight leaves in 3 hours";
    }

    public boolean checkFull(){
        boolean flag=true;
        for(int i=0;i<size;i++){
            if(seats[i]==0){
                flag=false;
                break;
            }
        }
        return flag;
    }

    public String toString(){
        String str = "";
        for(int i=0; i<getSize();i++){
            str += seats[i] + " ";
        }
        return str;
    }

}
