package org.example.task1.PointAdventure;

public class Point implements Movable{

    private int x;
    private int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    @Override
    public void moveDown() {
        setY(getY() - 1);
        System.out.println("Сдвигаем точку на 1 клетку вниз. Текущие координаты " + "y = "+ y +" x = " + x );

    }

    @Override
    public void moveUp() {
        setY(getY() + 1);
        System.out.println("Сдвигаем точку на 1 клетку вверх. Текущие координаты " + "y = "+ y +" x = " + x );
    }

    @Override
    public void moveLeft() {
        setX(getX() - 1);
        System.out.println("Сдвигаем точку на 1 клетку влево. Текущие координаты " + "y = "+ y +" x = " + x );
    }

    @Override
    public void moveRight() {
        setX(getX()+1);
        System.out.println("Сдвигаем точку на 1 клетку вправо. Текущие координаты " + "y = "+ y +" x = " + x );
    }

    @Override
    public void pointNow(){
        System.out.println( "Точка стоит на месте " + "y = "+ y +" x = " + x);
    }
}
