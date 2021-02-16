public class Mobile {
    String mobileNumber;

	public Mobile(){}

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String toString(){
        return "\nMobile number: " + getMobileNumber();
    }

}
