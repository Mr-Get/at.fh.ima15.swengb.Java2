package fh.java.geometry;

import fh.java.geometry.model.GeometricShape;
import fh.java.geometry.model.curved.Circle;
import fh.java.geometry.model.quadrilateral.Rectangle;
import fh.java.geometry.model.trilateral.RightTriangle;


import java.util.*;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {

        Main main = new Main();
        main.doIt();

    }

    private void doIt() {

        List<GeometricShape> shapeList = new ArrayList<>();

        fillList(shapeList);

        printList(shapeList);

        List<Circle> circleList = new ArrayList<>();

        for (GeometricShape shape : shapeList) {
            if (shape instanceof Circle) {
                circleList.add((Circle)shape);
            }
        }

        System.out.println("-------------------------------------------");
        for (Circle circle : circleList) {
            System.out.println(circle);
        }

    }


    public void fillList(List<GeometricShape> shapeList) {

        shapeList.add(new Circle(1,2,3.0));
        shapeList.add(new Circle(1,2,3.1));
        shapeList.add(new Circle(1,4,3.0));
        shapeList.add(new Circle(3,2,3.0));

        shapeList.add(new Rectangle(2,4,5.0,2.2));
        shapeList.add(new Rectangle(1,4,3.0,2.5));
        shapeList.add(new Rectangle(3,4,5.0,2.7));
        shapeList.add(new Rectangle(3,8,5.0,2.0));

        shapeList.add(new RightTriangle(55,44,3.3,4.4));

    }


    public void printList(List<GeometricShape> shapeList) {
        // print everything in the list

        System.out.println("--------------- for ----------------");
        //worst possible solution
        for (int pos = 0; pos < shapeList.size(); pos++) {
            System.out.println(shapeList.get(pos));
        }

        System.out.println("--------------- for each ----------------");
        // better Version
        for (GeometricShape shape : shapeList) {
            System.out.println(shape);
        }

        System.out.println("--------------- stream 1 ----------------");
        // BEST VERSION -- map and reduce  - high performance
        shapeList.stream()
                .forEach(shape -> System.out.println(shape));

        System.out.println("--------------- stream 2 ----------------");
        // extension to last version
        shapeList.stream().forEach(System.out::println);

    }

}
