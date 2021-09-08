public class Student {
    private final String studentName;
    private double examSum;
    private double examNumGrades;

    public Student(String studentName) {
        this.studentName = studentName;
        examSum = 0;   
        examNumGrades = 0;
    }

    public String getName() {
        return studentName;
    }

    public void addExam(double grade) {
        examSum += grade;
        examNumGrades++;
    }

    public double average() {
        return examSum / examNumGrades;
    }
}