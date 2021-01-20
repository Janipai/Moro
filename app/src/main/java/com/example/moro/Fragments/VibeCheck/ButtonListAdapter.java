package com.example.moro.Fragments.VibeCheck;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.moro.Fragments.EventHandler.EventFragment;
import com.example.moro.R;

import java.util.ArrayList;
import java.util.List;
/**
 * @author s195477, Shania Hau
 */

public class ButtonListAdapter extends RecyclerView.Adapter<ButtonListAdapter.MyViewHolder> {

    private Context myContext;
    private List<String> myButtons;

    public ButtonListAdapter(Context myContext, List<String> myButtons) {
        this.myContext = myContext;
        this.myButtons = myButtons;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater myInflater = LayoutInflater.from(myContext);
        view = myInflater.inflate(R.layout.gridview_item_buttons,parent,false);
        return new MyViewHolder(view);
    }

    ArrayList<TextView> choosenButtonList = new ArrayList<>();
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {

        holder.tv.setText(myButtons.get(position));

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (choosenButtonList.contains(holder.tv)){
                    holder.tv.setBackgroundResource(R.drawable.button_style_hvad);
                    holder.tv.setTextColor(Color.parseColor("#FFA500"));
                    choosenButtonList.remove(holder.tv);
                }else if (!choosenButtonList.contains(holder.tv)){
                    choosenButtonList.add(holder.tv);
                    //add vibe to showEventsBasedOnVibeCheck
                    holder.tv.setBackgroundResource(R.drawable.button_style_hvad2);
                    holder.tv.setTextColor(Color.parseColor("#FFFDBA"));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return myButtons.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv;
        LinearLayout layout;

        public MyViewHolder( @NonNull View itemView){
            super(itemView);

            tv = (TextView) itemView.findViewById(R.id.all_textview);
            layout = (LinearLayout) itemView.findViewById(R.id.linear_layout);
        }
    }
}