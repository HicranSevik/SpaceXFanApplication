package com.example.spacexfan.ui.rockets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.spacexfan.databinding.FragmentRocketsBinding

class RocketsFragment : Fragment() {

    private var _binding: FragmentRocketsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rocketsViewModel =
            ViewModelProvider(this).get(RocketsViewModel::class.java)

        _binding = FragmentRocketsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textRockets
        rocketsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}