import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShareJournalScreen(navController: NavController) {
    // Use your custom font family if you have one
    val titleFont = FontFamily.Default

    var email by remember { mutableStateOf(TextFieldValue("edilawit@gmail.com")) }
    var expanded by remember { mutableStateOf(false) }
    var selectedPermission by remember { mutableStateOf("Can view") }
    val permissions = listOf("Can view", "Can edit")

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAF6F6))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 20.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { navController.navigate("myjournals") }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.Black
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    "Wilowachn",
                    style = TextStyle(
                        fontFamily = titleFont,
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    ),
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                "Share Journal",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                "Share with",
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                color = Color(0xFF6B6767)
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                singleLine = true,
                shape = RoundedCornerShape(8.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                "permissions",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(8.dp))
            Box {
                TextButton(
                    onClick = { expanded = true },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.textButtonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.Black
                    )
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(selectedPermission, color = Color.Black)
                        Icon(
                            imageVector = Icons.Filled.ArrowDropDown,
                            contentDescription = null,
                            tint = Color.Black
                        )
                    }
                }
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    permissions.forEach { permission ->
                        DropdownMenuItem(
                            text = { Text(permission) },
                            onClick = {
                                selectedPermission = permission
                                expanded = false
                            }
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(36.dp))
            Button(
                onClick = { navController.navigate("SharedJournalPage")},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4A11F9)),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Share", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            }
        }
        // Bottom Navigation Bar
        NavigationBar(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
            containerColor = Color(0xE0E7E1E1)
        ) {
            NavigationBarItem(
                selected = false,
                onClick = { navController.navigate("welcome") },
                icon = { Icon(Icons.Filled.Home, contentDescription = "Home", tint = Color.Black) }
            )
            NavigationBarItem(
                selected = false,
                onClick = { navController.navigate("editor") },
                icon = { Icon(Icons.Filled.Edit, contentDescription = "Edit", tint = Color.Black) }
            )
            NavigationBarItem(
                selected = false,
                onClick = { navController.navigate("myjournals") },
                icon = { Icon(Icons.Filled.DateRange, contentDescription = "Table", tint = Color.Black) }
            )
            NavigationBarItem(
                selected = false,
                onClick = {navController.navigate("Sharing") },
                icon = { Icon(Icons.Filled.Share, contentDescription = "Share", tint = Color.Black) }
            )
        }
    }
}

//@Preview(showBackground = true, widthDp = 400, heightDp = 800)
//@Composable
//fun PreviewShareJournalScreen() {
//    MaterialTheme {
//        ShareJournalScreen()
//    }
//}