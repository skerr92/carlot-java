import java.util.*;

public class CarLot {

    ArrayList<Car> cars = new ArrayList<>();

    public CarLot() {

    }
    //I couldn't get it to return properly using 'Car' as the method type
    public String find(String carID) {
        for (int i = 0; i < cars.size(); i++) {
            if (carID.equals(cars.get(i).getIdentifier())) {
                return cars.get(i).getIdentifier();
            }



        } return null;
    }
    public Car getCarSold(String a) {
        Car myCar = new Car();
        for (int i = 0; i < carlotSize();i++) {
            if (a.equals(cars.get(i).getIdentifier())) {
                cars.get(i).setSold(true);
                myCar = cars.get(i);

            }
        } return myCar;
    }
    public int carlotSize() {
        return cars.size();
    }
    //I couldn't get it to return properly using 'Car' as the method type
    public String get(int position) {

        return cars.get(position).listingToString();
    }

    public double getCarAverageMPG() {
        double averageMPG = 0;
        if (cars.size() != 0) {
            for (int i = 0; i < cars.size(); i++) {
                averageMPG = averageMPG + cars.get(i).getMPG();
            } return (averageMPG / cars.size());
        } return -1;
    }
    public String getCarHighestMilage() {
        double highestMileage = 0.0;
        Car resultCar = new Car();

        if (cars.size() != 0) {
            for (int i = 0; i < cars.size(); i++) {
                if (cars.get(i).getMilage() > highestMileage) {
                    highestMileage = cars.get(i).getMilage();
                    resultCar = cars.get(i);

                }
            }
        } return resultCar.getIdentifier();
    }
    public double getBestMPG() {
        double bestMPG = 0.0;
        if (cars.size() != 0) {
            for (int i = 0; i < cars.size(); i++) {
                if (cars.get(i).getMPG() > bestMPG) {
                    bestMPG = cars.get(i).getMPG();
                }
            }
        } return bestMPG;
    }
    public ArrayList<Car> sortByBestMPG() {
        ArrayList<Car> newCars = new ArrayList<>(cars.size());
        ArrayList<Car> newerCars = new ArrayList<>(cars.size());
        for (int i = 0; i < cars.size(); i++) {
            newCars.add(cars.get(i));
        }
        Collections.sort(newCars, Comparator.comparingDouble(Car::getMPG));
        for (int j = newCars.size(); j > 0; j--) {
            newerCars.add(newCars.get(j-1));
        }
        return newerCars;
    }
    public ArrayList<Car> sortByHighestPrice() {
        ArrayList<Car> newCars = new ArrayList<>(cars.size());
        ArrayList<Car> newerCars = new ArrayList<>(cars.size());
        for (int i = 0; i < cars.size(); i++) {
            newCars.add(cars.get(i));
        }
        Collections.sort(newCars, Comparator.comparingInt(Car::getPrice));
        for (int j = newCars.size(); j > 0; j--) {
            newerCars.add(newCars.get(j-1));
        }
        return newerCars;
    }

    public ArrayList<String> sortByBestMPGString() {
        ArrayList<String> newCars = new ArrayList<>(cars.size());
        ArrayList<Car> otherCars = new ArrayList<>(cars.size());
        for (int i = 0; i < cars.size(); i++) {
            otherCars.add(cars.get(i));
        }
        Collections.sort(otherCars, Comparator.comparingDouble(Car::getMPG));

        for (int j = otherCars.size(); j > 0; j--) {
            newCars.add(otherCars.get(j-1).listingToString());
        }
        return newCars;
    }
    public int getTotalMiles() {
        int totalMiles = 0;
        if (cars.size() != 0) {
            for (int i = 0; i < cars.size(); i++) {
                totalMiles = totalMiles + cars.get(i).getMilage();
            }
        } return totalMiles;
    }
    public boolean add(Car carToAdd) {
         if (!cars.add(carToAdd)) {
             return false;
        } return true;

    }
    public int getProfit() {
        int totalProfit = 0;
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).isSold() == true) {
                totalProfit = totalProfit + cars.get(i).getProfit();
            }
        } return totalProfit;
    }

    public String carlotToString() {
        return "There are " + carlotSize() + " Cars on the lot. " + getTotalMiles() + " total miles. "
                + getCarAverageMPG() + " is the average MPG. " + getCarHighestMilage() + " has the highest" +
                " miles";

    }

}