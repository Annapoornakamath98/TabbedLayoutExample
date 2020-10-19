package com.yml.tab2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.room.Room


class SecondFragment : Fragment(R.layout.fragment_second) {
    private lateinit var searchBtn: Button
    private lateinit var updateBtn: Button
    private lateinit var edSearch: EditText
    private lateinit var edUpdate: EditText
    private lateinit var textView: TextView
    private lateinit var database: SongsRoomDatabase
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchBtn=view.findViewById(R.id.btnSearch)
        updateBtn=view.findViewById(R.id.btnUpdate)
        edSearch=view.findViewById(R.id.searchSong)
        edUpdate=view.findViewById(R.id.editUpdate)
        textView=view.findViewById(R.id.displaySongs)
        database= Room.databaseBuilder(view.context,SongsRoomDatabase::class.java,"word_database").build()

        fun readData(){
            val list:ArrayList<Songs> = ArrayList()
            Thread{
                list.addAll(database.wordDao().getSong(edSearch.text.toString()))
                textView.post {
                    if(list.isEmpty())
                        Toast.makeText(context,"Empty", Toast.LENGTH_SHORT).show()
                    else{
                        val uList:ArrayList<String> = ArrayList()
                        list.forEach{uList.add(it.word)
                            uList.add(it.singer)
                            uList.add(it.movie)
                            uList.add(it.dur)
                        }
                        textView.setText("Song Name: "+uList[0]+ "\nSinger: "+uList[1]+"\nMovie: "+uList[2]+"\nSong Duration: "+uList[3])
                    }
                }
            }.start()
        }
        fun getSinger(){
            Thread{
                database.wordDao().setSinger(edUpdate.text.toString(),edSearch.text.toString())
            }.start()
            Toast.makeText(view.context,"Changed", Toast.LENGTH_SHORT).show()
        }
        searchBtn.setOnClickListener {
            readData()
        }
        updateBtn.setOnClickListener {
            getSinger()
        }

    }

}