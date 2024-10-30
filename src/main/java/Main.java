// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    Scanner scanner = new Scanner(System.in);
    int num = scanner.nextInt();
    System.out.println(num);
    scanner.close();
  }

  // @Test
  // void addition() {
  // assertEquals(2, 1 + 1);
  // }
}