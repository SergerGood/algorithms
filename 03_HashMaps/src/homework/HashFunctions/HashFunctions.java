package homework.HashFunctions;

import java.util.stream.Stream;

public class HashFunctions {
    public static int hashString(String input) {

        var hash = 0;

        if (input != null) {
            for (int i = 0; i < input.length(); i++) {
                hash += input.charAt(i);
            }
        }

        return hash;
    }

    public static int hashInt(int input) {

        if (input == 0) return 0;

        var inputString = Integer.toString(input);
        var hash = 1;

        for (int i = 0; i < inputString.length(); i++) {

            var digit = Character.getNumericValue(inputString.charAt(i));
            if (digit != 0) {
                hash *= digit;
            }
        }

        return hash;
    }


    public static int hashStudent(Student student) {
        var hash = 1;

            for (int i = 0; i < student.name.length(); i++) {
                int numericValue = Character.getNumericValue(student.name.charAt(i));
                hash = (hash + numericValue) ^ student.age - numericValue;
            }

        return hash;

    }

    static class Student {
        private final int age;
        private final String name;

        public Student(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "St{age=" + age + ", name='" + name + '\'' + '}';
        }
    }

    public static void main(String[] args) {
        Stream.of(new Student(55, "Alex"),
                        new Student(4, "Ivan"),
                        new Student(8, "Lia"),
                        new Student(78, "Linus"),
                        new Student(78, "Lisun"),
                        new Student(87, "Linus"),
                        new Student(24, "Anna"),
                        new Student(42, "Anna"),
                        new Student(34, "Maya"))
                .map(st -> String.format("%30s hash=[%12d]", st, hashStudent(st)))
                .forEach(System.out::println);
    }
}
