package com.example.android.gdgfinder.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.android.gdgfinder.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // DONE (06) Create a binding to the home_fragment layout and tell the binding
        // about the viewModel.

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        val binding = HomeFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        // DONE (07)  Register an observer on navigateToSearch, and have it navigate
        // to gdgListFragment if shouldNavigate is true.
        viewModel.navigateToSearch.observe(viewLifecycleOwner, { navigate ->
           if(navigate){
               this.findNavController()
                   .navigate(HomeFragmentDirections.actionHomeFragmentToGdgListFragment())
               viewModel.onNavigatedToSearch()
           }
        })

        return binding.root
    }
}
