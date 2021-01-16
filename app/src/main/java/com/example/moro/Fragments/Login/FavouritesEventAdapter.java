package com.example.moro.Fragments.Login;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moro.Data.DTO.EventDTO;
import com.example.moro.Fragments.CustomFragment;
import com.example.moro.Fragments.EventHandler.EventDescFragment;
import com.example.moro.R;

import java.util.ArrayList;
import java.util.List;

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

    Context ctx = Context.getInstance();

    public FavouritesEventAdapter(android.content.Context myContext, ArrayList<EventDTO> myData) {
        this.myContext = myContext;
        this.myData = myData;
    }


    public FavouritesEventAdapter(android.content.Context myContext, ArrayList<EventDTO> myData, FavouritesEventAdapter.ViewType viewTypeSelected) {
        this.myContext = myContext;
        this.myData = myData;
        this.viewTypeSelected = viewTypeSelected;
    }

    public void updateViewType () {
    }

    @NonNull
    @Override
    public FavouritesEventAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater myInflater = LayoutInflater.from(myContext);
        if(this.viewTypeSelected == FavouritesEventAdapter.ViewType.VIEW_TYPE_LIST) {
            view = myInflater.inflate(R.layout.fragment_event_liste,parent,false);
            return new FavouritesEventAdapter.MyViewHolder(view);
        }
        else if (viewTypeSelected == FavouritesEventAdapter.ViewType.VIEW_TYPE_GRID) {
            view = myInflater.inflate(R.layout.fragment_event_sidebyside_view,parent,false);
            return new FavouritesEventAdapter.MyViewHolder(view);
        }
//        else if (viewTypeSelected == ViewType.VIEW_TYPE_LOCATION) {
//            skal bruges til lokation
//        }
        return null;
    }

    @Override
    public void onBindViewHolder(FavouritesEventAdapter.MyViewHolder holder, int position) {

        holder.tv_date.setText(myData.get(position).getDate());
        holder.iv_imageEvent.setScaleType(ImageView.ScaleType.FIT_XY);
        holder.iv_imageEvent.setImageResource(myData.get(position).getImage());
        holder.tv_title.setText(myData.get(position).getTitle());
        holder.tv_afstand.setText(myData.get(position).getDistance());
        holder.tv_tidsrum.setText(myData.get(position).getTimeframe());
        holder.addToRemove.setImageResource(R.drawable.ic_minus);

        holder.addToRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ctx.getStates().equals(new NotLoginState())){
                    AppCompatActivity activity = (AppCompatActivity)v.getContext();
                    LoginFragment fragment = new LoginFragment();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.event2All, fragment).addToBackStack(null).commit();

                }else {
                    //remove current event from favourites
                    //ctx.removeFavourites();
                }
            }
        });

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity)view.getContext();
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
        ImageView addToRemove;


        public MyViewHolder(View itemView) {
            super(itemView);

            tv_date = (TextView) itemView.findViewById(R.id.date);
            iv_imageEvent = (ImageView) itemView.findViewById(R.id.imageEvent);
            tv_title = (TextView) itemView.findViewById(R.id.title);
            tv_afstand = (TextView) itemView.findViewById(R.id.afstand);
            tv_tidsrum = (TextView) itemView.findViewById(R.id.tidsrum);
            cardView = (CardView) itemView.findViewById(R.id.cardview);
            addToRemove = (ImageView) itemView.findViewById(R.id.add);
        }

    }
}
