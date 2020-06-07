package com.example.tinderswipeview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.tinderswipeview.R
import com.example.tinderswipeview.databinding.CardViewProfileBinding
import com.example.tinderswipeview.model.Profile

class ProfileAdapter : RecyclerView.Adapter<ProfileAdapter.MyView>() {
    private var profiles: List<Profile>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        val binding: CardViewProfileBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.card_view_profile,
            parent,
            false
        )
        return MyView(binding)

    }

    override fun getItemCount(): Int {
        return profiles?.size ?: 0
    }

    fun setProfiles(profiles: List<Profile>) {
        this.profiles = profiles
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.cardViewProfileBinding.profile = profiles?.get(position)
        holder.cardViewProfileBinding.executePendingBindings()
    }

    inner class MyView(val cardViewProfileBinding: CardViewProfileBinding) :
        RecyclerView.ViewHolder(cardViewProfileBinding.root)
}