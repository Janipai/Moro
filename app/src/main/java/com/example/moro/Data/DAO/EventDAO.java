package com.example.moro.Data.DAO;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.moro.Data.DTO.EventDTO;
import com.example.moro.Data.DTO.MikkelEventDTO;
import com.example.moro.Fragments.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EventDAO {
    private static final String TAG = "Connectivity";
    private ArrayList<MikkelEventDTO> events = new ArrayList<>();
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
                            events.add(document.toObject(MikkelEventDTO.class));
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
