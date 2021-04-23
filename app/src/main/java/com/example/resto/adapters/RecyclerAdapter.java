package com.example.resto.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.resto.R;
import com.example.resto.models.NicePlace;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<NicePlace> mNicePlaces = new ArrayList<>();
    private Context mContext;
    private Integer layout_item;
    public RecyclerAdapter(Context context, List<NicePlace> nicePlaces,int layout_item) {
        mNicePlaces = nicePlaces;
        mContext = context;
        this.layout_item=layout_item;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(layout_item, viewGroup, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        // Set the name of the 'NicePlace'
        ((ViewHolder)viewHolder).mName.setText(mNicePlaces.get(i).getTitle());

        // Set the image
        RequestOptions defaultOptions = new RequestOptions()
                .error(R.drawable.ic_launcher_background);
        Glide.with(mContext)
                .setDefaultRequestOptions(defaultOptions)
                .load(mNicePlaces.get(i).getImageUrl())
                .into(((ViewHolder)viewHolder).mImage);
    }

    @Override
    public int getItemCount() {
        return mNicePlaces.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView mImage;
        private TextView mName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.image_resto);
            mName = itemView.findViewById(R.id.image_name);
        }
    }
}
