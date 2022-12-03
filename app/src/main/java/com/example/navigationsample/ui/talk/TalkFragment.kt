package com.example.navigationsample.ui.talk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.navigationsample.R
import com.example.navigationsample.databinding.FragmentTalkBinding

class TalkFragment : Fragment() {

    private var _binding: FragmentTalkBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val talkViewModel =
            ViewModelProvider(this)[TalkViewModel::class.java]

        _binding = FragmentTalkBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        talkViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_talk_to_talkRoomFragment)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}