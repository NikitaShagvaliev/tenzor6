package dev.file.infocard.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import dev.file.infocard.R
import dev.file.infocard.databinding.FragmentInfoBinding

class InfoFragment : Fragment(R.layout.fragment_info) {

    private var fragmentInfoBinding: FragmentInfoBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentInfoBinding.bind(view)
        fragmentInfoBinding = binding

        setImagePhoto(binding)
        setTexts(binding)
        setImageAchievements(binding)
        setMessageListener(binding)
    }

    private fun setImagePhoto(binding: FragmentInfoBinding) {
        val imageUrl = "https://www.mobilhanem.com/wp-content/uploads/2018/03/Being-Late-768x768.jpg"

        Glide.with(this)
            .load(imageUrl)
            .override(1920, 1080)
            .placeholder(R.drawable.ic_launcher_background)
            .into(binding.imagePhoto)
    }

    private fun setTexts(binding: FragmentInfoBinding) {
        binding.textFio.text = "Shagvaliev Nikita"
        binding.textPostInCompany.text = "Computer programmer"
        binding.textDepartment.text = "Google, Amazon, Facebook, Apple, Microsoft"

        binding.textEmail.text = "Email: email@email.com"
        binding.textPhone.text = "Phone: 88005555555"
    }

    private fun setImageAchievements(binding: FragmentInfoBinding) {
        val imageUrl =
            "https://cdn.icon-icons.com/icons2/2175/PNG/512/education_school_ribbon_award_achievement_recognition_best_icon_133341.png"
        for (i in 1..6) {
            val imageView = ImageView(requireContext())

            Glide.with(this)
                .load(imageUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageView)

            binding.fragmentHorizontalLayout.addView(imageView)
        }
    }

    private fun setMessageListener(binding: FragmentInfoBinding) {
        val clickMessage = Snackbar.make(
            binding.infoFragment,
            "Message to me",
            Snackbar.LENGTH_LONG
        )
        binding.messageButton.setOnClickListener {
            clickMessage.show()
        }
    }

    override fun onDestroyView() {
        fragmentInfoBinding = null
        super.onDestroyView()
    }
}