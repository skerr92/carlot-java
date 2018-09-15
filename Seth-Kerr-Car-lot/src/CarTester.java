public class CarTester {
    public static void main(String[] args) {
        System.out.println("Enter a car identifier: ");
        String carID = "1963 Ford Falcon";
        int miles = 100000;
        double mpg = 14.0;
        int cost = 6000;
        int price = 13995;

        Car newCar = new Car();
        newCar.CarID(carID);
        newCar.Car(carID, miles, mpg, cost, price);
        newCar.setSold(false);

        System.out.println("Fist car");
        System.out.println(newCar.listingToString());
        System.out.println("The cost is " + newCar.getCost());
        System.out.println("The profit if it's sold is: " + newCar.getProfit());
        System.out.println("The Milage is: " + newCar.getMilage());
        System.out.println("adding 500 more miles gives us: " + newCar.addMiles(2000));
        System.out.println();


        String carID2 = "2015 Ford Mustang";
        int miles2 = 25000;
        double mpg2 = 25.0;
        int cost2 = 23000;
        int price2 = 33995;

        Car newCar2 = new Car();
        newCar2.CarID(carID2);
        newCar2.Car(carID2, miles2, mpg2, cost2, price2);
        newCar2.setSold(true);

        System.out.println("Second Car");
        System.out.println(newCar2.listingToString());
        System.out.println("The cost is " + newCar2.getCost());
        System.out.println("The profit if it's sold is: " + newCar2.getProfit());
        System.out.println("The Milage is: " + newCar2.getMilage());
        System.out.println("adding 500 more miles gives us: " + newCar2.addMiles(500));
        System.out.println("Comparing miles and milage");
        System.out.println(newCar.compareMiles(newCar.carMiles, newCar2.carMiles));
        System.out.println(newCar2.compareMPG(newCar.carMilesPerGallon, newCar2.carMilesPerGallon));

    }
}
