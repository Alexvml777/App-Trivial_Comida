
package com.example.trivialcomida;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";
    //Vars
    private ArrayList<String> mImagePlate = new ArrayList<>();
    private ArrayList<String> mPlateName = new ArrayList<>();
    private ArrayList<String> mPlateDescription = new ArrayList<>();
    private Context mContext;

    //Constructor method as vars
    public RecyclerViewAdapter( Context mContext, ArrayList<String> mImagePlate, ArrayList<String> mPlateName, ArrayList<String> mPlateDescription) {
        this.mImagePlate = mImagePlate;
        this.mPlateName = mPlateName;
        this.mPlateDescription = mPlateDescription;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    //Return layout create by a ViewHolder and inflate as a view
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    //Receive a ViewlHolder and list position
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        //Get Images
        Glide.with(mContext)
                .asBitmap()
                .load(mImagePlate.get(position))
                .into(holder.imagePlate);

        //Use ViewHolder: set plateName and plateDescription
        holder.plateName.setText(mPlateName.get(position));
        holder.plateDescription.setText(mPlateDescription.get(position));

        //Add Toast popup & called GalleryActivity(class)
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on:" + mPlateName.get(position));

                Toast.makeText(mContext, mPlateName.get(position), Toast.LENGTH_SHORT).show();

                //Start called activity
                Intent intent = new Intent(mContext, GalleryActivity.class);
                intent.putExtra("image_urls", mImagePlate.get(position));
                intent.putExtra( "plate_name", mPlateName.get(position));
                intent.putExtra("plate_description", mPlateDescription.get(position));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    //Returns how many items are in the list
    public int getItemCount() { return mPlateName.size(); }

    //Reference each View (layout_listitem.xml)
    public class ViewHolder extends RecyclerView.ViewHolder {
        //Vars
        CircleImageView imagePlate;
        TextView plateName, plateDescription;
        RelativeLayout parentLayout;

        //Where catch
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imagePlate = itemView.findViewById(R.id.image_plate);
            plateName = itemView.findViewById(R.id.plate_name);
            plateDescription = itemView.findViewById(R.id.plate_description);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
