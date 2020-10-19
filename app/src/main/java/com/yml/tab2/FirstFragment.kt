package com.yml.tab2

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

lateinit var btnDone: Button
lateinit var textV: TextView
lateinit var editText1: EditText
lateinit var editText2: EditText
lateinit var editText3: EditText
lateinit var editText4: EditText
private lateinit var database: SongsRoomDatabase
class FirstFragment : Fragment(R.layout.fragment_first) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnDone=view.findViewById(R.id.done)
        editText1=view.findViewById(R.id.edit1)
        editText2=view.findViewById(R.id.edit2)
        editText3=view.findViewById(R.id.edit3)
        editText4=view.findViewById(R.id.edit4)
        database= Room.databaseBuilder(view.context,SongsRoomDatabase::class.java,"word_database").build()
        fun insertData(item:Songs){
            Thread{
                database.wordDao().insert(item)
                //database.wordDao().deleteAll()

            }.start()
        }
        btnDone.setOnClickListener {
            insertData(
                    Songs(
                            editText1.text.toString(),
                            editText2.text.toString(),
                            editText3.text.toString(),
                            editText4.text.toString()
                    )
            )

            Toast.makeText(view.context, "Success", Toast.LENGTH_SHORT).show()

//            textV.setText("Song is: "+ editText1.text.toString()+"\n Movie is: "+ editText2.text.toString()+"\nSinger is: "+ editText3.text.toString()
//                    +"\nDuration: "+ editText4.text.toString())
        }

    }


}