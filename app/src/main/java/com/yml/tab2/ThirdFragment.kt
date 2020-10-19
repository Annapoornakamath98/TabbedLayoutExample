package com.yml.tab2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room


class ThirdFragment : Fragment(R.layout.fragment_third) {
    private lateinit var recycler: RecyclerView
    private lateinit var database: SongsRoomDatabase
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler=view.findViewById(R.id.recyclerView)
        recycler.layoutManager= LinearLayoutManager(view.context)
        database= Room.databaseBuilder(view.context,SongsRoomDatabase::class.java,"word_database").build()
        //        val data=database.wordDao().getWords()
//        recycler.adapter=SongListAdapter(data)
        fun readData(){
            val list:ArrayList<Songs> =ArrayList()
            Thread{
                list.addAll(database.wordDao().getWords())
                recycler.post {
                    if(list.isEmpty())
                        Toast.makeText(context,"Empty", Toast.LENGTH_SHORT).show()
                    else{
                        val uList:ArrayList<String> = ArrayList()
                        list.forEach{uList.add(it.word)}
                        recycler.adapter=SongListAdapter(uList)
                    }
                }
            }.start()
        }
        readData()
    }

}