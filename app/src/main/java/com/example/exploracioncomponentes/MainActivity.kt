package com.example.exploracioncomponentes

import androidx.compose.material3.HorizontalDivider
import androidx.compose.ui.window.Dialog
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Snackbar
import androidx.compose.material3.TabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.rememberTooltipState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.res.painterResource

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

// 10. AlertDialog: ventana emergente que pide confirmación o muestra un aviso importante
@Composable
fun AlertDialogExample() {
    var mostrar by remember { mutableStateOf(true) }
    if (mostrar) {
        AlertDialog(
            onDismissRequest = { mostrar = false },
            title = { Text("Confirmar acción") },
            text = { Text("¿Seguro que deseas continuar?") },
            confirmButton = {
                Button(onClick = { mostrar = false }) { Text("Aceptar") }
            },
            dismissButton = {
                Button(onClick = { mostrar = false }) { Text("Cancelar") }
            }
        )
    }
}
@Preview(showBackground = true)
@Composable
fun AlertDialogPreview() { AlertDialogExample() }


// 11. Card: contenedor con esquinas redondeadas y elevación, usado para agrupar contenido relacionado
@Composable
fun CardExample() {
    Card(
        modifier = Modifier.padding(16.dp).size(150.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text("Título de la tarjeta", fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Contenido de ejemplo dentro de un Card.")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun CardPreview() { CardExample() }


// 12. Checkbox: casilla de verificación para opciones booleanas (marcado/desmarcado)
@Composable
fun CheckboxExample() {
    var marcado by remember { mutableStateOf(true) }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = marcado, onCheckedChange = { marcado = it })
        Text("Acepto los términos")
    }
}
@Preview(showBackground = true)
@Composable
fun CheckboxPreview() { CheckboxExample() }


// 13. FloatingActionButton: botón circular flotante para la acción principal de la pantalla
@Composable
fun FloatingActionButtonExample() {
    FloatingActionButton(onClick = {}) {
        Icon(Icons.Default.Add, contentDescription = "Agregar")
    }
}
@Preview(showBackground = true)
@Composable
fun FloatingActionButtonPreview() { FloatingActionButtonExample() }


// 14. Icon: muestra un ícono vectorial (de Material Icons u otro recurso)
@Composable
fun IconExample() {
    Icon(
        imageVector = Icons.Default.Add,
        contentDescription = "Ícono de agregar",
        modifier = Modifier.size(48.dp)
    )
}
@Preview(showBackground = true)
@Composable
fun IconPreview() { IconExample() }


// 15. Image: muestra una imagen (drawable, vectorial o bitmap)
@Composable
fun ImageExample() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = "Imagen de ejemplo",
        modifier = Modifier.size(100.dp)
    )
}
@Preview(showBackground = true)
@Composable
fun ImagePreview() { ImageExample() }


// 16. ProgressBar (CircularProgressIndicator): indica que un proceso está en curso
@Composable
fun ProgressBarExample() {
    CircularProgressIndicator()
}
@Preview(showBackground = true)
@Composable
fun ProgressBarPreview() { ProgressBarExample() }


