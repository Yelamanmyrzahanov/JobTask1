package kz.djunglestones.jobtask;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import me.fahmisdk6.avatarview.AvatarView;

public class ProfileEditActivity extends AppCompatActivity {
    private Toolbar profileToolbar;
    private EditText first_name_edit,last_name_edit,email_edit;
    private TextView profile_edit_toolbar_save_tv;
    private AvatarView avatarView;
    private Uri mainImageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);
        profileToolbar = findViewById(R.id.profile_edit_toolbar);
        setSupportActionBar(profileToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initUI();

        Intent intent = getIntent();
        String full_name = intent.getStringExtra("first_name");
        String[] name_and_surname = full_name.split(" ");
        first_name_edit.setText(name_and_surname[0]);
        last_name_edit.setText(name_and_surname[1]);


        profile_edit_toolbar_save_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileEditActivity.this,ProfileActivity.class);
                startActivity(intent);
            }
        });



        avatarView.bind(first_name_edit.getText().toString()+" "+last_name_edit.getText().toString(), "https://avatars2.githubusercontent.com");
        avatarView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN){
                    if (ContextCompat.checkSelfPermission(ProfileEditActivity.this, android.Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){

                        Toast.makeText(ProfileEditActivity.this,"Permission Denied",Toast.LENGTH_LONG).show();
                        ActivityCompat.requestPermissions(ProfileEditActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);
                    }
                    else{
                        CropImage.activity()
                                .setGuidelines(CropImageView.Guidelines.ON)
                                .setAspectRatio(1,1)
                                .start(ProfileEditActivity.this);

                    }
                }
            }
        });
    }

    private void initUI() {
        profile_edit_toolbar_save_tv = findViewById(R.id.profile_edit_toolbar_save_tv);
        avatarView = findViewById(R.id.profile_edit_avatar);
        first_name_edit = findViewById(R.id.first_name_edit);
        last_name_edit= findViewById(R.id.last_name_edit);
        email_edit = findViewById(R.id.email_edit);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                mainImageUri = result.getUri();
                avatarView.bind(first_name_edit.getText().toString()+" "+last_name_edit.getText().toString(), String.valueOf(mainImageUri));
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }
}
