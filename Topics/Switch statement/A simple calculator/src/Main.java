import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long firstInt = scanner.nextLong();
        char sum = scanner.next().charAt(0);
        long secondInt = scanner.nextLong();

        switch (sum) {
            case '+':
                System.out.println(firstInt + secondInt);
                break;
            case '-':
                System.out.println(firstInt - secondInt);
                break;
            case '*':
                System.out.println(firstInt * secondInt);
                break;
            case '/':
                if (secondInt == 0) {
                    System.out.println("Division by 0!");
                } else {
                    System.out.println(firstInt / secondInt);
                }
                break;
            default:
                System.out.println("Unknown operator");
                break;
        }
    }
}