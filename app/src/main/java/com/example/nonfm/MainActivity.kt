package com.example.nonfm

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var adapter : MyAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val nav_view = findViewById<NavigationView>(R.id.nav_view)
        nav_view.setNavigationItemSelectedListener(this)

        val list =ArrayList<listItem>()
        list.addAll(fillArras(resources.getStringArray(R.array.teg),
            resources.getStringArray(R.array.teg_content), getImageId(R.array.teg_image_array)))
        list.addAll(fillArras(resources.getStringArray(R.array.leh),
            resources.getStringArray(R.array.leh_content), getImageId(R.array.leh_image_array)))
        list.addAll(fillArras(resources.getStringArray(R.array.blag),
            resources.getStringArray(R.array.blag_content), getImageId(R.array.blag_image_array)))
        list.addAll(fillArras(resources.getStringArray(R.array.mal),
            resources.getStringArray(R.array.mal_content), getImageId(R.array.mal_image_array)))

        val rcView = findViewById<RecyclerView>(R.id.rcView)
        rcView.hasFixedSize()
        rcView.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter (list,this)
        rcView.adapter = adapter
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
         when  (item.itemId) {
             R.id.id_teg ->
             {
                 Toast.makeText(this,"Id teg",Toast.LENGTH_SHORT).show()
                 adapter?.updateAdapter(fillArras(resources.getStringArray(R.array.teg),
                     resources.getStringArray(R.array.teg_content), getImageId(R.array.teg_image_array)))

             }
             R.id.id_leh ->
             {
                 Toast.makeText(this,"Id leh",Toast.LENGTH_SHORT).show()
                 adapter?.updateAdapter(fillArras(resources.getStringArray(R.array.leh),
                     resources.getStringArray(R.array.leh_content), getImageId(R.array.leh_image_array)))

             }
             R.id.id_blag ->
             {
                 Toast.makeText(this,"Id blag",Toast.LENGTH_SHORT).show()
                 adapter?.updateAdapter(fillArras(resources.getStringArray(R.array.blag),
                     resources.getStringArray(R.array.blag_content), getImageId(R.array.blag_image_array)))
             }
             R.id.id_mal ->
             {
                 Toast.makeText(this,"Id mal",Toast.LENGTH_SHORT).show()
                 adapter?.updateAdapter(fillArras(resources.getStringArray(R.array.mal),
                     resources.getStringArray(R.array.mal_content), getImageId(R.array.mal_image_array)))
             }


         }
        var drawerLa: DrawerLayout? = null
        drawerLa = findViewById(R.id.drawerLayout)
        drawerLa?.closeDrawer(GravityCompat.START)


        return true
    }
    fun fillArras(titleArray: Array<String>,contentArray:Array<String>,imageArray: IntArray):List<listItem>
    {
        val listItemArray = ArrayList<listItem>()
        for (n in 0..listItemArray.size +3)
        {
             val listItem =listItem(imageArray[n],titleArray[n],contentArray[n])
            listItemArray.add(listItem)
        }
        return listItemArray

    }
    private fun getImageId(imageArrayId:Int):IntArray
    {
        val tArray:TypedArray = resources.obtainTypedArray(imageArrayId)
    val count = tArray.length()
        val ids =IntArray(count)
        for (i in ids.indices)
        {
            ids[i] =tArray.getResourceId(i,0)
        }
        tArray.recycle()
        return ids
    }
}