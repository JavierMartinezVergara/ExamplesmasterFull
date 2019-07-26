package com.mockup.allexamples.JDBCImageSFTP;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.mockup.allexamples.R;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;
import java.net.SocketException;
import java.util.UUID;


public class ImageFTP extends AppCompatActivity implements View.OnClickListener {

    float ppequenyo;
    float pmediano;
    float pgrande;
    float pdefecto;

    Button negro;
    Button blanco;
    Button rojo;
    Button verde;
    Button azul;

    ImageButton trazo;
    ImageButton anyadir;
    ImageButton borrar;
    ImageButton guardar;

    private Lienzo lienzo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_ftp);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);


        lienzo = (Lienzo)findViewById(R.id.lienzo);

        negro = findViewById(R.id.colornegro);
        blanco = findViewById(R.id.colorblanco);
        rojo = findViewById(R.id.colorrojo);
        verde = findViewById(R.id.colorverde);
        azul = findViewById(R.id.colorazul);
        trazo = findViewById(R.id.trazo);
        anyadir = findViewById(R.id.anyadir);
        borrar = findViewById(R.id.borrar);
        guardar = findViewById(R.id.guardar);

        negro.setOnClickListener(this);
        blanco.setOnClickListener(this);
        rojo.setOnClickListener( this);
        verde.setOnClickListener(this);
        azul.setOnClickListener(this);
        trazo.setOnClickListener( this);
        anyadir.setOnClickListener( this);
        borrar.setOnClickListener( this);
        guardar.setOnClickListener(this);







    }



    public void onClick(View v) {
        String color = null;


        switch (v.getId()){
            case R.id.colornegro:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.colorblanco:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.colorazul:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.colorverde:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.colorrojo:
                color = v.getTag().toString();
                lienzo.setColor(color);
                break;
            case R.id.trazo:
                final Dialog tamanyopunto = new Dialog(this);
                tamanyopunto.setTitle("Tamaño del punto:");
                tamanyopunto.setContentView(R.layout.tamanyo_punto);
                //listen for clicks on tamaños de los botones
                TextView smallBtn = (TextView)tamanyopunto.findViewById(R.id.tpequenyo);
                smallBtn.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Lienzo.setBorrado(false);
                        Lienzo.setTamanyoPunto(ppequenyo);

                        tamanyopunto.dismiss();
                    }
                });
                TextView mediumBtn = (TextView)tamanyopunto.findViewById(R.id.tmediano);
                mediumBtn.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Lienzo.setBorrado(false);
                        Lienzo.setTamanyoPunto(pmediano);

                        tamanyopunto.dismiss();
                    }
                });
                TextView largeBtn = (TextView)tamanyopunto.findViewById(R.id.tgrande);
                largeBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Lienzo.setBorrado(false);
                        Lienzo.setTamanyoPunto(pgrande);

                        tamanyopunto.dismiss();
                    }
                });
                //show and wait for user interaction
                tamanyopunto.show();


                break;
            case R.id.anyadir:


                AlertDialog.Builder newDialog = new AlertDialog.Builder(this);
                newDialog.setTitle("Nuevo Dibujo");
                newDialog.setMessage("¿Comenzar nuevo dibujo (perderás el dibujo actual)?");
                newDialog.setPositiveButton("Aceptar", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which){

                        lienzo.NuevoDibujo();
                        dialog.dismiss();
                    }
                });
                newDialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which){
                        dialog.cancel();
                    }
                });
                newDialog.show();


                break;
            case R.id.borrar:

                final Dialog borrarpunto = new Dialog(this);
                borrarpunto.setTitle("Tamaño de borrado:");
                borrarpunto.setContentView(R.layout.tamanyo_punto);
                //listen for clicks on tamaños de los botones
                TextView smallBtnBorrar = (TextView)borrarpunto.findViewById(R.id.tpequenyo);
                smallBtnBorrar.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Lienzo.setBorrado(true);
                        Lienzo.setTamanyoPunto(ppequenyo);

                        borrarpunto.dismiss();
                    }
                });
                TextView mediumBtnBorrar = (TextView)borrarpunto.findViewById(R.id.tmediano);
                mediumBtnBorrar.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Lienzo.setBorrado(true);
                        Lienzo.setTamanyoPunto(pmediano);

                        borrarpunto.dismiss();
                    }
                });
                TextView largeBtnBorrar = (TextView)borrarpunto.findViewById(R.id.tgrande);
                largeBtnBorrar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Lienzo.setBorrado(true);
                        Lienzo.setTamanyoPunto(pgrande);

                        borrarpunto.dismiss();
                    }
                });
                //show and wait for user interaction
                borrarpunto.show();


                break;
            case R.id.guardar:

                AlertDialog.Builder salvarDibujo = new AlertDialog.Builder(this);
                salvarDibujo.setTitle("Salvar dibujo");
                salvarDibujo.setMessage("¿Salvar Dibujo a la galeria?");
                salvarDibujo.setPositiveButton("Aceptar", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which){

                        //Salvar dibujo
                        lienzo.setDrawingCacheEnabled(true);
                        //attempt to save
                        String imgSaved = MediaStore.Images.Media.insertImage(
                                getContentResolver(), lienzo.getDrawingCache(),
                                UUID.randomUUID().toString()+".png", "drawing");
                        //Mensaje de todo correcto

                        FTPClient ftp = new FTPClient();
                        FTPClientConfig config = new FTPClientConfig();
                        config.setServerTimeZoneId("Pacific/Pitcairn"); // change required options
                        // for example config.setServerTimeZoneId("Pacific/Pitcairn")
                        ftp.configure(config );
                        boolean error = false;
                        try {
                            int reply;
                            String server = "192.168.14.142";
                            ftp.connect(server);
                            System.out.println("Connected to " + server + ".");
                            System.out.print(ftp.getReplyString());

                            // After connection attempt, you should check the reply code to verify
                            // success.
                            reply = ftp.getReplyCode();

                            if(!FTPReply.isPositiveCompletion(reply)) {
                                ftp.disconnect();
                                System.err.println("FTP server refused connection.");
                                System.exit(1);
                            }
         // transfer files
                            ftp.logout();
                        } catch(IOException e) {
                            error = true;
                            e.printStackTrace();
                        }  finally {
                            if(ftp.isConnected()) {
                                try {
                                    ftp.disconnect();
                                } catch(IOException ioe) {
                                    // do nothing
                                }
                            }
                            System.exit(error ? 1 : 0);
                        }

                        if(imgSaved!=null){
                            Toast savedToast = Toast.makeText(getApplicationContext(),
                                    "¡Dibujo salvado en la galeria!", Toast.LENGTH_SHORT);
                            savedToast.show();
                        }
                        else{
                            Toast unsavedToast = Toast.makeText(getApplicationContext(),
                                    "¡Error! La imagen no ha podido ser salvada.", Toast.LENGTH_SHORT);
                            unsavedToast.show();
                        }
                        lienzo.destroyDrawingCache();


                    }
                });
                salvarDibujo.setNegativeButton("Cancelar", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which){
                        dialog.cancel();
                    }
                });
                salvarDibujo.show();

                break;
            default:

                break;
        }
    }

}
