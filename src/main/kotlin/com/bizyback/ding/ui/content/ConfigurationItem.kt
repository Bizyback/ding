package com.bizyback.ding.ui.content

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bizyback.ding.utils.Tone

/**
 *
 * @project  ding
 * @author   mambo
 * @email    mambobryan@gmail.com
 * @date     Thu 16 November 2023
 * @time     8:23 pm
 *
 */
data class ConfigurationItem(
    val enabled: Boolean = true,
    val title: String,
    val selection: Tone,
    val options: List<Tone>,
)

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ConfigurationItemUI(
    modifier: Modifier = Modifier,
    item: ConfigurationItem,
    onToneSelected: (Tone) -> Unit,
    onTonePlayClicked: () -> Unit,
    onToneToggleClicked: () -> Unit,
) {

    var expanded by remember { mutableStateOf(false) }

    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Card(
            modifier = Modifier.weight(1f),
            onClick = {
//                expanded = expanded.not()
            }
        ) {
            Row(
                modifier = Modifier.padding(14.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(modifier = Modifier.padding(start = 16.dp), text = item.title)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "(${item.selection.source.replaceFirstChar { it.uppercase() }})",
                        fontSize = MaterialTheme.typography.caption.fontSize
                    )
                    val visible = false
                    if (visible)
                        Box(
                            modifier = Modifier
                        ) {
                            IconButton(onClick = { expanded = true }) {
                                Icon(Icons.Default.KeyboardArrowDown, contentDescription = "Localized description")
                            }
                            DropdownMenu(
                                expanded = expanded,
                                onDismissRequest = { expanded = false }
                            ) {
                                for (option in item.options) {
                                    DropdownMenuItem(
                                        onClick = {
                                            expanded = expanded.not()
                                            onToneSelected.invoke(option)
                                        },
                                    ) {
                                        Text(text = option.source.replaceFirstChar { it.uppercase() })
                                        if (option.source == item.selection.source)
                                            Icon(
                                                modifier = Modifier.padding(start = 8.dp),
                                                imageVector = Icons.Default.Check,
                                                contentDescription = ""
                                            )
                                    }
                                    Divider(modifier = Modifier.fillMaxWidth())
                                }
                            }
                        }
                }
            }
        }
        Card(modifier = Modifier.padding(start = 8.dp), onClick = onTonePlayClicked) {
            Row {
                IconButton(modifier = Modifier, onClick = onTonePlayClicked) {
                    Icon(Icons.Rounded.Notifications, "")
                }
            }
        }
        Card(
            modifier = Modifier.padding(start = 8.dp),
            onClick = onToneToggleClicked,
            backgroundColor = if (item.enabled) Color.Green else Color.Red,
            contentColor = if (item.enabled) Color.Black else Color.White,
        ) {
            Row {
                IconButton(modifier = Modifier, onClick = onToneToggleClicked) {
                    Icon(Icons.Rounded.Check, "")
                }
            }
        }
    }
}