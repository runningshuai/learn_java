package learnCollectors;

import java.util.Arrays;
import java.util.List;

public class studentService {
    public static void main(String[] args) {

        List<Student> nameList = Arrays.asList(
                new Student("子轩", 12, true, Student.Grade.one, 75),
                new Student("紫萱", 13, true, Student.Grade.two, 78),
                new Student("梓轩", 14, true, Student.Grade.three, 70),
                new Student("子萱", 12, false, Student.Grade.one, 80),
                new Student("梓萱", 13, false, Student.Grade.two, 65),
                new Student("紫轩", 14, false, Student.Grade.three, 79)
        );
        searchStudent ss = new searchStudent(nameList);
        ss.getAverageScore();
        ss.studentNumber();
        ss.studentOfGrade();
        ss.studentNumberOfGrade();
        ss.averageScoreOfGrade();
        ss.nameJoin();
        ss.nameJoin2();
        ss.studentOfMaxScore();
        ss.studentOfLocal();
        ss.averageScoreOfLocal();
        ss.totalScore();
        ss.totalScore2();
        ss.studentInfoLocal();
    }
}
