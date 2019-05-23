package com.example.fotbollsapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.fotbollsapp.Fotboll;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


// Create a new class, Mountain, that can hold your JSON data

// Create a ListView as in "Assignment 1 - Toast and ListView"

// Retrieve data from Internet service using AsyncTask and the included networking code

// Parse the retrieved JSON and update the ListView adapter

// Implement a "refresh" functionality using Android's menu system


public class MainActivity extends AppCompatActivity {

    private ArrayList <Fotboll> Abboberg=new ArrayList<>();

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public  boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if (id == R.id.action_AboutPage){
            Intent intent = new Intent(this, About.class);
            startActivity(intent);
            return true;
        }
        if(id == R.id.action_refresh){
            new FetchData().execute();
            Abboberg.clear();
            return true;
        }

        return super.onOptionsItemSelected(item);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new FetchData().execute();
        final ArrayAdapter<Fotboll> adapter = new ArrayAdapter(getApplicationContext(), R.layout.list_item_textview,
                R.id.my_item_textView, Abboberg);


        ListView myListView= (ListView) findViewById(R.id.my_listView);

        myListView.setAdapter(adapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener()  {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               /*Toast.makeText( getApplicationContext(),Abboberg.get(position).info() , Toast.LENGTH_LONG).show();*/
                Intent intent = new Intent(getApplicationContext(),  Fotboll2.class);

                Fotboll f = adapter.getItem(position);

                intent.putExtra("name",f.getName());
                intent.putExtra("location",f.getLocation());
                intent.putExtra("league",f.getLeague());
                intent.putExtra("size",f.getSize());
                intent.putExtra("PremierLeaguewins",f.getPremierLeaguewins());
                intent.putExtra("FaCupwins",f.getFaCupwins());

                //intent.putExtra("berg", mountainNames [position]  );
                startActivity(intent);
            }


        });
    }

    private class FetchData extends AsyncTask<Void,Void,String>{
        @Override
        protected String doInBackground(Void... params) {
            // These two variables need to be declared outside the try/catch
            // so that they can be closed in the finally block.
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;

            // Will contain the raw JSON response as a Java string.
            String jsonStr = null;

            try {
                // Construct the URL for the Internet service
                URL url = new URL("http://wwwlab.iit.his.se/a18abuah/Premierleague.json");

                // Create the request to the PHP-service, and open the connection
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                // Read the input stream into a String
                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {
                    // Nothing to do.
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                    // But it does make debugging a *lot* easier if you print out the completed
                    // buffer for debugging.
                    buffer.append(line + "\n");
                }

                if (buffer.length() == 0) {
                    // Stream was empty.  No point in parsing.
                    return null;
                }
                jsonStr = buffer.toString();
                return jsonStr;
            } catch (IOException e) {
                Log.e("PlaceholderFragment", "Error ", e);
                // If the code didn't successfully get the weather data, there's no point in
                // attempting to parse it.
                return null;
            } finally{
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {
                        Log.e("Network error", "Error closing stream", e);
                    }
                }
            }
        }
        @Override
        protected void onPostExecute(String o) {
            super.onPostExecute(o);
            Log.d("test1",o);
            try {

                JSONArray jsonberg = new JSONArray(o);
                Log.d("test2",jsonberg.get(0).toString());

                for (int i = 0; i < jsonberg.length(); i++ ){
                    JSONObject Abbo = jsonberg.getJSONObject(i);
                    String Fotbollsnamn = Abbo.getString("name");
                    String Fotbollslocation=Abbo.getString("location");
                    String Fotbollscompany=Abbo.getString("company");
                    String Fotbollscategory=Abbo.getString("category");
                    int Fotbollscost = Abbo.getInt("cost");
                    int Fotbollssize = Abbo.getInt("size");
                    String auxdata = Abbo.getString("auxdata");

                    JSONObject auxobjekt= new JSONObject(auxdata);
                    int Premierleaguewins = auxobjekt.getInt("PremierLeaguewins");
                    int Facupswins = auxobjekt.getInt("FaCupwins");

                    Log.d("test3" ,""+auxobjekt.getInt("PremierLeaguewins") );
                    // (String stringname, String inLeague,String stringcategory,String stringlocation,int intcost, int intsize)
                   // Log.d("test1 JsonElement: ", "\t" + Fotbollsnamn + " " + Premierleaguewins + " " + Fawins);
                    Abboberg.add(new Fotboll(Fotbollsnamn,Fotbollscompany, Fotbollscategory, Fotbollslocation, Fotbollscost,Fotbollssize,Premierleaguewins,Facupswins));

                }
                ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), R.layout.list_item_textview,
                        R.id.my_item_textView, Abboberg);


                ListView myListView= (ListView) findViewById(R.id.my_listView);

                myListView.setAdapter(adapter);



            } catch (JSONException e) {
                Log.e("test4","E:"+e.getMessage());
            }
            // This code executes after we have received our data. The String object o holds
            // the un-parsed JSON string or is null if we had an IOException during the fetch.

            // Implement a parsing code that loops through the entire JSON and creates objects
            // of our newly created Mountain class.
        }
    }
}

