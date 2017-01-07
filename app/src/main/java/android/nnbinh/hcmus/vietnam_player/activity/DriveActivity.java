package android.nnbinh.hcmus.vietnam_player.activity;

import android.content.Intent;
import android.nnbinh.hcmus.vietnam_player.MainActivity;
import android.nnbinh.hcmus.vietnam_player.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by nguyenngocbinh on 1/7/17.
 */

public class DriveActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton btnPre, btnPlay, btnNext;
    Button btnSuf, btnRepeat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drive);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnNext = (ImageButton) findViewById(R.id.imageButtonNext);
        btnPlay = (ImageButton) findViewById(R.id.imageButtonPlay);
        btnPre = (ImageButton) findViewById(R.id.imageButtonPre);
//        btnRepeat = (Button) findViewById(R.id.buttonRepeat);
//        btnSuf = (Button) findViewById(R.id.buttonSuf);

//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_drive, null);



        btnPlay.setOnClickListener(this);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == btnPlay.getId()){
            //btnPlay.setBackground(ic_pause_circle_outline_black_36dp);
        }
    }


    //create menu to and show it
    // use custom menu of dev
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_drive, menu);
        return super.onCreateOptionsMenu(menu);
    }
    // when selectd item in menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent mhNomal = new Intent(DriveActivity.this, MainActivity.class);
        startActivity(mhNomal);
        Toast.makeText(this, "Trở về giao diện Nomal", Toast.LENGTH_SHORT).show();
        return true;
    }
}
