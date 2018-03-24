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
public class TopSightsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Create an ArrayList for Top Sights fragment.
        // Populate string arrays with information from strings.xml.
        String[] topSightsVenues = getResources().getStringArray(R.array.top_sights_venues);
        String[] topSightsWorkingHours = getResources().getStringArray(R.array.top_sights_working_hours);
        String[] topSightsWebAddress = getResources().getStringArray(R.array.top_sights_web_address);

        // Get number of venues.
        // It's a counter for loops below.
        int venuesNameSize = topSightsVenues.length;

        // Populate int array with drawables ID's.
        int[] topSightsPhoto = new int[venuesNameSize];
        for (int i = 0; i < venuesNameSize; i++)
            topSightsPhoto[i] = getResources().getIdentifier("s_" + String.valueOf(i + 1), "drawable", getActivity().getPackageName());

        // Create Array List for Top Sights.
        final ArrayList<Riga> rigas = new ArrayList<>();
        for (int i = 0; i < venuesNameSize; i++) {
            String venueName = topSightsVenues[i];
            String workingHours = topSightsWorkingHours[i];
            String webAddress = topSightsWebAddress[i];
            int photo = topSightsPhoto[i];
            rigas.add(new Riga(venueName, workingHours, webAddress, photo));
        }

        // Use RigaAdapter.
        RigaAdapter adapter = new RigaAdapter(getActivity(), rigas, R.color.category_sights);
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
