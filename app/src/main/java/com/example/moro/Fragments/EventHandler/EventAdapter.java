package com.example.moro.Fragments.EventHandler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moro.Data.DTO.EventDTO;
import com.example.moro.Fragments.Login.Context;
import com.example.moro.Fragments.Login.LoginFragment;
import com.example.moro.Fragments.Login.MyProfile;
import com.example.moro.Fragments.Login.NotLoginState;
import com.example.moro.R;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.MyViewHolder> {


    public enum ViewType {
        VIEW_TYPE_LIST, VIEW_TYPE_GRID, VIEW_TYPE_LOCATION
    }

    private android.content.Context myContext;
    private List<EventDTO> myData;
    private ViewType viewTypeSelected;


    public EventAdapter(android.content.Context myContext, List<EventDTO> myData) {
        this.myContext = myContext;
        this.myData = myData;
    }


    public EventAdapter(android.content.Context myContext, List<EventDTO> myData, ViewType viewTypeSelected) {
        this.myContext = myContext;
        this.myData = myData;
        this.viewTypeSelected = viewTypeSelected;
    }

    public void updateViewType() {
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater myInflater = LayoutInflater.from(myContext);
        if (this.viewTypeSelected == ViewType.VIEW_TYPE_LIST) {
            view = myInflater.inflate(R.layout.fragment_event_liste, parent, false);

            return new MyViewHolder(view);
        } else if (viewTypeSelected == ViewType.VIEW_TYPE_GRID) {
            view = myInflater.inflate(R.layout.fragment_event_sidebyside_view, parent, false);
            return new MyViewHolder(view);
        }
//        else if (viewTypeSelected == ViewType.VIEW_TYPE_LOCATION) {
//            skal bruges til lokation
//        }
        return null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tv_date.setText(myData.get(position).getDate());
        holder.iv_imageEvent.setScaleType(ImageView.ScaleType.FIT_XY);
        holder.iv_imageEvent.setImageResource(myData.get(position).getImage());
        holder.tv_title.setText(myData.get(position).getTitle());
        holder.tv_afstand.setText(myData.get(position).getDistance());
        holder.tv_tidsrum.setText(myData.get(position).getTimeframe());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                EventDescFragment fragment = new EventDescFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.event2All, fragment).addToBackStack(null).commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return myData.size();
    }

//    @Override
//    public int getItemViewType(int position) {
//        return this.viewTypeSelected.ordinal();
//    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_date;
        ImageView iv_imageEvent;
        TextView tv_title;
        TextView tv_afstand;
        TextView tv_tidsrum;
        CardView cardView;
        ImageView addToFavourites;


        public MyViewHolder(View itemView) {
            super(itemView);

            tv_date = (TextView) itemView.findViewById(R.id.date);
            iv_imageEvent = (ImageView) itemView.findViewById(R.id.imageEvent);
            tv_title = (TextView) itemView.findViewById(R.id.title);
            tv_afstand = (TextView) itemView.findViewById(R.id.afstand);
            tv_tidsrum = (TextView) itemView.findViewById(R.id.tidsrum);
            cardView = (CardView) itemView.findViewById(R.id.cardview);
            addToFavourites = (ImageView) itemView.findViewById(R.id.add);
        }

    }


}
