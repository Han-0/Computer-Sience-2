/**
 * Project: Car DB
 * @Author: Justin Fulner
 * Date: December, 2018
 **/

public class Car {

    private String make, model, year, color, license;

    public Car() {
        make = "";
        model = "";
        year = "";
        color = "";
        license = "";
    }

    public Car(String make, String model, String year, String color, String license) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.license = license;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getYear() {
        return year;
    }

    public int getYearInt() {
        return Integer.parseInt(year);
    }

    public String getLicense() {
        return license;
    }

    public String toString() {
        return "Make: " + make + "\r\nModel: " + model + "\r\nYear: " + year + "\r\nColor: " + color +
                "\r\nLicense#: " + license;
    }
}