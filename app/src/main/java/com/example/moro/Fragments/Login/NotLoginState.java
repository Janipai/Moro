package com.example.moro.Fragments.Login;

import androidx.fragment.app.FragmentManager;

import com.example.moro.Fragments.CustomFragment;

/**
 * @author s195477, Shania Hau
 */
public class NotLoginState extends CustomFragment implements States {

    @Override
    public void createUserPressed(Context context) {
        replaceFragment(new OpretFragment());
    }

    @Override
    public void profilePressed(Context context, FragmentManager fragmentManager) {
        replaceFragment(new LoginFragment(),fragmentManager);
    }

    @Override
    public void favouriteFragment(Context context, FragmentManager fragmentManager) {
        replaceFragment(new LoginFragment(), fragmentManager);
    }
}
