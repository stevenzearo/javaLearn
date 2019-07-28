package test;

public class PersonTest {
    public static void main(String[] args) {
        Person person =new Person() {
            @Override
            public void say() {
                System.out.println("Hello, world!");
            }
        };
    person.say();
    }

}
