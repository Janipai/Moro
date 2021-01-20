package com.example.moro.Fragments.EventHandler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moro.Data.DAO.ProfileDAO;
import com.example.moro.Data.DTO.EventDTO;
import com.example.moro.Fragments.MainActivity;
import com.example.moro.R;
import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/** @author Jacob Christensen S174130
 * Everything else besides the things Mads has implemented i've implemented instead
 **/

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.MyViewHolder> implements Filterable {
    public enum ViewType {
        VIEW_TYPE_LIST, VIEW_TYPE_GRID, VIEW_TYPE_LOCATION
    }

    private android.content.Context myContext;
    private InfoAdapterInterface adapterInterface;
    /* List which is used to update elements when searching / showing when not searching */
    private List<EventDTO> itemsToAdapt;
    /* List used for safekeeping a complete list of events whom are not to be manipulated*/
    private List<EventDTO> itemsToAdaptComplete;
    private List<EventDTO> favouriteEventList = MainActivity.favouritesEvents;
    private ViewType viewType;


    public EventAdapter(android.content.Context myContext, List<EventDTO> myData, ViewType viewTypeSelected, InfoAdapterInterface adapterInterface) {
        this.myContext = myContext;
        this.itemsToAdapt = myData;
        this.viewType = viewTypeSelected;
        itemsToAdaptComplete = new ArrayList<>(myData);
        this.adapterInterface = adapterInterface;
    }

    public void updateViewType() {
    }

    /** @author Mads H. S195456
     * Method used to determine what viewholder the user wants (What type of recycler view is shown - Grid, list and so on.)
     **/
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater myInflater = LayoutInflater.from(myContext);
        if (this.viewType == ViewType.VIEW_TYPE_LIST) {
            view = myInflater.inflate(R.layout.fragment_event_liste, parent, false);
            return new MyViewHolder(view);
        } else if (this.viewType == ViewType.VIEW_TYPE_GRID) {
            view = myInflater.inflate(R.layout.fragment_event_sidebyside_view, parent, false);
            return new MyViewHolder(view);
        }
//        else if (viewTypeSelected == ViewType.VIEW_TYPE_LOCATION) {
//            skal bruges til lokation
//        }
        return null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tv_date.setText(itemsToAdapt.get(position).getDate());
        holder.iv_imageEvent.setScaleType(ImageView.ScaleType.FIT_XY);
        holder.tv_title.setText(itemsToAdapt.get(position).getName());
        holder.tv_afstand.setText(itemsToAdapt.get(position).getAddress());
        holder.tv_tidsrum.setText(itemsToAdapt.get(position).getTime());

       /*  Har udkommenteret fordi den crasher appen. Alt for mange billeder i et recyclerview tror jeg?
        Men er et library som kan vise billeder baseret på URL*/
        if(itemsToAdapt.get(position).getImage() != null && !itemsToAdapt.get(position).getImage().isEmpty()){
            Picasso.get()
                    .load(itemsToAdapt.get(position).getImage())
                    .placeholder(R.drawable.untitled)
                    .error(R.drawable.john)
                    .fit()
                    .noFade()
                    .into(holder.iv_imageEvent);
        } else {
            holder.iv_imageEvent.setImageDrawable(ContextCompat.getDrawable(myContext, R.drawable.bruh));
        }

        //add current event to favourites
        holder.addToFavourites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (favouriteEventList.contains(itemsToAdapt.get(position))){
                    holder.addToFavourites.setImageResource(R.drawable.ic_baseline_add_box_24);
                    favouriteEventList.remove(itemsToAdapt.get(position));
                }else{
                    holder.addToFavourites.setImageResource(R.drawable.ic_baseline_remove_box);
                    favouriteEventList.add(itemsToAdapt.get(position));
                }
                new ProfileDAO().updateUser(MainActivity.mAuth.getUid(), MainActivity.userProfile);
            }
        });

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapterInterface.onItemClicked(itemsToAdapt.get(position).getName(), itemsToAdapt.get(position).getDate());
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                EventDescFragment fragment = new EventDescFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, fragment).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemsToAdapt.size();
    }

    @Override
    public int getItemViewType(int position) {
        return viewType.ordinal();
    }


    /***
     * @author Mads H. S195456
    /* For filter search within events. Everything related to search / filtering */
    @Override
    public Filter getFilter() {
        return itemsFiltered;
    }
    /* Creating filter method */
    private final Filter itemsFiltered = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            /* List of filtered items */
            List<EventDTO> filteredList = new ArrayList<>();
            /* If the given charSequence (Users input in searchview) is 0 or null, if so readies all events to be searched through */
            if(constraint == null || constraint.length() == 0) {
                filteredList.addAll(itemsToAdaptComplete);
            } else {
                /* Makes input not case sensitive */
                String filterPattern = constraint.toString().toLowerCase().trim();
                /* Searches through all of the events to check for matching characters */
                for (EventDTO item : itemsToAdaptComplete) {
                    if (item.getName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }
            /* Sets results */
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        /* Method which updates the results in real time */
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            itemsToAdapt.clear();
            itemsToAdapt.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
    /* End of filtering */


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_date;
        ImageView iv_imageEvent;
        TextView tv_title;
        TextView tv_afstand;
        TextView tv_tidsrum;
        CardView cardView;
        ImageView addToFavourites;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_date = (TextView) itemView.findViewById(R.id.date);
            iv_imageEvent = (ImageView) itemView.findViewById(R.id.imageEvent);
            tv_title = (TextView) itemView.findViewById(R.id.title);
            tv_afstand = (TextView) itemView.findViewById(R.id.afstand);
            tv_tidsrum = (TextView) itemView.findViewById(R.id.tidsrum);
            cardView = (CardView) itemView.findViewById(R.id.cardview);
            addToFavourites = (ImageView) itemView.findViewById(R.id.add);
        }
    }

    public interface InfoAdapterInterface{
        void onItemClicked(String title, String date);
    }
}
