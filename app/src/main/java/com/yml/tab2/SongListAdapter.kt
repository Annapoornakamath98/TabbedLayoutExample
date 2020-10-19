package com.yml.tab2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SongListAdapter(val uList: ArrayList<String>):RecyclerView.Adapter<SongListAdapter.SongViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SongListAdapter.SongViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.songs_list,parent,false)
        return SongViewHolder(itemView)
    }

    class SongViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val songItemView:TextView=itemView.findViewById(R.id.textRoom)

    }

    override fun onBindViewHolder(holder: SongListAdapter.SongViewHolder, position: Int) {
        holder.songItemView.text=uList[position].toString()
    }

    override fun getItemCount(): Int {
        return uList.size
    }
}