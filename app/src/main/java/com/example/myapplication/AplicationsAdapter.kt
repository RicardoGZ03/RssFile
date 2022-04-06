package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AplicationsAdapter (context:Context, feedEntries:ArrayList<FeedEntry>):RecyclerView.Adapter<AplicationsAdapter.ViewHolder>(){
    private var localContext: Context? = null
    private var localFeedEntries: ArrayList<FeedEntry>? = null
    init {
        localContext = context
        localFeedEntries = feedEntries
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AplicationsAdapter.ViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(localContext)
        val view: View = layoutInflater.inflate(R.layout.P_recyclerView,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AplicationsAdapter.ViewHolder, position: Int) {
        val currentFeedEntry: FeedEntry = localFeedEntries!![position]
        holder.textArtist.text = currentFeedEntry.artist
        holder.textDescription.text = currentFeedEntry.summary
        holder.textName.text = currentFeedEntry.name

    }

    override fun getItemCount(): Int {
       return localFeedEntries?.size ?: 0
    }


    class ViewHolder(v:View):RecyclerView.ViewHolder(v){
         val textName: TextView = v.findViewById(R.id.textViewNombre)
          val textArtist: TextView = v.findViewById(R.id.textViewArtista)
         val textDescription: TextView = v.findViewById(R.id.textViewInfo)
    }
}