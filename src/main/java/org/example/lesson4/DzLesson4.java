package org.example.lesson4;

import io.netty.channel.epoll.Epoll;

public class DzLesson4 {

    public double SquareTriangle(int a, int b, int c) throws MyException
    {
        if(a<0 || b<0|| c<0) throw new MyException("Введены неположительные длины сторон стреугольника");
        if(a+b<c || b+c<a || a+c<b) throw new MyException("Треугольника с введенными сторонами не существует");
        double polPerimeter=(a+b+c)/2;
        return Math.sqrt(polPerimeter*(polPerimeter-a)*(polPerimeter-b)*(polPerimeter-c));

    }

}
