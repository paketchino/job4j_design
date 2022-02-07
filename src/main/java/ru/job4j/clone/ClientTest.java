package ru.job4j.clone;

public class ClientTest {

    public ClientTest() {
    }

    public static void main(String[] args) {
        DeepClone.Address address = new DeepClone.Address(1111, "address Line1", "address Line2", "Mumbai", 590999L);
        DeepClone.Employee employee1 = new DeepClone.Employee(1001, "KK", 30, "kishan.javatrainer@gmail.com", "pass@123", address);
        try {
            Object object = employee1.clone();
            DeepClone.Employee employee2 = (DeepClone.Employee) object;
            employee2.setName("Kishan");
            employee2.getAddress().setCity("Delhi");
            System.out.println("Original Employee object:::");
            System.out.println(employee1);
            System.out.println("Cloned Employee object:::");
            System.out.println(employee2);
            System.out.println(employee1.equals(employee2));
        } catch (CloneNotSupportedException var5) {
            var5.printStackTrace();
        }
    }
}
