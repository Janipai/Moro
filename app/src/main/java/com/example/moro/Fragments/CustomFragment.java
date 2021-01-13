package com.example.moro.Fragments;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.moro.R;

/* Back stack håndtering
Udviklet af Mads H.*/
public abstract class CustomFragment extends Fragment {


    // https://stackoverflow.com/questions/18305945/how-to-resume-fragment-from-backstack-if-exists
    public void replaceFragment (Fragment fragment){
        String backStateName = fragment.getClass().getName();
        FragmentManager manager = getActivity().getSupportFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate (backStateName, 0); //POP kan være 0

        FragmentTransaction ft = manager.beginTransaction();
        if (!fragmentPopped){ //fragment not in back stack, create it.
            ft.replace(R.id.main_fragment_container, fragment);
            ft.addToBackStack(backStateName);
            ft.commit();
        }
    }

   /* private static final String BACK_STACK_ROOT_TAG = "root_fragment";
    public void resetBackStack() {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        manager.popBackStack(BACK_STACK_ROOT_TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        ft.replace(R.id.main_fragment_container, new HomeFragment()).addToBackStack(BACK_STACK_ROOT_TAG).commit();
    }*/
}
