package practice;

import java.util.Scanner;

public class TrucksAndContainers {
    public int boxes;
    private static final int MAX_CONTAINERS_IN_CAR = 12;
    private static final int MAX_BOXES_IN_CONTAINERS = 27;
    private int aCalculationOfTheNumberOfCars;

    public TrucksAndContainers(int boxes) {
        this.boxes = boxes;
    }

    public int calculationContainers(int boxes) {
        int containers = 0;
        if (boxes > 0 && boxes > MAX_BOXES_IN_CONTAINERS) {
            containers = boxes / MAX_BOXES_IN_CONTAINERS;
            return (boxes % MAX_BOXES_IN_CONTAINERS) > 0 ? containers + 1 : containers;
        } else if (boxes > 0 && boxes <= MAX_BOXES_IN_CONTAINERS) {
            return containers + 1;
        } else {
            return 0;
        }
    }

    public int calculationOfTheNumberOfCars(int boxes) {
        int oneCar = MAX_BOXES_IN_CONTAINERS * MAX_CONTAINERS_IN_CAR;
        if (boxes > oneCar) {
            int calculationOfMachines = boxes / oneCar;
            return (boxes % oneCar) > 0 ? calculationOfMachines + 1 : calculationOfMachines;
        } else if (boxes <= oneCar) {
            return 1;
        } else {
            return 0;
        }
    }

    public void loadingIntoTheCar() {
        int boxx = 1;
        int count = 1;
        aCalculationOfTheNumberOfCars = calculationOfTheNumberOfCars(boxes);
        for (int i = 1; i <= aCalculationOfTheNumberOfCars; i++) {
            System.out.println("Грузовик: " + i);
            for (int d = 1; d <= MAX_CONTAINERS_IN_CAR; d++) {
                System.out.println("\tКонтейнер: " + count);
                count++;
                for (int c = 1; c <= MAX_BOXES_IN_CONTAINERS; c++) {
                    System.out.println("\t\tЯщик: " + boxx);
                    boxx++;
                    boxes--;
                    if (boxes == 0) {
                        break;
                    }
                }
                if (boxes == 0){
                    break;
                }
            }
        }
    }

    public void logisticsCalculation(int boxes) {
        if (boxes != 0) {
            loadingIntoTheCar();
        }
    }

    public static void main(String[] args) {
        int boxes = new Scanner(System.in).nextInt();
        TrucksAndContainers flight = new TrucksAndContainers(boxes);
        flight.logisticsCalculation(boxes);
        System.out.println("Необходимо:" + "\n" + "грузовиков - " + flight.aCalculationOfTheNumberOfCars +
                " шт." + "\n" + "контейнеров - " + flight.calculationContainers(boxes) + " шт.");
    }
}
