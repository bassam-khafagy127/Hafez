package com.bassamkhafagy.hafez.fragments

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bassamkhafagy.hafez.R
import com.bassamkhafagy.hafez.data.local.SoraReview
import com.bassamkhafagy.hafez.databinding.FragmentCreateRecivingSorraBinding
import com.bassamkhafagy.hafez.util.RegisterValidation
import com.bassamkhafagy.hafez.util.Resource
import com.bassamkhafagy.hafez.util.checkReview
import com.bassamkhafagy.hafez.util.getSystemDate
import com.bassamkhafagy.hafez.util.showSuccessToast
import com.bassamkhafagy.hafez.viewModel.HafezViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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
        setUpCallBacks(view)
        observeUiData()
    }


    private fun setUpUi() {
        binding.apply {
            dateFieldShowTv.text = getSystemDate()
            sheikhCl.isEnabled = false
            ringValueEd.isEnabled = false
        }
    }

    private fun observeUiData() {
        observeSurahLiveData()
        observeSheikhLiveData()
        observeStateLiveData()
        observeStudentLiveData()
        observeUiStateLiveData()
    }


    private fun setUpCallBacks(view: View) {
        binding.apply {
//            sheikhCl.setOnClickListener {
//                lifecycleScope.launch(Dispatchers.IO) {
//                    val allSheikh = viewModel.getAllSheikhData()
//                    withContext(Dispatchers.Main) {
//                        setSheikhName(allSheikh)
//                    }
//                }
//
//            }

            soraCl.setOnClickListener {
                setSurahName()
            }
            stateCl.setOnClickListener {
                setState()
            }

            studentCodeSearchIv.setOnClickListener {
                val studentCode = studentCodeValueEd.text?.trim().toString()
                getStudentNameByCode(studentCode)
            }
            saveBtn.setOnClickListener {
                reviewSave(view)
            }
        }
    }

    private fun reviewSave(view: View) {
        when (val validation = checkReview(reviewComposition(), requireContext())) {

            is RegisterValidation.Failed -> {
                Snackbar.make(requireContext(), view, validation.message, Snackbar.LENGTH_LONG)
                    .show()
            }

            is RegisterValidation.Success -> {
                lifecycleScope.launch(Dispatchers.IO) {
                    viewModel.saveReview(reviewComposition())
                    withContext(Dispatchers.Main) {
                        clearFieldData()
                    }
                }
            }
        }
    }


    private fun reviewComposition(): SoraReview {
        val studentCode = binding.studentCodeValueEd.text.toString()
        val date = binding.dateFieldShowTv.text.toString()
        val studentName = binding.studentNameValueEd.text.toString()
        val ring = binding.ringValueEd.text.toString()
        val sheikhName = binding.sheikhTvUser.text.toString()
        val soraName = binding.soraTvUser.text.toString()
        val state = binding.studentPassedStateValueEd.text.toString()
        val degree = binding.studentPassedDegreeValueEd.text.toString()
        return SoraReview(
            0,
            date,
            studentCode,
            studentName,
            ring,
            sheikhName,
            soraName,
            state,
            degree
        )
    }


    private fun clearFieldData() {
        binding.studentCodeValueEd.setText("")
        binding.studentNameValueEd.setText("")
        binding.ringValueEd.setText("")
        binding.sheikhTvUser.setText("")
        binding.soraTvUser.setText("")
        binding.studentPassedStateValueEd.setText("")
        binding.studentPassedDegreeValueEd.setText("")
    }

    private fun getStudentNameByCode(studentCode: String) {
        if (studentCode.isNotEmpty()) {
            lifecycleScope.launch(Dispatchers.IO) {

                if (viewModel.checkIFStudentExist(studentCode.toLong()) > 0) {
                    val name = viewModel.getStudentNameByCode(
                        studentCode.toLong()
                    )
                    viewModel.setStudentName(name ?: "Not Found")
                } else {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            requireContext(),
                            resources.getString(R.string.student_code) + " ${resources.getString(R.string.isNotFounded)}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

            }
        } else {
            Toast.makeText(
                requireContext(),
                resources.getString(R.string.student_code) + " ${resources.getString(R.string.cantBeEmpty)}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun setSheikhName(listItems: List<String>) {
        val alertDialog = AlertDialog.Builder(requireContext())
        alertDialog.setTitle("Chose Sheikh")
        alertDialog.setPositiveButton(getString(R.string.ok), null)
        val checkItem = 0
        alertDialog.setSingleChoiceItems(
            listItems.toTypedArray(),
            checkItem
        ) { _: DialogInterface?, which: Int ->
            Log.d("DialogSheikh2", listItems[which])
            viewModel.setSheikhName(listItems[which])
        }
        alertDialog.show()
    }

    private fun setState() {
        val alertDialog = AlertDialog.Builder(requireContext())
        alertDialog.setTitle(resources.getString(R.string.choseSheikh))
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
        alertDialog.setTitle(resources.getString(R.string.choseSurah))
        alertDialog.setPositiveButton(getString(R.string.ok), null)
        val checkItem = 0
        alertDialog.setSingleChoiceItems(sor, checkItem) { _: DialogInterface?, which: Int ->
            Log.d("DialogSurah", sor[which])
            viewModel.setSurahName(sor[which])
        }
        alertDialog.show()
    }

    private fun observeStudentLiveData() {
        viewModel.studentNameLiveDate.observe(viewLifecycleOwner) { student ->
            Log.d("Dialog", student)
            binding.studentNameValueEd.setText(student)
        }
    }

    private fun observeSurahLiveData() {
        viewModel.surahLiveDate.observe(viewLifecycleOwner) { surah ->
            binding.apply {
                soraTvUser.setText(surah)

                soraTvUser.visibility = View.VISIBLE
                soraClUser.visibility = View.VISIBLE
                soraIvTitle.visibility = View.VISIBLE
            }
        }
    }

    private fun observeSheikhLiveData() {
        viewModel.sheikhLiveDate.observe(viewLifecycleOwner) { sheikh ->
            binding.apply {
                sheikhTvUser.setText(sheikh)

                sheikhTvUser.visibility = View.VISIBLE
                sheikhClUser.visibility = View.VISIBLE
                sheikhIvUser.visibility = View.VISIBLE
            }
        }
    }

    private fun observeStateLiveData() {
        viewModel.passedStateLiveData.observe(viewLifecycleOwner) { state ->
            binding.studentPassedStateValueEd.setText(state)
        }
    }

    private fun observeUiStateLiveData() {
        viewModel.uiStateLiveDate.observe(viewLifecycleOwner) { state ->
            when (state) {
                is Resource.Loading -> {}
                is Resource.Error -> {}
                is Resource.Success -> {
                    showSuccessToast(requireContext())
                }

                is Resource.Unspecified -> {}
            }
        }
    }

}