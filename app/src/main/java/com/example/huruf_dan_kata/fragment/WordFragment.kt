package com.example.huruf_dan_kata.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.huruf_dan_kata.R
import com.example.huruf_dan_kata.adapter.WordAdapter
import com.example.huruf_dan_kata.data.DataWord

class WordFragment : Fragment() {

    lateinit var rvWords: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_word, container, false)

        // data dummy for words
        val listWords = arrayListOf(
            DataWord("A"),
            DataWord("B"),
            DataWord("C"),
            DataWord("D"),
            DataWord("E"),
            DataWord("F"),
            DataWord("G"),
            DataWord("H"),
            DataWord("I"),
            DataWord("J")
        )
        // object for adapter word
        val wordAdapter = WordAdapter(listWords)

        // make layout manajer for list word
        val lmW = LinearLayoutManager(activity)
        lmW.orientation = LinearLayoutManager.VERTICAL

        // call the recyclerview
        rvWords = view.findViewById(R.id.rv_word_container)

        // set layout manajer into recyclerview
        rvWords.layoutManager = lmW

        // set adapter into recyclerview
        var adapter = wordAdapter
        rvWords.adapter = adapter
        adapter.setOnItemClickListener(object : WordAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {

                val posisi = listWords[position].word
                val text = "you in $posisi"
                val duration = Toast.LENGTH_SHORT
                val aplicationContext = activity?.applicationContext

                val toast = Toast.makeText(aplicationContext,text,duration)
                toast.show()

                val bundle = Bundle()
                bundle.putString("KEY_WORD", posisi)

                Navigation.findNavController(view).navigate(R.id.action_wordFragment_to_detailWordFragment,bundle)
            }

        })

        return view
    }

}