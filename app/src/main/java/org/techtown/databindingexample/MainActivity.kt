package org.techtown.databindingexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.techtown.databindingexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var livetext : MutableLiveData<String> = MutableLiveData<String>().apply {
        value = "Start"
    }

    lateinit var binding: ActivityMainBinding
    val profileAdapter = ProfileAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        //binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(binding.root)
        binding.apply { //binding의 초기 셋팅을 위해 apply 사용
            binding.lifecycleOwner = this@MainActivity
            binding.activity = this@MainActivity

            change1.setOnClickListener {
                livetext.value = "LiveData 등장"
                btnClick(change1)
            }

            change2.setOnClickListener {
                livetext.value = "DataBinding 등장"
                btnClick(change2)
            }

        }
        setRcv()

    }

    fun btnClick(view:View){
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