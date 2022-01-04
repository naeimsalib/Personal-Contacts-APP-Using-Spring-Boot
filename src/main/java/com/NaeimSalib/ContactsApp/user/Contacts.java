package com.NaeimSalib.ContactsApp.user;

import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Entity
@Table(name="contacts")
public class Contacts {
    @Id // Identifies the id variable as the Table Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // the value in the Id will Auto Increment
    private Integer id;

    @Column(nullable = false, unique = true, length = 50, name="email")
    private String email;

    @Column(length = 25,name="first_name")
    private String first_name;

    @Column(length = 25,name="last_name")
    private String last_name;

    @Column(length = 13, name="phone_number") // 13 String Carracters to be in this Formate (XXX-XXX-XXXX)
    private  String phone_number;

    @Column(length = 200, name = "address")
    private String address;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
