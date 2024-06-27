import java.util.Scanner;

public class GarbageCollection {
    private int maxCapacity = 10000; // maximum capacity of truck in kg
    private int currentCapacity = 0; // current capacity of truck in kg
    private int time = 0; // time taken to collect garbage
    private int numStations = 0; // number of garbage transfer stations
    private int[] garbageAmounts; // amount of garbage at each station

    // constructor
    public GarbageCollection(int[] garbageAmounts) {
        this.garbageAmounts = garbageAmounts;
        this.numStations = garbageAmounts.length;
    }

    // method to calculate cost of bidding for garbage collection
    public int calculateCost() {
        int cost = 0;

        for (int i = 0; i < numStations; i++) {
            // add amount of garbage at station to current capacity
            currentCapacity += garbageAmounts[i];

            // if truck is full, dump garbage and add time taken to dump
            if (currentCapacity >= maxCapacity) {
                cost += dumpGarbage();
            }

            // add time taken to collect garbage at station
            time += 8;
        }

        // add time taken to return to first station
        time += 30;

        // dump any remaining garbage
        cost += dumpGarbage();

        // calculate total cost
        int totalCost = time * 120000 + 57000 + cost;

        return totalCost;
    }

    // method to dump garbage and return cost
    private int dumpGarbage() {
        int cost = 57000;
        currentCapacity = 0;
        time += 30;
        return cost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // read input data
        System.out.println("Enter the amount of garbage at each station:");
        String input = scanner.nextLine();
        String[] amountsStr = input.split(" ");
        int[] garbageAmounts = new int[amountsStr.length];
        for (int i = 0; i < amountsStr.length; i++) {
            garbageAmounts[i] = Integer.parseInt(amountsStr[i]);
        }

        // create GarbageCollection object and calculate cost
        GarbageCollection gc = new GarbageCollection(garbageAmounts);
        int cost = gc.calculateCost();

        // print result
        System.out.println("The total cost is " + cost + " VND");
    }
}
