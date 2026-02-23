package com.training.libraryofalltopics.permissions

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.training.libraryofalltopics.R

class FeatureActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_FEATURE_ID = "extra_feature_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.permission_activity_feature)

        val tv = findViewById<TextView>(R.id.tvFeature)
        val featureId = intent.getStringExtra(EXTRA_FEATURE_ID) ?: "(none)"
        tv.text = "Opened Feature Page for: $featureId"
    }

}