package app;

public class Person {
    private String name;
    private int age;
    private String iD; // you want this to stay? yes i am going to search with it yeah
    private String country;
    private String password;//the customers dont have psasword are we sure we want to have it in here ?
    private UserType type;


    public Person(String name, int age, String iD, String country, String password, UserType type) {
        this.name = name;
        this.age = age;
        this.iD = iD;
        this.country = country;  
        this.password = password;
        this.type = type;// u mean geneder in here right?
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public boolean isAdmin(){
        return this.type == UserType.ADMIN;//how do u use this ? i mean how come UsterType.ADMIN? We use an Enum just to make things clear, like we can clearly see what this is and use it, can't really use a class name what is Enum?
    }

    public String toString(){
        return String.format("Name: %s\nAge: %d\nID: %s\nCountry: %s", name, age, iD, country);
    }

    

    
    

    

}