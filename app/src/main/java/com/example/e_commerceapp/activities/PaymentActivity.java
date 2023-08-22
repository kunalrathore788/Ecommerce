package com.example.e_commerceapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.e_commerceapp.databinding.ActivityPaymentBinding;
import com.example.e_commerceapp.utilits.Constants;

public class PaymentActivity extends AppCompatActivity {

    ActivityPaymentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPaymentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String orderCode = getIntent().getStringExtra("orderCode");

        binding.webview.setMixedContentAllowed(true);
        binding.webview.loadUrl(Constants.PAYMENT_URL + orderCode);

    }
}