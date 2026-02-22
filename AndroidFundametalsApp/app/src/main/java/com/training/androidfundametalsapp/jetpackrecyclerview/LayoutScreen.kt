package com.training.androidfundametalsapp.jetpackrecyclerview

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.training.androidfundametalsapp.R

//@Preview(heightDp = 500)
@Composable
fun displayDesign() {
//    cardDesign()
    LazyColumn(content = {
        items(getListData()) { item ->
                cardDesign(
                    imageID = item.imageID,
                    userName = item.userName,
                    userDescription = item.userDescription
                )
        }
    })

}


@Composable
fun cardDesign(imageID: Int, userName: String, userDescription: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(imageID),
            contentDescription = "",
            Modifier
                .size(68.dp)
                .padding(8.dp)
        )
        Column(Modifier.padding(12.dp)) {
            Text(userName, fontSize = 20.sp, style = MaterialTheme.typography.headlineSmall)
            Text(userDescription, fontSize = 16.sp, style = MaterialTheme.typography.bodySmall)
        }
    }
}

fun getListData(): MutableList<Users> {
    val usersList = mutableListOf<Users>()
    usersList.add(Users(R.drawable.user1, "Meet Patel", "Android Developer"))
    usersList.add(Users(R.drawable.user5, "Shyam Tank", "ReactJs Developer"))
    usersList.add(Users(R.drawable.user2, "Shivraj Deshmukh", "Android Developer"))
    usersList.add(Users(R.drawable.user3, "Harsh Chaudhary", "Full Stack Developer"))
    usersList.add(Users(R.drawable.user4, "Vraj Patel", "Java Backend Developer"))
    usersList.add(Users(R.drawable.user1, "Meet Patel", "Android Developer"))
    usersList.add(Users(R.drawable.user5, "Shyam Tank", "ReactJs Developer"))
    usersList.add(Users(R.drawable.user2, "Shivraj Deshmukh", "Android Developer"))
    usersList.add(Users(R.drawable.user3, "Harsh Chaudhary", "Full Stack Developer"))
    usersList.add(Users(R.drawable.user4, "Vraj Patel", "Java Backend Developer"))
    usersList.add(Users(R.drawable.user1, "Meet Patel", "Android Developer"))
    usersList.add(Users(R.drawable.user5, "Shyam Tank", "ReactJs Developer"))
    usersList.add(Users(R.drawable.user2, "Shivraj Deshmukh", "Android Developer"))
    usersList.add(Users(R.drawable.user3, "Harsh Chaudhary", "Full Stack Developer"))
    usersList.add(Users(R.drawable.user4, "Vraj Patel", "Java Backend Developer"))

    return usersList
}