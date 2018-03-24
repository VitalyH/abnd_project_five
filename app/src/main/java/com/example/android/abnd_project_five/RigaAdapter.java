package com.example.android.abnd_project_five;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RigaAdapter extends ArrayAdapter<Riga> {
    private int mColorResourceId;

    // Initialize ViewHolder.
    public static class ViewHolder {
        TextView textViewVenue;
        TextView textViewHours;
        TextView textViewPriceRangeTag;
        TextView textViewPriceRange;
        ImageView imageViewPhoto;
        RelativeLayout textContainer;
    }

    // Initialize the ArrayAdapter's internal storage.
    // Resource "0" because it's a custom adapter for more then one TextView.
    public RigaAdapter(Activity context, ArrayList<Riga> words, int colorResourceId) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view.
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the object located at this positioren in the list.
        Riga currentRiga = getItem(position);

        // Create new ViewHolder for text views.
        ViewHolder holder = new ViewHolder();
        holder.textViewVenue = convertView.findViewById(R.id.list_view_venue_title);
        holder.textViewVenue.setText(currentRiga.getVenueTitle());
        holder.textViewHours = convertView.findViewById(R.id.list_view_working_hours);
        holder.textViewHours.setText(currentRiga.getWorkingHours());
        holder.textViewPriceRangeTag = convertView.findViewById(R.id.list_view_price_range_tag);
        holder.textViewPriceRange = convertView.findViewById(R.id.list_view_price_range);


        // Check whether or not there is price range field.
        if (currentRiga.hasPriceRange()) {
            holder.textViewPriceRange.setText(currentRiga.getPriceRange());
            holder.textViewPriceRange.setVisibility(View.VISIBLE);
            holder.textViewPriceRangeTag.setVisibility(View.VISIBLE);
        } else {
            holder.textViewPriceRange.setVisibility(View.GONE);
            holder.textViewPriceRangeTag.setVisibility(View.GONE);
        }

        // Handle an image.
        holder.imageViewPhoto = convertView.findViewById(R.id.list_view_venue_image);
        holder.imageViewPhoto.setImageResource(currentRiga.getVenueImage());

        // Set color of the container.
        holder.textContainer = convertView.findViewById(R.id.list_view_text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        holder.textContainer.setBackgroundColor(color);

        // Return the whole list item layout.
        return convertView;
    }
}