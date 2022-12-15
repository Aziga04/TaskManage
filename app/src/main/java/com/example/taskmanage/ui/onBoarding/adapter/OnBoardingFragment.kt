package com.example.taskmanage.ui.onBoarding.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.taskmanage.Data.Pref
import com.example.taskmanage.databinding.FragmentOnBoarding2Binding
import com.example.taskmanage.databinding.ItemBoardingBinding
import com.example.taskmanage.model.OnBoard


class OnBoardingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoarding2Binding
    private lateinit var adapter: OnBoardingAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentOnBoarding2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = OnBoardingAdapter(requireContext(), this::onClick)
        binding.viewPager.adapter = adapter
        binding.dotsIndicator.attachTo(binding.viewPager)

    }

    private fun onClick() {
        val pref = Pref(requireContext())
        pref.setOnBoardingSeen(true)
        findNavController().navigateUp()
    }

}