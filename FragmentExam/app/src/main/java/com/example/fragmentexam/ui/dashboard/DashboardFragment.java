package com.example.fragmentexam.ui.dashboard;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.fragmentexam.R;
import com.example.fragmentexam.User;
import com.example.fragmentexam.ui.home.HomeFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DashboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashboardFragment extends Fragment {
    private EditText etName,etPhone;
    private Button btnSubmit;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private View view;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private User user;
    public DashboardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DashboardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DashboardFragment newInstance(String param1, String param2) {
        DashboardFragment fragment = new DashboardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_dashboard, container, false);
        etName=(EditText) view.findViewById(R.id.editTextName);
        etPhone=(EditText) view.findViewById(R.id.editTextPhone);
        btnSubmit= (Button) view.findViewById(R.id.btnSend);
        btnSubmit.setOnClickListener(clickListener);
        return view;
    }




    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            user=new User(etName.getText().toString(),etPhone.getText().toString());
            FragmentTransaction transaction= getFragmentManager().beginTransaction();
            HomeFragment homeFragment =new HomeFragment();
            Bundle bundle=new Bundle();
            bundle.putString("name",user.getName());
            bundle.putString("phone",user.getPhone());
            homeFragment.setArguments(bundle);
            transaction.replace(R.id.container,homeFragment);
            transaction.addToBackStack(HomeFragment.TAG);
            transaction.commit();
        }
    };
}