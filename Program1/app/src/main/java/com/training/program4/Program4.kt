package com.training.program4

import java.util.Scanner

fun main(){
    var scanner = Scanner(System.`in`)
    println("Enter any String here : ")
    var originalText = scanner.nextLine().toCharArray()
    var reverse = ""
    for(i in originalText.size-1 downTo 0){
        reverse += originalText[i]
    }

    println("Reverse String = "+reverse)

}
