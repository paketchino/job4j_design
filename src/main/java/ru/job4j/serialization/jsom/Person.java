package ru.job4j.serialization.jsom;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)

public class Person {
    @XmlAttribute
    private boolean sex;

    @XmlAttribute
    private int age;
    private Conacat conacat;

    @XmlElementWrapper(name = "statuses")
    @XmlElement(name = "status")
    private String[] statuses;

    public Person() {}

    public Person(boolean sex, int age, Conacat conacat, String[] statuses) {
        this.sex = sex;
        this.age = age;
        this.conacat = conacat;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return "Person{"
                + "sex="
                + sex
                + ", age="
                + age + ", conacat="
                + conacat
                + ", statuses="
                + Arrays.toString(statuses)
                + '}';
    }

    public static void main(String[] args) throws Exception {
        final Person person = new Person(false, 30, new Conacat("11-111"), new String[] {"Student", "Free"});
        JAXBContext context = JAXBContext.newInstance(Person.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(person, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }

//        Unmarshaller unmarshaller = context.createUnmarshaller();
//        try (StringReader reader = new StringReader(xml)) {
//            Person result = (Person) unmarshaller.unmarshal(reader);
//            System.out.println(result);
//        }
//        final Gson gson = new GsonBuilder().create();
//        System.out.println(gson.toJson(person));
//
//        final String personJson =
//                "{"
//                + "\"sex\":false,"
//                + "\"age\":30,"
//                + "\"conacat\":"
//                    + "{"
//                        + "\"phone\":\"+7(924)111-111-11-11\""
//                + "\"statuses\":"
//                        + "[\"Student\",\"Free\"]"
//                + "}";
//        final Person personMod = gson.fromJson(personJson, Person.class);
//        System.out.println(personMod);
    }
}
