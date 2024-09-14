package org.example.task1;

import org.example.task1.Bank.BankAccount;
import org.example.task1.Book.Book;
import org.example.task1.Car.Car;
import org.example.task1.Clock.Time;
import org.example.task1.PointAdventure.Point;
import org.example.task1.University.Students;

public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
        account1.setBalance(8000);
        account1.print();


        Book book1 = new Book();
        book1.setBookName("lice’s Adventures in Wonderland");
        book1.setAuthor("Льюис Кэрролл");
        book1.setBookRelease(1865);
        book1.displayBook();

        Students student1 = new Students();
        student1.setStudentName("Billy Jean");
        student1.setStudentNumber(665);
        student1.setAverageRate(5);
        student1.printable();

        Point point1 = new Point(0,0);
        point1.pointNow();
        point1.moveDown();
        point1.moveRight();
        point1.moveRight();
        point1.moveRight();
        point1.moveUp();
        point1.moveLeft();
        point1.pointNow();

        Time day1 = new Time(23, 59, 59);
        day1.readTime();
        day1.tick();
        day1.readTime();

        Car car1 = new Car("Mercedes", "E 400 4MATIC", 2016);
        car1.carStart();
        car1.carDrive(10);
        car1.carStop();


    }

    }