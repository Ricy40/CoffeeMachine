import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final double pi = 3.14;

        String shape = scanner.next();

        switch (shape) {
            case "triangle":
                double a = scanner.nextDouble();
                double b = scanner.nextDouble();
                double c = scanner.nextDouble();
                double s = (a + b + c) / 2;
                double areaTriangle = Math.sqrt(s * (s - a) * (s - b) * (s - c));
                System.out.println(areaTriangle);
                break;
            case "rectangle":
                double d = scanner.nextDouble();
                double e = scanner.nextDouble();
                double areaRectangle = d * e;
                System.out.println(areaRectangle);
                break;
            case "circle":
                double r = scanner.nextDouble();
                double areaCircle = pi * r * r;
                System.out.println(areaCircle);
                break;
            default:
                System.out.println("Not a valid room shape!");
                break;
        }
    }
}