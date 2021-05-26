package com.example.trivialcomida;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class GalleryActivity extends AppCompatActivity {
    private static final String TAG = "GalleryActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Log.d(TAG, "onCreate: started.");

        //Toolbar Back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getIncomingIntent();
    }

    //Get to onClick method -> RecyclerViewAdapter(class)
    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");

        //Check the intents have extras before try to get the extras
        if(getIntent().hasExtra("image_urls") && getIntent().hasExtra("plate_name") && getIntent().hasExtra("plate_description")){
            Log.d(TAG, "getIncomingIntent: found intent extras.");

            //This prevent the app crash
            String imageUrls = getIntent().getStringExtra("image_urls");
            String plateName = getIntent().getStringExtra("plate_name");
            String plateDescription = getIntent().getStringExtra("plate_description");

            setImage(imageUrls, plateName, plateDescription);
        }
    }

    //Set the plate image, name and description to widgets
    private void setImage(String imageUrls, String plateName, String plateDescription){
        Log.d(TAG, "setImage: setting the image, name and description to widgets.");

        //Where catch
        TextView gPlateName = findViewById(R.id.gplate_name);
        gPlateName.setText(plateName);

        TextView gPlateDescription = findViewById(R.id.gplate_description);
        gPlateDescription.setText(plateDescription);

        ImageView gImage = findViewById(R.id.gimage_plate);
        Glide.with(this)
                .asBitmap()
                .load(imageUrls)
                .into(gImage);
    }
}
