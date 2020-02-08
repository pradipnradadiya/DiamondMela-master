package com.dealermela.other.activity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;

import com.dealermela.DealerMelaBaseActivity;
import com.dealermela.R;
import com.dealermela.listing_and_detail.activity.ListAct;
import com.dealermela.listing_and_detail.activity.ProductDetailAct;
import com.dealermela.retrofit.APIClient;
import com.dealermela.retrofit.ApiInterface;
import com.dealermela.util.AppConstants;
import com.dealermela.util.AppLogger;
import com.dealermela.util.CommonUtils;
import com.dealermela.util.Validator;
import com.google.gson.JsonObject;
import com.ligl.android.widget.iosdialog.IOSDialog;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.dealermela.home.activity.MainActivity.customerId;

public class ContactUsAct extends DealerMelaBaseActivity implements View.OnClickListener {

    private TextInputLayout tilName, tilEmail, tilTelephone, tilComment;
    private TextInputEditText edName, edEmail, edTelephone, edComment;
    private Button btnSubmit;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.act_contact_us;
    }

    @Override
    public void init() {

    }

    @Override
    public void initView() {
        bindToolBar("Contact Us");
        tilName = findViewById(R.id.tilName);
        tilEmail = findViewById(R.id.tilEmail);
        tilTelephone = findViewById(R.id.tilTelephone);
        tilComment = findViewById(R.id.tilComment);
        btnSubmit = findViewById(R.id.btnSubmit);

        edName = findViewById(R.id.edName);
        edEmail = findViewById(R.id.edEmail);
        edTelephone = findViewById(R.id.edTelephone);
        edComment = findViewById(R.id.edComment);


    }

    @Override
    public void postInitView() {

    }

    @Override
    public void addListener() {
        btnSubmit.setOnClickListener(this);

        edName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    tilName.setErrorEnabled(false);
                }
            }
        });

        edEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {

                    tilEmail.setErrorEnabled(false);

                }
            }
        });

    }

    @Override
    public void loadData() {

    }

    private boolean validateData() {
        if (TextUtils.isEmpty(Objects.requireNonNull(edName.getText()).toString())) {
            tilName.setError("Please enter name.");
            tilName.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(Objects.requireNonNull(edEmail.getText()).toString())) {
            tilEmail.setError("Please enter email id.");
            tilEmail.requestFocus();
            return false;
        } else if (!Validator.checkEmail(edEmail)) {
            tilEmail.setError("Please enter valid email id.");
            tilEmail.requestFocus();
            return false;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSubmit:
                boolean valid = validateData();
                if (valid) {
                    AppLogger.e("valid", "-------");
                    addContactUs(Objects.requireNonNull(edName.getText()).toString(),edComment.getText().toString(),edEmail.getText().toString());
                } else {
                    AppLogger.e("not valid", "-------");
                }
                break;
        }
    }

    private void addContactUs(String name, String comment, String email) {
        showProgressDialog(AppConstants.PLEASE_WAIT);
        ApiInterface apiInterface = APIClient.getClient().create(ApiInterface.class);
        Call<JsonObject> callApi = apiInterface.contactUs(name,comment,email);
        callApi.enqueue(new Callback<JsonObject>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(@NonNull Call<JsonObject> call, @NonNull Response<JsonObject> response) {
                AppLogger.e(AppConstants.RESPONSE, "--------------" + response.body());
                hideProgressDialog();
                try {
                    assert response.body() != null;
                    JSONObject jsonObject = new JSONObject(response.body().toString());
                    if (jsonObject.getString("status").equalsIgnoreCase(AppConstants.STATUS_CODE_SUCCESS)) {

                        new IOSDialog.Builder(ContactUsAct.this)
                                .setTitle("Success")
                                .setMessage(jsonObject.getString("message"))
                                .setCancelable(false)
                                .setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();

                                        edName.setText("");
                                        edComment.setText("");
                                        edEmail.setText("");



                                    }
                                })
                                .show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(@NonNull Call<JsonObject> call, @NonNull Throwable t) {
                hideProgressDialog();
            }

        });
    }
}
