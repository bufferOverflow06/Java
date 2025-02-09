// Constructor reference
// a type of method reference

import java.util.*;

class Student{
    int age;
    String name;

    public Student(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }
    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return "[" + this.getClass().getName() + "[name=" + name + ", age=" + age + "]"+ "]";
    }
}

public class test {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("AAA", "BBB", "CCC");

        List<Student> students = new ArrayList<>();

        // We can create new student objects and give the names as
        // for(String name : names){
        //     students.add(new Student(name));
        // }

        // We can do this also
        // students = names.stream()
        // .map(name -> new Student(name))
        // .toList();

        //Constructor reference
        students = names.stream()
        .map(Student::new)
        .toList();

        System.out.println(students);
    }
}
