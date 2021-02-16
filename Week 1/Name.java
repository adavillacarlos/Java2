public class Name {
    private String firstName;
    private String middleName;
    private String lastName;
    private Mobile mobileNumber;

    public Name(){}

    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public Name(String firstName, String middleName, String lastName, Mobile mobileNumber) {
        this(firstName,middleName,lastName);
        this.mobileNumber = mobileNumber;
    }

    public String getFirstName() {
        return firstName;
    }

 	public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
	        return lastName;
    }

    public Mobile getMobileNumber() {
	        return mobileNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMobileNumber(Mobile mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String toString(){
        return "\nName: <<" + getFirstName() + " " + getMiddleName() + " " + getLastName() + ">>" + mobileNumber.toString();
    }

}
