package com.example.nonfm

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class MyAdapter (listArray:ArrayList<listItem>,context: Context): RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    var listArrayR = listArray
    var contextR = context

   class ViewHolder(view:View):RecyclerView.ViewHolder(view) {
    
       val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
       val tvContext = view.findViewById<TextView>(R.id.tvContent)
       val im = view.findViewById<ImageView>(R.id.im)


       fun bind (listItem: listItem,context: Context)
       {
           tvTitle.text = listItem.titleText
           tvContext.text = listItem.contentText





           // удалила .substring(0,60) + "..."
        // val textCon =listItem.contentText.substring(0,60) + "..."
         //  tvContext.text = textCon

          // val text = listItem.contentText
           // val sliceText = text.substring(0,60)
           // var outputText = sliceText+"..."
           im.setImageResource(listItem.image_id)
           itemView.setOnClickListener(){
               Toast.makeText(context,"Pressed : ${tvTitle.text}",Toast.LENGTH_SHORT).show()

               val i = Intent(context,ContentActivity::class.java).apply {
                   putExtra("title", tvTitle.text.toString())

                   Log.e("TAG", tvTitle.text.toString())

                   putExtra("content",listItem.contentText)

                   putExtra("image",listItem.image_id)
                }
               context .startActivity(i)
           }

       }
   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(contextR)
        return (ViewHolder(inflater.inflate(R.layout.item_layout,parent,false)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listItem = listArrayR[position]
        holder.bind(listItem,contextR)
    }

    override fun getItemCount(): Int {
        return this.listArrayR.size
    }

    fun updateAdapter(listArray:List<listItem>)
    {
        listArrayR.clear()
        listArrayR.addAll(listArray)
        notifyDataSetChanged()

    }

}