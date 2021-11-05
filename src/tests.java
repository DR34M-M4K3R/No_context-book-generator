import java.util.Random;

public class tests {
    public static void main(String[] args) {

        for (int i = 0; i < 100; i ++) {
            Random r = new Random();
            int caca = r.nextInt(5 - 1) + 1;
            System.out.println(caca);
        }
    }
}
