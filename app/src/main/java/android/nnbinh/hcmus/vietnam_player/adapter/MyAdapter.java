package android.nnbinh.hcmus.vietnam_player.adapter;

import android.nnbinh.hcmus.vietnam_player.R;
import android.nnbinh.hcmus.vietnam_player.model.MediaModel;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nguyenngocbinh on 1/5/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList<MediaModel> mData;
    private ClickListener mClickListener;

    public interface ClickListener {
        void onItemClick(MediaModel media);
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        mClickListener = clickListener;
    }

    public MyAdapter(ArrayList<MediaModel> data) {
        this.mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_card_item, parent, false);

        // set the view's size, margins, padding and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final MediaModel media = mData.get(position);
        holder.mTextView.setText(media.getName());
        holder.mTxtArtist.setText(media.getArtistName());
        if(media.isLocal()) {
            holder.mState.setBackgroundResource(R.mipmap.ic_device_3);
        }else {
            holder.mState.setBackgroundResource(R.mipmap.ic_could_1);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mClickListener.onItemClick(media);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public TextView mTxtArtist;
        public ImageView mIcon;
        public ImageView mState;
        public ViewHolder(View v) {
            super(v);
            mTextView = (TextView) v.findViewById(R.id.item_title);
            mTxtArtist = (TextView) v.findViewById(R.id.item_artist);
            mIcon = (ImageView) v.findViewById(R.id.iv_item_left);
            mState = (ImageView) v.findViewById(R.id.iv_item_right);
        }
    }
}
