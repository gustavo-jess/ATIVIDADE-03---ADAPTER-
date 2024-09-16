package com.example.alunomanager

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.unipar.atvadapter.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var editTextArea: EditText
    private lateinit var textViewDate: TextView
    private lateinit var textViewList: TextView
    private lateinit var textViewCount: TextView
    private lateinit var buttonAdd: Button
    private lateinit var buttonClear: Button

    private val alunos = mutableListOf<String>()
    private val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextName = findViewById(R.id.editTextName)
        editTextArea = findViewById(R.id.editTextArea)
        textViewDate = findViewById(R.id.textViewDate)
        textViewList = findViewById(R.id.textViewList)
        textViewCount = findViewById(R.id.textViewCount)
        buttonAdd = findViewById(R.id.buttonAdd)
        buttonClear = findViewById(R.id.buttonClear)

        updateDate()

        buttonAdd.setOnClickListener {
            addAluno()
        }

        buttonClear.setOnClickListener {
            clearData()
        }
    }

    private fun updateDate() {
        val currentDate = dateFormat.format(Date())
        textViewDate.text = "Data Atual: $currentDate"
    }

    private fun addAluno() {
        val name = editTextName.text.toString().trim()
        val area = editTextArea.text.toString().trim()

        if (name.isNotEmpty() && area.isNotEmpty()) {
            val aluno = "$name - $area"
            alunos.add(aluno)
            updateList()
        }
    }

    private fun updateList() {
        val listBuilder = StringBuilder("Lista de Alunos:\n")
        for (aluno in alunos) {
            listBuilder.append(aluno).append("\n")
        }
        textViewList.text = listBuilder.toString()
        textViewCount.text = "Total de Alunos: ${alunos.size}"
    }

    private fun clearData() {
        alunos.clear()
        editTextName.text.clear()
        editTextArea.text.clear()
        updateList()
    }
}

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:backgroundTint="#E02B2B"
    android:orientation="vertical"
    android:padding="16dp">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:orientation="vertical">

        <EditText
            android:id="@+id/editTextName"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Nome do aluno" />

        <EditText
            android:id="@+id/editTextArea"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Área de escolha" />

        <TextView
            android:id="@+id/textViewDate"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Data Atual:" />

        <TextView
            android:id="@+id/textViewList"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:paddingTop="8dp"
            android:text="Lista de Alunos:" />

        <TextView
            android:id="@+id/textViewCount"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Total de Alunos:" />

        <Button
            android:id="@+id/buttonAdd"
            android:layout_width="169dp"
            android:layout_height="wrap_content"
            android:layout_marginLeft="80dp"
            android:layout_marginEnd="8dp"
            android:backgroundTint="#2A2C31"
            android:text="Adicionar" />

        <Button
            android:id="@+id/buttonClear"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginLeft="50dp"
            android:layout_marginRight="50dp"
            android:backgroundTint="#D11616"
            android:text="ZERAR"
            app:iconTint="#A69191" />

    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center_vertical"
        android:orientation="horizontal">

    </LinearLayout>

</LinearLayout>

