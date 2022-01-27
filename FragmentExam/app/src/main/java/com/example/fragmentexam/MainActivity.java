package com.example.fragmentexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.fragmentexam.ui.dashboard.DashboardFragment;
import com.example.fragmentexam.ui.home.HomeFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager2 viewPager2;
    private Button btnAdd, btnReplace;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        this.viewPager2 = (ViewPager2) findViewById(R.id.viewpager2);
//        this.viewPager2.setAdapter(adapter);
//        this.viewPager2.setPageTransformer(new ZoomOutPageTransformer());
        this.btnAdd = findViewById(R.id.btnAdd);
        this.btnReplace = findViewById(R.id.btnReplace);
        btnAdd.setOnClickListener(this);
        btnReplace.setOnClickListener(this);
        FragmentExamStateAdapter adapter = new FragmentExamStateAdapter(this);
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, new DashboardFragment(), null);
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAdd:
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment fr = getSupportFragmentManager().findFragmentById(R.id.container);
                if(fr!=null){
                    fragmentTransaction.hide(fr);
                }
                fragmentTransaction.add(R.id.container, new HomeFragment(),HomeFragment.TAG);
                fragmentTransaction.addToBackStack(HomeFragment.TAG);
                fragmentTransaction.commit();
                break;
//            case R.id.btnReplace:
        }
    }


}