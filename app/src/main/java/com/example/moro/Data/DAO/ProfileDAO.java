package com.example.moro.Data.DAO;

import android.app.Activity;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.moro.Data.ADatabaseCon.Connection;
import com.example.moro.Data.DTO.EventDTO;
import com.example.moro.Data.DTO.MikkelEventDTO;
import com.example.moro.Data.DTO.ProfileDTO;
import com.example.moro.Fragments.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.net.UnknownHostException;
import java.util.ArrayList;

public class ProfileDAO {
    private static final String TAG = "ProfileDAO";
    // Forbindelsen til databasen
    private final FirebaseFirestore mBase = FirebaseFirestore.getInstance();

    // Definer final strings til kommunikation til databasen
    //private final String profilePassword = "password";
    private final String profileUsername = "userID";
    private final String profileDateBorn = "dateborn";
    private final String profileFavourites = "favourites";

    public ProfileDAO () {
    }

    public void test() {
        ProfileDTO dto = new ProfileDTO("mikkel",
                "dk@gmail.dk",
                "123",
                "123456",
                new ArrayList<>()
        );
        createUser("123", dto);
    }

    public void findUser (String userID, Activity act) {
        mBase.collection("Users").document(userID).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                         ProfileDTO user = document.toObject(ProfileDTO.class);
                        MainActivity activity = ((MainActivity)act);
                        activity.setUserProfile(user);
                        activity.getEvents();

                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
    }

    public void deleteUser () {


    }

    public void updateUser (String userID, ProfileDTO dto) {

    }

    public void createUser (String userID, ProfileDTO dto) {
        mBase.collection("Users").document(userID).set(dto);
    }
}
