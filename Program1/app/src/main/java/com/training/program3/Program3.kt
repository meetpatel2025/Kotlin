package com.training.program3

import java.util.Scanner

fun main(){
    var txt = Scanner(System.`in`)
    println("Enter any String : ")
    var input = txt.nextLine()

    count(input)
}

fun count(text: String) {

    var ch = text.toCharArray()
    var char = 0
    var number = 0
    var space = 0
    var others = 0

    for(c in ch.withIndex()){
        if(Character.isLetter(c.value)){
            char++
        }else if(Character.isDigit(c.value)){
            number++
        }else if(Character.isSpaceChar(c.value)){
            space++
        }else{
            others++
        }
    }

    println("Characters : "+char+"\nDigits : "+number+"\nSpaces :"+space+"\nOther :"+others)
}
