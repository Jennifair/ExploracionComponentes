package com.example.exploracioncomponentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.exploracioncomponentes.ui.theme.ExploracionComponentesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExploracionComponentesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ExploracionComponentesTheme {
        Greeting("Android")
    }
}


// 1. LazyColumn: lista vertical que solo dibuja los elementos visibles (eficiente para listas largas)
@Composable
fun LazyColumnExample() {
    LazyColumn(modifier = Modifier.padding(8.dp)) {
        items(10) { index ->
            Text(text = "Elemento $index", modifier = Modifier.padding(8.dp))
        }
    }
}
@Preview(showBackground = true)
@Composable
fun LazyColumnPreview() { LazyColumnExample() }


// 2. LazyRow: igual que LazyColumn pero en horizontal
@Composable
fun LazyRowExample() {
    LazyRow(modifier = Modifier.padding(8.dp)) {
        items(10) { index ->
            Text(text = "Item $index", modifier = Modifier.padding(8.dp))
        }
    }
}
@Preview(showBackground = true)
@Composable
fun LazyRowPreview() { LazyRowExample() }


// 3. Grid (usamos LazyVerticalGrid como ejemplo de "Grid" clásico)
@Composable
fun GridExample() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.height(150.dp)
    ) {
        items(9) { index ->
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .size(50.dp)
                    .background(Color(0xFFB39DDB)),
                contentAlignment = Alignment.Center
            ) { Text("$index") }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GridPreview() { GridExample() }


// 4. ConstraintLayout: posiciona elementos relacionándolos entre sí mediante "constraints"
@Composable
fun ConstraintLayoutExample() {
    ConstraintLayout(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        val (texto, boton) = createRefs()
        Text(
            text = "Hola Constraint",
            modifier = Modifier.constrainAs(texto) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            }
        )
        Button(
            onClick = {},
            modifier = Modifier.constrainAs(boton) {
                top.linkTo(texto.bottom, margin = 8.dp)
                start.linkTo(parent.start)
            }
        ) { Text("Botón") }
    }
}
@Preview(showBackground = true)
@Composable
fun ConstraintLayoutPreview() { ConstraintLayoutExample() }


// 5. Scaffold: estructura base de una pantalla (topBar, bottomBar, contenido, FAB, etc.)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample() {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Mi App") }) },
        floatingActionButton = { FloatingActionButton(onClick = {}) { Icon(Icons.Default.Add, contentDescription = "Agregar") } }
    ) { padding ->
        Text("Contenido de la pantalla", modifier = Modifier.padding(padding))
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ScaffoldPreview() { ScaffoldExample() }


// 6. Surface: contenedor con color de fondo, elevación y forma (base visual de Material Design)
@Composable
fun SurfaceExample() {
    Surface(
        modifier = Modifier.size(120.dp).padding(8.dp),
        color = Color(0xFFE1BEE7),
        shadowElevation = 4.dp
    ) {
        Text("Soy una Surface", modifier = Modifier.padding(8.dp))
    }
}
@Preview(showBackground = true)
@Composable
fun SurfacePreview() { SurfaceExample() }


// 7. Chip: etiqueta compacta, útil para filtros o categorías
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChipExample() {
    AssistChip(onClick = {}, label = { Text("Kotlin") })
}
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ChipPreview() { ChipExample() }


// 8. FlowRow: como Row pero pasa a la siguiente línea si no cabe (wrap automático)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlowRowExample() {
    FlowRow(modifier = Modifier.padding(8.dp)) {
        repeat(8) { index ->
            AssistChip(onClick = {}, label = { Text("Tag $index") }, modifier = Modifier.padding(2.dp))
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun FlowRowPreview() { FlowRowExample() }


// 9. FlowColumn: igual que FlowRow pero organiza en columnas que "saltan" a la siguiente
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlowColumnExample() {
    FlowColumn(modifier = Modifier.height(150.dp).padding(8.dp)) {
        repeat(8) { index ->
            AssistChip(onClick = {}, label = { Text("Tag $index") }, modifier = Modifier.padding(2.dp))
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun FlowColumnPreview() { FlowColumnExample() }