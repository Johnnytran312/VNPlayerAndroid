package android.nnbinh.hcmus.vietnam_player.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.nnbinh.hcmus.vietnam_player.MainActivity;
import android.nnbinh.hcmus.vietnam_player.R;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by nguyenngocbinh on 1/8/17.
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    public void goToFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                .replace(R.id.content_main, fragment)
                .addToBackStack(null).commit();
    }

    public void goToActivity(Class activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    };
}
