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

public class RecyclerThreeAdapter extends RecyclerView.Adapter<RecyclerThreeAdapter.RVThreeViewHolder> {

    List<String > list;
    Context context;

    public RecyclerThreeAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RVThreeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recycler_row,parent,false);
        return new RVThreeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVThreeViewHolder holder, int position) {
        Glide.with(context).load(list.get(position)).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class RVThreeViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public RVThreeViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.recycler_row_image);
        }
    }
}
