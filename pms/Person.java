package pms;

public abstract class Person {
    
    private String name;
    private String telephone_no;    
    
    Person(String name, String telephone_no) {
        this.name = name;
        this.telephone_no = telephone_no;
    }  
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the telephone_no
     */
    public String getTelephone_no() {
        return telephone_no;
    }

    /**
     * @param telephone_no the telephone_no to set
     */
    public void setTelephone_no(String telephone_no) {
        this.telephone_no = telephone_no;
    }    
    
    public abstract void add_person();
    
    public abstract boolean isUsernameOrPhoneAvailable(String username, String phoneNum);
    
    public boolean isValidPhoneNumber(String phoneNumber) {
    // Check if the phone number contains 10 digits and starts with 0
        return phoneNumber.matches("^0[0-9]{9}$");
    }
}
