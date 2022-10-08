package com.example.mycodeschoolhomeworks.country

import android.icu.number.NumberFormatter.with
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatImageView
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.mycodeschoolhomeworks.R

class Flags : AppCompatActivity() {
    private lateinit var armenianFlag: AppCompatImageView
    private lateinit var russianFlag: AppCompatImageView
    private lateinit var franceFlag: AppCompatImageView
    private lateinit var usaFlag: AppCompatImageView
    private lateinit var ukFlag: AppCompatImageView
    private lateinit var germanyFlag: AppCompatImageView
    private lateinit var italyFlag: AppCompatImageView
    private lateinit var spainFlag: AppCompatImageView
    private lateinit var indianFlag: AppCompatImageView
    private lateinit var iranianFlag: AppCompatImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flags)

        armenianFlag = findViewById(R.id.armenianFlag);
        russianFlag = findViewById(R.id.russianFlag);
        franceFlag = findViewById(R.id.franceFlag);
        usaFlag = findViewById(R.id.usaFlag);
        ukFlag = findViewById(R.id.ukFlag);
        germanyFlag = findViewById(R.id.germanyFlag);
        italyFlag = findViewById(R.id.italyFlag);
        spainFlag = findViewById(R.id.spainFlag);
        indianFlag = findViewById(R.id.indianFlag);
        iranianFlag = findViewById(R.id.iranianFlag);

        Glide.with(this)
            .load("https://upload.wikimedia.org/wikipedia/commons/thumb/2/2f/Flag_of_Armenia.svg/2560px-Flag_of_Armenia.svg.png")
            .placeholder(R.drawable.icon_flags)
            .error(R.drawable.icon_flags)
            .into(armenianFlag);

        Glide.with(this)
            .load("https://upload.wikimedia.org/wikipedia/commons/thumb/f/f3/Flag_of_Russia.svg/1920px-Flag_of_Russia.svg.png")
            .placeholder(R.drawable.icon_flags)
            .error(R.drawable.icon_flags)
            .into(russianFlag);

        Glide.with(this)
            .load("https://upload.wikimedia.org/wikipedia/en/thumb/c/c3/Flag_of_France.svg/1920px-Flag_of_France.svg.png")
            .placeholder(R.drawable.icon_flags)
            .error(R.drawable.icon_flags)
            .into(franceFlag);

        Glide.with(this)
            .load("https://upload.wikimedia.org/wikipedia/en/thumb/a/a4/Flag_of_the_United_States.svg/2560px-Flag_of_the_United_States.svg.png")
            .placeholder(R.drawable.icon_flags)
            .error(R.drawable.icon_flags)
            .into(usaFlag);

        Glide.with(this)
            .load("https://upload.wikimedia.org/wikipedia/en/thumb/a/ae/Flag_of_the_United_Kingdom.svg/2560px-Flag_of_the_United_Kingdom.svg.png")
            .placeholder(R.drawable.icon_flags)
            .error(R.drawable.icon_flags)
            .into(ukFlag);

        Glide.with(this)
            .load("https://upload.wikimedia.org/wikipedia/en/thumb/b/ba/Flag_of_Germany.svg/2560px-Flag_of_Germany.svg.png")
            .placeholder(R.drawable.icon_flags)
            .error(R.drawable.icon_flags)
            .into(germanyFlag);

        Glide.with(this)
            .load("https://upload.wikimedia.org/wikipedia/en/thumb/0/03/Flag_of_Italy.svg/1920px-Flag_of_Italy.svg.png")
            .placeholder(R.drawable.icon_flags)
            .error(R.drawable.icon_flags)
            .into(italyFlag);

        Glide.with(this)
            .load("https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Bandera_de_España.svg/1920px-Bandera_de_España.svg.png")
            .placeholder(R.drawable.icon_flags)
            .error(R.drawable.icon_flags)
            .into(spainFlag);

        Glide.with(this)
            .load("https://upload.wikimedia.org/wikipedia/en/thumb/4/41/Flag_of_India.svg/1920px-Flag_of_India.svg.png")
            .placeholder(R.drawable.icon_flags)
            .error(R.drawable.icon_flags)
            .into(indianFlag);

        Glide.with(this)
            .load("https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Flag_of_Iran.svg/2560px-Flag_of_Iran.svg.png")
            .placeholder(R.drawable.icon_flags)
            .error(R.drawable.icon_flags)
            .into(iranianFlag);

    }
}

