package com.dealermela.authentication.myaccount.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.dealermela.R;
import com.dealermela.home.activity.MainActivity;

public class SuccessOrderDialogClass extends Dialog implements View.OnClickListener {

    private final Activity activity;
    private String message;

    public SuccessOrderDialogClass(Activity activity, String message) {
        super(activity);
        // TODO Auto-generated constructor stub
        this.activity = activity;
        this.message=message;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_success_msg);
        Button btnOk = findViewById(R.id.btnOk);
        TextView tvMsg = findViewById(R.id.tvMsg);
        tvMsg.setText(message);
        btnOk.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnOk:
                Intent intent=new Intent(activity,MainActivity.class);
                activity.startActivity(intent);
                activity.finishAffinity();
                break;

            default:
                break;
        }
        dismiss();
    }


}
