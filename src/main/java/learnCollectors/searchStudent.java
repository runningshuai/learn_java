package learnCollectors;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.Comparator;

public class searchStudent {
    public List<Student> menu;

    public searchStudent(List<Student> nameList){
        this.menu = nameList;
    }

    //平均成绩
    public void getAverageScore(){
        Double averageScore = menu.stream().collect(Collectors.averagingDouble(Student::getScore));
        Optional.ofNullable(averageScore).ifPresent(System.out::println);
    }

    //统计多少学生
    public void studentNumber(){
        long num;
        num = menu.stream().collect(Collectors.counting());
        System.out.println(num);
    }

    //按年级分组
    public void studentOfGrade(){
        Map<Student.Grade, List<Student>> result = menu.stream().collect(Collectors.groupingBy(Student::getGrade));
        Optional.ofNullable(result).ifPresent(System.out::println);

    }

    //分组，统计各个年级有多少学生
    public void studentNumberOfGrade(){
        Map<Student.Grade, Long> result = menu.stream()
                .collect(Collectors.groupingBy(Student::getGrade,Collectors.counting()));
        Optional.ofNullable(result).ifPresent(System.out::println);

    }
    //分组，统计各个年级的最高分
    public void averageScoreOfGrade(){
        Map<Student.Grade, Double> result = menu.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade,
                        TreeMap::new,
                        Collectors.averagingDouble(Student::getScore)));
        Optional.ofNullable(result).ifPresent(System.out::println);
    }

    //joining 所有学生的名字连在一起
    public void nameJoin(){
        String result = menu.stream()
                .map(Student::getName)
                .collect(Collectors.joining(",", "Names[", "]"));
        Optional.ofNullable(result).ifPresent(System.out::println);
    }

    //maping 所有学生的名字连在一起
    public void nameJoin2(){
        String result = menu.stream()
                .collect(Collectors.mapping(
                        Student::getName, Collectors.joining(",")));
        Optional.ofNullable(result).ifPresent(System.out::println);
    }

    //列出所有学生成绩最高的学生信息
    public void studentOfMaxScore(){
        menu.stream().collect(Collectors.maxBy(Comparator.comparingInt(Student::getScore)))
                .ifPresent(System.out::println);
    }

    //列出所有学生中本地和非本地学生信息 partitoningBy
    public void studentOfLocal(){
        Map<Boolean, List<Student>> result = menu.stream()
                .collect(Collectors.partitioningBy(Student::getIsLocal));
        Optional.ofNullable(result).ifPresent(System.out::println);
    }

    //列出所有学生中本地和非本地学生的平均总成绩
    public void averageScoreOfLocal(){
        Map<Boolean, Double> result = menu.stream()
                .collect(Collectors.partitioningBy(
                        Student::getIsLocal,
                        Collectors.averagingDouble(Student::getScore)));
        Optional.ofNullable(result).ifPresent(System.out::println);
    }

    //统计所有学生的总成绩
    public void totalScore(){
        Integer result = menu.stream()
                .map(Student::getScore)
                .collect(Collectors.reducing(0,(d1, d2) -> d1 + d2));
        System.out.println(result);
    }

    //统计所有学生的总成绩
    public void totalScore2(){
        Integer result = menu.stream()
                .collect(Collectors.summingInt(Student::getScore));
        System.out.println(result);
    }

    //本地学生，toList
    public void studentInfoLocal(){
        List<Student> result = menu.stream()
                .filter(Student::getIsLocal)
                .collect(Collectors.toList());
        System.out.println(result);
    }
}
