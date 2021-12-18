package ru.job4j.serialization.jsom;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "university")
@XmlAccessorType(XmlAccessType.FIELD)
public class University {

    @XmlAttribute
    private boolean deducted;

    @XmlAttribute
    private int score;

    @XmlAttribute
    private String teacher;
    private Student student;

    @XmlElementWrapper(name = "subjects")
    @XmlElement(name = "subject")
    private String[] subjects;

    public University(boolean deducted, int score, String teacher, Student student, String[] subjects) {
        this.deducted = deducted;
        this.score = score;
        this.teacher = teacher;
        this.student = student;
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "University{" + "deducted="
                + deducted + ", Score="
                + score + ", teacher='" + teacher
                + '\'' + ", student=" + student
                + ", subjects="
                + Arrays.toString(subjects) + '}';
    }


    public static void main(String[] args) throws Exception {
        final University university = new University(false, 5, "Pert",
                new Student(20, "Roman"), new String[] {"JSOM", "JAVA"});
        JAXBContext jaxbContext = JAXBContext.newInstance(University.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(university, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            University result = (University) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(university));
        final String univesityJson =
                "{"
                        + "\"deducted\" : false,"
                        + "\"score\" :5,"
                        + "\"teacher\":\"Petr\","
                        + "\"student\":"
                            + "{"
                                + "\"age\":20"
                            + "},"
                        + "\"subjects\":"
                            + "[\"JSOM\",\"JAVA\"]"
                + "}";
        final University universityMod = gson.fromJson(univesityJson, University.class);
        System.out.println(universityMod);
    }
}
