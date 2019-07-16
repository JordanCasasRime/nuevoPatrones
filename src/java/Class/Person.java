package Class;

import Prototype.IClone;

public class Person implements IClone {
    
    private int personId;
    private String name;
    private String lastName;
    private int age;
    private String type;
    private String phone;
    private String address;

    public Person() {
    }

    public Person(int personId, String name, String lastName, int age, String userType, String phone, String address) {
        this.personId = personId;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.type = userType;
        this.phone = phone;
        this.address = address;
    }
    
    public Person(int personaId,String name,String lastName, int age, String address,String type){
        this.personId = personaId;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.type = type;
    }
    
    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int userId) {
        this.personId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String userType) {
        this.type = userType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public IClone clone() {
        IClone person = new Person(this.personId, this.name, this.lastName, this.age, this.type, this.phone, this.address);
        return person;
    }

}