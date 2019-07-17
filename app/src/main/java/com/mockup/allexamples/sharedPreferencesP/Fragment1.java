package com.mockup.allexamples.sharedPreferencesP;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.mockup.allexamples.R;

import java.util.prefs.Preferences;

public class Fragment1 extends Fragment {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor sharepeditor;


    EditText editTextName, editTextPass;
    View view;
    Button buttonSaveData;
    CheckBox checkBox;
    Context context;

    private String text, text2;



    public Fragment1() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_viewpagersp, container, false);

        editTextName = view.findViewById(R.id.edName);
        editTextPass = view.findViewById(R.id.edPassword);
        buttonSaveData = view.findViewById(R.id.btnLogin);
        checkBox = view.findViewById(R.id.checkSave);



        buttonSaveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    saveData();
                Toast.makeText(getActivity(),"Datos guardados", Toast.LENGTH_SHORT);
            }
        });

        cargaData();
        updateViews();












        return view;
    }

    public void saveData(){
  //      context.getApplicationContext();

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        sharedPreferences = getActivity().getSharedPreferences("Preferencias",Context.MODE_PRIVATE);
        sharepeditor = sharedPreferences.edit();
        sharepeditor.putString("Nombre", editTextName.getText().toString());
        sharepeditor.putString("Password", editTextPass.getText().toString());

        sharepeditor.apply();

    }

    public void cargaData(){

        sharedPreferences = getActivity().getSharedPreferences("Preferencias",Context.MODE_PRIVATE);

        text = sharedPreferences.getString("Nombre", "");
        text2 = sharedPreferences.getString("Password", "");

    }

    public void updateViews() {
        editTextPass.setText(text2);
        editTextName.setText(text);
    }
}
