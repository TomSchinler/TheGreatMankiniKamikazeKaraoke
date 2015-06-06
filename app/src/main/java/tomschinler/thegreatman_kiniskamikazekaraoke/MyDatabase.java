package tomschinler.thegreatman_kiniskamikazekaraoke;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.TextView;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by TomandGina on 3/9/2015.
 */
public class MyDatabase extends SQLiteAssetHelper {


    private static final String DATABASE_NAME = "mankiniDB.sqlite";
    private static final int DATABASE_VERSION = 1;






    public MyDatabase(SongActivity context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public Cursor kamikazeSelected() {
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor =db.rawQuery("SELECT * FROM songList ORDER BY random() limit 1", null);

        return cursor;
    }

    public Cursor genreSelected(final String genre) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor =db.rawQuery("SELECT * FROM songList WHERE Genre = ? ORDER BY random() limit 1", new String[] {genre});
        return cursor;
    }

    public Cursor decadeSelected(final String decade) {
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor =db.rawQuery("SELECT * FROM songList WHERE Decade = ? ORDER BY random() limit 1", new String[] {decade});
        return cursor;
    }

    public Cursor bothSelected(final String genre, String decade) {

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor =db.rawQuery("SELECT * FROM songList WHERE Decade = ? AND Genre = ? ORDER BY random() limit 1", new String[] {decade, genre});

        return cursor;
    }

}
