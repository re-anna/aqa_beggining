package org.example.task1.Clock;

public class Time implements Readable{

    private int hour;
    private int minutes;
    private int seconds;

    public Time(int hour, int minutes, int seconds){
        this.hour = hour;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public void setHour(int hour){
        this.hour = hour;
    }

    public void setMinutes(int minutes){
        this.minutes = minutes;
    }

    public void setSeconds(int seconds){
        this.seconds = seconds;
    }

    public int getHour(){
        return this.hour;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public int getSeconds(){
        return this.seconds;
    }

    public void tick() {
        seconds++;
        calculateTickLogic();
    }

    public void calculateTickLogic() {
        if (seconds == 60) {
            seconds = 0;
            minutes++;
        }

        if (minutes == 60) {
            minutes = 0;
            hour++;
        }

        if (hour == 24) {
            hour = 0;
        }
    }

    @Override
    public void readTime() {
        System.out.println("Teкущее время "+ getHour() + " часов " + getMinutes() + " минут " + getSeconds() + " секунд.");

    }
}
