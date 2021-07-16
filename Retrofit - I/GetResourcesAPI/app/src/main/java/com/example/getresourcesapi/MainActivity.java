package com.example.getresourcesapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText metUserId;
    private Button mbtnclick;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final LoadingDialog loadingDialog = new LoadingDialog(this);
        initviews();
        mbtnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingDialog.startLoadingAnimation();
                ApiService();

            }
        });
    }

    private void initviews() {
        mbtnclick = findViewById(R.id.btnCallApi);
        metUserId = findViewById(R.id.etUserId);
    }

    public void ApiService() {
        ApiService apiService = Network.getInstance().create(ApiService.class);
        int userId = Integer.parseInt(metUserId.getText().toString());
        apiService.getUser(userId).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                ResponseModel model = response.body();

                String firstname = model.getData().getName();
                String year = model.getData().getYear() + " ";
                String company = model.getData().getPantoneValue();
                String colour = model.getData().getColor();
                intent.putExtra("userid",metUserId.getText().toString());
                intent.putExtra("firstname",firstname);
                intent.putExtra("year",year);
                intent.putExtra("company",company);
                intent.putExtra("colour",colour);


                startActivity(intent);
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });
    }
}