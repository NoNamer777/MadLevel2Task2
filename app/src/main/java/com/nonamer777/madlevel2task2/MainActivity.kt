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

        // Attaches the created ItemTouchHelpers to the view.
        createItemTouchHelper(ItemTouchHelper.LEFT).attachToRecyclerView(rvStatements)
        createItemTouchHelper(ItemTouchHelper.RIGHT).attachToRecyclerView(rvStatements)
    }

    /** Creates an ItemTouchHelper in for a certain swipe direction. */
    private fun createItemTouchHelper(swipeDirection: Int): ItemTouchHelper {

        val callback = object: ItemTouchHelper.SimpleCallback(0, swipeDirection) {

            // Disable moving items up or down in the list.
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean = false

            // Handles swiping an item
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val condition = statements[position].isTruth

                /* Remove an item when the its condition is `false` and the direction of the swipe is left. (4)
                 * Remove an item when the its condition is `true` and the direction of the swipe is right. (8) */
                when (direction) {
                    4 -> removeStatement(!condition, position)
                    8 -> removeStatement(condition, position)
                }
            }
        }
        return ItemTouchHelper(callback)
    }

    /**
     * Removes a statement from the list if the user had swiped the statement to the right direction.
     * Otherwise show a Snackbar.
     * */
    private fun removeStatement(answerIsCorrect: Boolean, index: Int) {
        if (answerIsCorrect) {
            statements.removeAt(index)
            statementAdapter.notifyDataSetChanged()
            return
        }
        /* Resets the swiped item back to its original position after it had been swiped in the
         * wrong direction and show the Snackbar. */
        statementAdapter.notifyDataSetChanged()

        Snackbar.make(
            rvStatements,
            "Sorry, your answer is incorrect and thus we can not remove the statement.",
            Snackbar.LENGTH_LONG
        ).show()
    }
}
