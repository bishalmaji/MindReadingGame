package com.bishal.mindreadinggame.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bishal.mindreadinggame.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerTwoAdapter extends RecyclerView.Adapter<RecyclerTwoAdapter.RVTwoViewHolder> {
    List<String > list;
    Context context;

    public RecyclerTwoAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RVTwoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recycler_row,parent,false);
        return new RVTwoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVTwoViewHolder holder, int position) {
        Glide.with(context).load(list.get(position)).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class RVTwoViewHolder extends RecyclerView.ViewHolder{
       ImageView imageView;
        public RVTwoViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.recycler_row_image);
        }
    }
}
