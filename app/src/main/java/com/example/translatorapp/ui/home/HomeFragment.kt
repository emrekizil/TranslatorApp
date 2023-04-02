package com.example.translatorapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.translatorapp.data.dto.detect.post.PostDetectItem
import com.example.translatorapp.data.dto.language.LanguageResponseItem
import com.example.translatorapp.data.dto.translate.post.PostTranslateItem
import com.example.translatorapp.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel by viewModels<HomeViewModel>()

    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }
    var firstSelection = true
    var buttonIsChecked = false


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeLanguageState()
        observeDetectLanguage()
        observeTranslate()
        buttonSetup()
        translateText()
    }


    private fun observeTranslate() {
        viewModel.translateHomeUiState.observe(viewLifecycleOwner) {
            when (it) {
                is HomeUiState.Error -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
                is HomeUiState.Loading -> {}
                is HomeUiState.Success -> {
                    binding.resultTextView.text = it.data?.get(0)?.translations?.get(0)?.text
                }
            }
        }
    }

    private fun observeDetectLanguage() {
        viewModel.detectLanguageHomeUiState.observe(viewLifecycleOwner) {
            when (it) {
                is HomeUiState.Error -> {}
                is HomeUiState.Loading -> {}
                is HomeUiState.Success -> {
                    viewModel.fromLanguage = it.data?.get(0)?.language.toString()
                }
            }
        }
    }

    private fun observeLanguageState() {
        viewModel.getLanguage()
        viewModel.languageHomeUiState.observe(viewLifecycleOwner) { response ->
            when (response) {
                is HomeUiState.Error -> {
                    Toast.makeText(requireContext(), response.message, Toast.LENGTH_SHORT).show()
                }
                is HomeUiState.Success -> {
                    response.data?.let { it -> setSpinner(it) }
                }
                is HomeUiState.Loading -> {
                }
            }
        }
    }

    private fun detectLanguage() {
        val post = listOf(PostDetectItem(binding.translateEditText.text.toString()))
        viewModel.detectLanguage(post)
    }

    private fun translateText() {
        binding.translateButton.setOnClickListener {
            pushTranslate(binding.translateEditText.text.toString())
        }
    }

    private fun pushTranslate(textInput: String) {
        val post = listOf(PostTranslateItem(textInput))
        if (buttonIsChecked) {
            detectLanguage()
            viewModel.pushTranslate(post)
        } else {
            viewModel.pushTranslate(post)
        }
    }

    private fun setSpinner(data: List<LanguageResponseItem>) {
        val spinnerAdapter = ArrayAdapter(
            requireContext(),
            androidx.transition.R.layout.support_simple_spinner_dropdown_item,
            data
        )
        binding.fromSpinner.adapter = spinnerAdapter
        binding.fromSpinner.setSelection(32)
        binding.fromSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val selectedItem = binding.fromSpinner.selectedItem as LanguageResponseItem
                if(!firstSelection){
                    viewModel.fromLanguage = selectedItem.code
                }
                binding.detectLanguageCheckBox.isChecked = false
                firstSelection = false
            }
            override fun onNothingSelected(p0: AdapterView<*>?) = Unit
        }
        binding.toSpinner.adapter = spinnerAdapter
        binding.toSpinner.setSelection(145)
        binding.toSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val selectedItem = binding.toSpinner.selectedItem as LanguageResponseItem
                viewModel.toLanguage = selectedItem.code
            }
            override fun onNothingSelected(p0: AdapterView<*>?) = Unit
        }
    }

    private fun buttonSetup() {
        binding.detectLanguageCheckBox.setOnCheckedChangeListener { _, isChecked ->
            buttonIsChecked = isChecked
        }
        binding.flipLanguage.setOnClickListener {
            changeLanguageFlip()
        }
    }
    private fun changeLanguageFlip(){
        val fromSpinnerSelection = binding.fromSpinner.selectedItemPosition
        val toSpinnerSelection = binding.toSpinner.selectedItemPosition
        binding.fromSpinner.setSelection(toSpinnerSelection)
        binding.toSpinner.setSelection(fromSpinnerSelection)
    }


}