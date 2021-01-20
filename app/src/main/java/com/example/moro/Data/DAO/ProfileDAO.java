package com.example.moro.Data.DAO;

import android.app.Activity;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.moro.Data.DTO.ProfileDTO;
import com.example.moro.Fragments.Login.LoginFragment;
import com.example.moro.Fragments.Login.OpretFragment;
import com.example.moro.Fragments.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

/**
 * @author Mikkel Johansen s175194
 */
public class ProfileDAO {
    private static final String TAG = "ProfileDAO";
    // Forbindelsen til databasen
    private final FirebaseFirestore mBase = FirebaseFirestore.getInstance();
    private final FirebaseAuth mAuth = FirebaseAuth.getInstance();

    /**
     * This method search for the user with the given userID and set the activeUser DTO to that person
     * @param userID The user ID
     * @param act The activity this method is called from
     */
    public void findUserInit(String userID, Activity act) {
        mBase.collection("Users").document(userID).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();
                if (document.exists()) {
                    Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                     ProfileDTO user = document.toObject(ProfileDTO.class);
                    MainActivity activity = ((MainActivity)act);
                    activity.setUserProfile(user);
                    //this method call is used to make the start up of the app synchronized
                    activity.getEvents();

                } else {
                    Log.d(TAG, "No such document");
                }
            } else {
                Log.d(TAG, "get failed with ", task.getException());
            }
        });
    }

    //this method is called to find a user matching the User id given in the login
    public void findUserSign(String userID, LoginFragment frag) {
        mBase.collection("Users").document(userID).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();
                if (document.exists()) {
                    Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                    ProfileDTO user = document.toObject(ProfileDTO.class);
                    ((MainActivity)frag.getActivity()).setUserProfile(user);
                    ((MainActivity)frag.getActivity()).updateFav();
                    frag.done();

                } else {
                    Log.d(TAG, "No such document");
                }
            } else {
                Log.d(TAG, "get failed with ", task.getException());
            }
        });
    }

    //used to delete an user
    public void deleteUser () {
        mBase.collection("Users").document(mAuth.getUid()).delete();
        mAuth.getCurrentUser().delete();
    }

    //this method is used to update an user, by overwritting it's db document
    public void updateUser (String userID, ProfileDTO dto) {
        mBase.collection("Users").document(userID).set(dto, SetOptions.merge());
    }

    //this method is used to create a new user in the database
    public void createUser (String userID, ProfileDTO dto, OpretFragment frag) {
        mBase.collection("Users").document(userID).set(dto)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d(TAG, "DocumentSnapshot successfully written!");
                ((MainActivity)frag.getActivity()).setUserProfile(dto);
                frag.done();
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error writing document", e);
                    }
                });
    }
}
