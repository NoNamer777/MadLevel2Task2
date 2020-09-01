package com.nonamer777.madlevel2task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.nonamer777.madlevel2task2.databinding.ActivityMainBinding
import com.nonamer777.madlevel2task2.model.Statement
import com.nonamer777.madlevel2task2.model.StatementAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val statements = arrayListOf<Statement>()
    private val statementAdapter = StatementAdapter(statements)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.rvStatements.layoutManager = LinearLayoutManager(
            this@MainActivity,
            RecyclerView.VERTICAL,
            false
        )
        binding.rvStatements.adapter = statementAdapter
        binding.rvStatements.addItemDecoration(
            DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL)
        )

        // Loads in the statements data.
        for (i in Statement.STATEMENTS.indices) {
            statements.add(Statement(Statement.STATEMENTS[i], Statement.STATEMENT_CONDITION[i]))
        }
        statementAdapter.notifyDataSetChanged()
