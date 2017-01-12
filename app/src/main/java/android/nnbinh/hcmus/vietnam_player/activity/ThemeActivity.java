package android.nnbinh.hcmus.vietnam_player.activity;

import android.content.Intent;
import android.nnbinh.hcmus.vietnam_player.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by nguyenngocbinh on 1/7/17.
 */

public class ThemeActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnNormal;
    Button btnEasy;
    Button btnFull;
    Button btnDrive;
    ImageView imgThemesView;

    String idthem = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imgThemesView = (ImageView) findViewById(R.id.imageViewThemes);

        btnNormal = (Button) findViewById(R.id.buttonNormal);
        btnEasy = (Button) findViewById(R.id.buttonEasy);
        btnFull = (Button) findViewById(R.id.buttonFull);
        btnDrive = (Button) findViewById(R.id.buttonDrive);

        btnNormal.setOnClickListener(this);
        btnEasy.setOnClickListener(this);
        btnFull.setOnClickListener(this);
        btnDrive.setOnClickListener(this);

        Toast.makeText(ThemeActivity.this,"NORMAL", Toast.LENGTH_SHORT).show();
        imgThemesView.setImageResource(R.mipmap.theme_full_play);
        idthem = "normal";


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    //  //for action bar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);

        // change theme for app
        switch (item.getItemId()){
            case R.id.action_settings:
                return super.onOptionsItemSelected(item);
            case R.id.action_favorite:
            {
                if(idthem == "easy"){//change theme to easy
                    Toast.makeText(ThemeActivity.this, "bạn đã đổi qua giao diện EASY", Toast.LENGTH_SHORT).show();
                }
                if(idthem == "drive"){//change theme to drive
                    Toast.makeText(ThemeActivity.this, "bạn đã đổi qua giao diện DRIVE", Toast.LENGTH_SHORT).show();
                    Intent mhDrive = new Intent(ThemeActivity.this, DriveActivity.class);
                    startActivity(mhDrive);
                }
                if(idthem == "full"){// change them to full
                    Toast.makeText(ThemeActivity.this, "bạn đã đổi qua giao diện FULL", Toast.LENGTH_SHORT).show();
                }
                if(idthem == "normal"){//change themes to normal
                    Toast.makeText(ThemeActivity.this, "bạn đã đổi qua giao diện NORMAL", Toast.LENGTH_SHORT).show();
                }
            }

        }
        return true;
    }



    @Override
    public void onClick(View v) {
        if(v.getId() == btnDrive.getId()){
//            Toast.makeText(ThemeActivity.this,"DRIVE", Toast.LENGTH_SHORT).show();
            imgThemesView.setImageResource(R.mipmap.theme_drive_play);
            idthem = "drive";
        } else if(v.getId() == btnEasy.getId()){
            Toast.makeText(ThemeActivity.this,"EASY", Toast.LENGTH_SHORT).show();
            imgThemesView.setImageResource(R.mipmap.sexy_girl_by_mira_heart);
            idthem = "easy";
        } else if(v.getId() == btnFull.getId()){
            Toast.makeText(ThemeActivity.this,"FULL", Toast.LENGTH_SHORT).show();
            imgThemesView.setImageResource(R.mipmap.blue_girl);
            idthem = "full";
        }else if(v.getId() == btnNormal.getId()){
            Toast.makeText(ThemeActivity.this,"NORMAL", Toast.LENGTH_SHORT).show();
            imgThemesView.setImageResource(R.mipmap.blue_girl);
            idthem = "normal";
        }

    }
}
