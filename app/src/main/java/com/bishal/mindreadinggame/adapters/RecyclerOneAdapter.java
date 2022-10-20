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

public class RecyclerOneAdapter extends RecyclerView.Adapter<RecyclerOneAdapter.RVOneViewHolder> {
    List<String > list;
    Context context;

    public RecyclerOneAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RVOneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recycler_row,parent,false);
        return new RVOneViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVOneViewHolder holder, int position) {
        Glide.with(context).load(list.get(position)).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class RVOneViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public RVOneViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.recycler_row_image);
        }
    }
}
