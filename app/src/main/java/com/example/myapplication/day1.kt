package com.example.myapplication

import java.security.KeyStore.TrustedCertificateEntry

fun main(){
    //java -> system.out.println()
    //kotlin
    println("Hello World");
    //mutable
    var name = "Lucifer"
    name = "ankit";
    println(name);

    //immutable
    var age = 20;


    // java -> String name = "Lucifer";
    var name1 : String  = "Lucifer"
    var age1 : Int = 10;
    var terms : Boolean = false;

    println("My name is ${name1.uppercase()}");

    //
    var data = arrayOf("Lucifer","Ram","Shyam")
    println("1st element is ${data[0]}");
    println("1st element is ${data[1]}");
    println("1st element is ${data[2]}");

    //array list
    var students = arrayListOf("Lucifer","Ram")
    var students1 = arrayListOf<Any>("Lucifer","Ram",12,true,10.5);
    var age2 = ArrayList<Int>();
    students.add("Shyam");

    var lst = listOf("Lucifer");
    var lst1 = mutableListOf("Ankit");

    //map -> keys ra value ko form ma

    var dictionary = mutableMapOf(
        "cat" to "This is animal",
        "RoyalEnfield" to " This is bike",
        "apple" to "This is fruit"
    )


    println("Enter any world")
    var input : String = readln()
    println(dictionary[input]);

    println("Enter day of week");
    var dayOfWeek : Int = readln().toInt();
    var day : String

    when(dayOfWeek){
        1 -> day = "Sunday"
        2 -> day = "Monday"
        3 -> day = "Tuesday"

        else -> day = "Invalid option"
    }

    println(day)

    // for loop
    for (i in 0 until 5) {
        println(i);
    }
    for (i in 0 .. 5){
        println(i);
    }

    //function
    fun calculate(a : Int, b : Int) : Int{
        return a+b;
    }
    calculate(10,20);
}