package ie.gmit.segregation;

public class ToyPlane implements Toy, Flyable, Movable {
    double price;
    String color;

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void setColor(String color) {
        this.color=color;
    }

    @Override
    public void move()
    {
        //Plane can move left and right, forward and backwards
    }
    @Override
    public void fly(){
        //plane can fly up to 100 metres
    }
}