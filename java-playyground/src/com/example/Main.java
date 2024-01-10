package com.example;

import com.example.collection.Collection;
import com.example.collection.List;
import com.example.newfeatures.Demo;
import com.example.newfeatures.DemoImplementation;
import com.example.newfeatures.Sample;
import com.example.newfeatures.SampleImplementation;
import com.example.shapes.Circle;
import com.example.shapes.Shape;
import com.example.shapes.Square;
import com.example.shapes.Triangle;

public class Main {
    public static void main(String[] args) {
//        Shape[] shapes = {
//                new Circle(),
//                new Square(),
//                new Triangle(),
//        };
//        for (Shape shape: shapes){
//            shape.draw();
//        }
//
//        Collection c = new List(9);
//        Util a = new Util("Billi");
//        a.printMessage();
//        Util b = new Util("Silli");
//        b.printMessage();
//        Util c = new Util("Milli");
//        c.printMessage();
//        System.out.println(Util.square(8));
//        System.out.println(Util.pi);

//        Sample s = new SampleImplementation();
//        s.foo();
//        s.bar();
//        Sample.baz();

        Demo d = new DemoImplementation();
        d.foo();
        d.bar();
    }
}