package com.example.showtext_mvvm.show.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.showtext_mvvm.databinding.FragmentShowTextBinding
import com.example.showtext_mvvm.show.viewModel.ShowTextViewModel


class ShowTextFragment : Fragment() {
    private var binding: FragmentShowTextBinding? = null
    private var viewModel: ShowTextViewModel? = null
    private var showTextObserver: Observer<String>? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShowTextBinding
            .inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setListener()
    }

    fun setListener(){
        binding?.btnShow?.setOnClickListener{
            viewModel?.saveText(binding?.edEnterText?.text.toString())
        }
    }

    override fun onStart() {
        initShowTextObserver()
        initShowTextViewModel()
        showTextObserver?.let { showTextObserver ->
            viewModel?.enterText?.observe(this, showTextObserver)
        }
        binding?.tvShowText?.text = viewModel?.enterText?.value.toString()

        super.onStart()
    }

  private fun initShowTextObserver() {
        showTextObserver = Observer { showValue ->
            binding?.tvShowText?.text = showValue.toString()
        }
    }
    private fun initShowTextViewModel(){
        viewModel = ViewModelProvider(requireActivity())[ShowTextViewModel::class.java]
    }

    override fun onDestroy() {
        binding = null
        showTextObserver?.let { showTextObserver ->
            viewModel?.enterText?.removeObserver(showTextObserver)
        }
        super.onDestroy()
    }
}
