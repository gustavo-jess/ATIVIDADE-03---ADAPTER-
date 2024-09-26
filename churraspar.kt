**package br.unipar.atividade3pt2

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var edNumHomens: EditText
    private lateinit var edNumMulheres: EditText
    private lateinit var edNumCriancas: EditText
    private lateinit var txtCarne: TextView
    private lateinit var txtAperitivos: TextView
    private lateinit var txtTotalKgComida: TextView
    private lateinit var txtCerveja: TextView
    private lateinit var txtAgua: TextView
    private lateinit var txtRefrigerante: TextView
    private lateinit var txtTotalLitrosBebida: TextView
    private lateinit var btnCalcular: Button
    private lateinit var btnZerar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edNumHomens = findViewById(R.id.edNumHomens)
        edNumMulheres = findViewById(R.id.edNumMulheres)
        edNumCriancas = findViewById(R.id.edNumCriancas)
        txtCarne = findViewById(R.id.txtCarne)
        txtAperitivos = findViewById(R.id.txtAperitivos)
        txtTotalKgComida = findViewById(R.id.txtTotalKgComida)
        txtCerveja = findViewById(R.id.txtCerveja)
        txtAgua = findViewById(R.id.txtAgua)
        txtRefrigerante = findViewById(R.id.txtRefrigerante)
        txtTotalLitrosBebida = findViewById(R.id.txtTotalLitrosBebida)
        btnCalcular = findViewById(R.id.btnCalcular)
        btnZerar = findViewById(R.id.btnZerar)

        btnCalcular.setOnClickListener { calcular() }
        btnZerar.setOnClickListener { zerar() }
    }

    private fun calcular() {
        val numHomens = edNumHomens.text.toString().toIntOrNull() ?: 0
        val numMulheres = edNumMulheres.text.toString().toIntOrNull() ?: 0
        val numCriancas = edNumCriancas.text.toString().toIntOrNull() ?: 0

        val carnePorHomem = 400
        val carnePorMulher = 300
        val carnePorCrianca = 200
        val margemSeguranca = 0.10

        val totalCarne = (numHomens * carnePorHomem + numMulheres * carnePorMulher + numCriancas * carnePorCrianca) * (1 + margemSeguranca)

        val aperitivoPorHomem = 150
        val aperitivoPorMulher = 100
        val aperitivoPorCrianca = 50
        val totalAperitivos = (numHomens * aperitivoPorHomem + numMulheres * aperitivoPorMulher + numCriancas * aperitivoPorCrianca) * (1 + margemSeguranca)

        val cervejaPorHomem = 4
        val cervejaPorMulher = 2
        val totalCerveja = (numHomens * cervejaPorHomem + numMulheres * cervejaPorMulher) * (1 + margemSeguranca)

        val aguaPorPessoa = 2
        val refrigerantePorPessoa = 1.5
        val totalAgua = (numMulheres + numCriancas) * aguaPorPessoa * (1 + margemSeguranca)
        val totalRefrigerante = (numMulheres + numCriancas) * refrigerantePorPessoa * (1 + margemSeguranca)

        val totalComidaKg = (totalCarne + totalAperitivos) / 1000
        val totalBebidasLitros = totalCerveja + totalAgua + totalRefrigerante

        txtCarne.text = "Carne: ${totalCarne.toInt()} g"
        txtAperitivos.text = "Aperitivos: ${totalAperitivos.toInt()} g"
        txtTotalKgComida.text = "Total em Kilos: $totalComidaKg Kg"
        txtCerveja.text = "Cerveja: ${totalCerveja.toInt()} L"
        txtAgua.text = "Água: ${totalAgua.toInt()} L"
        txtRefrigerante.text = "Refrigerante: ${totalRefrigerante.toInt()} L"
        txtTotalLitrosBebida.text = "Total em Litros: $totalBebidasLitros L"
    }

    private fun zerar() {
        edNumHomens.text.clear()
        edNumMulheres.text.clear()
        edNumCriancas.text.clear()
        txtCarne.text = "Carne: 0 g"
        txtAperitivos.text = "Aperitivos: 0 g"
        txtTotalKgComida.text = "Total em Kilos: 0 Kg"
        txtCerveja.text = "Cerveja: 0 L"
        txtAgua.text = "Água: 0 L"
        txtRefrigerante.text = "Refrigerante: 0 L"
        txtTotalLitrosBebida.text = "Total em Litros: 0 L"
    }
}**
