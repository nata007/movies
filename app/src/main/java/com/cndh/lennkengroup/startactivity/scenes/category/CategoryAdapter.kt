package com.cndh.lennkengroup.startactivity.scenes.category

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cndh.lennkengroup.startactivity.Domain.database.entities.catalog.CategoryList
import com.cndh.lennkengroup.startactivity.Domain.database.entities.catalog.Data
import com.cndh.lennkengroup.startactivity.R
import kotlinx.android.synthetic.main.category_card.view.*

class CategoryAdapter(private val list: CategoryList,private val onListDataInteraction: OnSelectCategory) : RecyclerView.Adapter<CategoryAdapter.ViewHoler>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoler {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_card, parent, false)
        return ViewHoler(view)
    }

    override fun getItemCount(): Int {
        return list.data.size
    }

    override fun onBindViewHolder(holder: ViewHoler, position: Int) {

        holder.bind(list.data.get(position))
        holder.mView.setOnClickListener {
            onListDataInteraction.onListDataInteraction(list.data.get(position))
        }
    }


    inner class ViewHoler(val mView: View) : RecyclerView.ViewHolder(mView) {

        fun bind(data:Data) {
            mView.categoryName.text = data.category
            mView.categoryColor.setBackgroundColor(Color.parseColor(data.color))
        }
    }
}