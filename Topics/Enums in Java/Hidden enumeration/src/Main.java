public class Main {

    public static void main(String[] args) {
        int numberOfStar = 0;

        for (Secret secret : Secret.values()) {
            if (secret.name().startsWith("STAR")) {
                numberOfStar++;
            }
        }

        System.out.println(numberOfStar);
    }
}