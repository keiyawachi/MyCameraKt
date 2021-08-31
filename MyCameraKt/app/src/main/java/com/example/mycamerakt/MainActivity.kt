package com.example.mycamerakt

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

import androidx.activity.result.contract.ActivityResultContracts
import com.example.mycamerakt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val imageView: ImageView by lazy { findViewById<ImageView>(R.id.image_view) }
    //private val imageView: Bitmap by lazy { findViewById<Bitmap>(R.id.image_view) }
    private val imageCaptureButton: View by lazy { findViewById<View>(R.id.camera_button) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sendButton.setOnClickListener {
            val intent = Intent(application, SubActivity::class.java)
            startActivity(intent)
        }

        enableCameraFunction()

    }

    private fun enableCameraFunction() {
        val takePicturePreview = registerForActivityResult(ActivityResultContracts.TakePicturePreview(), this::onPicture)
        imageCaptureButton.setOnClickListener { takePicturePreview.launch(null) }

    }

    private fun onPicture(bitmap: Bitmap?) {
        imageView.setImageBitmap(bitmap ?: return)
    }

}