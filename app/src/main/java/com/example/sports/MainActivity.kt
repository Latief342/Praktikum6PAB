package com.example.sports

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvAthletes: RecyclerView
    private val list = ArrayList<Athlete>()
    private lateinit var adapter: AthleteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvAthletes = findViewById(R.id.rv_athletes)
        rvAthletes.setHasFixedSize(true)

        list.addAll(getListAthletes())
        showRecyclerList()

        val etSearch: EditText = findViewById(R.id.et_search)
        etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                filterData(s.toString())
            }
        })
    }

    private fun filterData(query: String) {
        val filteredList = ArrayList<Athlete>()
        for (item in list) {

            if (item.name.lowercase().contains(query.lowercase())) {
                filteredList.add(item)
            }
        }

        if (filteredList.isEmpty()) {
            Toast.makeText(this, "Atlet tidak ditemukan", Toast.LENGTH_SHORT).show()
        } else {
            adapter.setFilteredList(filteredList)
        }
    }

    private fun getListAthletes(): ArrayList<Athlete> {
        val dataName = arrayOf(
            "Cristiano Ronaldo", "Jon Rahm", "Lionel Messi", "LeBron James",
            "Giannis Antetokounmpo", "Kylian Mbappé", "Neymar", "Karim Benzema",
            "Stephen Curry", "Lamar Jackson"
        )
        val dataSport = arrayOf(
            "Sepak Bola", "Golf", "Sepak Bola", "Basket",
            "Basket", "Sepak Bola", "Sepak Bola", "Sepak Bola",
            "Basket", "American Football"
        )
        val dataEarnings = arrayOf(
            "Rp 4.160 Miliar", "Rp 3.488 Miliar", "Rp 2.160 Miliar", "Rp 2.051 Miliar",
            "Rp 1.776 Miliar", "Rp 1.760 Miliar", "Rp 1.728 Miliar", "Rp 1.696 Miliar",
            "Rp 1.632 Miliar", "Rp 1.608 Miliar"
        )
        val dataDescription = arrayOf(
            "Megabintang Portugal yang kini bermain untuk Al Nassr. Ia menjadi atlet dengan bayaran tertinggi berkat kontrak fantastis di liga Arab Saudi dan sponsor besar.",
            "Pegolf profesional asal Spanyol yang mendapatkan bayaran masif setelah bergabung dengan liga LIV Golf yang didanai PIF Arab Saudi.",
            "Legenda sepak bola Argentina yang bermain di Inter Miami. Penghasilannya berasal dari gaji klub, bagi hasil Apple TV, dan sponsor abadi dengan Adidas.",
            "Ikon NBA dari Los Angeles Lakers. Selain gaji besar di lapangan, ia memiliki portofolio investasi dan kerajaan bisnis hiburannya sendiri.",
            "Bintang Milwaukee Bucks asal Yunani ini baru saja menandatangani perpanjangan kontrak besar dan memiliki kesepakatan sepatu yang sangat menguntungkan.",
            "Penyerang mematikan Prancis. Kontrak besarnya di Real Madrid serta berbagai dukungan sponsor menjadikannya atlet muda terkaya.",
            "Bintang Brasil yang pindah ke Al Hilal. Kesepakatan transfernya tidak hanya mencakup gaji pokok, tetapi juga fasilitas mewah dan bonus komersial.",
            "Striker asal Prancis yang memenangkan Ballon d'Or. Ia bergabung dengan Al-Ittihad dengan kontrak multi-tahun yang sangat menggiurkan.",
            "Penembak jitu terbaik sejarah NBA dari Golden State Warriors. Ia memiliki brand sendiri di bawah naungan Under Armour.",
            "Quarterback bintang Baltimore Ravens yang menandatangani kontrak perpanjangan rekor di NFL pada tahun lalu."
        )
        val dataPhoto = intArrayOf(
            R.drawable.ronaldo, R.drawable.rahm, R.drawable.messi, R.drawable.lebron,
            R.drawable.giannis, R.drawable.mbappe, R.drawable.neymar, R.drawable.benzema,
            R.drawable.curry, R.drawable.lamar
        )

        val listAthlete = ArrayList<Athlete>()
        for (i in dataName.indices) {
            val athlete = Athlete(dataName[i], dataSport[i], dataEarnings[i], dataDescription[i], dataPhoto[i])
            listAthlete.add(athlete)
        }
        return listAthlete
    }

    private fun showRecyclerList() {
        rvAthletes.layoutManager = LinearLayoutManager(this)
        adapter = AthleteAdapter(list)
        rvAthletes.adapter = adapter

        adapter.setOnItemClickCallback(object : AthleteAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Athlete) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_ATHLETE, data)
                startActivity(intent)
            }
        })
    }
}