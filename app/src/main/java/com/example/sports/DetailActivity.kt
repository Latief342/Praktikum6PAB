package com.example.sports

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ATHLETE = "extra_athlete"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvName: TextView = findViewById(R.id.tv_detail_name)
        val tvSport: TextView = findViewById(R.id.tv_detail_sport)
        val tvEarnings: TextView = findViewById(R.id.tv_detail_earnings)
        val tvDescription: TextView = findViewById(R.id.tv_detail_description)
        val imgPhoto: ImageView = findViewById(R.id.img_detail_photo)
        val btnShare: Button = findViewById(R.id.btn_share)

        // --- INI BAGIAN YANG BERUBAH: Menggunakan getSerializableExtra ---
        val athlete = if (Build.VERSION.SDK_INT >= 33) {
            intent.getSerializableExtra(EXTRA_ATHLETE, Athlete::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getSerializableExtra(EXTRA_ATHLETE) as? Athlete
        }

        if (athlete != null) {
            tvName.text = athlete.name
            tvSport.text = athlete.sport
            tvEarnings.text = athlete.earnings
            tvDescription.text = athlete.description
            com.bumptech.glide.Glide.with(this)
                .load(athlete.imageRes)
                .into(imgPhoto)

            // Fungsionalitas tombol Share
            btnShare.setOnClickListener {
                val shareText = "Cek info atlet ini!\nNama: ${athlete.name}\nOlahraga: ${athlete.sport}\nPenghasilan: ${athlete.earnings}"
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, shareText)
                    type = "text/plain"
                }
                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)
            }
        }
    }
}