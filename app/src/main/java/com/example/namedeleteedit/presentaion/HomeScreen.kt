package com.example.namedeleteedit.presentaion

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.namedeleteedit.NameViewModel
import com.example.namedeleteedit.core.Common.Companion.addName
import com.example.namedeleteedit.core.Common.Companion.cancel
import com.example.namedeleteedit.core.Common.Companion.done
import com.example.namedeleteedit.core.Common.Companion.label
import com.example.namedeleteedit.core.Common.Companion.label2
import com.example.namedeleteedit.core.Common.Companion.typeSomething
import com.example.namedeleteedit.core.Common.Companion.working
import com.example.namedeleteedit.room.NameEntities

@Composable
fun HomeScreen(viewModel: NameViewModel = hiltViewModel()) {
    val nameCollection by viewModel.names.collectAsState(initial = emptyList())
    var nameForEditBox by remember { mutableStateOf("") }
    Column(
        Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        Text(text = label, style = MaterialTheme.typography.h6)
        Text(text = label2, style = MaterialTheme.typography.subtitle1)
        OutlinedTextField(
            value = nameForEditBox,
            onValueChange = { nameForEditBox = it },
            placeholder = { Text(text = typeSomething) }
        )
        Button(
            onClick = {
                viewModel.addName(NameEntities(0, nameForEditBox))
                nameForEditBox = ""
            },
            enabled = nameForEditBox.isNotBlank()
        ) { Text(text = addName) }
        Divider()
        LazyColumn() {
            items(items = nameCollection) {
                ItemCard(
                    nameEntities = it,
                    onClickDelete = { viewModel.deleteName(it) },
                    onClickEdit = {
                        viewModel.getName(it.id)
                        viewModel.openDialog()
                    })

                if (viewModel.dialogState) {
                    AlertDialog(
                        onDismissRequest = { viewModel.closeDialog() },
                        title = { Text(text = working) },
                        text = {
                            TextField(
                                value = viewModel.nameState.name,
                                onValueChange = { viewModel.updateNameName(it) })
                        },
                        confirmButton = {
                            TextButton(onClick = {
                                viewModel.updateName()
                                viewModel.closeDialog()
                            },
                                enabled = viewModel.nameState.name.isNotBlank()
                            ) {
                                Text(text = done)
                            }
                        },
                        dismissButton = {
                            TextButton(onClick = {
                                viewModel.closeDialog()
                            }) {
                                Text(text = cancel)
                            }
                        }
                    )
                }
            }
        }
    }
}


@Composable
fun ItemCard(nameEntities: NameEntities, onClickDelete: () -> Unit, onClickEdit: () -> Unit) {
    Card {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = nameEntities.name)
            IconRow(onClickDelete = { onClickDelete() }, onClickEdit = { onClickEdit() })
        }
    }
}

@Composable
fun IconRow(onClickDelete: () -> Unit, onClickEdit: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        IconButton(onClick = onClickDelete) {
            Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete")
        }

        IconButton(onClick = onClickEdit) {
            Icon(imageVector = Icons.Default.Edit, contentDescription = "Delete")
        }
    }
}