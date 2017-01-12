package android.nnbinh.hcmus.vietnam_player.fragment;

import android.nnbinh.hcmus.vietnam_player.R;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by nguyenngocbinh on 1/8/17.
 */

public class DriveFragment extends BaseFragment {
    ImageButton btnPre, btnPlay, btnNext;
    Button btnSuf, btnRepeat;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayout(R.layout.drive_themes);
        setHasOptionsMenu(true);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnNext = (ImageButton) view.findViewById(R.id.imageButtonNext);
        btnPlay = (ImageButton) view.findViewById(R.id.imageButtonPlay);
        btnPre = (ImageButton) view.findViewById(R.id.imageButtonPre);
        btnPlay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_drive, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
