package com.revivable.hydrogen.controller;

import java.text.DecimalFormat;
import java.util.function.Consumer;
import java.util.function.Function;

public class LambdaController {
    public static void main(String[] args) {
        InnerClass inner = new InnerClass(99999);

        inner.printCount(i -> new DecimalFormat("#,###").format(i));

        new Thread(() -> System.out.println(111)).start();

        Function<Integer,String> func = i -> new DecimalFormat("#,###").format(i);
        Consumer<Function<Integer,String>> consumer = inner::printCount;
        consumer.accept(func);
    }
}

class InnerClass{
    Integer count;

    InnerClass(Integer count){
        this.count = count;
    }

    public void printCount(Function<Integer,String> moneyFormat){
        System.out.println("这个数字是："+moneyFormat.apply(this.count));
    }
}