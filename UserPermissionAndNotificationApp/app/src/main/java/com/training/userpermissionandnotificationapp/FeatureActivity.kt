package com.training.userpermissionandnotificationapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FeatureActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_FEATURE_ID = "extra_feature_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature)

        val tv = findViewById<TextView>(R.id.tvFeature)
        val featureId = intent.getStringExtra(EXTRA_FEATURE_ID) ?: "(none)"
        tv.text = "Opened Feature Page for: $featureId"
    }

}