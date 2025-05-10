//
//package com.example.wilowachn.screens
//
//import androidx.compose.foundation.BorderStroke
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun JournalEditorScreen(
//    journalTitle: String = "",
//    journalContent: String = "",
//    onTitleChange: (String) -> Unit = {},
//    onContentChange: (String) -> Unit = {},
//    onSave: (Any?, Any?) -> Unit = {},
//    onDelete: () -> Unit = {},
//    onBack: () -> Unit = {}
//) {
//    val bgColor = Color(0xFFF7F0EE)
//    val purple = Color(0xFF4000F4)
//
//    var title by remember { mutableStateOf(journalTitle) }
//    var content by remember { mutableStateOf(journalContent) }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(bgColor)
//            .padding(24.dp)
//    ) {
//        Row(
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            IconButton(onClick = onBack) {
//                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
//            }
//            Spacer(modifier = Modifier.width(8.dp))
//            Text(
//                text = "Wilowachin",
//                fontWeight = FontWeight.Bold,
//                fontSize = 32.sp,
//                color = Color.Black
//            )
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Text(
//            text = "Create Journal",
//            fontWeight = FontWeight.Black,
//            fontSize = 24.sp,
//            modifier = Modifier.align(Alignment.CenterHorizontally)
//        )
//
//        Spacer(modifier = Modifier.height(32.dp))
//
//        Text(
//            text = "Title",
//            fontWeight = FontWeight.Bold,
//            fontSize = 20.sp,
//            color = Color(0xFF555052),
//        )
//        Spacer(modifier = Modifier.height(4.dp))
//        OutlinedTextField(
//            value = title,
//            onValueChange = {
//                title = it
//                onTitleChange(it)
//            },
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(56.dp),
//            shape = RoundedCornerShape(10.dp),
//            colors = TextFieldDefaults.outlinedTextFieldColors(
//                containerColor = Color.White,
//                unfocusedBorderColor = Color(0xFFDDDDDD),
//                focusedBorderColor = purple
//            ),
//            singleLine = true,
//            textStyle = LocalTextStyle.current.copy(fontSize = 18.sp)
//        )
//
//        Spacer(modifier = Modifier.height(20.dp))
//
//        Text(
//            text = "Content",
//            fontWeight = FontWeight.Bold,
//            fontSize = 20.sp,
//            color = Color(0xFF555052),
//        )
//        Spacer(modifier = Modifier.height(4.dp))
//        OutlinedTextField(
//            value = content,
//            onValueChange = {
//                content = it
//                onContentChange(it)
//            },
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(120.dp),
//            shape = RoundedCornerShape(10.dp),
//            colors = TextFieldDefaults.outlinedTextFieldColors(
//                containerColor = Color.White,
//                unfocusedBorderColor = Color(0xFFDDDDDD),
//                focusedBorderColor = purple
//            ),
//            textStyle = LocalTextStyle.current.copy(fontSize = 16.sp)
//        )
//
//        Spacer(modifier = Modifier.height(36.dp))
//
//
//        Button(
//            onClick = onSave,
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(56.dp),
//            colors = ButtonDefaults.buttonColors(containerColor = purple),
//            shape = RoundedCornerShape(14.dp),
//            elevation = ButtonDefaults.buttonElevation(0.dp)
//        ) {
//            Text("Save", fontSize = 18.sp, color = Color.White)
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        OutlinedButton(
//            onClick = onDelete,
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(50.dp),
//            shape = RoundedCornerShape(14.dp),
//            border = BorderStroke(1.dp, Color(0xFFDDDDDD)),
//            colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.White)
//        ) {
//            Text("Delete", fontSize = 18.sp, color = Color.Black)
//        }
//    }
//}
//
//@Preview(showBackground = true, widthDp = 400, heightDp = 800)
//@Composable
//fun PreviewJournalEditorScreen() {
//    MaterialTheme {
//        JournalEditorScreen()
//    }
//}



//// (Code for JournalEditorScreen.kt as you provided earlier, with necessary modifications)
package com.example.wilowachin.presentation.screens

import android.app.Application
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.wilowachin.viewmodel.JournalEditorViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import androidx.compose.ui.text.TextStyle
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JournalEditorScreen(
    navController: NavHostController,
    journalId: Int,
    onSave: (String, String) -> Unit,
    onDelete: () -> Unit,
    onBack: @Composable () -> Unit
) {
    val context = LocalContext.current
    val application = context.applicationContext as Application
    val journalEditorViewModel: JournalEditorViewModel = remember {
        JournalEditorViewModel(application, journalId)
    }

    val title by journalEditorViewModel.title.collectAsState()
    val content by journalEditorViewModel.content.collectAsState()

    val bgColor = Color(0xFFF7F0EE)
    val purple = Color(0xFF4000F4)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(bgColor)
            .padding(24.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
             Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Wilowachn",
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = if (journalId == 0) "Create Journal" else "Edit Journal",
            fontWeight = FontWeight.Black,
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Title",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color(0xFF555052),
        )
        Spacer(modifier = Modifier.height(4.dp))
        OutlinedTextField(
            value = title,
            onValueChange = { journalEditorViewModel.updateTitle(it) },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(10.dp),
//            colors = TextFieldDefaults.outlinedTextFieldColors(
//                containerColor = Color.White,
//                unfocusedBorderColor = Color(0xFFDDDDDD),
//                focusedBorderColor = purple
            colors = TextFieldDefaults.colors( // Use TextFieldDefaults.colors
                unfocusedContainerColor =  Color.White,
                focusedContainerColor = Color.White,
                unfocusedIndicatorColor = Color(0xFFDDDDDD), // Changed to unfocusedIndicatorColor
                focusedIndicatorColor = purple,           // Changed to focusedIndicatorColor
                cursorColor = purple
            ),
            singleLine = true,
            textStyle = LocalTextStyle.current.copy(fontSize = 18.sp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Content",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color(0xFF555052),
        )
        Spacer(modifier = Modifier.height(4.dp))
//        OutlinedTextField(
//            value = content,
//            onValueChange = { journalEditorViewModel.updateContent(it) },
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(120.dp),
//            shape = RoundedCornerShape(10.dp),
//            colors = TextFieldDefaults.outlinedTextFieldColors(
//                containerColor = Color.White,
//                unfocusedBorderColor = Color(0xFFDDDDDD),
//                focusedBorderColor = purple
//            ),
//            textStyle = LocalTextStyle.current.copy(fontSize = 16.sp)
//        )

        OutlinedTextField(
            value = title,
            onValueChange = { journalEditorViewModel.updateTitle(it) },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.colors( // Use TextFieldDefaults.colors
                unfocusedContainerColor =  Color.White,
                focusedContainerColor = Color.White,
                unfocusedIndicatorColor = Color(0xFFDDDDDD), // Changed to unfocusedIndicatorColor
                focusedIndicatorColor = purple,           // Changed to focusedIndicatorColor
                cursorColor = purple
            ),
            singleLine = true,
            textStyle = TextStyle(fontSize = 18.sp)
        )

        Spacer(modifier = Modifier.height(36.dp))
        Button(
            onClick = { onSave(title, content) },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(containerColor = purple),
            shape = RoundedCornerShape(14.dp),
            elevation = ButtonDefaults.buttonElevation(0.dp)
        ) {
            Text("Save", fontSize = 18.sp, color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (journalId != 0) { // Show delete button only when editing an existing journal
            Button(
                onClick = onDelete,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                shape = RoundedCornerShape(14.dp),
                elevation = ButtonDefaults.buttonElevation(0.dp)
            ) {
                Text("Delete", fontSize = 18.sp, color = Color.White)
            }
        }
    }
}



