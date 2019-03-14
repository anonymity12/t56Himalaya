package com.example.paul.t56himalaya.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ximalaya.ting.android.opensdk.model.album.Album;
import com.example.paul.t56himalaya.R;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by paul on 2019/3/13
 * last modified at 23:22.
 * Desc:
 */

public class RecommendListAdapter extends RecyclerView.Adapter<RecommendListAdapter.InnerHolder> {
    private List<Album> mData = new ArrayList<>();

    @Override
    public RecommendListAdapter.InnerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recommend, parent, false);
        return new InnerHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecommendListAdapter.InnerHolder holder, int position) {
        holder.itemView.setTag(position);
        holder.setData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        if (mData != null) {
            return mData.size();
        }
        return 0;
    }

    public void setData(List<Album> albums) {
        if (mData != null) {
            mData.clear();
            mData.addAll(albums);
        }
        notifyDataSetChanged();
    }

    public class InnerHolder extends RecyclerView.ViewHolder {

        public InnerHolder(View itemView) {
            super(itemView);
        }

        public void setData(Album album) {
            //======find the widget
            // 1 the cover
            ImageView albumCoverIv = itemView.findViewById(R.id.album_cover);
            // 2 the desc
            TextView albumDescrTv = itemView.findViewById(R.id.album_description);
            // 3 the title
            TextView albumTitleTv = itemView.findViewById(R.id.album_title_tv);
            // 4 the play count
            TextView albumPlayCountTv = itemView.findViewById(R.id.album_play_count);
            // 5 the album size
            TextView albumContentCountTv = itemView.findViewById(R.id.album_content_size);

            //======set the data details
            albumTitleTv.setText(album.getAlbumTitle());
            albumDescrTv.setText(album.getAlbumIntro());
            albumPlayCountTv.setText(album.getPlayCount() + "");
            albumContentCountTv.setText(album.getIncludeTrackCount() + "");
        }
    }
}
