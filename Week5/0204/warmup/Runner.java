
import java.util.ArrayList;
import java.util.Iterator;

public class Runner {

    public static void main(String[] args) {

        ArrayList<Student> studentList = new ArrayList<>();

        studentList.add(new Student("Henry", 34));
        studentList.add(new Student("Jose", 21));
        studentList.add(new Student("Carla", 21));
        studentList.add(new Student("Nancy", 19));

        int totalAge = 0;
        for (Student s : studentList) {
            totalAge += s.getAge();
        }
        System.out.println("Total age: " + totalAge);

        Iterator<Student> it = studentList.iterator();
        while (it.hasNext()) {
            if (it.next().getAge() == 21) {
                it.remove();
            }
        }

        for (Student s : studentList) {
            System.out.println(s);
        }
    }
}
