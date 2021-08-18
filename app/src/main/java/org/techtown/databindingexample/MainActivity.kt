package org.techtown.databindingexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.techtown.databindingexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var text = "첫번 째"
    lateinit var binding: ActivityMainBinding
    val profileAdapter = ProfileAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        //binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(binding.root)

        binding.activity = this
        setRcv()

    }

    fun btnClick(view:View){
        text = "두번 째"
        Toast.makeText(this,"버튼 클릭" , Toast.LENGTH_SHORT).show()
        val data = ProfileData(binding.name.text.toString() , binding.age.text.toString().toInt())
        profileAdapter.data.add(data)
        profileAdapter.notifyDataSetChanged()
        binding.invalidateAll()
    }

    fun setRcv(){
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = profileAdapter
        profileAdapter.notifyDataSetChanged()

    }

}