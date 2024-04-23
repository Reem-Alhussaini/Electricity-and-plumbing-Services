package Strategy;
public class Cutomer {

    private String Name;
    private String PhoneNumber;

    public Cutomer(String name, String phoneNumber) {
        Name = name;
        PhoneNumber = phoneNumber;
    }

    public String getName() {
        return Name;
    }
 
    public void setName(String name) {
        Name = name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public void rateEmployee(Employee employee, int rating){
        employee.setRating(rating);
        System.out.println("");
    }

}
