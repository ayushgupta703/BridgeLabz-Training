package model;

import java.util.Objects;

public class Contact implements Comparable<Contact> {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;

    public Contact(String firstName, String lastName, String address, String city, String state, String zip, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getFirstName() {
		return firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public String getAddress() {
		return address;
	}



	public String getCity() {
		return city;
	}



	public String getState() {
		return state;
	}



	public String getZip() {
		return zip;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public String getEmail() {
		return email;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public void setState(String state) {
		this.state = state;
	}



	public void setZip(String zip) {
		this.zip = zip;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	// UC 7 – Duplicate check based on first + last name
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return firstName.equalsIgnoreCase(contact.firstName) && lastName.equalsIgnoreCase(contact.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName.toLowerCase(), lastName.toLowerCase());
    }
    
    // UC 11 – Sort by Person's Name
    @Override
    public int compareTo(Contact other) {
        int firstNameCompare = this.firstName.compareToIgnoreCase(other.firstName);
        if (firstNameCompare != 0) {
            return firstNameCompare;
        }
        return this.lastName.compareToIgnoreCase(other.lastName);
    }


    // UC 11 – Printing contact
    @Override
    public String toString() {
        return "Contact{" + "Name='" + firstName + " " + lastName + '\'' + ", City='" + city + '\'' + ", State='" + state + '\'' +", Zip='" + zip + '\'' + ", Phone='" + phoneNumber + '\'' + ", Email='" + email + '\'' + '}';
    }
}
