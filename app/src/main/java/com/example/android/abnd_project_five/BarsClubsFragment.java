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
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BarsClubsFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Create an ArrayList of top sights in Riga.

        final ArrayList<Riga> rigas = new ArrayList<>();
        rigas.add(new Riga("Latvian National Museum of Art", "10:00-18:00", "https://www.liveriga.com/en/1176-latvian-national-museum-of-art", R.drawable.s_1));


        // Use RigaAdapter.
        RigaAdapter adapter = new RigaAdapter(getActivity(), rigas, R.color.category_bars_clubs);
        View rootView = inflater.inflate(R.layout.activity_main, container, false);
        ListView listView = rootView.findViewById(R.id.riga);
        //ListView listView = findViewById(R.id.song);
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
