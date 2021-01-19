package com.example.moro.Data.DAO;

import android.util.Log;

import com.example.moro.Data.DTO.EventDTO;
import com.example.moro.Fragments.MainActivity;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;

/**
 * @author Mikkel Johansen s175194
 */
public class EventDAO {
    private static final String TAG = "Connectivity";
    private ArrayList<EventDTO> events = new ArrayList<>();
    private static EventDAO instance;

    private EventDAO(){}

    public static EventDAO getInstance() {
        if (instance != null)
            return instance;
        return  instance = new EventDAO();
    }

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public void getAllEvents(MainActivity activity){
        db.collection("Events")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            Log.d(TAG, document.getId() + " => " + document.getData());
                            events.add(document.toObject(EventDTO.class));
                            Log.d(TAG, String.valueOf(events.size()));
                        }
                        activity.setEvents(events);
                        activity.initializingDone();

                    } else {
                        Log.d(TAG, "Error getting documents: ", task.getException());
                    }
                });
    }
}
