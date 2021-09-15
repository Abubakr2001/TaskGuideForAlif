package com.leonardo.guideapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.leonardo.guideapp.MainActivity
import com.leonardo.guideapp.R
import com.leonardo.guideapp.adapters.GuideAdapter
import com.leonardo.guideapp.data.Guide
import com.leonardo.guideapp.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var adapter: GuideAdapter
    private val viewModel: MainViewModel by viewModels()
    lateinit var recyclerView: RecyclerView


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getGuides().observe(viewLifecycleOwner){ guides ->
            if (guides != null){
                recyclerView = view.findViewById<RecyclerView>(R.id.rcView)
                recyclerView.layoutManager = LinearLayoutManager(activity)
                adapter = GuideAdapter(guides
                        as ArrayList<Guide>){
                    (requireActivity() as MainActivity).openFragment(MainFragmentDetail.newInstance(it))
                }
                recyclerView.adapter = adapter
            }
        }
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}