package com.example.moro.Fragments.VibeCheck;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moro.Data.DTO.EventDTO;
import com.example.moro.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private final String TAG = "RecyclerViewAdapter";
    private ArrayList<EventDTO> eventDTOS = new ArrayList<>();
    private Context mContext;

    public RecyclerAdapter(Context mContext, ArrayList<EventDTO> eventDTOS) {
        this.eventDTOS = eventDTOS;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
       holder.eventTitle.setText(eventDTOS.get(position).getTitle());
       holder.eventTimeframe.setText(eventDTOS.get(position).getTimeframe());
       holder.eventDate.setText(eventDTOS.get(position).getDate());
       holder.background.setImageResource(eventDTOS.get(position).getImage());

       holder.background.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Log.d(TAG, "Clicked on " + eventDTOS.get(position).getTitle());
               Toast.makeText(mContext, eventDTOS.get(position).getTitle(), Toast.LENGTH_SHORT).show();
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

        public ViewHolder(View itemView) {
            super(itemView);
            background = itemView.findViewById(R.id.cardviewImgView);
            eventTitle = itemView.findViewById(R.id.cardviewEventtitle);
            eventTimeframe = itemView.findViewById(R.id.cardviewTime);
            eventDate = itemView.findViewById(R.id.cardviewDate);
        }

    }
}
