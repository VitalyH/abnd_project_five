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
public class BarsClubsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Create an ArrayList for Bars&Clubs fragment.
        // Populate string arrays with information from strings.xml.
        String[] barsClubsVenues = getResources().getStringArray(R.array.bars_clubs_venues);
        String[] barsClubsWorkingHours = getResources().getStringArray(R.array.bars_clubs_working_hours);
        String[] barsClubsPriceRange = getResources().getStringArray(R.array.bars_clubs_price_range);
        String[] barsClubsWebAddress = getResources().getStringArray(R.array.bars_clubs_web_address);

        // Get number of venues.
        // It's a counter for loops below.
        int venuesNameSize = barsClubsVenues.length;

        // Populate int array with drawables ID's.
        int[] barsClubsPhoto = new int[venuesNameSize];
        for (int i = 0; i < venuesNameSize; i++)
            barsClubsPhoto[i] = getResources().getIdentifier("bc_" + String.valueOf(i + 1), "drawable", getActivity().getPackageName());

        // Create Array List for Bars&Clubs.
        final ArrayList<Riga> rigas = new ArrayList<>();
        for (int i = 0; i < venuesNameSize; i++) {
            String venueName = barsClubsVenues[i];
            String workingHours = barsClubsWorkingHours[i];
            String priceRange = barsClubsPriceRange[i];
            String webAddress = barsClubsWebAddress[i];
            int photo = barsClubsPhoto[i];
            rigas.add(new Riga(venueName, workingHours, priceRange, webAddress, photo));
        }

        // Use RigaAdapter.
        RigaAdapter adapter = new RigaAdapter(getActivity(), rigas, R.color.category_bars_clubs);
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
