package com.example.contactstest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    ArrayAdapter<String> adapter;
//
//    List<String> contactsList = new ArrayList<>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        ListView contactsView = (ListView) findViewById(R.id.contacts_view);
//        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contactsList);
//        contactsView.setAdapter(adapter);
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 1);
//        } else {
//            readContacts();
//        }
//    }
//
//    private void readContacts() {
//        Cursor cursor = null;
//        try {
//            //查询联系人数据
//            cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
//            if (cursor != null) {
//                while (cursor.moveToNext()) {
//                    //获取联系人姓名
//                    String displayName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
//                    //获取联系人手机号
//                    String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
//                    contactsList.add(displayName + "\n" + number);
//                }
//                adapter.notifyDataSetChanged();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (cursor != null) {
//                cursor.close();
//            }
//        }
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        switch (requestCode) {
//            case 1:
//                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    readContacts();
//                } else {
//                    Toast.makeText(this, "You denied the permission", Toast.LENGTH_SHORT).show();
//                }
//                break;
//            default:
//        }
//    }

    private MyDatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper  =  new  MyDatabaseHelper(this,  "Contacts.db",  null,  1);
        SQLiteDatabase  db  =  dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        //添加两条数据
        values.put("name","Tony");
        values.put("tel","123");
        values.put("sex","man");
        db.insert("Contacts",  null,  values);
        values.clear();
        values.put("name","Jen");
        values.put("tel","456");
        values.put("sex","woman");
        db.insert("Contacts",  null,  values);
    }

}