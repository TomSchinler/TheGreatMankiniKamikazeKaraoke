package tomschinler.thegreatman_kiniskamikazekaraoke;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.PopupMenu;
import android.widget.Spinner;


public class KamikazeSelect extends ActionBarActivity implements AdapterView.OnItemSelectedListener {

    private static  final String TAG = "Variable is ";




    private String mDecade;
    private String mGenre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kamikaze_select);


        //Genre Select Spinner
        Spinner spinner = (Spinner) findViewById(R.id.genreSelect);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.genreOptions, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        //Decade Select Spinner
        Spinner spinner2 = (Spinner) findViewById(R.id.decadeSelect);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.decadeOptions, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_kamikaze_select, menu);
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


    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner spinner = (Spinner) parent;
        // Genre Select Spinner logic
        if(spinner.getId() == R.id.genreSelect)
        {
            if (position == 0) {
                // select all from DB if no selection is made
                mGenre = "*";
                Log.v(TAG, mGenre);
            }
            else {
                // use spinner input to narrow DB Query
                mGenre = spinner.getItemAtPosition(position).toString();
                Log.v(TAG, mGenre);
            }
        }
        else if(spinner.getId() == R.id.decadeSelect)
        {
            //do this
            if (position == 0) {
                // select all from DB if no selection is made
                mDecade = "*";
            }
                // set mDecade based on spinner selected
            else if (position == 1) {
                mDecade = "50";
                Log.v(TAG, mDecade);
            }
            else if (position == 2) {
                mDecade = "60";
                Log.v(TAG, mDecade);
            }
            else if (position == 3 ) {
                mDecade = "70";
                Log.v(TAG, mDecade);
            }
            else if (position == 4 ) {
                mDecade = "80";
                Log.v(TAG, mDecade);
            }
            else if (position == 5 ) {
                mDecade = "90";
                Log.v(TAG, mDecade);
            }
            else if (position == 6 ) {
                mDecade = "00";
                Log.v(TAG, mDecade);
            }
            else if (position == 7 ) {
                mDecade = "10";
                Log.v(TAG, mDecade);
            }
        }

    }


    public void onNothingSelected(AdapterView<?> parent) {
        //required method not used in this application
    }

    // opens new fragment when button is pushed
    public void song(View view) {
        Intent intent = new Intent(this, SongActivity.class);
        intent.putExtra("Genre", mGenre);
        intent.putExtra("Decade", mDecade);
        startActivity(intent);
    }






}
