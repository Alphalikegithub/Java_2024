import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        int i = sumValueBy2Num(3, 4);
        System.out.println(i);
//        System.out.printf("Hello and welcome!");
//        Scanner sc = new Scanner(System.in);
//        double firstTest = sc.nextDouble();
//        System.out.println(firstTest);
//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>
//
//            System.out.println("i = " + i);
//        }

    }
    public static int sumValueBy2Num (int num1, int num2)
    {
        int sum;
        sum = num1 + num2;
        return sum;
    }
}