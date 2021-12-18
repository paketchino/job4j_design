package ru.job4j.serialization.jsom;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.json.JSONArray;
import org.json.JSONObject;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public Person(boolean sex, int age, Conacat conacat, String[] statuses) {
        this.sex = sex;
        this.age = age;
        this.conacat = conacat;
        this.statuses = statuses;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setConacat(Conacat conacat) {
        this.conacat = conacat;
    }

    public void setStatuses(String[] statuses) {
        this.statuses = statuses;
    }

    public boolean isSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public Conacat getConacat() {
        return conacat;
    }

    public String[] getStatuses() {
        return statuses;
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

    /**
     * для примера
       JSONArray jsonStatuses = new JSONArray(list);
        final Person person = new Person(false, 30, new Conacat("11-111"), new String[] {"Worker", "Married"});
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sex", person.isSex());
        jsonObject.put("age", person.getAge());
        jsonObject.put("phone", jsonContact);
        jsonObject.put("statuses", jsonStatuses);
        System.out.println(jsonObject.toString());
      System.out.println(new JSONObject(person).toString());
     */

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

        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Person result = (Person) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(person));

        final String personJson =
                "{"
                + "\"sex\":false,"
                + "\"age\":30,"
                + "\"conacat\":"
                    + "{"
                        + "\"phone\":\"+7(924)111-111-11-11\""
                + "\"statuses\":"
                        + "[\"Student\",\"Free\"]"
                + "}";
        final Person personMod = gson.fromJson(personJson, Person.class);
        System.out.println(personMod);

        JSONObject jsonContact = new JSONObject("{\"phone\":\"+7(924)111-111-11-11\"}");
        List<String> list = new ArrayList<>();
        list.add("Student");
        list.add("Free");
        JSONArray jsonStatuses = new JSONArray(list);
    }
}
