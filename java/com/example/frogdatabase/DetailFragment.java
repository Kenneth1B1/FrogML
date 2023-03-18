package com.example.frogdatabase;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailFragment extends Fragment {

    private Frog mFrog;
    private int FrogId;
    private ListFragment list;
    public static final String ARG_FROG_ID = "frog_id";


    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrogId = 1;

        // Get the selected band
        //mFrog = FrogRepository.getInstance(requireContext()).getFrog(list.getID());
        // Get the band ID from the fragment arguments
        Bundle args = getArguments();
        if (args != null) {
            FrogId = args.getInt(ARG_FROG_ID);
        }
        mFrog = FrogRepository.getInstance(requireContext()).getFrog(FrogId);

    }

    public void setFrogId(int id){
        FrogId = id;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        if (mFrog != null) {
            TextView nameTextView = rootView.findViewById(R.id.frog_name);
            //set name of frog
            nameTextView.setText(mFrog.getName());

            //get image of frog

            ImageView imageView=(ImageView) rootView.findViewById(R.id.frog_pic);
            String frogString = "frog" + mFrog.getId();
            int resID = getResources().getIdentifier(frogString,"drawable","com.example.frogdatabase");
            //imageView.setImageResource(R.drawable.frog1);
            imageView.setImageResource(resID);
            //description or address for frog
            TextView descriptionTextView = rootView.findViewById(R.id.frog_description);
            descriptionTextView.setText(mFrog.getmAddress());
        }

        return rootView;
    }
}