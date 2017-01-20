package com.example.amald.newmusictest;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by amald on 20/1/17.
 */

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.MyViewHolder> {

    private Context mContext;
    private List<SOng> songList;
    private Cursor cursor;

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView title, surname;
        public CardView song;

        public MyViewHolder(View view) {
            super(view);

            title = (TextView) view.findViewById(R.id.title);
            surname = (TextView) view.findViewById(R.id.surname);
            song = (CardView) view.findViewById(R.id.card_view);
        }
    }


    public SongAdapter(Context mContext, List<SOng> sbgList) {
        this.mContext = mContext;
        this.songList = sbgList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.song_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        final SOng sOng = songList.get(position);
        holder.title.setText(sOng.getName());
        holder.surname.setText(sOng.getSurname());

        holder.song.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String currentFile = sOng.getData();

                MainActivity.startPlay(currentFile);


            }
        });







    }

    @Override
    public int getItemCount() {
        return songList.size();

    }
}
