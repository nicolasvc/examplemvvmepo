package com.example.examplemvvmepo.features.listusers.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import com.example.domain.UserDomain
import com.example.examplemvvmepo.R
import com.example.examplemvvmepo.databinding.ItemUserBinding

class ListUserAdapter(private val interaction: Interaction? = null) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val DIFF_CALLBACK = object : DiffUtil.ItemCallback<UserDomain>() {

        override fun areItemsTheSame(oldItem: UserDomain, newItem: UserDomain): Boolean = oldItem == newItem

        override fun areContentsTheSame(oldItem: UserDomain, newItem: UserDomain): Boolean = oldItem.id == newItem.id

    }
    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListUserViewHolder(
            binding,
            interaction
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ListUserViewHolder -> {
                holder.bind(differ.currentList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<UserDomain>) {
        differ.submitList(list)
    }

    class ListUserViewHolder
    constructor(
        private val binding : ItemUserBinding,
        private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: UserDomain)  {
            binding.postTitle.text = item.name
            binding.postAuthor.text = item.lastname
            binding.ageUser.text = item.age.toString()
        }
    }

    interface Interaction {
        fun onItemSelected(position: Int, item: UserDomain)
    }
}
