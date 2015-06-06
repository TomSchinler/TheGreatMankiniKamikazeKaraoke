package tomschinler.thegreatman_kiniskamikazekaraoke;


import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;


public class SongActivity extends ActionBarActivity {

    private MyDatabase db;
    private static  final String TAG = "We got ";

    String mGenre;
    String mDecade;


    public String getGenre() {
        return mGenre;
    }

    public String getDecade() {
        return mDecade;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        //when activity launches query database using user params

        mGenre = getIntent().getExtras().getString("Genre");
        mDecade = getIntent().getExtras().getString("Decade");
        Log.v(TAG, mGenre);
        Log.v(TAG, mDecade);

        String songTitle = "";
        String songArtist = "";
        String songYear = "";

        TextView mSongTitle = (TextView)findViewById(R.id.songTitle);
        TextView mSongArtist = (TextView)findViewById(R.id.songArtist);
        TextView mSongYear = (TextView)findViewById(R.id.songYear);




        db= new MyDatabase(this);




        if (mGenre.equals("*") && mDecade.equals("*")) {

            Cursor cursor = db.kamikazeSelected();
            try {
                while (cursor.moveToNext()) {
                    songTitle = cursor.getString(1);
                    songArtist = cursor.getString(2);
                    songYear = cursor.getString(4);
                }
            } finally {
                cursor.close();
            }
            db.close();

        }
        else if (!mGenre.equals("*") && mDecade.equals("*")) {
            Cursor cursor = db.genreSelected(mGenre);
            try {
                while (cursor.moveToNext()) {
                    songTitle = cursor.getString(1);
                    songArtist = cursor.getString(2);
                    songYear = cursor.getString(4);
                }
            } finally {
                cursor.close();
            }
            db.close();
        }

        else if (mGenre.equals("*") && !mDecade.equals("*")) {
            Cursor cursor = db.decadeSelected(mDecade);
            try {
                while (cursor.moveToNext()) {
                    songTitle = cursor.getString(1);
                    songArtist = cursor.getString(2);
                    songYear = cursor.getString(4);
                }
            } finally {
                cursor.close();
            }
            db.close();
        }

        else if (!mGenre.equals("*") && !mDecade.equals("*")) {
            Cursor cursor = db.bothSelected(mGenre, mDecade);
            try {
                while (cursor.moveToNext()) {
                    songTitle = cursor.getString(1);
                    songArtist = cursor.getString(2);
                    songYear = cursor.getString(4);
                }
            } finally {
                cursor.close();
            }
            db.close();
        }
        mSongTitle.setText(songTitle);
        mSongArtist.setText(songArtist);
        mSongYear.setText(songYear);


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


}
