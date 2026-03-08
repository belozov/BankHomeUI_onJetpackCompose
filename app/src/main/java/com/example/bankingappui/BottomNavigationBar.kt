package com.example.bankingappui

import android.R.attr.onClick
import android.R.attr.text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.example.bankingappui.data.BottomNavigation


val items = listOf(
        BottomNavigation(
            tittle = "Home",
            icon = Icons.Rounded.Home
        ),
        BottomNavigation(
            tittle = "Wallet",
            icon = Icons.Rounded.Wallet
        ),
        BottomNavigation(
            tittle = "Notifications",
            icon = Icons.Rounded.Notifications
        ),
        BottomNavigation(
            tittle = "Account",
            icon = Icons.Rounded.AccountCircle
        )
    )
@Preview
@Composable
    fun BottomNavigationBar() {
        NavigationBar {
            Row(
                modifier = Modifier.background(MaterialTheme.colorScheme.inverseOnSurface)
            ){
                items.forEachIndexed { index, item ->
                    NavigationBarItem (
                        selected = index == 0,
                        onClick = { },
                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.tittle,
                                tint = MaterialTheme.colorScheme.onBackground
                            )
                        },
                        label = { Text(text = item.tittle) }
                    )

                }
            }
        }
        }
