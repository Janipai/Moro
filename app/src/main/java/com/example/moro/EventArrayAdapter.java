package com.example.moro;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class EventArrayAdapter extends ArrayAdapter<Event> {

    private Context mContext;
    int mResource;

    public EventArrayAdapter(Context context, int resource, ArrayList<Event> events) {
        super(context, resource, events);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        String title = getItem(position).getTitle();
        String distance = getItem(position).getDistance();
        String date = getItem(position).getDate();
        String timeframe = getItem(position).getTimeframe();
        int image = getItem(position).getImage();

        Event event = new Event(title, distance, date, timeframe, image);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView titleTxt = convertView.findViewById(R.id.eventtitleTxt);
        TextView distanceTxt = convertView.findViewById(R.id.distanceTxt);
        TextView dateTxt = convertView.findViewById(R.id.dateTxt);
        TextView tframeTxt = convertView.findViewById(R.id.timeframeTxt);

        titleTxt.setText(title);
        distanceTxt.setText(distance);
        dateTxt.setText(date);
        tframeTxt.setText(timeframe);

        return convertView;
    }
}
