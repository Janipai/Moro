package com.example.moro;

import androidx.lifecycle.ViewModelProviders;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.moro.AboutUsFragment;
import com.example.moro.ContactFragment;
import com.example.moro.HomeFragment;
import com.example.moro.MainActivity;
import com.example.moro.OpretFragment;
import com.example.moro.R;
import com.example.moro.TipFragment;

public class LoginFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_login, container, false);
        Button bOP = (Button) myView.findViewById(R.id.buttonOpretLogin);
        Button bL = (Button) myView.findViewById(R.id.buttonLogin);

        bL.setOnClickListener(this);
        bOP.setOnClickListener(this);

        return myView;
    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        switch (v.getId()){
             case R.id.buttonLogin:
                fragment = new MinProfil();
                break;
            case R.id.buttonOpretLogin:
                fragment = new OpretFragment();
                break;
        }
        ((MainActivity) getActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment_container, fragment).addToBackStack(null).commit();

    }
}