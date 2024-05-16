package com.example.myapp.Adapters;

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
import com.example.myapp.Domains.diagnose_Domain;
import com.example.myapp.Domains.getStarted_Domain;
import com.example.myapp.R;

import java.util.ArrayList;

public class getStarted_Adapter extends RecyclerView.Adapter<getStarted_Adapter.viewHolder> {
    ArrayList<getStarted_Domain> items;

    public getStarted_Adapter(ArrayList<getStarted_Domain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_get_started,parent,false);
        return new viewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.titleText.setText(items.get(position).getTitle());

        int drawableResId = holder.itemView.getResources().getIdentifier(items.get(position).getPicPath()
                ,"drawable",holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResId)
                .transform(new CenterCrop(), new GranularRoundedCorners(40, 40, 40, 40))
                .into(holder.pic);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView titleText;
        ImageView pic;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            titleText = itemView.findViewById(R.id.titleText);
            pic = itemView.findViewById(R.id.picImg);
        }
    }
}
