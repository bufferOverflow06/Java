// The Integer class implements Comparable<Integer> and that is why sort works with Integer
// If we want natural sorting we can implement comparable
// The Comparable interface has a method called compareTo which must be defined
import java.util.*;

class Student { // implements Comparable<Student>
    int age;
    String name;

    public Student(int age, String name){
        this.age = age;
        this.name = name;
    }

    public String toString() {
        return "Student " + "[ age=" + age + ", name= " + name + "]";
    }

    public int compareTo(Student that) {
        if(this.age > that.age){
            return 1;
        }
        else{
            return -1;
        }
    }
}

public class DemoStudent{
    public static void main(String []args){

        // Comparator<Student>  com = new Comparator<Student>() {
        //     public int compare(Student s1, Student s2){
        //         if(s1.age > s2.age){
        //             return 1;
        //         }
        //         else{
        //             return -1;
        //         }
        //     }
        // };

        // or using lambda expression

        Comparator<Student> com = (s1, s2) -> s1.age > s2.age ? 1 : -1;

        List<Student> students = new ArrayList<>();

        students.add(new Student(21, "AAA"));
        students.add(new Student(12, "BBB"));
        students.add(new Student(18, "CCC"));
        students.add(new Student(20, "DDD"));
        students.add(new Student(24, "EEE"));

        // System.out.println(students);

        Collections.sort(students, com);

        for(Student student : students){
            System.out.println(student);
        }
    }

}
