package learnBase;

public class learnSwitch {
    public static void main(String[] args) {
        char grade = 'C';

        switch(grade){
            case 'A':
                System.out.println("优秀");
                break;
            case 'B':
                System.out.println("良好");
                break;
            case 'C':
                System.out.println("及格");
                break;
            default:
                System.out.println("未知等级");
        }
    }
}
