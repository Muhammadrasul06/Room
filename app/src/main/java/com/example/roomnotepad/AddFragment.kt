package com.example.roomnotepad

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.roomnotepad.databinding.FragmentAddBinding
import com.example.roomnotepad.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class AddFragment : Fragment() {
    lateinit var binding: FragmentAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener {
            val note =
                Note(0, binding.edTitle.text.toString(), binding.edDescpiction.text.toString())
            GlobalScope.launch(Dispatchers.IO) {
                NoteDataBase.DatabaseBuilder.getDatabase(requireContext())
                    .noteDao.insertNote(note)
            }
        }
    }
}