package com.example.moro;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class RightNowEventArrayAdapter extends PagerAdapter {

    private Context mContext;
    private ArrayList<Event> rightNowList;

    public RightNowEventArrayAdapter(Context context, ArrayList<Event> rightNowList){
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
        TextView title = view.findViewById(R.id.cardviewEventtitle);
        TextView timeframe = view.findViewById(R.id.cardviewTime);

        Event event = rightNowList.get(position);
        String eventDate= event.getDate();
        String eventTitle = event.getTitle();
        String eventTimeframe = event.getTimeframe();
        int eventImage = event.getImage();

        date.setText(eventDate);
        title.setText(eventTitle);
        timeframe.setText(eventTimeframe);
        background.setImageResource(eventImage);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
