public class ATMCard {
    private String cardNumber;
    private Name name;
    private float balance;

    public ATMCard(){}

    public ATMCard(String cardNumber, Name name, float balance) {
        this.cardNumber = cardNumber;
        this.name=name;
        this.balance = balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Name getName() {
	        return name;
    }

   	public float getBalance() {
	        return balance;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setName(Name name) {
        this.name = name;
    }


    public void setBalance(float balance) {
        this.balance = balance;
    }

    public float checkBalance(){
        return getBalance();
    }

    public float depositMoney(float amount){
        setBalance(getBalance()+amount);
        return getBalance();
    }

    public boolean withdrawMoney(float amount){
        boolean flag=true;
        if(amount<=getBalance())
            setBalance(getBalance()-amount);
        else
            flag=false;
        return flag;
    }

    public float interest(float rate){
        setBalance((getBalance()*(rate/100))+getBalance());
		return getBalance();
    }

    public String toString(){
        String formatBalance = String.format("%.02f", getBalance());
        return name.toString() + "\nAccount number: " + getCardNumber() + "\nBalance: " + formatBalance + "\n" ;
    }

}
