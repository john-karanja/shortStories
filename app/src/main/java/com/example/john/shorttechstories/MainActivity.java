package com.example.john.shorttechstories;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        private ArrayAdapter<String> storiesadapter;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            String[] listitemtechstories = {
                    "Bill Gates and Microsoft",
                    "Steve Jobs, Woz & Apple",
                    "Sergey,Larry Page & Google ",
                    "Mark Zuckerberg & Facebook",
                    "Larry Elison & Oracle",
                    "The Paypal Mafia",
                    "The Twitter Story",
                    "The John Karanja Story"
            };

            List<String> techstories = new ArrayList<String>(
                    Arrays.asList(listitemtechstories));

            //InitializeAdapter
            ArrayAdapter<String> storiesadapter = new ArrayAdapter<String>(
                    getActivity(),
                    //reference layout.ID of list item layout
                    R.layout.list_item_techstoies,
                    //reference textview.ID of the textview to populate
                    R.id.list_item_techstories_textview,
                    //list of tech stories of data
                    techstories );


            //Get a reference to the list view, and attach this adapter to the list view
            ListView listView = (ListView) rootView.findViewById(
                    R.id.listview_techstories);
            listView.setAdapter(storiesadapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int Position
                        , long id) {
                Intent intent = new Intent();
                    switch (Position){
                        case 0:
                          intent = new Intent(getActivity(), Bill_gates.class);
                            break;
                        case 1:
                            intent = new Intent(getActivity(), Steveandwoz.class);
                            break;
                        case 2:
                            intent = new Intent(getActivity(), Sergeyandlarry.class);
                        case 3:
                            intent = new Intent(getActivity(), Markzuckerberg.class);
                        case 4:
                            intent = new Intent(getActivity(), LarryElison.class);
                        case 5:
                            intent = new Intent(getActivity(), Thepaypalmafia.class);
                        case 6:
                            intent = new Intent(getActivity(), Thetwitterstory.class);
                        case 7:
                            intent = new Intent(getActivity(), Thejohnkaranjastory.class);







                    }

                    startActivity(intent);


                }
            });

            return rootView;
        }
    }
}
