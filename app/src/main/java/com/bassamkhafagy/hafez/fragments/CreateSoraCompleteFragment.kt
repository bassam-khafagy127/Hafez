package com.bassamkhafagy.hafez.fragments

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bassamkhafagy.hafez.R
import com.bassamkhafagy.hafez.databinding.FragmentCreateRecivingSorraBinding
import com.bassamkhafagy.hafez.util.getSystemDate
import com.bassamkhafagy.hafez.viewModel.HafezViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateSoraCompleteFragment : Fragment(R.layout.fragment_create_reciving_sorra) {
    private lateinit var binding: FragmentCreateRecivingSorraBinding
    private val viewModel by viewModels<HafezViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateRecivingSorraBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpUi()
        setUpCallBacks()
        observeUiData()
    }

    private fun setUpUi() {
        binding.apply {
            dateFieldShowTv.text = getSystemDate()
        }
    }

    private fun observeUiData() {
        observeSurahLiveData()
        observeSheikhLiveData()
        observeStateLiveData()
    }

    private fun observeSurahLiveData() {
        viewModel.surahLiveDate.observe(viewLifecycleOwner) { surah ->
            binding.apply {
                soraTvUser.text = surah

                soraTvUser.visibility = View.VISIBLE
                soraClUser.visibility = View.VISIBLE
                soraIvTitle.visibility = View.VISIBLE
            }
        }
    }

    private fun observeSheikhLiveData() {
        viewModel.sheikhLiveDate.observe(viewLifecycleOwner) { sheikh ->
            binding.apply {
                sheikhTvUser.text = sheikh

                sheikhTvUser.visibility = View.VISIBLE
                sheikhClUser.visibility = View.VISIBLE
                sheikhIvUser.visibility = View.VISIBLE
            }
        }
    }

    private fun observeStateLiveData() {
        viewModel.stateLiveDate.observe(viewLifecycleOwner) { state ->
            binding.studentPassedStateValueEd.setText(state)
        }
    }


    private fun setUpCallBacks() {
        binding.apply {
            sheikhCl.setOnClickListener {
                setSheikhName()
            }

            soraCl.setOnClickListener {
                setSurahName()
            }
            studentPassedStateValueEd.setOnClickListener {
                setState()
            }


        }
    }

    private fun setSheikhName() {
        val alertDialog = AlertDialog.Builder(requireContext())
        alertDialog.setTitle("Chose Sheikh")
        alertDialog.setPositiveButton(getString(R.string.ok), null)
        val checkItem = 0
        val sheikh = arrayOf(
            "AhmedTanaby",
            "Saed Elzaki",
            "AhmedTanaby",
            "Saed Elzaki",
            "AhmedTanaby",
            "Saed Elzaki"
        )
        alertDialog.setSingleChoiceItems(sheikh, checkItem) { _: DialogInterface?, which: Int ->
            Log.d("DialogSheikh2", sheikh[which])
            viewModel.setSheikhName(sheikh[which])
        }
        alertDialog.show()
    }

    private fun setState() {
        val alertDialog = AlertDialog.Builder(requireContext())
        alertDialog.setTitle("Chose Sheikh")
        alertDialog.setPositiveButton(getString(R.string.ok), null)
        val checkItem = 0
        val items =
            arrayOf(resources.getString(R.string.Passed), resources.getString(R.string.Faild))
        alertDialog.setSingleChoiceItems(items, checkItem) { _: DialogInterface?, which: Int ->
            Log.d("DialogState", items[which])
            viewModel.setStateValue(items[which])
        }
        alertDialog.show()
    }

    private fun setSurahName() {
        val sor = resources.getStringArray(R.array.quranArray)
        val alertDialog = AlertDialog.Builder(requireContext())
        alertDialog.setTitle("Chose Surah")
        alertDialog.setPositiveButton(getString(R.string.ok), null)
        val checkItem = 0
        alertDialog.setSingleChoiceItems(sor, checkItem) { _: DialogInterface?, which: Int ->
            Log.d("DialogSurah", sor[which])
            viewModel.setSurahName(sor[which])
        }
        alertDialog.show()
    }


}