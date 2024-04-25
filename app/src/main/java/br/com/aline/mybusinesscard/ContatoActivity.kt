package br.com.aline.mybusinesscard

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.aline.mybusinesscard.databinding.ActivityContatoBinding

lateinit var binding: ActivityContatoBinding

class Contato : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContatoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.tvLinkedin.setOnClickListener {

            val intent =
                Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/ferreiraline/"))
            startActivity(intent)
        }

        binding.tvEmail.setOnClickListener {

            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto: alinfst@gmail.com")
            intent.putExtra(Intent.EXTRA_EMAIL, "Hi, Aline")
            intent.putExtra(Intent.EXTRA_SUBJECT, "Hello")
            startActivity(intent)

        }

        binding.tvGithub.setOnClickListener {

            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/al1neferreira"))
            startActivity(intent)
        }

        binding.tvWhatsapp.setOnClickListener {

            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
                type = "text/plain"
                setPackage("com.whatsapp")
            }
            if (intent
                    .resolveActivity(
                        packageManager
                    )
                == null) Toast.makeText(
                this,
                "Please install whatsapp first.",
                Toast.LENGTH_SHORT)
                .show()

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }

    }
}

// TODO: intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+"+55"+mobileNumber + "&text="+message));