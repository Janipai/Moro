package com.example.moro.Fragments;

import android.app.Activity;

import android.view.View;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.moro.Fragments.Login.Context;
import com.example.moro.R;

/** Back Stack håndtering
 * @author Mads H
 */
public abstract class CustomFragment extends Fragment {


    // https://stackoverflow.com/questions/18305945/how-to-resume-fragment-from-backstack-if-exists
    public void replaceFragment (Fragment fragment){
        String backStateName = fragment.getClass().getName();
        FragmentManager manager = getActivity().getSupportFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate(backStateName, 0);

        FragmentTransaction ft = manager.beginTransaction();
        if (!fragmentPopped && manager.findFragmentByTag(backStateName) == null){ //fragment not in back stack, create it.
            //@author s195477 Shania Hau
            ft.setCustomAnimations(R.anim.enter_right_to_left,
                    R.anim.exit_right_to_left,
                    R.anim.enter_left_to_right,
                    R.anim.exit_left_to_right);
            ft.replace(R.id.main_fragment_container, fragment);
            ft.addToBackStack(backStateName);
            ft.commit();
        }
    }

    public void replaceFragment (Fragment fragment, FragmentManager fragmentManager){
        String backStateName = fragment.getClass().getName();
        FragmentManager manager = fragmentManager;
        boolean fragmentPopped = manager.popBackStackImmediate (backStateName, 0); //POP kan være 0

        FragmentTransaction ft = manager.beginTransaction();
        if (!fragmentPopped){ //fragment not in back stack, create it.
            ft.setCustomAnimations(R.anim.enter_right_to_left,
                    R.anim.exit_right_to_left,
                    R.anim.enter_left_to_right,
                    R.anim.exit_left_to_right).replace(R.id.main_fragment_container, fragment);
            ft.addToBackStack(backStateName);
            ft.commit();
        }
    }
}
