package android.nnbinh.hcmus.vietnam_player.fragment;

import android.app.Fragment;
import android.nnbinh.hcmus.vietnam_player.R;
import android.nnbinh.hcmus.vietnam_player.adapter.MyAdapter;
import android.nnbinh.hcmus.vietnam_player.model.MediaModel;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by nguyenngocbinh on 1/5/17.
 */

public class FirstFragment extends BaseFragment {
    private String mPageTitle;
    private int mPageIndex;
    private final static String PAGE_INDEX = "PAGE_INDEX";
    private final static String PAGE_TITLE = "PAGE_TITLE";
    private RecyclerView mRecyclerView;
    private MyAdapter mRecycleAdapter;

    public static FirstFragment newInstance(int index, String title){
        FirstFragment fragmentFirst = new FirstFragment();
        Bundle args = new Bundle();
        args.putInt(PAGE_INDEX, index);
        args.putString(PAGE_TITLE, title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPageIndex = getArguments().getInt(PAGE_INDEX, 0);
        mPageTitle = getArguments().getString(PAGE_TITLE);
        setTitle(getString(R.string.app_name));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
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
        mRecycleAdapter = new MyAdapter(getData());
        mRecycleAdapter.setOnItemClickListener(new MyAdapter.ClickListener() {
            @Override
            public void onItemClick(MediaModel media) {
                PlayerMediaFragment.start(media);
                PlayerMediaFragment fragment = PlayerMediaFragment.start(media);
                goToFragment(fragment);
            }
        });
        mRecyclerView.setAdapter(mRecycleAdapter);
    }

    private ArrayList<MediaModel> getData() {
        ArrayList<MediaModel> myDataset = new ArrayList<MediaModel>();
        myDataset.add(new MediaModel(1, "Lạc trôi", "", "Sơn Tùng MT-P", true));
        myDataset.add(new MediaModel(2, "Phía sau một cô gái", "","Sonbin Hoàng Sơn", true));
        myDataset.add(new MediaModel(3, "Cơn mưa ngang qua", "", "Sơn Tùng MT-P", false));
        myDataset.add(new MediaModel(4, "Giả vờ Yêu", "", "Ngô Kiến Huy", false));
        myDataset.add(new MediaModel(5, "Thương nhau để đó", "","Hamlet Trương", true));
        myDataset.add(new MediaModel(6, "Tâm sự với người lạ", "", "Tiên Cookie", false));

        myDataset.add(new MediaModel(7, "Gạt đi nước mắt", "", "Noo Phước Thịnh", false));
        myDataset.add(new MediaModel(8, "Không cần thêm một ai nữa", "","Mr. Siro", true));
        myDataset.add(new MediaModel(9, "Giá có thể ôm ai và khóc", "", "Phạm Hồng Phước", true));
        myDataset.add(new MediaModel(10, "Lý cây bông", "", "Ricky ", true));
        myDataset.add(new MediaModel(11, "My destiny", "","Hồ Ngọc Hà", true));
        myDataset.add(new MediaModel(12, "Người yêu cũ", "", "Khởi ", false));

        myDataset.add(new MediaModel(13, "Rơi", "", "Trung Quân Idol", true));
        myDataset.add(new MediaModel(14, "Trót yêu", "","Trung Quân Idol", false));
        myDataset.add(new MediaModel(15, "Welcome to New York", "", "Taylor Swift", true));
        myDataset.add(new MediaModel(16, "Đừng ", "", "Hồ Ngọc Hà", true));
        myDataset.add(new MediaModel(17, "Đông", "","Vũ Cát Tường", false));
        myDataset.add(new MediaModel(18, "Đưng yêu", "", "Thu Minh ", false));

        return myDataset;
    }
}
