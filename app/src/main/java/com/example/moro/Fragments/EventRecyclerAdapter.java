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
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moro.Data.DTO.EventDTO;
import com.example.moro.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class EventRecyclerAdapter extends RecyclerView.Adapter<EventRecyclerAdapter.ViewHolder> {

    private final String TAG = "RecyclerViewAdapter";
    private ArrayList<EventDTO> eventDTOS = new ArrayList<>();
    private Context mContext;

    public EventRecyclerAdapter(Context mContext, ArrayList<EventDTO> eventDTOS) {
        this.eventDTOS = eventDTOS;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_event_adapterv_view_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.eventTitle.setText(eventDTOS.get(position).getName());
        holder.eventTimeframe.setText(eventDTOS.get(position).getTime());
        holder.eventDate.setText(eventDTOS.get(position).getDate());
        //holder.background.setImageResource(eventDTOS.get(position).getImage());
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
        holder.background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Clicked on " + eventDTOS.get(position).getName());
                Toast.makeText(mContext, eventDTOS.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return eventDTOS.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView background;
        TextView eventTitle;
        TextView eventTimeframe;
        TextView eventDate;
        TextView eventDistance;

        public ViewHolder(View itemView) {
            super(itemView);
            background = itemView.findViewById(R.id.HomeEventView_IV_background);
            eventTitle = itemView.findViewById(R.id.HomeEventView_TV_title);
            eventTimeframe = itemView.findViewById(R.id.HomeEventView_TV_timeframe);
            eventDate = itemView.findViewById(R.id.HomeEventView_TV_date);
            eventDistance = itemView.findViewById(R.id.HomeEventView_TV_distance);

        }

    }
}
