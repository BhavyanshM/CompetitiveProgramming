import java.sql.Time;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Natrij {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int[] nums = {1,23,94,-12,3,50,-4, 0,2,132};
        Arrays.stream(nums)
                .sorted()
                .filter(x -> x>0)
                .forEach(System.out::println);

    }

}
