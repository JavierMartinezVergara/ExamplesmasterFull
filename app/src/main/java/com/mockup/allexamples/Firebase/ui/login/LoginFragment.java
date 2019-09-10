package com.mockup.allexamples.Firebase.ui.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.mockup.allexamples.R;

public class LoginFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private EditText user, password;

    FloatingActionButton botonlogin;

    private FirebaseAuth firebaseAuth;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_home, container, false);

        user = root.findViewById(R.id.userfirebase);
        password = root.findViewById(R.id.passwordfirebase);

        botonlogin = root.findViewById(R.id.loginboton);

        firebaseAuth = FirebaseAuth.getInstance();

        botonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(root, "Se presionó el FAB", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                String email, passworddata;

                email = user.getText().toString();

                passworddata = password.getText().toString();

                firebaseAuth.signInWithEmailAndPassword(email,passworddata)
                        .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if(task.isSuccessful()){
                                    Toast.makeText(getContext(),"Bienvenido", Toast.LENGTH_LONG).show();
                                    FirebaseUser user = firebaseAuth.getCurrentUser();
                                    updateUI(user);
                                }
                                else {

                                    updateUI(null);

                                }

                            }
                        });



            }
        });






        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser usuarioactual = firebaseAuth.getCurrentUser();
        updateUI(usuarioactual);
    }

    private void updateUI(FirebaseUser usuarioactual) {
        if(user!=null){
            Toast.makeText(getContext(),"Ya has iniciado sesion", Toast.LENGTH_LONG).show();

        }

    }


}