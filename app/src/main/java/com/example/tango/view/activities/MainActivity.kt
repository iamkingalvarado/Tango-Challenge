package com.example.tango.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tango.R
import com.example.tango.data.repositories.NewPositionsRepository
import com.example.tango.view.adapters.MyAdapter
import com.example.tango.view.viewmodels.PositionsViewModel
import com.example.tango.view.viewmodels.PositionsViewModelFactory

class MainActivity : AppCompatActivity() {
    private val recyclerView: RecyclerView by lazy { RecyclerView(this) }
    private val adapter = MyAdapter()

    private lateinit var positionsViewModel: PositionsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(recyclerView)

        setupView()
        setupViewModels()
        initObservations()

        positionsViewModel.fetchPositions()
    }

    private fun setupViewModels() {
        val factory = PositionsViewModelFactory(NewPositionsRepository())
        positionsViewModel = ViewModelProvider(this, factory).get(PositionsViewModel::class.java)
    }

    private fun setupView() {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
    }

    private fun initObservations() {
        observe(positionsViewModel.positions) {
            adapter.update(it)
        }

        observe(positionsViewModel.exception) {
            Toast.makeText(this, R.string.dialog_error, Toast.LENGTH_SHORT).show()
        }
    }
}

fun <T> LifecycleOwner.observe(liveData: LiveData<T>, function: (T) -> Unit) {
    liveData.observe(this, Observer { function.invoke(it) })
}