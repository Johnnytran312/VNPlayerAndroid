package android.nnbinh.hcmus.vietnam_player.fragment;

import android.content.Intent;
import android.nnbinh.hcmus.vietnam_player.R;
import android.nnbinh.hcmus.vietnam_player.activity.DriveActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by nguyenngocbinh on 1/8/17.
 */

public class ThemeFragment extends BaseFragment {
    Button btnNormal;
    Button btnEasy;
    Button btnFull;
    Button btnDrive;
    ImageView imgThemesView;

    String idthem = "";
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayout(R.layout.fragment_theme);
        setTitle(getString(R.string.menu_item_ui));
        setHasOptionsMenu(true);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imgThemesView = (ImageView) view.findViewById(R.id.imageViewThemes);

        btnNormal = (Button) view.findViewById(R.id.buttonNormal);
        btnEasy = (Button) view.findViewById(R.id.buttonEasy);
        btnFull = (Button) view.findViewById(R.id.buttonFull);
        btnDrive = (Button) view.findViewById(R.id.buttonDrive);

        btnNormal.setOnClickListener(this);
        btnEasy.setOnClickListener(this);
        btnFull.setOnClickListener(this);
        btnDrive.setOnClickListener(this);
        imgThemesView.setImageResource(R.mipmap.theme_full_play);
        idthem = "normal";

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_settings:
                return super.onOptionsItemSelected(item);
            case R.id.action_favorite:
            {
                if(idthem == "easy"){//change theme to easy
                    Toast.makeText(getActivity(), "bạn đã đổi qua giao diện EASY", Toast.LENGTH_SHORT).show();
                }
                if(idthem == "drive"){//change theme to drive
                    Toast.makeText(getActivity(), "bạn đã đổi qua giao diện DRIVE", Toast.LENGTH_SHORT).show();
                    Intent mhDrive = new Intent(getActivity(), DriveActivity.class);
                    startActivity(mhDrive);
                }
                if(idthem == "full"){// change them to full
                    Toast.makeText(getActivity(), "bạn đã đổi qua giao diện FULL", Toast.LENGTH_SHORT).show();
                }
                if(idthem == "normal"){//change themes to normal
                    Toast.makeText(getActivity(), "bạn đã đổi qua giao diện NORMAL", Toast.LENGTH_SHORT).show();
                }
            }

        }
        return true;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == btnDrive.getId()){
//            Toast.makeText(getActivity(),"DRIVE", Toast.LENGTH_SHORT).show();
            imgThemesView.setImageResource(R.mipmap.theme_drive_play);
            idthem = "drive";
        } else if(v.getId() == btnEasy.getId()){
            Toast.makeText(getActivity(),"EASY", Toast.LENGTH_SHORT).show();
            imgThemesView.setImageResource(R.mipmap.sexy_girl_by_mira_heart);
            idthem = "easy";
        } else if(v.getId() == btnFull.getId()){
            Toast.makeText(getActivity(),"FULL", Toast.LENGTH_SHORT).show();
            imgThemesView.setImageResource(R.mipmap.blue_girl);
            idthem = "full";
        }else if(v.getId() == btnNormal.getId()){
            Toast.makeText(getActivity(),"NORMAL", Toast.LENGTH_SHORT).show();
            imgThemesView.setImageResource(R.mipmap.blue_girl);
            idthem = "normal";
        }
    }
}
