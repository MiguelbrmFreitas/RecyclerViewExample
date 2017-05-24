package br.unb.miguel.recyclerviewexample;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Miguel on 24/05/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.CardViewHolder> {

    private Context mContext;
    MyOnItemClickListener mItemClickListener;

    private ArrayList<Animal> animalArrayList; // List of the animals

    /**
     * Constructor
     * @param animalArrayList   List of animals
     */
    public RecyclerViewAdapter(ArrayList<Animal> animalArrayList) {
        this.animalArrayList = animalArrayList;
    }

    @Override
    public int getItemCount() {
        return animalArrayList.size();
    }


    /**
     * Class to bind the attributes to the view holder
     * @param animalViewHolder  View Holder contains the attributes of the view
     * @param i Position in the list
     */
    @Override
    public void onBindViewHolder(CardViewHolder animalViewHolder, int i) {
        Animal animal = animalArrayList.get(i);

        animalViewHolder.vName.setText(animal.get_name());
        animalViewHolder.vDescription.setText(animal.get_description());

        int imageFileDrawable = animal.get_imageFileDrawable();

        // Using the reference to the drawable file
        animalViewHolder.vImg.setImageBitmap(decodeSampledBitmapFromResource(mContext.getResources(), imageFileDrawable, 100, 100));
    }

    /**
     * Constructor of view holder
     * @param viewGroup group of the view
     * @param i position
     * @return return a new view holder
     */
    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.card_layout, viewGroup, false);

        mContext = itemView.getContext();

        return new CardViewHolder(itemView);
    }

    /**
     * Inner class of the CardViewHolder to manage and bind the attributes
     */
    class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView vName;
        TextView vDescription;
        ImageView vImg;

        CardViewHolder(View v) {
            super(v);
            vName =  (TextView) v.findViewById(R.id.card_title);
            vDescription = (TextView)  v.findViewById(R.id.card_description);
            vImg = (ImageView) v.findViewById(R.id.card_img);
            v.setOnClickListener(this);
        }

        /**
         * Method to define what to do when an element is clicked
         * @param view Reference to the view clicked
         */
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext, "The animal " + vName.getText() + " was clicked!", Toast.LENGTH_SHORT).show(); // show a message
        }
    }

    public void SetOnItemClickListener(final MyOnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    // The following methods are just to optimize the bitmap reading

    private static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    private static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }
}

