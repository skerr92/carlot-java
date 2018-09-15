import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class CarLotMain {
    public static void main(String[] args) {
        CarLot myNewCarlot = new CarLot();
        ArrayList<Car> myBestMPGCars = new ArrayList<>();
        myBestMPGCars = myNewCarlot.sortByBestMPG();
        Car aNewCar = new Car();
        WidgetViewer newCarlot = new WidgetViewer(1000, 600);
        JLabel newCarName = new JLabel("new car id");
        JTextField newCarNameField = new JTextField();
        JLabel newCarMileage = new JLabel("new car mileage");
        JTextField newCarMileageField = new JTextField();
        JLabel newCarMPG = new JLabel("MPG");
        JTextField newCarMPGField = new JTextField();
        JLabel newCarCost = new JLabel("new car cost");
        JTextField newCarCostField = new JTextField();
        JLabel newCarPrice = new JLabel("new car price");
        JTextField newCarPriceField = new JTextField();
        JButton makeNewCarButton = new JButton("make a new car");
        JLabel bestMPG = new JLabel("[best MPG none]");
        JLabel highestMileage = new JLabel("[highest mileage none]");
        JLabel fleetAVGMPG = new JLabel("[fleet avg MPG - 1.0]");
        JLabel soldCarID = new JLabel("Sold Car ID");
        JTextField soldCarField = new JTextField();
        JButton recordSaleButton = new JButton("Press to record sale");
        JLabel carlotProfit = new JLabel("profit: 0");
        JTextArea carLot = new JTextArea("Carlot as entered");
        JTextArea carlotMPG = new JTextArea("Carlot by MPG");
        JButton sortHighestPrice = new JButton("Sort by Highest Price");
        JButton sortLowestPrice = new JButton("Sort by Lowest Price");

        newCarlot.add(newCarName, 8, 8, 100, 25);
        newCarlot.add(newCarNameField, 120, 8, 100, 25);
        newCarlot.add(newCarMileage, 228, 8, 120, 25);
        newCarlot.add(newCarMileageField, 346, 8, 100, 25);
        newCarlot.add(newCarMPG, 454, 8, 100, 25);
        newCarlot.add(newCarMPGField, 522, 8, 100, 25);
        newCarlot.add(soldCarID, 730, 8, 100, 25);
        newCarlot.add(soldCarField, 838, 8, 100, 25);
        newCarlot.add(newCarCost, 8, 42, 100, 25);
        newCarlot.add(newCarCostField, 120, 42, 100, 25);
        newCarlot.add(newCarPrice, 228, 42, 100, 25);
        newCarlot.add(newCarPriceField, 346, 42, 100, 25);
        newCarlot.add(recordSaleButton, 730, 42, 200, 25);
        newCarlot.add(makeNewCarButton, 8, 80, 175, 25);
        newCarlot.add(bestMPG, 8, 115, 125, 25);
        newCarlot.add(highestMileage, 228, 115, 150, 25);
        newCarlot.add(fleetAVGMPG, 454, 115, 150, 25);
        newCarlot.add(carlotProfit, 730, 115, 125, 25);
        newCarlot.add(carLot, 8, 150, 700, 200);
        newCarlot.add(sortHighestPrice, 730, 150, 200,25);
        newCarlot.add(sortLowestPrice, 730, 200, 200, 25);
        newCarlot.add(carlotMPG, 8, 360, 700, 200);

        newCarAdded addANewCar = new newCarAdded(myNewCarlot,newCarNameField, newCarMileageField, newCarPriceField, newCarMPGField, newCarCostField, carLot, bestMPG, highestMileage, fleetAVGMPG, carlotMPG, aNewCar, myBestMPGCars);
        carIsSold soldACar = new carIsSold(soldCarField, myNewCarlot, carLot, carlotMPG, carlotProfit);

        sortHighest sortHighstCarPrice = new sortHighest(myNewCarlot, carlotMPG);
        sortLowest sortLowestCarPrice = new sortLowest(myNewCarlot, carlotMPG);

        makeNewCarButton.addActionListener(addANewCar);
        recordSaleButton.addActionListener(soldACar);
        sortLowestPrice.addActionListener(sortLowestCarPrice);
        sortHighestPrice.addActionListener(sortHighstCarPrice);


    }
    //creates new car objects to add to myNewCarLot
    static class newCarAdded extends WidgetViewerActionEvent {

        private CarLot myNewCarlot;

        private ArrayList<Car> myBestMPGLot = new ArrayList<>();
        private JTextField carIDField;
        private JTextField carMileageField;
        private JTextField carPriceField;
        private JTextField carMPGField;
        private JTextField carCostField;
        private JTextArea carlotArea;
        private JLabel updateBestMPG;
        private JLabel updateHighestMileage;
        private JLabel updateFleetAvgMPG;
        private JTextArea updateBestCarlotMPG;


        public newCarAdded(CarLot cars,JTextField a, JTextField b, JTextField c, JTextField d, JTextField e, JTextArea f, JLabel g, JLabel h, JLabel i, JTextArea j, Car k, ArrayList<Car> l) {
            myNewCarlot = cars;
            carIDField = a;
            carMileageField = b;
            carPriceField = c;
            carMPGField = d;
            carCostField = e;
            carlotArea = f;
            updateBestMPG = g;
            updateHighestMileage = h;
            updateFleetAvgMPG = i;
            updateBestCarlotMPG = j;
            myBestMPGLot = l;

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //Check to see if any of the text fields is empty.
            if (carIDField.getText().isEmpty() || carMileageField.getText().isEmpty() || carMPGField.getText().isEmpty()
                    || carCostField.getText().isEmpty() || carPriceField.getText().isEmpty()) {
                updateBestCarlotMPG.setText("One or more of the fields is empty. Please try again!");

            }
            //Continue if check statement returns false.

            Car newCar = new Car();

            newCar.setIdentifier(carIDField.getText());
            newCar.setMilage(Integer.parseInt(carMileageField.getText()));
            newCar.setPrice(Integer.parseInt(carPriceField.getText()));
            newCar.setMPG(Double.parseDouble(carMPGField.getText()));
            newCar.setCost(Integer.parseInt(carCostField.getText()));
            newCar.setSold(false);
            myNewCarlot.add(newCar);

            carlotArea.append("\n" + newCar.listingToString());
            myBestMPGLot = myNewCarlot.sortByBestMPG();

            System.out.println(myNewCarlot.sortByBestMPGString());

            updateBestCarlotMPG.setText("Carlot by MPG: ");

            for (int i = 0; i < myNewCarlot.carlotSize(); i++) {
                    updateBestCarlotMPG.append("\n" + myBestMPGLot.get(i).listingToString());
            }



            carIDField.setText("");
            carMileageField.setText("");
            carPriceField.setText("");
            carMPGField.setText("");
            carCostField.setText("");
            updateBestMPG.setText("best MPG: " + myNewCarlot.getBestMPG());
            updateHighestMileage.setText("highest mileage: " + myNewCarlot.getCarHighestMilage());
            updateFleetAvgMPG.setText("fleet avg MPG: " + myNewCarlot.getCarAverageMPG());


        }

    }
    static class carIsSold extends WidgetViewerActionEvent {

        private Car carSold = new Car();
        private JTextArea myCarLot;
        private CarLot myNewCarLot = new CarLot();
        private ArrayList<Car> myBestMPGLot = new ArrayList<>();
        private JTextArea bestMPGLot;
        private JTextField soldCarField;
        private JLabel updateProfit;


        public carIsSold(JTextField a, CarLot b, JTextArea c, JTextArea d, JLabel e) {
            soldCarField = a;
            myNewCarLot = b;
            myCarLot = c;
            bestMPGLot = d;
            updateProfit = e;
        }


        @Override
        public void actionPerformed(ActionEvent e) {

            //Check to see if soldCarField is empty or if it exists in myNewCarLot
            if (soldCarField.getText().isEmpty()) {
                bestMPGLot.setText("No Car Entered");

                for (int i = 0; i < myNewCarLot.carlotSize(); i++) {
                    if (!soldCarField.getText().equals(myNewCarLot.get(i))) {
                        bestMPGLot.setText("No Car Found");
                    }
                }
            }
            //Continues on if soldCarField check comes back negative.
            myNewCarLot.getCarSold(soldCarField.getText());
            myBestMPGLot = myNewCarLot.sortByBestMPG();

            System.out.println(myNewCarLot.sortByBestMPGString());
            myCarLot.setText("Carlot as entered ");
            for (int i = 0; i < myNewCarLot.carlotSize(); i++) {
                myCarLot.append("\n" + myNewCarLot.get(i));
            }
            bestMPGLot.setText("Carlot by MPG: ");

            for (int i = 0; i < myNewCarLot.carlotSize(); i++) {
                bestMPGLot.append("\n" + myBestMPGLot.get(i).listingToString());
            }

            soldCarField.setText("");
            updateProfit.setText("profit: " + myNewCarLot.getProfit());


        }

    }
    //Created a way to sort highest and lowest priced cars on the lot
    static class sortHighest extends WidgetViewerActionEvent {
        private JTextArea newTextArea;
        private CarLot sortedCarlot = new CarLot();
        private ArrayList<Car> highestPrices = new ArrayList<>();

        public sortHighest(CarLot a, JTextArea b) {
            sortedCarlot = a;
            newTextArea = b;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            highestPrices = sortedCarlot.sortByHighestPrice();

            newTextArea.setText("Carlot Sorted by Highest Price ");

            for (int i = 0; i < sortedCarlot.carlotSize(); i++) {
                newTextArea.append("\n" + highestPrices.get(i).listingToString());
            }
        }
    }
    static class sortLowest extends WidgetViewerActionEvent {
        private JTextArea newTextArea;
        private CarLot sortedCarlot = new CarLot();
        private ArrayList<Car> lowestPrices = new ArrayList<>();

        public sortLowest(CarLot a, JTextArea b) {
            sortedCarlot = a;
            newTextArea = b;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            lowestPrices = sortedCarlot.sortByHighestPrice();

            newTextArea.setText("Carlot Sorted by Lowest Price ");

            for (int i = sortedCarlot.carlotSize(); i > 0; i--) {
                newTextArea.append("\n" + lowestPrices.get(i-1).listingToString());
            }
        }
    }
}
