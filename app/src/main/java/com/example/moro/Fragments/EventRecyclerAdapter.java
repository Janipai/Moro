package com.example.moro.Fragments;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moro.Data.DAO.ProfileDAO;
import com.example.moro.Data.DTO.EventDTO;
import com.example.moro.Fragments.EventHandler.EventDescFragment;
import com.example.moro.Fragments.Login.NotLoginState;
import com.example.moro.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/** @author s195467 Stefan Luxhøj */
// Adapter for the event recommended to the user on the home screen.
public class EventRecyclerAdapter extends RecyclerView.Adapter<EventRecyclerAdapter.ViewHolder> {

    private final String TAG = "RecyclerViewAdapter";
    private InfoAdapterInterface adapterInterface;
    private ArrayList<EventDTO> eventDTOS = new ArrayList<>();
    private Context mContext;
    private List<EventDTO> favouriteEventList = MainActivity.favouritesEvents;
    com.example.moro.Fragments.Login.Context ctx = com.example.moro.Fragments.Login.Context.getInstance();


    public EventRecyclerAdapter(Context mContext, ArrayList<EventDTO> eventDTOS, InfoAdapterInterface adapterInterface) {
        this.eventDTOS = eventDTOS;
        this.mContext = mContext;
        this.adapterInterface = adapterInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_event_adapterv_view_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    // Method for setting the content in the item
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.eventTitle.setText(eventDTOS.get(position).getName());
        holder.eventTimeframe.setText(eventDTOS.get(position).getTime());
        holder.eventDate.setText(eventDTOS.get(position).getDate());
        holder.eventDistance.setText(eventDTOS.get(position).getAddress());

        if(eventDTOS.get(position).getImage() != null && !eventDTOS.get(position).getImage().isEmpty()){
            Picasso.get()
                    .load(eventDTOS.get(position).getImage())
                    .placeholder(R.drawable.untitled)
                    .error(R.drawable.john)
                    .fit()
                    .noFade()
                    .into(holder.background);
        } else {
            holder.background.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.untitled));
        }

        /**
         * @author Jacob Christensen
         */
        holder.background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapterInterface.onItemClicked(eventDTOS.get(position).getName(), eventDTOS.get(position).getDate());
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                EventDescFragment fragment = new EventDescFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, fragment).addToBackStack(null).commit();
            }
        });
        /**
         * @author Shania Hau
         */
        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ctx.isLogin()){
                    ctx.favouritFragment( ((AppCompatActivity) mContext).getSupportFragmentManager());
                }else{
                    if (favouriteEventList.contains(eventDTOS.get(position))){
                        holder.add.setImageResource(R.drawable.ic_baseline_add_box_24);
                        favouriteEventList.remove(eventDTOS.get(position));
                    }else{
                        holder.add.setImageResource(R.drawable.ic_baseline_remove_box);
                        favouriteEventList.add(eventDTOS.get(position));
                    }
                    new ProfileDAO().updateUser(MainActivity.mAuth.getUid(), MainActivity.userProfile);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return eventDTOS.size();
    }

    // Class for the items content.
    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView background;
        TextView eventTitle;
        TextView eventTimeframe;
        TextView eventDate;
        TextView eventDistance;
        ImageView add;

        public ViewHolder(View itemView) {
            super(itemView);
            background = itemView.findViewById(R.id.HomeEventView_IV_background);
            eventTitle = itemView.findViewById(R.id.HomeEventView_TV_title);
            eventTimeframe = itemView.findViewById(R.id.HomeEventView_TV_timeframe);
            eventDate = itemView.findViewById(R.id.HomeEventView_TV_date);
            eventDistance = itemView.findViewById(R.id.HomeEventView_TV_distance);
            add = itemView.findViewById(R.id.HomeEvent_add);

        }

    }

    /**
     * @author Jacob Christensen
     */
    public interface InfoAdapterInterface{
        void onItemClicked(String title, String date);
    }

}
