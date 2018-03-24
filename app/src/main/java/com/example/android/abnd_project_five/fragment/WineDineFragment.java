package com.example.android.abnd_project_five.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.abnd_project_five.R;
import com.example.android.abnd_project_five.Riga;
import com.example.android.abnd_project_five.RigaAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class WineDineFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Create an ArrayList for Wine&Dine fragment.
        // Populate string arrays with information from strings.xml.
        String[] wineDineVenues = getResources().getStringArray(R.array.wine_dine_venues);
        String[] wineDineWorkingHours = getResources().getStringArray(R.array.wine_dine_working_hours);
        String[] wineDinePriceRange = getResources().getStringArray(R.array.wine_dine_price_range);
        String[] wineDineWebAddress = getResources().getStringArray(R.array.wine_dine_web_address);

        // Get number of venues.
        // It's a counter for loops below.
        int venuesNameSize = wineDineVenues.length;

        // Populate int array with drawables ID's.
        int[] wineDinePhoto = new int[venuesNameSize];
        for (int i = 0; i < venuesNameSize; i++)
            wineDinePhoto[i] = getResources().getIdentifier("wd_" + String.valueOf(i + 1), "drawable", getActivity().getPackageName());

        // Create Array List for Wine&Dine.
        final ArrayList<Riga> rigas = new ArrayList<>();
        for (int i = 0; i < venuesNameSize; i++) {
            String venueName = wineDineVenues[i];
            String workingHours = wineDineWorkingHours[i];
            String priceRange = wineDinePriceRange[i];
            String webAddress = wineDineWebAddress[i];
            int photo = wineDinePhoto[i];
            rigas.add(new Riga(venueName, workingHours, priceRange, webAddress, photo));
        }

        // Use RigaAdapter.
        RigaAdapter adapter = new RigaAdapter(getActivity(), rigas, R.color.category_wine_dine);
        View rootView = inflater.inflate(R.layout.activity_main, container, false);
        ListView listView = rootView.findViewById(R.id.riga);
        if (listView != null) {
            listView.setAdapter(adapter);

            // Handle clicks on items in ListView.
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    // Get the Riga object at the given position the user clicked on.
                    Riga riga = rigas.get(position);
                    // Open link in the browser.
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(riga.getRigaWeb()));
                    startActivity(browserIntent);
                }
            });
        }
        return rootView;
    }
}
