package com.dee.rentalmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dee.rentalmanagement.Fragment.BuyFragment;
import com.dee.rentalmanagement.Fragment.SellFragment;
import com.google.android.material.tabs.TabLayout;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {
private Button btnSell, btnBuy, btnMore;
    private boolean status = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btnBuy =findViewById(R.id.btnBuy);
        btnSell = findViewById(R.id.btnSell);
        btnMore = findViewById(R.id.btnMore);

        btnBuy.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getSupportFragmentManager();
FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
        if (status){
              BuyFragment buyFragment =new BuyFragment();
              fragmentTransaction.replace(R.id.FragmentContainer,buyFragment);
            //fragmentTransaction.add(R.id.FragmentContainer,buyFragment);
            fragmentTransaction.commit();
              btnBuy.setText("Buy");
              status= false;
        }
        else {
            SellFragment sellFragment = new SellFragment();
            fragmentTransaction.replace(R.id.FragmentContainer,sellFragment);
            fragmentTransaction.commit();
            btnSell.setText("Sell");
            status =true;
        }


        }
}
