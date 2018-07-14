import java.util.Scanner;

public class DiscussionWeekTwo {
public static void main (String [] args){

Scanner sc = new Scanner(System.in);



System.out.println('Enter your age and press enter: ');
int age = sc.nextInt();

if (age >= 21){
System.out.println('You can buy a drink!');
}
else {
System.out.println('Sorry, you cannot buy a drink!');
}
}
}