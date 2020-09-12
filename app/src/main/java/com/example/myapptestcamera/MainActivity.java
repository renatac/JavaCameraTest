package com.example.myapptestcamera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Gallery;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Intent cameraIntent = null;
    Intent galleryIntent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        galleryIntent = new Intent(Intent.ACTION_PICK);
        Intent chooser = Intent.createChooser(galleryIntent, "");
        cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        chooser.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{cameraIntent});
        startActivityForResult(chooser, 3);

    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == 3 && resultCode == RESULT_OK) {
            if (intent.resolveActivity(this.getPackageManager()) != null) {
                Toast.makeText(MainActivity.this, "oi", Toast.LENGTH_LONG).show();


                if (intent == cameraIntent) {
                    Toast.makeText(MainActivity.this, "camera", Toast.LENGTH_LONG).show();
                    cameraIntent = null;
                } else if (intent == galleryIntent) {
                    Toast.makeText(MainActivity.this, "galeria", Toast.LENGTH_LONG).show();
                    galleryIntent = null;
                }
            }
        }
    }
}
