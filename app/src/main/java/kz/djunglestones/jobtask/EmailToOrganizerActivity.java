package kz.djunglestones.jobtask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class EmailToOrganizerActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText email_editText,subject_edittext,message_edittext;
    private String emailOfOrganizer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_to_organizer);

        initUI();

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Сообщение");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        emailOfOrganizer = intent.getStringExtra("email_of_organizer");

        email_editText.setText("yelamanmyrzahanov@gmail.com");
        message_edittext.setText("Some kind of message");
        subject_edittext.setText("Some kind of subject");











    }

    private void initUI() {
        toolbar = findViewById(R.id.email_to_organizer_toolbar);
        message_edittext = findViewById(R.id.message_edittext);
        subject_edittext = findViewById(R.id.subject_edittext);
        email_editText = findViewById(R.id.email_editText);
    }

    private void sendMail() {
        String subject = subject_edittext.getText().toString();
        String message = message_edittext.getText().toString();
        String emailOf = email_editText.getText().toString();

        Toast.makeText(EmailToOrganizerActivity.this,"OK",Toast.LENGTH_SHORT).show();

        SendMail sm = new SendMail(this, emailOfOrganizer, subject, message);

        sm.execute();
        finish();




    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.email_to_org_menu,menu);

        MenuItem sendMenuItem = menu.findItem(R.id.send_email_to);


        sendMenuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (message_edittext.getText().toString().isEmpty() && email_editText.getText().toString().isEmpty() && subject_edittext.getText().toString().isEmpty()){
                    Toast.makeText(EmailToOrganizerActivity.this,"Заполните все пустые места",Toast.LENGTH_SHORT).show();
                }else{
                    sendMail();
                }


                return true;
            }


        });
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
