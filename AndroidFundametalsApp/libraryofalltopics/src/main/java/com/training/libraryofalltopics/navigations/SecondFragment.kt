package com.training.libraryofalltopics.navigations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.training.libraryofalltopics.R
import com.training.libraryofalltopics.databinding.NavFragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var binding: NavFragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.nav_fragment_second, container, false)


        var input = requireArguments().getString("name")
        binding.secondFm.text = input.toString()

        return binding.root
    }


}