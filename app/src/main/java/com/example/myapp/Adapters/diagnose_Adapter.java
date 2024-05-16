package com.example.myapp.Adapters;

import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.myapp.Activities.detail_activity;
import com.example.myapp.Domains.diagnose_Domain;
import com.example.myapp.R;

import java.util.ArrayList;

public class diagnose_Adapter extends RecyclerView.Adapter<diagnose_Adapter.ViewHolder> {
    ArrayList<diagnose_Domain> items;

    public diagnose_Adapter(ArrayList<diagnose_Domain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public diagnose_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_diagnose,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull diagnose_Adapter.ViewHolder holder, int position) {
        holder.titleText.setText(items.get(position).getTitle());
        int drawableResourceId = holder.itemView.getResources().getIdentifier(items.get(position).getPicPath(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .transform(new CenterCrop(),new GranularRoundedCorners(40,40,40,40))
                .into(holder.pic);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), detail_activity.class);
            intent.putExtra("object", (Parcelable) items.get(position));
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView titleText;
        ImageView pic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleText = itemView.findViewById(R.id.titleText);
            pic = itemView.findViewById(R.id.picImg);
        }
    }
}
