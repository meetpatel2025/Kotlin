package com.training.program2

import java.util.Scanner

fun main(){
    var num1 = Scanner(System.`in`)
    var num2 = Scanner(System.`in`)

    println("Enter first number : ")
    var n1 = num1.nextInt()
    println("Enter second number : ")
    var n2 = num1.nextInt()

    println("Before Swapping\n-------------------------")
    println("Number-1 = "+n1)
    println("Number-2 = "+n2)

    n1 = n1+n2 // 5 + 4 = 9
    n2 = n1-n2 // 9 - 4 = 5
    n1 = n1-n2 // 9 - 5 = 4

    println("\nAfter Swapping\n-------------------------")
    println("Number-1 = "+n1)
    println("Number-2 = "+n2)
}