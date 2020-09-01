package com.nonamer777.madlevel2task2.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nonamer777.madlevel2task2.R
import com.nonamer777.madlevel2task2.databinding.ItemStatementBinding

class StatementAdapter(private val statements: List<Statement>):
        RecyclerView.Adapter<StatementAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val binding = ItemStatementBinding.bind(itemView)

        fun dataBind(statement: Statement) {
            binding.tvStatementLabel.text = statement.statement
        }
    }

    /**
     * Creates and returns a ViewHolder object,
     * inflating a standard layout called `simple_list_item_1`
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_statement, parent, false)
    )

    /** Returns the size of the list. */
    override fun getItemCount(): Int = statements.size

    /** Called by RecyclerView to display the data at the specified position. */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.dataBind(statements[position])
}
