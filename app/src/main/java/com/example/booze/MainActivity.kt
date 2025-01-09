package com.example.booze

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.example.booze.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Bind all volume, percent, and count input fields
        val volumeFields = arrayOf(
            binding.editTextVolume1,
            binding.editTextVolume2,
            binding.editTextVolume3,
            binding.editTextVolume4,
            binding.editTextVolume5
        )

        val percentFields = arrayOf(
            binding.editTextPercent1,
            binding.editTextPercent2,
            binding.editTextPercent3,
            binding.editTextPercent4,
            binding.editTextPercent5
        )

        val countFields = arrayOf(
            binding.editTextCount1,
            binding.editTextCount2,
            binding.editTextCount3,
            binding.editTextCount4,
            binding.editTextCount5
        )

        val result = binding.textViewResult

        // Add TextWatcher to handle dynamic updates
        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                var totalStandardDrinks = 0.0
                for (i in volumeFields.indices) {
                    val volumeStr = volumeFields[i].text.toString()
                    val percentStr = percentFields[i].text.toString()
                    val countStr = countFields[i].text.toString()

                    if (volumeStr.isNotEmpty() && percentStr.isNotEmpty() && countStr.isNotEmpty()) {
                        val volume = volumeStr.toDoubleOrNull()
                        val percent = percentStr.toDoubleOrNull()
                        val count = countStr.toIntOrNull() ?: 1

                        if (volume != null && percent != null) {
                            totalStandardDrinks += ((volume * count * (percent / 100)) / 17.05)
                        }
                    }
                }
                result.text = String.format("%.2f", totalStandardDrinks)
            }

            override fun afterTextChanged(s: Editable?) {}
        }

        // Attach the TextWatcher to all input fields
        volumeFields.forEach { it.addTextChangedListener(textWatcher) }
        percentFields.forEach { it.addTextChangedListener(textWatcher) }
        countFields.forEach { it.addTextChangedListener(textWatcher) }
    }
}