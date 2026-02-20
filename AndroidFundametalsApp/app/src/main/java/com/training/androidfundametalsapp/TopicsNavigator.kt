package com.training.androidfundametalsapp

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast


fun openLegacyActivity(context: Context, filePath: String) {
    try {
        val file = Class.forName(filePath)
        val intent = Intent(context, file)
        context.startActivity(intent)
//    } catch (cnf: ClassNotFoundException) {
//        Toast.makeText(context, "Screen not found:\n$filePath", Toast.LENGTH_LONG).show()
//    } catch (anf: ActivityNotFoundException) {
//        Toast.makeText(context, "Cannot open activity:\n$filePath", Toast.LENGTH_LONG).show()
    } catch (e: Exception) {
        println(e.printStackTrace())
        Toast.makeText(context, "Error while opening screen:\n${e.message}", Toast.LENGTH_LONG).show()
    }
}
