package com.movie.ext

import android.content.Context
import android.widget.Toast

fun Context.toastS(message: String) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
