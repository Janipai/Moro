//package com.example.moro.Fragments;
//
//import android.app.LauncherActivity;
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentStatePagerAdapter;
//import androidx.recyclerview.widget.RecyclerView;
//import androidx.viewpager.widget.PagerAdapter;
//
//import com.example.moro.Data.DTO.EventDTO;
//import com.example.moro.R;
//
//import java.util.ArrayList;
//
//public class RightNowEventArrayAdapter extends RecyclerView.Adapter<RightNowEventArrayAdapter.EventDTO> {
//
//
//    private ArrayList<EventDTO> rightNowList;
//    private Context mContext;
//
//    public RightNowEventArrayAdapter(Context context, ArrayList<EventDTO> rightNowList){
//        this.mContext = context;
//        this.rightNowList = rightNowList;
//    }
//
//
//
//
//
//    @NonNull
//    @Override
//    public Object instantiateItem(@NonNull ViewGroup container, int position) {
//
//        View view = LayoutInflater.from(mContext).inflate(R.layout.cardview_item, container, false);
//
//        ImageView background = view.findViewById(R.id.cardviewImgView);
//        TextView date = view.findViewById(R.id.cardviewDate);
//        final TextView title = view.findViewById(R.id.cardviewEventtitle);
//        TextView timeframe = view.findViewById(R.id.cardviewTime);
//
//        date.setText(rightNowList.get(position).getDate());
//        title.setText(rightNowList.get(position).getTitle());
//        timeframe.setText(rightNowList.get(position).getTimeframe());
//        background.setImageResource(rightNowList.get(position).getImage());
//
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(mContext, title.getText(), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        container.addView(view);
//
//        return view;
//    }
//
//
//
//
//    @Override
//    public void onBindViewHolder(@NonNull RightNowEventArrayAdapter.EventDTO holder, int position) {
//
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull RightNowEventArrayAdapter holder, int position) {
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return 0;
//    }
//}
