package com.example.moro.Fragments.VibeCheck;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moro.R;

import java.util.ArrayList;
import java.util.List;
/**
 * @author s195477, Shania Hau
 */
public class ButtonListHvorAdapter extends RecyclerView.Adapter<ButtonListHvorAdapter.MyViewHolder>{

    private Context myContext;
    private List<String> myButtons;

    public ButtonListHvorAdapter(Context myContext, List<String> myButtons) {
        this.myContext = myContext;
        this.myButtons = myButtons;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater myInflater = LayoutInflater.from(myContext);
        view = myInflater.inflate(R.layout.gridview_item_hvor_buttons,parent,false);
        return new  MyViewHolder(view);

    }

    ArrayList<TextView> choosenButtonList = new ArrayList<>();
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        holder.tv.setText(myButtons.get(position));
        //holder.tv.setPadding(40,40,40,40);

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //AppCompatActivity activity = (AppCompatActivity)view.getContext();
                //EventBeskrivelseFragment fragment = new EventBeskrivelseFragment();
                //activity.getSupportFragmentManager().beginTransaction().replace(R.id.event2All, fragment).addToBackStack(null).commit();

                if (choosenButtonList.contains(holder.tv)){
                    holder.tv.setBackgroundResource(R.drawable.button_style_hvor);
                    holder.tv.setTextColor(Color.parseColor("#990000"));
                    choosenButtonList.remove(holder.tv);
                }else if (!choosenButtonList.contains(holder.tv)){
                    choosenButtonList.add(holder.tv);
                    holder.tv.setBackgroundResource(R.drawable.button_style_hvor2);
                    holder.tv.setTextColor(Color.parseColor("#FFB7FC"));
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

        public MyViewHolder(@NonNull View itemView){
            super(itemView);

            tv = (TextView) itemView.findViewById(R.id.all_textview_forhvor);
            layout = (LinearLayout) itemView.findViewById(R.id.linear_layout_forhvor);
        }
    }
}
