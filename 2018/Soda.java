import java.util.Scanner;

public class Soda {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int e = scan.nextInt();
        int f = scan.nextInt();
        int c = scan.nextInt();
        int total = e + f;
        int drinks = 0;
        int totalDrinks = 0;
        while(total >= c){
            drinks = total/c;
            totalDrinks += drinks;
            total = drinks + (total%c);
        }
        System.out.print(totalDrinks);
    }

}
