package com.example.moro.Fragments.Login;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moro.Data.DAO.ProfileDAO;
import com.example.moro.Data.DTO.EventDTO;
import com.example.moro.Fragments.EventHandler.EventDescFragment;
import com.example.moro.Fragments.MainActivity;
import com.example.moro.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * @author s195477, Shania Hau
 */

public class FavouritesEventAdapter extends RecyclerView.Adapter<FavouritesEventAdapter.MyViewHolder> {

    public enum ViewType {
        VIEW_TYPE_LIST, VIEW_TYPE_GRID, VIEW_TYPE_LOCATION
    }

    private android.content.Context myContext;
    private ArrayList<EventDTO> myData;
    private FavouritesEventAdapter.ViewType viewTypeSelected;
    private EventLister recall;

    public interface EventLister {
        void updateRecyclerView();
    }

    public FavouritesEventAdapter(android.content.Context myContext, ArrayList<EventDTO> myData, FavouritesEventAdapter.ViewType viewTypeSelected, EventLister recall) {
        this.myContext = myContext;
        this.myData = myData;
        this.viewTypeSelected = viewTypeSelected;
        this.recall = recall;
    }

    @NonNull
    @Override
    public FavouritesEventAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater myInflater = LayoutInflater.from(myContext);
        if (this.viewTypeSelected == FavouritesEventAdapter.ViewType.VIEW_TYPE_LIST) {
            view = myInflater.inflate(R.layout.fragment_event_liste, parent, false);
            return new FavouritesEventAdapter.MyViewHolder(view);
        } else if (viewTypeSelected == FavouritesEventAdapter.ViewType.VIEW_TYPE_GRID) {
            view = myInflater.inflate(R.layout.fragment_event_sidebyside_view, parent, false);
            return new FavouritesEventAdapter.MyViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tv_date.setText(myData.get(position).getDate());
        holder.iv_imageEvent.setScaleType(ImageView.ScaleType.FIT_XY);
        holder.tv_title.setText(myData.get(position).getName());
        holder.tv_afstand.setText(myData.get(position).getAddress());
        holder.tv_tidsrum.setText(myData.get(position).getTime());
        holder.addToRemove.setImageResource(R.drawable.ic_baseline_remove_box);
        holder.infoBar.setBackgroundColor(Color.parseColor("#01362F"));

        if(myData.get(position).getImage() != null && !myData.get(position).getImage().isEmpty()){
            Picasso.get()
                    .load(myData.get(position).getImage())
                    .placeholder(R.drawable.untitled)
                    .error(R.drawable.john)
                    .fit()
                    .noFade()
                    .into(holder.iv_imageEvent);
        } else {
            holder.iv_imageEvent.setImageDrawable(ContextCompat.getDrawable(myContext, R.drawable.bruh));
        }

        holder.addToRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.addToRemove.setImageResource(R.drawable.ic_baseline_add_box_24);
                myData.remove(myData.get(position));
                new ProfileDAO().updateUser(MainActivity.mAuth.getUid(), MainActivity.userProfile);
                recall.updateRecyclerView();
            }
        });

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

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_date;
        ImageView iv_imageEvent;
        TextView tv_title;
        TextView tv_afstand;
        TextView tv_tidsrum;
        CardView cardView;
        ImageView addToRemove;
        RelativeLayout infoBar;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_date = (TextView) itemView.findViewById(R.id.date);
            iv_imageEvent = (ImageView) itemView.findViewById(R.id.imageEvent);
            tv_title = (TextView) itemView.findViewById(R.id.title);
            tv_afstand = (TextView) itemView.findViewById(R.id.afstand);
            tv_tidsrum = (TextView) itemView.findViewById(R.id.tidsrum);
            cardView = (CardView) itemView.findViewById(R.id.cardview);
            addToRemove = (ImageView) itemView.findViewById(R.id.add);
            infoBar = (RelativeLayout) itemView.findViewById(R.id.infoBar);
        }

    }
}
