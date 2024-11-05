package com.example.recyclerviewpict

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerviewpict.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Menggunakan generatePictures, membuat instance adapter, dan diatur ke RecyclerView
        val pictureList = generatePictures()
        val adapterPicture = PictureAdapter(pictureList)

        // Mengatur RecyclerView pada rvPicture
        with(binding) {
            rvPicture.apply {
                adapter = adapterPicture
                layoutManager = GridLayoutManager(this@MainActivity, 3)
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // Membuat daftar objek Picture yang akan ditampilkan
    private fun generatePictures() : List<Picture> {
        return listOf(
            Picture(R.drawable.acrobat_svgrepo_com, "Acrobat"),
            Picture(R.drawable.baidu_svgrepo_com, "Baidu"),
            Picture(R.drawable.brw_firefox_svgrepo_com, "Firefox"),
            Picture(R.drawable.amazon_svgrepo_com, "Amazom"),
            Picture(R.drawable.blender_svgrepo_com, "Blender"),
            Picture(R.drawable.brw_opera_svgrepo_com, "Opera"),
            Picture(R.drawable.illustrator_svgrepo_com, "Illustrator"),
            Picture(R.drawable.aftereffects_svgrepo_com, "After Effects"),
            Picture(R.drawable.photoshop_svgrepo_com, "Photoshop"),
            Picture(R.drawable.brw_explorer_svgrepo_com, "Explorer"),
            Picture(R.drawable.brw_chrome_svgrepo_com, "Chrome"),
            Picture(R.drawable.brw_safari_01_svgrepo_com, "Safari"),
        )
    }
}