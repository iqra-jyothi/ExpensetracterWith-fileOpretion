import javax.annotation.processing.SupportedSourceVersion;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Tracker tc=new Tracker();
        ArrayList<Expense>al=new ArrayList<>();
//        HashMap<Date,Expense>he=new HashMap<>();
        System.out.println("Welcome to Expense Tracker");

        tc.readtiledata(al);

        while(true)
        {
            System.out.println("1.enter add your expenses");
            System.out.println("2. view All Expenses");
            System.out.println("3. view All Expenses based on date");
            System.out.println("4.view All expense from date to specifice date");
            System.out.println("5.delete expense specific dtate");
            System.out.println("6.delete All expenses");
            System.out.println("7.detete with specific date and cretory");
            System.out.println("8.total all expense for specific date");
            System.out.println("9.total all expense for specific date and category");
            System.out.println("10.total all expense form date  to  specific date");
            System.out.println("12.view category wise total");
            System.out.println("13.view sorted by amount");
            System.out.println("11. exit");
            System.out.println("enter choice ");
            int choice=sc.nextInt();
            switch (choice)
            {
                case 1:tc.addexpense(al,sc);
                System.out.println("sucessfully added");
                break;
                case 2:tc.viewallexpenses(al);
                break;
                case 3:tc.viewAllExpensesSpecificDate(al,sc);
                break;
                case 4:tc.ViewAllFromtoToexpeses(al,sc);
                break;
                case 5:tc.DeleteSpecificdate(al,sc);
                break;
                case 6:tc.DeleteAll(al);
                break;
                case 7: tc.DeleteSpecificdateandcretory(al,sc);
                break;
                case 8:double total=tc.TotalExpenseSpecificDate(al,sc);
                System.out.println("total expenses on this date "+total);
                break;
                case 9:double t=tc.totalcetogarydate(al,sc);
                    System.out.println("the total amount is "+t);
                    break;
                case 10:double ts=tc.TotalFromTo(al,sc);
                    System.out.println("total expenses on this date "+ts);
                    break;

                case 11:System.out.println("exit");
                tc.printallExpenses(al);
                return;
                case 12: tc.viewCategoryWiseTotal(al); break;
                case 13: tc.viewSortedByAmount(al); break;
                default:System.out.println("enter ");
            }
        }
    }
}