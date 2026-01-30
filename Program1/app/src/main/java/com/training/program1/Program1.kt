package com.training.program1

import java.util.Scanner

fun main(){
    println("Ram Ram")

    // Program-1

    var num1 = Scanner(System.`in`)
    var num2 = Scanner(System.`in`)

    println("Enter first number : ")
    var n1 = num1.nextDouble()
    println("Enter second number : ")
    var n2 = num2.nextDouble()

    var divisionResult = n1/n2;
    var moduloResult = n1%n2;

    println(" Result\n Division of $n1 / $n2 = "+divisionResult+ "\n Reminder of $n1 % $n2 = "+moduloResult)


}