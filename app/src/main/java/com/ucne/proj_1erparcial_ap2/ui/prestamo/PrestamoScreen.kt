package com.ucne.proj_1erparcial_ap2.ui.prestamo

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.layout.BoxScopeInstance.align
//import androidx.compose.foundation.layout.BoxScopeInstance.align
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.*
import androidx.compose.material3.R
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ucne.proj_1erparcial_ap2.data.local.entity.PrestamoEntity


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrestamoScreen(viewModel: PrestamoViewModel = hiltViewModel()) {
    Column(Modifier.fillMaxSize()) {
        PrestamoBody(viewModel)
        val uiState by viewModel.uiState.collectAsState()
        PrestamoListScreen(uiState.prestamosList)

    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun PrestamoBody(
    viewModel: PrestamoViewModel
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Registro de Prestamos",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(30.dp))
        OutlinedTextField(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            value = viewModel.deudor,
            onValueChange = { viewModel.deudor = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = null,
                    modifier = Modifier
                        .size(33.dp)
                        .padding(4.dp)
                )
            },
            label = {
                Text(
                    text = "Deudor",
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold
                )
            }
        )
        OutlinedTextField(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            value = viewModel.concepto,
            onValueChange = { viewModel.concepto = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.TextSnippet,
                    contentDescription = null,
                    modifier = Modifier
                        .size(33.dp)
                        .padding(4.dp)
                )
            },
            label = {
                Text(
                    "Concepto",
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold
                )
            },

            )
        OutlinedTextField(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            value = viewModel.monto,
            onValueChange = { viewModel.monto = it },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.AttachMoney,
                    contentDescription = null,
                    modifier = Modifier
                        .size(33.dp)
                        .padding(4.dp)
                )
            },
            label = {
                Text(
                    "Monto",
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold
                )
            }
        )
        Spacer(modifier = Modifier.height(30.dp))
        ExtendedFloatingActionButton(
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(start = 12.dp),
            shape = CircleShape,
            text = {
                Text(
                    "Guardar",
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold
                )
            },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Save, contentDescription
                    = "Guardar"
                )
            },
            onClick = { viewModel.insertar() },
        )
        Spacer(modifier = Modifier.height(30.dp))
    }
}

@Composable
private fun PrestamoListScreen(prestamos: List<PrestamoEntity>) {
    LazyColumn {
        item {
            Text(
                text = "Lista de Prestamos",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold
            )
        }
        items(prestamos) {

                pre ->
            PrestamoRow(pre)

        }
    }
}

@Composable
private fun PrestamoRow(prestamo: PrestamoEntity) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column() {
                Text(
                    text = prestamo.deudor,
                    style = MaterialTheme.typography.titleLarge,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold
                    // modifier = Modifier.weight(3f)
                )
                Text(
                    text = prestamo.concepto,
                    style = MaterialTheme.typography.titleSmall,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold
                    // modifier = Modifier.weight(3f)
                )
            }

            Text(
                String.format("%.2f", prestamo.monto),
                textAlign = TextAlign.End,
                style = MaterialTheme.typography.titleLarge,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(2f)
            )
        }
        Divider(Modifier.fillMaxWidth())
    }
}

