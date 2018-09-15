public class Car {

    String carID = null;
    int carMiles = 0;
    double carMilesPerGallon = 0.0;
    int costToAcquire = 0;
    int sellingCost = 0;
    boolean carSold = false;
    int carProfit = 0;

    Car() {

    }

    public String CarID(String theName) {
        carID = theName;
        return carID;
    }

    public void Car(String theName, int numMiles, double mileage, int myCost, int sellPrice) {
        carID = theName;
        carMiles = numMiles;
        carMilesPerGallon = mileage;
        costToAcquire = myCost;
        sellingCost = sellPrice;


    }

    //Accessors

    public String getIdentifier() {
        return carID;
    }

    public int getCost() {
        return costToAcquire;
    }

    public int getMilage() {
        return carMiles;
    }

    public double getMPG() {
        return carMilesPerGallon;
    }

    public int getPrice() {
        return sellingCost;
    }

    public boolean isSold() {
        return carSold;
    }

    public int getProfit() {

        if (carSold == true) {

            return sellingCost - costToAcquire;
        }
        return 0;


    }
    public double compareMPG(double car, double otherCar) {
       if ((car - otherCar) < 0) {
           return car - otherCar;
       } else if ((car - otherCar) > 0) {
           return car - otherCar;
       } return 0;
    }
    public int compareMiles(int car, int otherCar) {
        if ((car - otherCar) < 0) {
            return car - otherCar;
        } else if ((car - otherCar) > 0) {
            return car - otherCar;
        } return 0;
    }
    public String listingToString() {
        if (!carSold) {
            return "Car id=" + carID + ", milage=" +
                    carMiles + ", mpg=" + carMilesPerGallon + ", cost=" + costToAcquire
                    + ", price=" + sellingCost + ", is not sold";
        } return "Car id=" + carID + ", milage=" +
                carMiles + ", mpg=" + carMilesPerGallon + ", cost=" + costToAcquire
                + ", price=" + sellingCost + ", is sold, profit=" + (sellingCost - costToAcquire);
    }


    //Mutators

    public String setIdentifier(String newID) {
        carID = newID;
        return carID;
    }
    public void setCost(int newCost) {
        costToAcquire = newCost;
        //return costToAcquire;
    }
    public int setMilage(int newMilage) {
        carMiles = newMilage;
        return carMiles;

    }
    public double setMPG(double newMPG) {
        carMilesPerGallon = newMPG;
        return carMilesPerGallon;
    }
    public int setPrice(int newPrice) {
        sellingCost = newPrice;
        return sellingCost;
    }
    public boolean setSold(boolean soldValue) {
        carSold = soldValue;
        return carSold;
    }
    public int addMiles(int milesToAdd) {
        carMiles = (carMiles + milesToAdd);
        return carMiles;
    }


}
