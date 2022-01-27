package com.example.fragmentexam;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.fragmentexam.ui.dashboard.DashboardFragment;
import com.example.fragmentexam.ui.home.HomeFragment;
import com.example.fragmentexam.ui.notifications.NotificationsFragment;

public class FragmentExamStateAdapter extends FragmentStateAdapter {


    public FragmentExamStateAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position==0)
            return new HomeFragment();
        else if (position == 1)
            return new NotificationsFragment();
        else
            return new DashboardFragment();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
