/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figure;

/**
 *
 * @author rolandcarter
 */
class Circle {
    private double radius;
     
    public Circle(double r){
        radius = r;
    }
     
    public void setRadius(double radius) {
          this.radius = radius;
    }
     
    public double getRadius() {
        return radius;
    }
    
     @Override
    public String toString(){
        return String.format("radius: %s", radius);
    }
}

public class Cone extends Circle {
    private double height;

    public Cone(double height, double r) {
        super(r);
        this.height = height;
    }

     
     
    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }
    
    @Override
    public String toString(){
        return String.format("height: %s\nradius: %s", height, super.getRadius());
    }
}

