
import java.util.*;

public class Practice {
    public static void main(String[] args) {
        int[][] details = {
                { 2, 60 },
                { 8, 95 },
                { 3, 70 },
                { 7, 90 },
                { 1, 45 },
                { 9, 98 },
                { 4, 75 },
                { 6, 85 },
                { 2, 55 },
                { 9, 92 },
        };
        char[] grades = { 'C', 'A', 'B', 'A', 'F', 'A', 'B', 'B', 'C', 'A' };
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < grades.length; i++) {
            list.add(new Student(details[i][0], details[i][1], grades[i]));
        }
        int hour = 5;
        int attendance = 80;
        TreeSet<Student> treeSet = new TreeSet<>((a, b) -> Double.compare(a.distance, b.distance));
        for (Student student : list) {
            student.distance = calculateDistance(student, hour, attendance);
            treeSet.add(student);
        }
        for (Student student : treeSet) {
            System.out.println("Distance: " + student.distance + " Grade: " + student.Grade);
        }
    }

    private static class Student {
        final int hours;
        final int attendance;
        final char Grade;
        double distance;

        public Student(int hours, int attendance, char grade) {
            this.hours = hours;
            this.attendance = attendance;
            this.Grade = grade;
            this.distance = (double) (0);
        }
    }

    private static double calculateDistance(Student student, int hour, int attendance) {
        double hourDistance = Math.pow(student.hours - hour, 2);
        double attendanceDistance = Math.pow(student.attendance - attendance, 2);
        return Math.sqrt(hourDistance + attendanceDistance);
    }
}
