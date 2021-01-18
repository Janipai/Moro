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

/*** Back Stack håndtering
 * @author Mads H
 */
public abstract class CustomFragment extends Fragment {

Animation animation;

    // https://stackoverflow.com/questions/18305945/how-to-resume-fragment-from-backstack-if-exists
    public void replaceFragment (Fragment fragment){
        String backStateName = fragment.getClass().getName();
        FragmentManager manager = getActivity().getSupportFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate(backStateName, 0); //POP kan være 0

        FragmentTransaction ft = manager.beginTransaction();
        if (!fragmentPopped){ //fragment not in back stack, create it.
            //shan laver farlige ting
            ft.setCustomAnimations(R.anim.fade_in,R.anim.fade_out);
            //ft.setCustomAnimations()
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
            ft.replace(R.id.main_fragment_container, fragment);
            ft.addToBackStack(backStateName);
            ft.commit();
        }
    }


//    private static final String BACK_STACK_ROOT_TAG = "root_fragment";
//    public void readyBackStack(Fragment fragment, FragmentManager fragmentManager) {
//        FragmentTransaction ft = fragmentManager.beginTransaction();
//        fragmentManager.popBackStack(BACK_STACK_ROOT_TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE);
//        ft.replace(R.id.main_fragment_container, new HomeFragment()).addToBackStack(BACK_STACK_ROOT_TAG).commit();
//    }
}
