package ru.job4j.clone;

public class DeepClone {

     static class Address {
        private int id;
        private String addressLine1;
        private String addressLine2;
        private String city;
        private long zipCode;

        public Address(int id, String addressLine1, String addressLine2, String city, long zipCode) {
            this.id = id;
            this.addressLine1 = addressLine1;
            this.addressLine2 = addressLine2;
            this.city = city;
            this.zipCode = zipCode;
        }

        public int getId() {
            return this.id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAddressLine1() {
            return this.addressLine1;
        }

        public void setAddressLine1(String addressLine1) {
            this.addressLine1 = addressLine1;
        }

        public String getAddressLine2() {
            return this.addressLine2;
        }

        public void setAddressLine2(String addressLine2) {
            this.addressLine2 = addressLine2;
        }

        public String getCity() {
            return this.city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public long getZipCode() {
            return this.zipCode;
        }

        public void setZipCode(long zipCode) {
            this.zipCode = zipCode;
        }

        public String toString() {
            return "Address [id=" + this.id + ", addressLine1=" + this.addressLine1 + ", addressLine2=" + this.addressLine2 + ", city=" + this.city + ", zipCode=" + this.zipCode + "]";
        }
    }

    static class Employee implements Cloneable {
        private int id;
        private String name;
        private int age;
        private String email;
        private String password;
        private Address address;

        public Employee(int id, String name, int age, String email, String password, Address address) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.email = email;
            this.password = password;
            this.address = address;
        }

        public int getId() {
            return this.id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return this.age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getEmail() {
            return this.email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return this.password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Address getAddress() {
            return this.address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        public Object clone() throws CloneNotSupportedException {
            Employee employee = (Employee) super.clone();
            employee.setAddress(new Address(this.getAddress().getId(), this.getAddress().getAddressLine1(), this.getAddress().getAddressLine2(), this.getAddress().getCity(), this.getAddress().getZipCode()));
            return employee;
        }

        public String toString() {
            return "Employee [id=" + this.id + ", name=" + this.name + ", age=" + this.age + ", email=" + this.email + ", password=" + this.password + ", address=" + this.address + "]";
        }
    }
}
