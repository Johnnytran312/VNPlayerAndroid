package android.nnbinh.hcmus.vietnam_player.fragment;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.nnbinh.hcmus.vietnam_player.R;
import android.nnbinh.hcmus.vietnam_player.adapter.MyAdapter;
import android.nnbinh.hcmus.vietnam_player.model.MediaModel;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by nguyenngocbinh on 1/13/17.
 */

public class MediaListFragment extends BaseFragment {
    private ArrayList<MediaModel> mMedias;
    private final static String PAGE_INDEX = "PAGE_INDEX";
    private final static String PAGE_TITLE = "PAGE_TITLE";
    private RecyclerView mRecyclerView;
    private MyAdapter mRecycleAdapter;

    public static MediaListFragment newInstance(int index, String title){
        MediaListFragment fragmentFirst = new MediaListFragment();
        Bundle args = new Bundle();
        args.putInt(PAGE_INDEX, index);
        args.putString(PAGE_TITLE, title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getString(R.string.app_name));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab, container, false);
        setupRecycleView(view);
        return view;
    }



    private void setupRecycleView(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycle_view);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mMedias = getAllMedias();
        mRecycleAdapter = new MyAdapter(mMedias);
        mRecycleAdapter.setOnItemClickListener(new MyAdapter.ClickListener() {
            @Override
            public void onItemClick(MediaModel media) {
                MediaPlayerFragment.start(media);
                MediaPlayerFragment fragment = MediaPlayerFragment.start(media);
                goToFragment(fragment);
            }
        });
        mRecyclerView.setAdapter(mRecycleAdapter);
    }
    public ArrayList<MediaModel> getAllMedias(){
        ArrayList<MediaModel> mediaModels = new ArrayList<>();


//        String[] projection = {
//                MediaStore.Audio.Media._ID,
//                MediaStore.Audio.Media.ARTIST,
//                MediaStore.Audio.Media.TITLE,
//                MediaStore.Audio.Media.DATA,
//                MediaStore.Audio.Media.DISPLAY_NAME,
//                MediaStore.Audio.Media.DURATION
//        };
//
//        String selection = MediaStore.Audio.Media.IS_MUSIC + " != 0";
//
//        Cursor songCursor = getActivity().managedQuery(
//                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
//                projection,
//                selection,
//                null,
//                null);

        ContentResolver contentResolver = getContext().getContentResolver();
        Uri songUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor songCursor = contentResolver.query(songUri, null, null, null, null);

        if(songCursor != null && songCursor.moveToFirst())
        {
            int songId = songCursor.getColumnIndex(MediaStore.Audio.Media._ID);
            int songTitle = songCursor.getColumnIndex(MediaStore.Audio.Media.TITLE);
            int songAlbum= songCursor.getColumnIndex(MediaStore.Audio.Media.ALBUM);
            int songArtist= songCursor.getColumnIndex(MediaStore.Audio.Media.ARTIST);
            int songDuration= songCursor.getColumnIndex(MediaStore.Audio.Media.DURATION);
            int songSize= songCursor.getColumnIndex(MediaStore.Audio.Media.DURATION);
            int songType= songCursor.getColumnIndex(MediaStore.Audio.Media.MIME_TYPE);
            int songData= songCursor.getColumnIndex(MediaStore.Audio.Media.DATA);


            do {
                long currentId = songCursor.getLong(songId);
                String currentTitle = songCursor.getString(songTitle);
                String currentArtist = songCursor.getString(songArtist);
                String currentAlbum = songCursor.getString(songAlbum);
                String currentDuration = songCursor.getString(songDuration);
                String currentSize = songCursor.getString(songSize);
                String currentType = songCursor.getString(songType);

                MediaModel media = new MediaModel(currentId,currentTitle,"", currentArtist, true);
                mediaModels.add(media);
            } while(songCursor.moveToNext());
        }
        return mediaModels;
    }



}
