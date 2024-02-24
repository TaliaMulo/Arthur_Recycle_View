package com.example.arthurrecyclelview;

import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.MyViewHolder> {

    private ArrayList<DataModel> dataSet;
    private ItemClickListener itemClickListener;
    public CustomerAdapter(ArrayList<DataModel> dataSet , ItemClickListener itemClickListener) {
        this.dataSet = dataSet ;
        this.itemClickListener = itemClickListener;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textViewName;
        TextView textViewDescription;
        ImageView imageView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textView2);
            textViewDescription = itemView.findViewById(R.id.textView3);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

    @NonNull
    @Override
    public CustomerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardrow ,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerAdapter.MyViewHolder holder, int position) {
        holder.textViewName.setText(dataSet.get(position).getName());
        holder.textViewDescription.setText(dataSet.get(position).getDescription());
        holder.imageView.setImageResource(dataSet.get(position).getImage());

        holder.itemView.setOnClickListener(v -> {
            itemClickListener.onItemClick(dataSet.get(position));
        });

        Animation animation = AnimationUtils.loadAnimation(holder.itemView.getContext(),R.anim.anim_one);

        holder.itemView.startAnimation(animation);

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public interface ItemClickListener{
        void  onItemClick(DataModel details);
    }

    public void filterList(ArrayList<DataModel> filteredList){
        dataSet = filteredList;
        notifyDataSetChanged();
    }
}
