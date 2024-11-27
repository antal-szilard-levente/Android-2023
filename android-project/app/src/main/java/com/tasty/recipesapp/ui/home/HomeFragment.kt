package com.tasty.recipesapp.ui.home

import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.tasty.recipesapp.R



class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Find the TextView and apply the gradient effect
        val textView = view.findViewById<TextView>(R.id.textView)
        val paint = textView.paint
        val width = paint.measureText(textView.text.toString())

        val shader = LinearGradient(
            0f, 0f, width, textView.textSize,
            intArrayOf(
                0xFF00FFFF.toInt(),
                0xFF00FFFF.toInt()  // Cyan
            ),
            null,
            Shader.TileMode.CLAMP
        )

        textView.paint.shader = shader

        return view
    }

}
