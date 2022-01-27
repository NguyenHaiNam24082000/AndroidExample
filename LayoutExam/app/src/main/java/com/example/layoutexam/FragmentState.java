package com.example.layoutexam;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.layoutexam.Fragment.ChangePassword.ChangePasswordFragment;
import com.example.layoutexam.Fragment.Information.InformationFragment;
import com.example.layoutexam.Fragment.Profile.ProfileFragment;

public class FragmentState extends FragmentStateAdapter {
    Fragment fragment=null;
    public FragmentState(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                fragment= new InformationFragment();
                break;
            case 1:
                fragment= new ProfileFragment();
                break;
            case 2:
                fragment= new ChangePasswordFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
