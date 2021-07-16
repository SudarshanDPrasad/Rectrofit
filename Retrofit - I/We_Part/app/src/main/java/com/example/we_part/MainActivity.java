    package com.example.we_part;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText mEtUserId;
    private Button mBtnCallApi;
    private TextView mTvFirstName;
    private TextView mTvLastName;
    private TextView mTvEmail;
    private TextView mtvlines;
    private ImageView mIvAvator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intitviews();
    }

    private void intitviews() {
        mBtnCallApi = findViewById(R.id.btnCallApi);
        mEtUserId = findViewById(R.id.etUserId);
        mTvFirstName = findViewById(R.id.tvfirstName);
        mTvLastName = findViewById(R.id.tvLastName);
        mTvEmail = findViewById(R.id.tvEmail);
        mIvAvator = findViewById(R.id.ivAvatar);
        mtvlines = findViewById(R.id.tvLines);

        mBtnCallApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiService apiService = Network.getInstance().create(ApiService.class);
                int userId = Integer.parseInt(mEtUserId.getText().toString());
                apiService.getUser(userId).enqueue(new Callback<ResponseResponseModel>() {
                    @Override
                    public void onResponse(Call<ResponseResponseModel> call, Response<ResponseResponseModel> response) {
                        ResponseResponseModel model = response.body();

                        String firstName = model.getData().getFirstName();
                        String lastName = model.getData().getLastName();
                        String email = model.getData().getEmail();
                        mTvFirstName.setText(firstName);
                        mTvLastName.setText(lastName);
                        mTvEmail.setText(email);
                        Glide.with(mIvAvator).load(model.getData().getAvatar()).into(mIvAvator);

                        SupportResponseModel supportResponseModel = model.getSupport();
                        String lines = model.getSupport().getText();
                        mtvlines.setText(lines);

                    }

                    @Override
                    public void onFailure(Call<ResponseResponseModel> call, Throwable t) {

                    }
                });
            }
        });
    }

}