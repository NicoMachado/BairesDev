package com.cse.bairesdev.ui.gallery

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.cse.bairesdev.R
import com.cse.bairesdev.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment(R.layout.fragment_gallery) {

    private lateinit var galleryViewModel: GalleryViewModel
    private lateinit var binding: FragmentGalleryBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        galleryViewModel =
                ViewModelProvider(this).get(GalleryViewModel::class.java)
        //val root = inflater.inflate(R.layout.fragment_gallery, container, false)

        binding = FragmentGalleryBinding.inflate(inflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //val textView: TextView = root.findViewById(R.id.text_gallery)
        galleryViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textGallery.text = it
        })

        binding.buttonAlert.setOnClickListener {
            var alertDialog = AlertDialog.Builder(requireActivity()).create()
            alertDialog.setTitle("Alerta!")
            alertDialog.setMessage("Baires Dev")

            alertDialog.show()

        }

        binding.buttonToast.setOnClickListener {
            Toast.makeText(requireContext(), "This is a Toast!", Toast.LENGTH_LONG).show()
        }
    }
}