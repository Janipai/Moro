package com.example.moro.Data.ADatabaseCon;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.moro.Data.DTO.EventDTO;
import com.example.moro.Data.DTO.MikkelEventDTO;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Connection {
    private static final String TAG = "Connectivity";
    private ArrayList<MikkelEventDTO> events = new ArrayList<>();
    private static Connection instance;

    private Connection(){}

    public static Connection getInstance() {
        if (instance != null)
            return instance;
        return  instance = new Connection();
    }

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public void insertInCollection(String collectionPath, HashMap<String, Object> data){
        db.collection(collectionPath)
        .add(data)
        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Log.d("Tag", "Success transfering data!");
            }
        })
        .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("Tag", "Something went wrong under transmission");
            }
        });
    }

    public void readFromCollection(String collectionPath){
        db.collection(collectionPath)
                .get()
                .addOnCompleteListener(task -> {
                    if(task.isSuccessful()){
                        for(QueryDocumentSnapshot document : task.getResult()){
                            Log.d("Tag", document.getId() + "=> " + document.getData());
                        }
                    } else {
                        Log.w("Tag", "Error getting documents", task.getException());
                    }
                });
    }
    public void getAll(){
        db.collection("Events")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                events.add(document.toObject(MikkelEventDTO.class));
                                Log.d(TAG, String.valueOf(events.size()));
                            }
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });
    }
    public void getAllFromCollection(String collectionPath){
        db.collection(collectionPath)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if(queryDocumentSnapshots.isEmpty()){
                            Log.d("TAG", "OnSuccess the Document is empty");
                            return;
                        } else {
                                List<EventDTO> types = queryDocumentSnapshots.toObjects(EventDTO.class);

                                //events.addAll(types);
                                Log.d("Tag", "OnSuccess" + events);
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w("Tag", "Something went wrong");
            }
        });
    }

    public ArrayList<MikkelEventDTO> getEvents(){
        return events;
    }
}
