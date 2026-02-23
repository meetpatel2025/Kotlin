package com.training.androidfundametalsapp

import android.content.Context
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Android
import androidx.compose.material.icons.outlined.AutoAwesome
import androidx.compose.material.icons.outlined.Autorenew
import androidx.compose.material.icons.outlined.Calculate
import androidx.compose.material.icons.outlined.Casino
import androidx.compose.material.icons.outlined.Code
import androidx.compose.material.icons.outlined.Contacts
import androidx.compose.material.icons.outlined.CurrencyExchange
import androidx.compose.material.icons.outlined.Description
import androidx.compose.material.icons.outlined.ExposurePlus1
import androidx.compose.material.icons.outlined.FormatQuote
import androidx.compose.material.icons.outlined.GridView
import androidx.compose.material.icons.outlined.Image
import androidx.compose.material.icons.outlined.Language
import androidx.compose.material.icons.outlined.Link
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Navigation
import androidx.compose.material.icons.outlined.NotificationsActive
import androidx.compose.material.icons.outlined.OpenInNew
import androidx.compose.material.icons.outlined.PlayCircle
import androidx.compose.material.icons.outlined.Security
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.ShowChart
import androidx.compose.material.icons.outlined.SportsSoccer
import androidx.compose.material.icons.outlined.SwapHoriz
import androidx.compose.material.icons.outlined.Swipe
import androidx.compose.material.icons.outlined.TagFaces
import androidx.compose.material.icons.outlined.Terminal
import androidx.compose.material.icons.outlined.ViewList
import androidx.compose.material.icons.outlined.ViewQuilt
import androidx.compose.material.icons.outlined.ViewStream
import androidx.compose.material.icons.outlined.Widgets
import androidx.compose.material.icons.outlined.WifiTethering
import androidx.compose.ui.graphics.vector.ImageVector
import com.google.gson.Gson
import com.training.androidfundametalsapp.model.Topics
import com.training.androidfundametalsapp.model.UiTopics

object TopicsController {

    var topicsList: List<UiTopics> = emptyList()
        private set

    fun loadAssetsFromJSON(context: Context) {
        val json = context.assets.open("Topics.json")
            .bufferedReader(Charsets.UTF_8)
            .use { it.readText() }

        val raw = Gson().fromJson(json, Array<Topics>::class.java).asList()

        topicsList = raw.map { t ->
            UiTopics(
                topicID = t.topicID,
                topicHeader = t.topicHeader,
                topicDescription = t.topicDescription,
                imageName = mapImage(t.imageName),
                file = t.file
            )
        }
    }

    private val iconMap: Map<String, ImageVector> = mapOf(
        "Autorenew"        to Icons.Outlined.Autorenew,
        "List"             to Icons.Outlined.List,
        "Calculate"        to Icons.Outlined.Calculate,
        "ExposurePlus1"    to Icons.Outlined.ExposurePlus1,
        "TagFaces"         to Icons.Outlined.TagFaces,
        "Language"         to Icons.Outlined.Language,
        "OpenInNew"        to Icons.Outlined.OpenInNew,
        "Casino"           to Icons.Outlined.Casino,
        "Description"      to Icons.Outlined.Description,
        "PlayCircle"       to Icons.Outlined.PlayCircle,
        "SwapHoriz"        to Icons.Outlined.SwapHoriz,
        "Android"          to Icons.Outlined.Android,
        "Contacts"         to Icons.Outlined.Contacts,
        "CurrencyExchange" to Icons.Outlined.CurrencyExchange,
        "ViewList"         to Icons.Outlined.ViewList,
        "Link"             to Icons.Outlined.Link,
        "Code"             to Icons.Outlined.Code,
        "ViewQuilt"        to Icons.Outlined.ViewQuilt,
        "ShoppingCart"     to Icons.Outlined.ShoppingCart,
        "Image"            to Icons.Outlined.Image,
        "AutoAwesome"      to Icons.Outlined.AutoAwesome,
        "ViewStream"       to Icons.Outlined.ViewStream,
        "ShowChart"        to Icons.Outlined.ShowChart,
        "Navigation"       to Icons.Outlined.Navigation,
        "Menu"             to Icons.Outlined.Menu,
        "Terminal"         to Icons.Outlined.Terminal,
        "FormatQuote"      to Icons.Outlined.FormatQuote,
        "NotificationsActive" to Icons.Outlined.NotificationsActive,
        "WifiTethering"    to Icons.Outlined.WifiTethering,
        "SportsSoccer"     to Icons.Outlined.SportsSoccer,
        "Security"         to Icons.Outlined.Security,
        "Swipe"            to Icons.Outlined.Swipe,
        "GridView"         to Icons.Outlined.GridView,
        "Widgets"          to Icons.Outlined.Widgets
    )

    fun mapImage(imageName: String): ImageVector =
        iconMap[imageName.trim()] ?: Icons.Outlined.Autorenew
}
