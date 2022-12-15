package com.example.taskmanage.ui.onBoarding.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.taskmanage.Data.Pref
import com.example.taskmanage.R
import com.example.taskmanage.databinding.ItemBoardingBinding
import com.example.taskmanage.model.OnBoard

class OnBoardingAdapter(
    private val context: Context,
    private val onClick:() -> Unit
) : RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {


    private val data = arrayListOf(
        OnBoard(R.raw.task_animat, "It's available in your favorite cities nowand thy wait! go and orderfour favorite juices"),
        OnBoard(R.raw.task_animat_1, "Juice is a beverage made from theextraction or pressing out of natural liquidcontained good quality fruitsfour favorite juices"),
        OnBoard(R.raw.tsak_animat_2, "User can look for their favorite juicesand buy it through the online gatewayprocess or through cash on delivery")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(ItemBoardingBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class OnBoardingViewHolder(private val binding: ItemBoardingBinding) :
        ViewHolder(binding.root) {
        fun bind(onBoard: OnBoard) {
            binding.tvTitle.text = onBoard.title
            onBoard.image?.let { binding.ivBoarding.setAnimation(it) }
            if (adapterPosition == data.lastIndex) {
                binding.tvSkip.text = context.getString(R.string.next)
            } else binding.tvSkip.text = context.getString(R.string.skip)

            binding.tvSkip.setOnClickListener {
                onClick()
            }
        }


    }
}