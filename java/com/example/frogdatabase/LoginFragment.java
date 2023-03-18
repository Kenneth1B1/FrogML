package com.example.frogdatabase;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class LoginFragment extends Fragment{


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        View rootView = inflater.inflate(R.layout.activity_login, container, false);

        Button button = (Button) rootView.findViewById(R.id.login);
        button.setOnClickListener((View buttonView) -> {
            Navigation.findNavController(buttonView).navigate(R.id.login_load);
        });



        return rootView;
    }
}
