package com.training.libraryofalltopics.manifest;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.training.libraryofalltopics.R;
import com.training.libraryofalltopics.manifest.api.ApiService;

import java.util.List;

import retrofit2.Retrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;
//import retrofit2.converter.gson.GsonConverterFactory;

public class ManifestMainActivity extends AppCompatActivity {

private Button fetchBtn;
    private ProgressBar progressLoader;
    private TextView resultOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.manifest_activity_main);

        // 1. Initialize Views
        fetchBtn = findViewById(R.id.fetchBtn);
        progressLoader = findViewById(R.id.progressLoader);
        resultOutput = findViewById(R.id.resultOutput);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 2. Set Button Click Listener
        fetchBtn.setOnClickListener(v -> {
            if (NetworkUtils.isNetworkAvailable(this)) {
                makeAPICall();
            } else {
                showNoInternetDialog();
            }
        });
    }

    private void makeAPICall() {
        progressLoader.setVisibility(View.VISIBLE);
        resultOutput.setText("Fetching data...");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<UserData>> call = apiService.getPosts();

        call.enqueue(new Callback<List<UserData>>() {
            @Override
            public void onResponse(Call<List<UserData>> call, Response<List<UserData>> response) {
                progressLoader.setVisibility(View.GONE);

                if (response.isSuccessful() && response.body() != null && !response.body().isEmpty()) {
                    String firstTitle = response.body().get(0).getTitles();
                    String body = response.body().get(0).getBody();
                    resultOutput.setText("First Post Title:\n" + firstTitle + "\n\n Body : \n"+body);
                } else {
                    resultOutput.setText("Response empty or unsuccessful.");
                }
            }

            @Override
            public void onFailure(Call<List<UserData>> call, Throwable t) {
                progressLoader.setVisibility(View.GONE);
                resultOutput.setText("Error: " + t.getMessage());
            }
        });
    }

    private void showNoInternetDialog() {
        new AlertDialog.Builder(this)
                .setTitle("No Internet")
                .setMessage("Please check your connection and try again.")
                .setPositiveButton("Cancel", (dialog, which) -> dialog.dismiss())
                .setNegativeButton("Enable Internet", ((dialog, which) -> {
                    this.startActivity(new Intent(Settings.ACTION_WIRELESS_SETTINGS));
                }))
                .setCancelable(false)
                .show();
    }
}
