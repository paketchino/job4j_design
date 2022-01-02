package ru.job4j.serialization;

import java.io.*;
import java.nio.file.Files;
import java.util.Objects;

public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;
    private final int zipcode;
    private String phone;

    public Contact(int zipcode, String phone) {
        this.zipcode = zipcode;
        this.phone = phone;
    }

    public int getZipcode() {
        return zipcode;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public int hashCode() {
        return Objects.hash(zipcode, phone);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)  {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Contact contact = (Contact) o;
        return zipcode == contact.zipcode && Objects.equals(phone, contact.phone);
    }


    @Override
    public String toString() {
        return "Contact{" + "zipcode="
                + zipcode + ", phone='"
                + phone + '\''
                + '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final Contact contact = new Contact(123456, "+7 (111) 111-11-11");

        File tempFile = Files.createTempFile(null, null).toFile();
        try (FileOutputStream fos = new FileOutputStream(tempFile);
            ObjectOutputStream oos =
                    new ObjectOutputStream(fos)) {
                oos.writeObject(contact);
            }
        try (FileInputStream fis = new FileInputStream(tempFile);
             ObjectInputStream ois =
                     new ObjectInputStream(fis)) {
                 final Contact contactFromFile = (Contact) ois.readObject();
                 System.out.println(contactFromFile);
        }
    }
}
