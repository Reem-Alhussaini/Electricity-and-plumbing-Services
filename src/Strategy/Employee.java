package Strategy;
public class Employee {

    private String name;
    private String phoneNumber;
    private int rating;
    private String job;

    public Employee(String name, String phoneNumber, int rating, String job) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.rating = rating;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getJob() {
        return job;
    }

}
