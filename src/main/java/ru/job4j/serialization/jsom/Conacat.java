package ru.job4j.serialization.jsom;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "concat")
public class Conacat {

    @XmlAttribute
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Conacat(String phone) {
        this.phone = phone;
    }

    public Conacat() {}

    @Override
    public String toString() {
        return "Conacat{" +
                "phone='" + phone + '\''
                + '}';
    }
}
