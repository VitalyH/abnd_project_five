package com.example.android.abnd_project_five;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RigaAdapter extends ArrayAdapter<Riga> {
    private int mColorResourceId;

    // Initialize the ArrayAdapter's internal storage.
    // Resource "0" because it's a custom adapter for more then one TextView.
    public RigaAdapter(Activity context, ArrayList<Riga> words, int colorResourceId) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the object located at this position in the list.
        Riga currentRiga = getItem(position);

        // Find in the list_item.xml the venue title and set on the TextView.
        TextView venueTextView = listItemView.findViewById(R.id.list_view_venue_title);
        venueTextView.setText(currentRiga.getVenueTitle());

        // Find in the list_item.xml the working hours and set on the TextView.
        TextView workingHoursTextView = listItemView.findViewById(R.id.list_view_working_hours);
        workingHoursTextView.setText(currentRiga.getWorkingHours());

        // Find in the list_item.xml the venue image and set on the ImageView.
        ImageView imageView = listItemView.findViewById(R.id.list_view_venue_image);
        imageView.setImageResource(currentRiga.getVenueImage());

        // Set the theme color for the list item.
        // Find the color from resource ID.
        // Set the background color of the text container.
        View textContainer = listItemView.findViewById(R.id.list_view_text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout.
        return listItemView;
    }
}