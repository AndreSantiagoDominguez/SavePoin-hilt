package com.example.savepoint.core.di

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalContext
import com.example.savepoint.SavePointApp

@Composable
@ReadOnlyComposable
fun appContainer(): AppContainer = LocalContext.current.appContainer

val Context.appContainer: AppContainer
    get() = (applicationContext as SavePointApp).appContainer
