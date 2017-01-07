package android.nnbinh.hcmus.vietnam_player.activity;

import android.nnbinh.hcmus.vietnam_player.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by nguyenngocbinh on 1/7/17.
 */

public class EqualizerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Spinner spinEqualizers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equalizer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        spinEqualizers = (Spinner) findViewById(R.id.spinnerDefaultEqualizer);
        //Create an arrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.equalizers_default, android.R.layout.simple_spinner_dropdown_item);

        //specity the layout to use whent the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //apply the adapter to the spinner
        spinEqualizers.setAdapter(adapter);

        spinEqualizers.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}