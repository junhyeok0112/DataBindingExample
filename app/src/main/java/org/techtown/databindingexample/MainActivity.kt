package org.techtown.databindingexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import org.techtown.databindingexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var text = "첫번 째"
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        //binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(binding.root)

        binding.activity = this
        binding.change.setOnClickListener {
            text = "두번 째"
            binding.invalidateAll()
        }
    }
}