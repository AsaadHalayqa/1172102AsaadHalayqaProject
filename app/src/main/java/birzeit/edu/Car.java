package birzeit.edu;

public class Car {

    //data fields
    private String year;
    private String make;
    private String model;
    private String distance;
    private String price;
    private String accidents;

    //default constructor
    public Car() {
    }

    //constructor with parameter
    public Car(String year, String make, String model, String distance, String price, String accidents) {

        this.year = year;
        this.make = make;
        this.model = model;
        this.distance = distance;
        this.price = price;
        this.accidents = accidents;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAccidents() {
        return accidents;
    }

    public void setAccidents(String accidents) {
        this.accidents = accidents;
    }

    @Override
    public String toString() {
        return "Car{" +
                "year='" + year + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", distance='" + distance + '\'' +
                ", price='" + price + '\'' +
                ", accidents='" + accidents + '\'' +
                '}';
    }
}
