package com.example.moro.Fragments.Login;

import androidx.fragment.app.FragmentManager;

import com.example.moro.Data.DAO.ProfileDAO;
import com.example.moro.Data.DTO.EventDTO;
import com.example.moro.Data.DTO.ProfileDTO;
import com.example.moro.Fragments.CustomFragment;
import com.example.moro.Fragments.HomeFragment;

import java.util.ArrayList;

/**
 * @author s195477, Shania Hau
 */

public class LoginState extends CustomFragment implements States {

    @Override
    public void createUserPressed(Context context) {
        replaceFragment(new HomeFragment());
    }

    @Override
    public void profilePressed(Context context, FragmentManager fragmentManager) {
        replaceFragment(new MyProfile(), fragmentManager);
    }

    @Override
    public void favouriteFragment(Context context, FragmentManager fragmentManager) {
        replaceFragment(new FavouritesFragment(), fragmentManager);
    }
}
