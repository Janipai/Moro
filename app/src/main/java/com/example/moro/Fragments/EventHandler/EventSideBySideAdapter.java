package com.example.moro.Fragments.EventHandler;

import android.content.Context;
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
import com.example.moro.R;

import java.util.List;

public class EventSideBySideAdapter extends RecyclerView.Adapter<EventSideBySideAdapter.MyViewHolder> {

         private Context myContext;
         private List<EventDTO> myData;


    public EventSideBySideAdapter(Context myContext, List<EventDTO> myData) {
        this.myContext = myContext;
        this.myData = myData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater myInflater = LayoutInflater.from(myContext);
        view = myInflater.inflate(R.layout.fragment_event_sidebyside_view,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tv_date.setText(myData.get(position).getDate());
        holder.iv_imageEvent.setImageResource(myData.get(position).getImage());
        holder.tv_title.setText(myData.get(position).getTitle());
        holder.tv_afstand.setText(myData.get(position).getDistance());
        holder.tv_tidsrum.setText(myData.get(position).getTimeframe());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity)view.getContext();
                EventBeskrivelseFragment fragment = new EventBeskrivelseFragment();
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


        public MyViewHolder(View itemView) {
            super(itemView);

            tv_date = (TextView) itemView.findViewById(R.id.date);
            iv_imageEvent = (ImageView) itemView.findViewById(R.id.imageEvent);
            tv_title = (TextView) itemView.findViewById(R.id.title);
            tv_afstand = (TextView) itemView.findViewById(R.id.afstand);
            tv_tidsrum = (TextView) itemView.findViewById(R.id.tidsrum);
            cardView = (CardView) itemView.findViewById(R.id.cardview);
        }

    }


}
