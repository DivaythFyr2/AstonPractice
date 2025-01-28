import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        String helloWorld = "Hello, World!";

        IntStream.range(0, helloWorld.length()).forEach(i -> {
            System.out.print(helloWorld.charAt(i));
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        System.out.println();
    }
}
