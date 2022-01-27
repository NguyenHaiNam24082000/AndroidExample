package com.example.learnjapanexample.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.learnjapanexample.AsteriskPasswordTransformationMethod;
import com.example.learnjapanexample.R;

public class LoginFragment extends Fragment {

    private View view;
    private TextView btnForgotPassword;
    private EditText edtUsername,edtPassword;

    public static final String TAG = "LOGIN_FRAGMENT";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_login, container, false);

        btnForgotPassword = (TextView) view.findViewById(R.id.btnForgotPassword);
        edtUsername = (EditText) view.findViewById(R.id.edtUsername);
        edtPassword = (EditText) view.findViewById(R.id.edtPassword);

        edtPassword.setTransformationMethod(new AsteriskPasswordTransformationMethod());

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnForgotPassword.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                ForgotPasswordFragment forgotPasswordFragment= new ForgotPasswordFragment();

                FragmentTransaction transaction= getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(
                        R.anim.slide_in,
                        R.anim.fade_out,
                        R.anim.fade_in,
                        R.anim.slide_out
                );

                Bundle bundle= new Bundle();
                bundle.putString("UserName",edtUsername.getText().toString());

                forgotPasswordFragment.setArguments(bundle);
                transaction.replace(R.id.container,forgotPasswordFragment, ForgotPasswordFragment.TAG);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }
}