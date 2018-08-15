package kz.djunglestones.jobtask;


import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Link3Fragment extends Fragment {

    private TextView get_contacts_tv;
    private View v;
    private static final int PERMISSIONS_REQUEST_READ_CONTACTS = 100;

    public Link3Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        v = inflater.inflate(R.layout.fragment_link3, container, false);
//        get_contacts_tv = v.findViewById(R.id.get_contacts_tv);
//        get_contacts_tv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M && getContext().checkSelfPermission(Manifest.permission.READ_CONTACTS)!= PackageManager.PERMISSION_GRANTED){
//                    requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, PERMISSIONS_REQUEST_READ_CONTACTS);
//                }
//                else {
//                    ContentResolver contentResolver = getContext().getContentResolver();
//                    Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);
//
//                    while (cursor.moveToNext()){
//                        String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
//                        String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
//
//                        Cursor phoneCursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,
//                                ContactsContract.CommonDataKinds.Phone.CONTACT_ID+" = ?",new String[]{id},null);
//                        Log.e("Name",id+" = "+name );
//
//                        while (phoneCursor.moveToNext()){
//                            String phoneNumber = phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
//
//                            Log.e("Phone",id+" = "+name+" "+phoneNumber);
//                        }
//
//
//                    }
//                }
//
//
//            }
//        });
        return v;

    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        if (requestCode == PERMISSIONS_REQUEST_READ_CONTACTS) {
//            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                // Permission is granted
//            } else {
//                Toast.makeText(getContext(), "Until you grant the permission, we canot display the names", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
}
