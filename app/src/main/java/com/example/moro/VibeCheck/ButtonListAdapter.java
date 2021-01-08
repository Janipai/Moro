package com.example.moro.VibeCheck;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.moro.EventHandler.RecyclerViewOnClickListener;
import com.example.moro.R;

import java.util.List;


public class ButtonListAdapter extends RecyclerView.Adapter<ButtonListAdapter.MyViewHolder> {

    private final RecyclerViewOnClickListener listener;
    private Context myContext;
    private List<Button> myButtons;

    public ButtonListAdapter(RecyclerViewOnClickListener listener,Context myContext, List<Button> myButtons) {
        this.listener = listener;
        this.myContext = myContext;
        this.myButtons = myButtons;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater myInflater = LayoutInflater.from(myContext);
        view = myInflater.inflate(R.layout.fragment_hvad,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //holder.all_buttons.setBackgroundResource(R.drawable.hvad_button_style);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        Button all_buttons;

        public MyViewHolder( @NonNull View itemView){
            super(itemView);

            all_buttons = (Button) itemView.findViewById(R.id.all_buttons);
        }
    }
}