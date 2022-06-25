package com.example.recycleview

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.TextView
import com.example.recycleview.Adapter.AdapterTeamBola
import com.example.recycleview.databinding.ActivityMainBinding
import com.example.recycleview.model.Pemain
import android.media.Image as Image1

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listPemain = ArrayList<Pemain> ()
        listPemain.add(Pemain("Thibaut Courtois",R.drawable.courtois,"Penjaga Gawang", "2.00 m", "Belgia", "11 Mei 1992"))
        listPemain.add(Pemain("Karim Benzema",R.drawable.benzema,"Penyerang", "1,85 m", "Prancis", "19 Desember 1987"))
        listPemain.add(Pemain("Marcelo Vieira da Silva",R.drawable.marcello,"Belakang", "1,74 m", "Brasil", "12 Mei 1988"))
        listPemain.add(Pemain("Sergio Ramos García",R.drawable.ramos,"Belakang", "1,84 m", "Sevilla", "30 Maret 1986"))
        listPemain.add(Pemain("Zinedine Yazid Zidane",R.drawable.zidan,"Pelatih", "1,85 m", "Prancis", "23 Juni 1972"))

        binding.list.adapter = AdapterTeamBola( this, listPemain, object : AdapterTeamBola.OnClickListener {
            override fun detailData(item: Pemain?) {
               Dialog(this@MainActivity).apply {
                   requestWindowFeature(Window.FEATURE_NO_TITLE)
                   setCancelable(true)
                   setContentView(R.layout.detail_data_pemain)

                   val image
                   image = this.findViewById<image>(R.id.image_pemain)
                   val nama = this.findViewById<TextView>(R.id.txtNamaPemain)
                   val posisi = this.findViewById<TextView>(R.id.txtPosisi)
                   val tinggi = this.findViewById<TextView>(R.id.txtTinggi)
                   val tempatlahir = this.findViewById<TextView>(R.id.txttempatlahir)
                   val tgllahir = this.findViewById<TextView>(R.id.txtTanggallahir)
                   val btn = this.findViewById<Button>(R.id.btnClose)

                   image.setImageResource(item?.foto ?: 0)
                   nama.text = "${item?.nama}"
                   posisi.text = "${item?.posisi}"
                   tinggi.text = "${item?.tingg}"
                   tempatlahir.text = "${item?.temparlahir}"
                   tgllahir.text = "${item?.tgllahir}"

                   btn.setOnClickListener {
                       this.dismiss()
                   }

               }
            }

        })

    }
}

class image : View() {

}

}
