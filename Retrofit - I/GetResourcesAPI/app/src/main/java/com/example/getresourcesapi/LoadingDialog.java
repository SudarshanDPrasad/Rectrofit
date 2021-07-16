package com.example.getresourcesapi;

import android.app.AlertDialog;
import android.view.LayoutInflater;

public class LoadingDialog {
    private MainActivity activity;
    private AlertDialog dialog;

    public LoadingDialog(MainActivity activity) {
        this.activity = activity;
    }


    public void startLoadingAnimation(){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.loader,null));
        builder.setCancelable(true);
        dialog = builder.create();
        dialog.show();
    }
    public void dissmissDialog(){
        dialog.dismiss();
    }
}
