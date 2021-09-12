import java.util.ArrayList;

public class Gradebook {
    public static void main(String[] args) {
        Student waseem = new Student("Waseem");
        Student matthew = new Student("Matthew Polus");
        matthew.addExam(59);
        matthew.addExam(100);

        System.out.println(waseem + "\n" + matthew);
    }
}