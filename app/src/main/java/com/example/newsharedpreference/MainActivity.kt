package com.example.newsharedpreference

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.newsharedpreference.databinding.ActivityMainBinding
import java.util.prefs.AbstractPreferences

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences=getSharedPreferences("NoteData", Context.MODE_PRIVATE)

        binding.saveNoteButton.setOnClickListener{
            val note=binding.notesEditText.text.toString()
            val sharedEdit=sharedPreferences.edit()
            sharedEdit.putString("note",note)
            sharedEdit.apply()
            Toast.makeText(this,"Note Stored Successfully", Toast.LENGTH_SHORT).show()
            binding.notesEditText.text.clear()
        }

        binding.displayNoteButton.setOnClickListener{
            val storedNote= sharedPreferences.getString("note","")
            binding.noteTextView.text= "$storedNote"
        }


    }
}