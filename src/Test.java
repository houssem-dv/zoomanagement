import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Test{
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Houssem", 21));
        students.add(new Student(2, "Ghassen", 28));
        students.add(new Student(3, "Emna", 19));

        StudentManagement management = new StudentManagement();

        System.out.println(" Affichage  des étudiants ");
        Consumer<Student> printStudent = student -> System.out.println(student.toString());
        management.displayStudents(students, printStudent);

        System.out.println("\n Étudiants de plus de 20 ans ");
        Predicate<Student> ageFilter = student -> student.getAge() > 20;
        management.displayStudentsByFilter(students, ageFilter, printStudent);

        System.out.println("\n Noms des étudiants ");
        Function<Student, String> getName = Student::getName;
        String names = management.returnStudentsNames(students, getName);
        System.out.println("Noms: " + names);

        System.out.println("\nCréation d'un nouvel étudiant ");
        Supplier<Student> studentSupplier = () -> new Student(4, "Ahmed", 23);
        Student newStudent = management.createStudent(studentSupplier);
        System.out.println("Nouvel étudiant: " + newStudent);
        students.add(newStudent);

        System.out.println("\nÉtudiants triés par ID");
        Comparator<Student> idComparator = Comparator.comparingInt(Student::getId);
        List<Student> sortedStudents = management.sortStudentsById(students, idComparator);
        sortedStudents.forEach(student -> System.out.println(student));

        System.out.println("\nConversion en Stream et filtrage (âge >= 20)");
        management.convertToStream(students)
                .filter(student -> student.getAge() >= 20)
                .forEach(student -> System.out.println(student));
    }
}