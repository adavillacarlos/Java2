import java.util.*;

public class TestATMCardClass {
    public static void main(String[] args) {
        boolean flag = true;
        float amount =0;
        float rate=0;
        int ans=0;

        Scanner sc = new Scanner(System.in);
        Name name = new Name();
        Mobile mobile = new Mobile();

        System.out.print("Enter name: ");
        String firstName = sc.next();
        name.setFirstName(firstName);

        String middleName = sc.next();
        name.setMiddleName(middleName);

        String lastName = sc.nextLine();
        name.setLastName(lastName);

        System.out.print("Enter a mobile number: ");
        String num = sc.nextLine();
        mobile.setMobileNumber(num);
        name.setMobileNumber(mobile);

        System.out.print("Enter account number: ");
        String cardNumber = sc.nextLine();

        System.out.print("Enter beginning balance: ");
        amount = sc.nextFloat();

        ATMCard card = new ATMCard(cardNumber,name,amount);


        do{
            menu();
            ans=sc.nextInt();
            switch (ans){
                case 1:
                    System.out.print("\nEnter amount: ");
                    amount = sc.nextFloat();
                    card.depositMoney(amount);
                    System.out.println(card);
                    break;
                case 2:
                    System.out.print("\nEnter amount: ");
                    amount = sc.nextFloat();
                    if(!card.withdrawMoney(amount))
                        System.out.println("\nINSUFFICIENT FUNDS");
                    else
                        System.out.println(card);
                    break;
                case 3:
                    System.out.println(card);
                    break;
                case 4:
                   	System.out.print("\nEnter rate: ");
				    rate = sc.nextFloat();
                    System.out.printf("\nNew Balance: %.2f\n",card.interest(rate));
                    break;
                case 5:
                    flag=false;
                    break;
                default:
                    System.out.println("You have entered the wrong choice!");
            }

        }while(flag);
    }

    private static void menu(){
        System.out.println("\nDEBIT CARD TRANSACTION");
        System.out.println("[1] Deposit Cash");
        System.out.println("[2] Withdraw Cash");
        System.out.println("[3] Inquire Balance");
        System.out.println("[4] Calculate Interest Rate");
        System.out.println("[5] Exit");
        System.out.print("\nYour choice: ");
    }

}
