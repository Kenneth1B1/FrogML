package com.example.frogdatabase;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import androidx.fragment.app.Fragment;


import java.util.List;

public class ListFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);

        // Click listener for the RecyclerView
        View.OnClickListener onClickListener = itemView -> {

            // Create fragment arguments containing the selected band ID
            int selectedFrogId = (int) itemView.getTag();
            Bundle args = new Bundle();
            args.putInt(DetailFragment.ARG_FROG_ID, selectedFrogId);

            // Replace list with details
            Navigation.findNavController(itemView).navigate(R.id.show_item_detail, args);
            //Navigation.findNavController(itemView).navigate(R.id.show_item_detail);
        };


        // Send frogs to RecyclerView
        RecyclerView recyclerView = rootView.findViewById(R.id.band_list);
        List<Frog> frogs = FrogRepository.getInstance(requireContext()).getFrogs();
        recyclerView.setAdapter(new BandAdapter(frogs, onClickListener));

        Button button2 = (Button) rootView.findViewById(R.id.planner);
        button2.setOnClickListener((View buttonView) -> {
            Navigation.findNavController(buttonView).navigate(R.id.plan_load);
            //Navigation.findNavController(buttonView).navigate(R.id.show_item_detail);
        });

        Button button3 = (Button) rootView.findViewById(R.id.map);
        button3.setOnClickListener((View buttonView) -> {
            Navigation.findNavController(buttonView).navigate(R.id.map_load);
            //Navigation.findNavController(buttonView).navigate(R.id.show_item_detail);
        });

        return rootView;
    }

    private class BandAdapter extends RecyclerView.Adapter<BandHolder> {

        private final List<Frog> mFrogs;
        private final View.OnClickListener mOnClickListener;

        public BandAdapter(List<Frog> frogs, View.OnClickListener onClickListener) {
            mFrogs = frogs;
            mOnClickListener = onClickListener;
        }

        @NonNull
        @Override
        public BandHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new BandHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(BandHolder holder, int position) {
            Frog frog = mFrogs.get(position);
            holder.bind(frog);
            holder.itemView.setTag(frog.getId());
            holder.itemView.setOnClickListener(mOnClickListener);
        }

        @Override
        public int getItemCount() {
            return mFrogs.size();
        }
    }

    private static class BandHolder extends RecyclerView.ViewHolder {

        private final TextView mNameTextView;

        public BandHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_frog, parent, false));
            mNameTextView = itemView.findViewById(R.id.frog_name);
        }

        public void bind(Frog frog) {
            mNameTextView.setText(frog.getName());
        }
    }
}
