package com.example.moro.Fragments.BurgerMenu;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.moro.Data.DTO.TipDTO;
import com.example.moro.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * @author Mikkel Johansen s175194
 */
public class TipFragment extends Fragment implements View.OnFocusChangeListener {
    private static final String TAG = "TipFragment";
    AdapterView.OnItemSelectedListener dateListener;
    TipFragment activity = this;
    EditText eventName;
    EditText eventWhere;
    EditText eventWhat;
    EditText eventLink;
    Spinner dateSpinner;
    Spinner monthSpinner;
    Spinner yearSpinner;
    String name, about, where, link, day, month, year;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tip, container, false);
        Button submit = view.findViewById(R.id.tip_submit);

        //initializing my xml elements
        dateSpinner = view.findViewById(R.id.datePicker);
        monthSpinner = view.findViewById(R.id.monthPicker);
        yearSpinner = view.findViewById(R.id.yearPicker);
        eventName = view.findViewById(R.id.eventName);
        eventWhere = view.findViewById(R.id.eventWhere);
        eventWhat = view.findViewById(R.id.eventWhat);
        eventLink = view.findViewById(R.id.eventLink);

        //adding onFocus listeners to my Text fields
        eventName.setOnFocusChangeListener(this);
        eventWhere.setOnFocusChangeListener(this);
        eventWhat.setOnFocusChangeListener(this);
        eventLink.setOnFocusChangeListener(this);

        // initializing a new string Arraylist
        ArrayList<String> yy = new ArrayList<>();
        //adds the hint
        yy.add("YY");
        //finds the current year
        int a = Calendar.getInstance().get(Calendar.YEAR);
        //adds 100 year extra to the array
        for (int i = 0; i < 100; i++) {
            yy.add(Integer.toString(a + i));
        }

        dateListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String temp = parent.getItemAtPosition(position).toString();

                switch (view.getId()) {
                    case R.id.datePicker:
                        day = temp;
                        break;
                    case R.id.monthPicker:
                        month = temp;
                        break;
                    case R.id.yearPicker:
                        year = temp;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };

        //Creating the adapters for my spinners
        ArrayAdapter<CharSequence> dayAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.date_array, android.R.layout.simple_spinner_item);
        dayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> monthAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.month_array, android.R.layout.simple_spinner_item);
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<String> yearAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, yy);
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Applying the adapters and the selectListeners to the spinners
        dateSpinner.setAdapter(dayAdapter);
        dateSpinner.setOnItemSelectedListener(dateListener);
        monthSpinner.setAdapter(monthAdapter);
        monthSpinner.setOnItemSelectedListener(dateListener);
        yearSpinner.setAdapter(yearAdapter);
        yearSpinner.setOnItemSelectedListener(dateListener);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TipDTO tip = new TipDTO(name, where, about, link, day + "-" + month + "-" + year);
                //tries to add the new tip to the database
                FirebaseFirestore.getInstance().collection("Tips").add(tip).addOnSuccessListener(documentReference -> {
                    Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    Toast.makeText(activity.getContext(), "Tak for tippet!", Toast.LENGTH_SHORT).show();
                    //emtying out the text fields
                    eventName.getText().clear();
                    eventLink.getText().clear();
                    eventWhat.getText().clear();
                    eventWhere.getText().clear();
                    dateSpinner.setSelection(0);
                    monthSpinner.setSelection(0);
                    yearSpinner.setSelection(0);
                })
                        .addOnFailureListener(e -> {
                            Log.w(TAG, "Error while uploading tip", e);
                            Toast.makeText(activity.getContext(), "Noget gik galt prøv igen senere", Toast.LENGTH_SHORT).show();
                        });
            }
        });

        // returning the Inflated the layout for this fragment
        return view;
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus)
            return;
        switch (v.getId()) {
            case R.id.eventName:
                name = eventName.getText().toString();
                break;
            case R.id.eventWhere:
                where = eventWhere.getText().toString();
                break;
            case R.id.eventWhat:
                about = eventWhat.getText().toString();
                break;
            case R.id.eventLink:
                link = eventLink.getText().toString();
                break;
        }
    }
}

