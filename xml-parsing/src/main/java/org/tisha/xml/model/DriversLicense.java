package org.tisha.xml.model;

import java.util.Arrays;

/**
 * @author Tsikhan Kuprevich
 * @since 8/7/2017
 */
public class DriversLicense {

    private long number;
    private String status;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String vehicleType;
    private String dateOfIssue;

    private String[] photo;

    private Address address = new Address();

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(String dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String[] getPhoto() {
        return photo;
    }

    public void setPhoto(String[] photo) {
        this.photo = photo;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "DriversLicense{" +
                "number=" + number +
                ", status='" + status + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", dateOfIssue='" + dateOfIssue + '\'' +
                ", photo=" + Arrays.toString(photo) +
                ", address=" + address.toString() +
                '}';
    }
}
