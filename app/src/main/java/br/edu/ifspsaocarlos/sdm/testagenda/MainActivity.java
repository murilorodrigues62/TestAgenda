package br.edu.ifspsaocarlos.sdm.testagenda;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public static final String AUTHORITY = "br.edu.ifspsaocarlos.contatocp.provider";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/contatos");
    public static final String KEY_NAME = "nome";
    public static final String KEY_FONE = "fone";
    public static final String KEY_FONE2 = "fone2";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_NIVER = "niver";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, "Contato via Content Provider");
        values.put(KEY_FONE, "980000000");
        values.put(KEY_EMAIL, "content@provider.com");
        values.put(KEY_FONE2, "990000000");
        values.put(KEY_NIVER, "06/65");

        Uri ins=getContentResolver().insert(CONTENT_URI, values);

        Cursor cursor=getContentResolver().query(CONTENT_URI, null, null, null, null);
        while (cursor.moveToNext()) {
            Log.d("Nome:", cursor.getString(1));
            Log.d("Fone:", cursor.getString(2));
            Log.d("Email:", cursor.getString(3));
            Log.d("Fone 2:", cursor.getString(4));
            Log.d("Aniversario:", cursor.getString(5));
        }

    }
}
