package com.example.moro.Fragments.Login;

import androidx.fragment.app.FragmentManager;

import com.example.moro.Data.DTO.EventDTO;

import java.util.ArrayList;

/**
 * @author s195477, Shania Hau
 */
public interface States {
    //not login
    void createUserPressed(Context context);
    void profilePressed(Context context, FragmentManager fragmentManager);
    //login
    void favouriteFragment (Context context, FragmentManager fragmentManager);
}