// 17. RadioButton: permite elegir UNA opción entre varias (mutuamente excluyentes)
@Composable
fun RadioButtonExample() {
    var seleccionado by remember { mutableStateOf(0) }
    Column {
        listOf("Opción A", "Opción B").forEachIndexed { index, texto ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = seleccionado == index,
                    onClick = { seleccionado = index }
                )
                Text(texto)
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun RadioButtonPreview() { RadioButtonExample() }


// 18. Slider: control deslizante para elegir un valor dentro de un rango
@Composable
fun SliderExample() {
    var valor by remember { mutableStateOf(0.5f) }
    Slider(value = valor, onValueChange = { valor = it })
}
@Preview(showBackground = true)
@Composable
fun SliderPreview() { SliderExample() }


// 19. Spacer: espacio vacío usado para separar elementos visualmente
@Composable
fun SpacerExample() {
    Row {
        Text("Izquierda")
        Spacer(modifier = Modifier.width(32.dp))
        Text("Derecha")
    }
}
@Preview(showBackground = true)
@Composable
fun SpacerPreview() { SpacerExample() }


// 20. Switch: interruptor de encendido/apagado (on/off)
@Composable
fun SwitchExample() {
    var activado by remember { mutableStateOf(true) }
    Switch(checked = activado, onCheckedChange = { activado = it })
}
@Preview(showBackground = true)
@Composable
fun SwitchPreview() { SwitchExample() }


// 21. TopAppBar: barra superior de la pantalla, usualmente con el título de la app
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarExample() {
    TopAppBar(title = { Text("Mi Aplicación") })
}
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun TopAppBarPreview() { TopAppBarExample() }


// 22. Divider (HorizontalDivider): línea delgada que separa visualmente secciones de contenido
@Composable
fun DividerExample() {
    Column {
        Text("Sección 1")
        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
        Text("Sección 2")
    }
}
@Preview(showBackground = true)
@Composable
fun DividerPreview() { DividerExample() }


// 23. Dialog: ventana emergente genérica y personalizable (más flexible que AlertDialog)
@Composable
fun DialogExample() {
    var mostrar by remember { mutableStateOf(true) }
    if (mostrar) {
        Dialog(onDismissRequest = { mostrar = false }) {
            Surface(shape = RoundedCornerShape(8.dp)) {
                Text("Este es un Dialog personalizado", modifier = Modifier.padding(24.dp))
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DialogPreview() { DialogExample() }


// 24. DropdownMenu: menú desplegable con una lista de opciones
@Composable
fun DropDownMenuExample() {
    var expandido by remember { mutableStateOf(false) }
    Box {
        Button(onClick = { expandido = true }) { Text("Abrir menú") }
        DropdownMenu(expanded = expandido, onDismissRequest = { expandido = false }) {
            DropdownMenuItem(text = { Text("Opción 1") }, onClick = { expandido = false })
            DropdownMenuItem(text = { Text("Opción 2") }, onClick = { expandido = false })
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DropDownMenuPreview() { DropDownMenuExample() }


// 25. LazyVerticalGrid: cuadrícula que solo dibuja los elementos visibles (versión "oficial" del control de grillas)
@Composable
fun LazyVerticalGridExample() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.height(120.dp)
    ) {
        items(6) { index ->
            Card(modifier = Modifier.padding(4.dp)) {
                Text("Celda $index", modifier = Modifier.padding(12.dp))
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun LazyVerticalGridPreview() { LazyVerticalGridExample() }


// 26. OutlinedTextField: campo de texto con borde delineado (variante estética de TextField)
@Composable
fun OutlinedTextFieldExample() {
    var texto by remember { mutableStateOf("") }
    OutlinedTextField(
        value = texto,
        onValueChange = { texto = it },
        label = { Text("Escribe algo") }
    )
}
@Preview(showBackground = true)
@Composable
fun OutlinedTextFieldPreview() { OutlinedTextFieldExample() }


// 27. Snackbar: mensaje breve y temporal que aparece en la parte inferior de la pantalla
@Composable
fun SnackbarExample() {
    Snackbar { Text("Este es un mensaje Snackbar") }
}
@Preview(showBackground = true)
@Composable
fun SnackbarPreview() { SnackbarExample() }


// 28. TabRow: fila de pestañas para navegar entre secciones
@Composable
fun TabRowExample() {
    var seleccionado by remember { mutableStateOf(0) }
    val tabs = listOf("Inicio", "Perfil", "Ajustes")
    TabRow(selectedTabIndex = seleccionado) {
        tabs.forEachIndexed { index, titulo ->
            Tab(
                selected = seleccionado == index,
                onClick = { seleccionado = index },
                text = { Text(titulo) }
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun TabRowPreview() { TabRowExample() }


// 29. BottomNavigation (NavigationBar en Material3): barra de navegación inferior con íconos
@Composable
fun BottomNavigationExample() {
    var seleccionado by remember { mutableStateOf(0) }
    NavigationBar {
        NavigationBarItem(
            selected = seleccionado == 0,
            onClick = { seleccionado = 0 },
            icon = { Icon(Icons.Default.Home, contentDescription = "Inicio") },
            label = { Text("Inicio") }
        )
        NavigationBarItem(
            selected = seleccionado == 1,
            onClick = { seleccionado = 1 },
            icon = { Icon(Icons.Default.Person, contentDescription = "Perfil") },
            label = { Text("Perfil") }
        )
    }
}
@Preview(showBackground = true)
@Composable
fun BottomNavigationPreview() { BottomNavigationExample() }


// 30. NavigationRail: barra de navegación vertical, usada en pantallas grandes (tablets)
@Composable
fun NavigationRailExample() {
    var seleccionado by remember { mutableStateOf(0) }
    NavigationRail {
        NavigationRailItem(
            selected = seleccionado == 0,
            onClick = { seleccionado = 0 },
            icon = { Icon(Icons.Default.Home, contentDescription = "Inicio") },
            label = { Text("Inicio") }
        )
        NavigationRailItem(
            selected = seleccionado == 1,
            onClick = { seleccionado = 1 },
            icon = { Icon(Icons.Default.Person, contentDescription = "Perfil") },
            label = { Text("Perfil") }
        )
    }
}
@Preview(showBackground = true)
@Composable
fun NavigationRailPreview() { NavigationRailExample() }


// 31. Tooltip: texto de ayuda que aparece al mantener presionado o pasar el cursor sobre un elemento
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TooltipExample() {
    TooltipBox(
        positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
        tooltip = { PlainTooltip { Text("Este es un Tooltip") } },
        state = rememberTooltipState()
    ) {
        Icon(Icons.Default.Info, contentDescription = "Info")
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun TooltipPreview() { TooltipExample() }


// 32. Pager (HorizontalPager): permite deslizar entre páginas horizontalmente (como un carrusel)
@Composable
fun PagerExample() {
    val pagerState = rememberPagerState(pageCount = { 3 })
    HorizontalPager(state = pagerState, modifier = Modifier.height(100.dp)) { page ->
        Box(
            modifier = Modifier.fillMaxWidth().padding(16.dp).background(Color(0xFFC5E1A5)),
            contentAlignment = Alignment.Center
        ) { Text("Página $page") }
    }
}
@Preview(showBackground = true)
@Composable
fun PagerPreview() { PagerExample() }