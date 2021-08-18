package org.techtown.databindingexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import org.techtown.databindingexample.databinding.ListItemBinding

class ProfileAdapter : RecyclerView.Adapter<ProfileAdapter.ViewHolder> () {

    var data = ArrayList<ProfileData>()

    inner class ViewHolder(val binding : ListItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun onbind(data : ProfileData){ //뷰 홀더에서 데이터를 binding의 user에 셋팅
            binding.user = data
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileAdapter.ViewHolder {
        val binding = DataBindingUtil.inflate<ListItemBinding>(LayoutInflater.from(parent.context) , R.layout.list_item , parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProfileAdapter.ViewHolder, position: Int) {
        holder.onbind(data[position])       //뷰 홀더에 position 번째 데이터 셋팅
    }

    override fun getItemCount() = data.size

}