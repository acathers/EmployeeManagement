package app;

import java.util.InvalidPropertiesFormatException;
import java.util.List;


public class Employee extends Person {

    public List<WorkTime> workTime;
    
    private Employee(String name, int age, String iD, String country, String password, UserType type) {
        super(name, age, iD, country, password, type);
    }

    public static class EmployeeBuilder {
        private String name;
        private int age;
        private String iD; 
        private String country;
        private String password;
        private UserType type;

        public EmployeeBuilder setName(String name){
            this.name = name;
            return this;
        }

        public EmployeeBuilder setAge(int age){
            this.age = age;
            return this;
        }

        public EmployeeBuilder setID(String iD){
            this.iD = iD;
            return this;
        }
        public EmployeeBuilder setCountry(String country){
            this.country = country;
            return this;
        } 
        public EmployeeBuilder setPassword(String password){
            this.password = password;
            return this;
        } 
        public EmployeeBuilder setType(UserType type){
            this.type = type;
            return this;
        }

        public Employee build() throws InvalidPropertiesFormatException{
            if(name == null || age == 0 || iD == null || country == null || password == null || type == null){
                throw new InvalidPropertiesFormatException("Missing attribute to build Employee Object");
            }
            return new Employee(name, age, iD, country, password, type);
        }     
    }

}