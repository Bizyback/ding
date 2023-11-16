package com.bizyback.ding.ui.content

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bizyback.ding.DingBundle.message
import com.bizyback.ding.settings.DingSettings
import com.bizyback.ding.utils.ring.*

/**
 *
 * @project  ding
 * @author   mambo
 * @email    mambobryan@gmail.com
 * @date     Thu 16 November 2023
 * @time     5:39 pm
 *
 */

data class DingConfigurationUI(val enabled: Boolean, val tone: Tone)

@Composable
fun DingContent(
    settings: DingSettings,
    onDismissDialogClicked: () -> Unit
) {

    var start by remember { mutableStateOf(DingConfigurationUI(settings.startEnabled, settings.startTone)) }
    var success by remember { mutableStateOf(DingConfigurationUI(settings.successEnabled, settings.successTone)) }

    Surface(modifier = Modifier) {
        Column(modifier = Modifier.padding(16.dp).fillMaxSize()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier.padding(vertical = 8.dp),
                    text = message("notification.project")
                )
            }
            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = message("configure.title"),
                fontSize = MaterialTheme.typography.h4.fontSize
            )
            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = message("configure.description")
            )
            Column(modifier = Modifier.fillMaxWidth().weight(1f).padding(vertical = 16.dp)) {
                ConfigurationItemUI(
                    modifier = Modifier.fillMaxWidth(),
                    item = ConfigurationItem(
                        enabled = start.enabled,
                        title = message("configure.build.start"),
                        selection = start.tone,
                        options = StartKey.values().map { it.tone }
                    ),
                    onToneSelected = {
                        settings.startTone = it
                        start = start.copy(tone = settings.startTone)
                    },
                    onTonePlayClicked = { ring(settings.startTone) },
                    onToneToggleClicked = {
                        settings.startEnabled = settings.startEnabled.not()
                        start = start.copy(enabled = settings.startEnabled)
                    }
                )
                ConfigurationItemUI(
                    modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                    item = ConfigurationItem(
                        enabled = success.enabled,
                        title = message("configure.build.finish.success"),
                        selection = success.tone,
                        options = SuccessToneKey.values().map { it.tone }
                    ),
                    onToneSelected = {
                        settings.successTone = it
                        success = success.copy(tone = settings.successTone)
                    },
                    onTonePlayClicked = { ring(settings.successTone) },
                    onToneToggleClicked = {
                        settings.successEnabled = settings.successEnabled.not()
                        success = success.copy(enabled = settings.successEnabled)
                    }
                )
            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Button(
                    onClick = onDismissDialogClicked,
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green, contentColor = Color.Black)
                ) {
                    Text(
                        modifier = Modifier.padding(vertical = 4.dp, horizontal = 16.dp),
                        text = message("configure.action.done")
                    )
                }
            }
        }
    }

}
