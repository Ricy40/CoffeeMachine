import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String input = scanner.next();
        int n = scanner.nextInt();
        int m = scanner.nextInt() + 1;

        System.out.println(input.substring(n, m));

    }
}