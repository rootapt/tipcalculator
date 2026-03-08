package com.example.tipcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TipCalculatorApp()
        }
    }
}

@Composable
fun TipCalculatorApp() {
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            TipScreen()
        }
    }
}

@Composable
fun TipScreen() {
    var sumText by remember { mutableStateOf("") }
    var dishesText by remember { mutableStateOf("") }
    // Новая переменная для слайдера
    var sliderValue by remember { mutableStateOf(0f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        // Поле для суммы заказа
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Сумма заказа:",
                modifier = Modifier.width(120.dp)
            )
            OutlinedTextField(
                value = sumText,
                onValueChange = { sumText = it },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                shape = RoundedCornerShape(8.dp)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Поле для количества блюд
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Количество блюд:",
                modifier = Modifier.width(120.dp)
            )
            OutlinedTextField(
                value = dishesText,
                onValueChange = { dishesText = it },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                shape = RoundedCornerShape(8.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // НОВЫЙ КОД: Чаевые и слайдер
        Text(
            text = "Чаевые:",
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Подписи 0 и 25 над слайдером
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "0", style = MaterialTheme.typography.bodySmall)
            Text(text = "25", style = MaterialTheme.typography.bodySmall)
        }

        // Слайдер
        Slider(
            value = sliderValue,
            onValueChange = { sliderValue = it },
            valueRange = 0f..25f,
            steps = 24, // 24 шага между 0 и 25 для плавности
            modifier = Modifier.fillMaxWidth()
        )

        // Добавляем отступ после слайдера
        Spacer(modifier = Modifier.height(20.dp))

        // Здесь пока ничего нет, но в следующих коммитах добавим радиокнопки
    }
}