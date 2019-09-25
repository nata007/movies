package com.cndh.lennkengroup.startactivity.scenes.category.movies

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cndh.lennkengroup.startactivity.Domain.database.entities.catalog.Data
import com.cndh.lennkengroup.startactivity.Domain.database.entities.catalog.Movie
import com.cndh.lennkengroup.startactivity.R
import kotlinx.android.synthetic.main.category_card.view.*
import kotlinx.android.synthetic.main.movies_card.view.*

class MoviesAdapter (private val list: List<Movie>,private  val color: String) : RecyclerView.Adapter<MoviesAdapter.ViewHoler>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoler {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movies_card, parent, false)
        return ViewHoler(view,color)
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: ViewHoler, position: Int) {
        holder.bind(list.get(position))
    }

    inner class ViewHoler(val mView: View,val color:String) : RecyclerView.ViewHolder(mView) {

        fun bind(movie: Movie) {
            mView.movieTitle.text = movie.title
            mView.movieSubTitle.text = movie.subtitle
            mView.movieYear.text = movie.year.toString()
            mView.moviewDescription.text = movie.description
            mView.lineRelative.setBackgroundColor(Color.parseColor(color))
        }
    }
}