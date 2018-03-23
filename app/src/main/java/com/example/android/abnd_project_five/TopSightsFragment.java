package com.example.android.abnd_project_five;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

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
        String[] top_sights_venues = getResources().getStringArray(R.array.top_sights_venues);
        String[] top_sights_working_hours = getResources().getStringArray(R.array.top_sights_working_hours);
        String[] top_sights_web_address = getResources().getStringArray(R.array.top_sights_web_address);

        // Get number of venues.
        // It's a counter for loops below.
        int venuesNameSize = top_sights_venues.length;

        // Populate int array with drawables ID's.
        int[] top_sights_photo = new int[venuesNameSize];
        for (int i = 0; i < venuesNameSize; i++)
            top_sights_photo[i] = getResources().getIdentifier("s_" + String.valueOf(i + 1), "drawable", getActivity().getPackageName());

        // Create Array List for Top Sights.
        final ArrayList<Riga> rigas = new ArrayList<>();
        for (int i = 0; i < venuesNameSize; i++) {
            String venue_name = top_sights_venues[i];
            String working_hours = top_sights_working_hours[i];
            String web_address = top_sights_web_address[i];
            int photo = top_sights_photo[i];
            rigas.add(new Riga(venue_name, working_hours, web_address, photo));
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
