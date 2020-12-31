package com.example.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdatabase.adapter.UserAdapter
import com.example.roomdatabase.databinding.ActivityMainBinding
import com.example.roomdatabase.model.User
import com.example.roomdatabase.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userAdapter: UserAdapter
    private val  userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initRecyclerView()

        userViewModel.getUserData.observe(this, Observer {
            userAdapter.setData(it as ArrayList<User>)
        })

        binding.save.setOnClickListener {
            insertIntoRoom()
        }
    }

    private fun insertIntoRoom() {
        val mName = binding.name.text.toString().trim()
        val mAge = binding.age.text.toString().trim()

        if (!TextUtils.isEmpty(mName) && !TextUtils.isEmpty(mAge)){
            val  user = User(mName,mAge.toInt())
            userViewModel.insert(user)
            Toast.makeText(applicationContext,"Inserted Succesfully",Toast.LENGTH_SHORT).show()

        }
        else{
            Toast.makeText(applicationContext,"Please fill all fields",Toast.LENGTH_SHORT).show()

        }
    }

    private fun initRecyclerView() {
        userAdapter = UserAdapter(this, ArrayList())
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = userAdapter
        }
    }
}