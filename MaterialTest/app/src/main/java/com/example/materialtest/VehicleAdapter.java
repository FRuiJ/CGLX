package com.example.materialtest;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class VehicleAdapter extends RecyclerView.Adapter<VehicleAdapter.ViewHolder> {
    private Context mContext;
    private List<Vehicle> mVehicleList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView vehicleImage;
        TextView vehicleName;

        public ViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            vehicleImage = itemView.findViewById(R.id.vehicle_image);
            vehicleName = itemView.findViewById(R.id.vehicle_name);
        }
    }



    public VehicleAdapter(List<Vehicle> vehiclesList){
        mVehicleList = vehiclesList;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public VehicleAdapter.ViewHolder onCreateViewHolder(
            @NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        if (mContext == null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.vehicle_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Vehicle vehicle = mVehicleList.get(position);
                Intent intent = new Intent(mContext, VehicleActivity.class);
                intent.putExtra(VehicleActivity.VEHICLE_NAME, vehicle.getName());
                intent.putExtra(VehicleActivity.VEHICLE_IMAGE_ID, vehicle.getImageId());
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull VehicleAdapter.ViewHolder holder, int position) {
        Vehicle vehicle = mVehicleList.get(position);
        holder.vehicleName.setText(vehicle.getName());
        Glide.with(mContext).load(vehicle.getImageId()).into((holder.vehicleImage));
    }

    @Override
    public int getItemCount() {
        return mVehicleList.size();
    }



}
