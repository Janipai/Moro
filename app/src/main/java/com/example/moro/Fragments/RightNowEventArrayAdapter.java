package com.example.moro.Fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.moro.Data.DTO.EventDTO;
import com.example.moro.R;

import java.util.ArrayList;

public class RightNowEventArrayAdapter extends PagerAdapter {

    private Context mContext;
    private ArrayList<EventDTO> rightNowList;

    public RightNowEventArrayAdapter(Context context, ArrayList<EventDTO> rightNowList){
        this.mContext = context;
        this.rightNowList = rightNowList;
    }

    @Override
    public int getCount() {
        return rightNowList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return false;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.cardview_item, container, false);

        ImageView background = view.findViewById(R.id.cardviewImgView);
        TextView date = view.findViewById(R.id.cardviewDate);
        final TextView title = view.findViewById(R.id.cardviewEventtitle);
        TextView timeframe = view.findViewById(R.id.cardviewTime);

        EventDTO event = rightNowList.get(position);
        final String eventDate= event.getDate();
        final String eventTitle = event.getTitle();
        final String eventTimeframe = event.getTimeframe();
        final int eventImage = event.getImage();

        date.setText(eventDate);
        title.setText(eventTitle);
        timeframe.setText(eventTimeframe);
        background.setImageResource(eventImage);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, eventTitle, Toast.LENGTH_SHORT).show();
            }
        });

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
