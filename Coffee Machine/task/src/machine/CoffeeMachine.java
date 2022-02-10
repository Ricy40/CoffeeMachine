package machine;

import java.util.Scanner;

public class CoffeeMachine {

    static MachineStatus status = MachineStatus.CHOOSING_ACTION;
    static boolean operational = true;
    static int currentWater = 400;
    static int currentMilk = 540;
    static int currentCoffeeBeans = 120;
    static int currentMoney = 550;
    static int currentCups = 9;
    static Coffee espresso = new Coffee(250, 0, 16, 4);
    static Coffee latte = new Coffee(350, 75, 20, 7);
    static Coffee cappuccino = new Coffee(200, 100, 12, 6);

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWrite action (buy, fill, take, remaining, exit):");

        while (operational) {
            String choice = scanner.next();
            machineAction(choice);
        }
    }

    private static void machineAction(String input) {
        switch (status) {
            case CHOOSING_ACTION:
                mainMenu(input);
                break;

            case CHOOSING_COFFEE:
                switch (input) {
                    case "1":
                        buyCoffee(espresso);
                        break;
                    case "2":
                        buyCoffee(latte);
                        break;
                    case "3":
                        buyCoffee(cappuccino);
                        break;
                    case "back":
                        break;
                    default:
                        System.out.println("Invalid Selection!");
                        break;
                }
                status = MachineStatus.CHOOSING_ACTION;
                System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
                break;
            case FILL_WATER:
                currentWater += Integer.parseInt(input);
                status = MachineStatus.FILL_MILK;
                System.out.println("Write how many ml of milk you want to add:");
                break;
            case FILL_MILK:
                currentMilk += Integer.parseInt(input);
                status = MachineStatus.FILL_COFFEEBEANS;
                System.out.println("Write how many grams of coffee beans you want to add:");
                break;
            case FILL_COFFEEBEANS:
                currentCoffeeBeans += Integer.parseInt(input);
                status = MachineStatus.FILL_CUPS;
                System.out.println("Write how many disposable cups of coffee you want to add:");
                break;
            case FILL_CUPS:
                currentCups += Integer.parseInt(input);
                status = MachineStatus.CHOOSING_ACTION;
                System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
                break;
            default:
                System.out.println("Invalid Choice!");
                status = MachineStatus.CHOOSING_ACTION;
                System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
                break;
        }
    }

    private static void mainMenu(String input) {
        switch (input) {
            case "buy":
                status = MachineStatus.CHOOSING_COFFEE;
                System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                break;
            case "fill":
                status = MachineStatus.FILL_WATER;
                System.out.println("\nWrite how many ml of water you want to add:");
                break;
            case "take":
                System.out.println("I gave you $" + currentMoney);
                currentMoney = 0;
                System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
                break;
            case "remaining":
                System.out.println(
                        "\nThe coffee machine has:\n" +
                                currentWater + " ml of water\n" +
                                currentMilk + " ml of milk\n" +
                                currentCoffeeBeans + " g of coffee beans\n" +
                                currentCups + " disposable cups\n" +
                                "$" + currentMoney + " of money"
                );
                System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
                break;
            case "exit":
                operational = false;
        }
    }

    private static void buyCoffee(Coffee coffee) {
        if (coffee.getWaterCost() > currentWater) {
            System.out.println("Sorry, not enough water!");
        } else if (coffee.getMilkCost() > currentMilk) {
            System.out.println("Sorry, not enough milk!");
        } else if (coffee.getCoffeeBeanCost() > currentCoffeeBeans) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (currentCups <= 0) {
            System.out.println("Sorry, not enough disposable cups!");
        } else {
            currentWater -= coffee.getWaterCost();
            currentMilk -= coffee.getMilkCost();
            currentCoffeeBeans -= coffee.getCoffeeBeanCost();
            currentCups -= 1;
            currentMoney += coffee.getMoneyCost();
            System.out.println("I have enough resources, making you a coffee!");
        }
    }
}

enum MachineStatus {
    CHOOSING_ACTION, CHOOSING_COFFEE, FILL_WATER, FILL_MILK, FILL_COFFEEBEANS, FILL_CUPS
}

class Coffee {

    private final int waterCost;
    private final int milkCost;
    private final int coffeeBeanCost;
    private final int moneyCost;

    public Coffee(int waterCost, int milkCost, int coffeeBeanCost, int moneyCost) {
        this.waterCost = waterCost;
        this.milkCost = milkCost;
        this.coffeeBeanCost = coffeeBeanCost;
        this.moneyCost = moneyCost;
    }

    public int getWaterCost() {
        return waterCost;
    }

    public int getMilkCost() {
        return milkCost;
    }

    public int getCoffeeBeanCost() {
        return coffeeBeanCost;
    }

    public int getMoneyCost() {
        return moneyCost;
    }
}
