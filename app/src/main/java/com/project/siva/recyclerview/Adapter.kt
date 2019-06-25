package com.project.siva.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.content.ClipData
import android.view.DragEvent
import android.widget.LinearLayout

class Adapter(val data : MutableList<String>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view  = LayoutInflater.from(p0.context).inflate(R.layout.view_holder,p0,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.textView.text = data[p1]
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView), View.OnLongClickListener, View.OnDragListener {

        init {
            itemView.setOnLongClickListener(this)
            itemView.setOnDragListener(this)
        }

        val textView = itemView.findViewById<TextView>(R.id.textView)!!

        override fun onLongClick(v: View?): Boolean {
            val data = ClipData.newPlainText("", "")
            val shadowBuilder = View.DragShadowBuilder(v)
            v!!.startDrag(data, shadowBuilder, v, 0)
            v.visibility = View.INVISIBLE
            return true
        }

        override fun onDrag(v: View?, event: DragEvent?): Boolean {
            when(event!!.action) {
                DragEvent.ACTION_DRAG_STARTED -> { }
                DragEvent.ACTION_DRAG_ENTERED -> { }
                DragEvent.ACTION_DRAG_EXITED -> { }
                DragEvent.ACTION_DROP -> {
                    val view = event.localState as View
                    val owner = view.parent as ViewGroup
                    owner.removeView(view)
                    val container = v as LinearLayout
                    container.addView(view)
                    view.visibility = View.VISIBLE
                }
                DragEvent.ACTION_DRAG_ENDED -> { }
            }
            return true
        }
    }
}