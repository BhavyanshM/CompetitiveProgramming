import java.util.Arrays;
import java.util.Scanner;

public class Wet_Tiles {

    static class Point {
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
//        while(true){
            int X = scan.nextInt();
//            if(X==-1)break;
            int Y = scan.nextInt();
            int T = scan.nextInt();
            int L = scan.nextInt();
            int W = scan.nextInt();

            int[][] grid = new int[X+1][Y+1];
            for(int i = 1; i<L; i++){
                grid[scan.nextInt()][scan.nextInt()] = 1;
            }
            for(int i = 1; i<W; i++){
                grid[scan.nextInt()][scan.nextInt()] = -1;
                grid[scan.nextInt()][scan.nextInt()] = -1;
            }
            System.out.println();
            for(int i = 1; i<X+1; i++){
                System.out.println(Arrays.toString(grid[i]));
            }
//        }



    }


}
