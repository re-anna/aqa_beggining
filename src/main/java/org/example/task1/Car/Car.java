package org.example.task1.Car;

public class Car implements Drivable{
    private String brand;
    private String model;
    private int carRelease;

    public Car(String brand, String model, int carRelease){
        this.brand = brand;
        this.model = model;
        this.carRelease = carRelease;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }
    public void setModel(String model){
        this.model = model;
    }
    public void setCarRelease(int carRelease){
        this.carRelease = carRelease;
    }

    public String getBrand(){
        return this.brand;
    }
    public String getModel(){
        return this.model;
    }

    public int getCarRelease() {
        return this.carRelease;
    }


    @Override
    public void carStart() {
        System.out.println("Автомобиль " + getBrand()+ " " + getModel() + " " + getCarRelease() + " года выпуска начал движение");
    }

    @Override
    public void carStop() {
        System.out.println("Автомобиль " + getBrand()+ " " + getModel() + " " + getCarRelease() + " года выпуска совершил остановку");

    }

    @Override
    public void carDrive(double distance) {
        System.out.println("Автомобиль проехал " + distance + "км.");


    }

}
