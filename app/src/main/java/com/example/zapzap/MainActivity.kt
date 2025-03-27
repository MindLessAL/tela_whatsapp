package com.example.zapzap

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Message
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.CircleNotifications
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.PostAdd
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zapzap.ui.theme.ZapZapTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ZapZapTheme {
                App()
            }
        }
    }

}
sealed class NavItem(
    val label: String,
    val icon: ImageVector,
//    val route: String
){
    object Chats: NavItem("Chats", Icons.AutoMirrored.Filled.Message)
    object Status: NavItem("Status", Icons.Default.PostAdd)
    object Calls: NavItem("Calls", Icons.Default.Call)
    object Updates: NavItem("Updates", Icons.Default.CircleNotifications)
    object Communities: NavItem("Communities", Icons.Default.People)

}


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun App() {
    val items = remember {
        listOf(
            NavItem.Chats,
            NavItem.Status,
            NavItem.Calls,
            NavItem.Updates,
            NavItem.Communities
        )
    }

    var selectItem by remember {
        mutableStateOf(items.first())
    }

    val pagerState = rememberPagerState {
        items.size
    }

    LaunchedEffect(selectItem) {
        pagerState.animateScrollToPage(items.indexOf(selectItem))
    }
    LaunchedEffect(pagerState.targetPage) {
        selectItem = items[pagerState.targetPage]
    }
    // TEST


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text(text = "ZapZap") },
                actions = {
                    Row(
                        Modifier.padding(8.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {

                        Icon(Icons.Default.CameraAlt, contentDescription = null)
                        Icon(Icons.Default.MoreVert, contentDescription = null)
                    }


                }

            )
        },
        bottomBar = {
                BottomAppBar{
                    items.forEach { navItem ->
                        NavigationBarItem(
                            selected = navItem == selectItem,
                            onClick = {
                                selectItem = navItem
                            },
                            icon = {
                                Icon(navItem.icon, contentDescription = null)

                            },
                            label = {
                                Text(text = navItem.label)
                            }

                        )

                    }

                }

        }
    ) { innerPadding ->
        HorizontalPager(
            pagerState,
            Modifier.padding(innerPadding)
        ) {
            page ->
            val item = items[page]
            when(item){
                NavItem.Chats -> ChatsListScreen()
                NavItem.Status -> StatusListScreen()
                NavItem.Calls -> CallsListScreen()
                NavItem.Updates -> UpdatesListScreen()
                NavItem.Communities -> CommunityListScreen()
            }
        }

    }
}



@Composable
fun ChatsListScreen(modifier: Modifier = Modifier){
    Box(modifier = modifier.fillMaxSize()){
        Text(
            text = "Chats List",
            Modifier.align(Alignment.Center),
            style = TextStyle(
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@Composable
fun StatusListScreen(modifier: Modifier = Modifier){
    Box(modifier = modifier.fillMaxSize()){
        Text(
            text = "Status List",
            Modifier.align(Alignment.Center),
            style = TextStyle(
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}
@Composable
fun CallsListScreen(modifier: Modifier = Modifier){
    Box(modifier = modifier.fillMaxSize()){
        Text(
            text = "Call List",
            Modifier.align(Alignment.Center),
            style = TextStyle(
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}
@Composable
fun UpdatesListScreen(modifier: Modifier = Modifier){
    Box(modifier = modifier.fillMaxSize()){
        Text(
            text = "Updates List",
            Modifier.align(Alignment.Center),
            style = TextStyle(
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@Composable
fun CommunityListScreen(modifier: Modifier = Modifier){
    Box(modifier = modifier.fillMaxSize()){
        Text(
            text = "Communities List",
            Modifier.align(Alignment.Center),
            style = TextStyle(
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}






@Preview
@Composable
private fun AppPreview() {
    ZapZapTheme {
        App()
    }


}