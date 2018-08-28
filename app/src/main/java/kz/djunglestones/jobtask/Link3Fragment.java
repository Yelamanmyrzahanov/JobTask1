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
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Link3Fragment extends Fragment {

    private TextView get_contacts_tv;
    private View v;
    private static final int PERMISSIONS_REQUEST_READ_CONTACTS = 100;
    private boolean isEmpty = true;
    private RecyclerView recyclerView;
    private List<UserContacts> userContactsList;

    public Link3Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        if (!isEmpty){
            v = inflater.inflate(R.layout.fragment_link3, container, false);
        }else{
            v = inflater.inflate(R.layout.fragment_link3_with_contacts,container,false);
            recyclerView  = v.findViewById(R.id.friend_contacts_recyclerview);
            addContacts();
            recyclerView.setHasFixedSize(true);
            RecyclerViewFriendContacts recyclerViewFriendContacts = new RecyclerViewFriendContacts(getContext(),userContactsList);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(recyclerViewFriendContacts);
        }

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

    private void addContacts() {
        userContactsList = new ArrayList<>();
        userContactsList.add(new UserContacts("Danabek Piknar","Kolsay",R.drawable.logo));
        userContactsList.add(new UserContacts("Danabek Piknar","Kolsay",R.drawable.logo));
        userContactsList.add(new UserContacts("Danabek Piknar","Kolsay",R.drawable.logo));
        userContactsList.add(new UserContacts("Danabek Piknar","Kolsay",R.drawable.logo));
        userContactsList.add(new UserContacts("Danabek Piknar","Kolsay",R.drawable.logo));
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
