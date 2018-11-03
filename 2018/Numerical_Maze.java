import java.util.Arrays;
import java.util.Scanner;

public class Numerical_Maze {

    static void print(String arg){
        System.out.println(arg);
    }
    static int rows, cols = 0;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        rows = scan.nextInt();
        cols = scan.nextInt();
        int[][] maze = new int[rows][cols];
        for (int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                maze[i][j] = scan.nextInt();
            }
        }

        for(int i = 0; i<rows; i++){
            print(Arrays.toString(maze[i]));
        }
    }
}
