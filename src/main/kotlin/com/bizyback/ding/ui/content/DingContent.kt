package com.bizyback.ding.ui.content

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bizyback.ding.DingBundle.message
import com.bizyback.ding.settings.DingSettings
import com.bizyback.ding.utils.Tone
import com.bizyback.ding.utils.ring
import com.bizyback.ding.utils.tones.*

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

    var run by remember { mutableStateOf(DingConfigurationUI(settings.runEnabled, settings.runTone)) }
    var indexing by remember { mutableStateOf(DingConfigurationUI(settings.indexingEnabled, settings.indexingTone)) }
    var testing by remember { mutableStateOf(DingConfigurationUI(settings.testingEnabled, settings.testingTone)) }
    var start by remember { mutableStateOf(DingConfigurationUI(settings.startEnabled, settings.startTone)) }
    var success by remember { mutableStateOf(DingConfigurationUI(settings.successEnabled, settings.successTone)) }
    var failed by remember { mutableStateOf(DingConfigurationUI(settings.failedEnabled, settings.failedTone)) }
    var canceled by remember { mutableStateOf(DingConfigurationUI(settings.canceledEnabled, settings.canceledTone)) }

    Surface(modifier = Modifier) {
        Column(
            modifier = Modifier.padding(16.dp).fillMaxSize()
        ) {
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
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(vertical = 16.dp)
                .verticalScroll(rememberScrollState())
            ) {
                ConfigurationItemUI(
                    modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                    item = ConfigurationItem(
                        enabled = run.enabled,
                        title = message("configure.build.run"),
                        selection = run.tone,
                        options = StartToneKey.values().map { it.tone }
                    ),
                    onToneSelected = {
                        settings.runTone = it
                        run = run.copy(tone = settings.runTone)
                    },
                    onTonePlayClicked = { ring(settings.runTone) },
                    onToneToggleClicked = {
                        settings.runEnabled = settings.runEnabled.not()
                        run = run.copy(enabled = settings.runEnabled)
                    }
                )
                ConfigurationItemUI(
                    modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                    item = ConfigurationItem(
                        enabled = indexing.enabled,
                        title = message("configure.build.indexing"),
                        selection = indexing.tone,
                        options = StartToneKey.values().map { it.tone }
                    ),
                    onToneSelected = {
                        settings.indexingTone = it
                        indexing = indexing.copy(tone = settings.indexingTone)
                    },
                    onTonePlayClicked = { ring(settings.indexingTone) },
                    onToneToggleClicked = {
                        settings.indexingEnabled = settings.indexingEnabled.not()
                        indexing = indexing.copy(enabled = settings.indexingEnabled)
                    }
                )
                ConfigurationItemUI(
                    modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                    item = ConfigurationItem(
                        enabled = testing.enabled,
                        title = message("configure.build.testing"),
                        selection = testing.tone,
                        options = StartToneKey.values().map { it.tone }
                    ),
                    onToneSelected = {
                        settings.testingTone = it
                        testing = testing.copy(tone = settings.testingTone)
                    },
                    onTonePlayClicked = { ring(settings.testingTone) },
                    onToneToggleClicked = {
                        settings.testingEnabled = settings.testingEnabled.not()
                        testing = testing.copy(enabled = settings.testingEnabled)
                    }
                )
                ConfigurationItemUI(
                    modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                    item = ConfigurationItem(
                        enabled = start.enabled,
                        title = message("configure.build.start"),
                        selection = start.tone,
                        options = StartToneKey.values().map { it.tone }
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
                ConfigurationItemUI(
                    modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                    item = ConfigurationItem(
                        enabled = failed.enabled,
                        title = message("configure.build.finish.failed"),
                        selection = failed.tone,
                        options = SuccessToneKey.values().map { it.tone }
                    ),
                    onToneSelected = {
                        settings.failedTone = it
                        failed = failed.copy(tone = settings.failedTone)
                    },
                    onTonePlayClicked = { ring(settings.failedTone) },
                    onToneToggleClicked = {
                        settings.failedEnabled = settings.failedEnabled.not()
                        failed = failed.copy(enabled = settings.failedEnabled)
                    }
                )
                ConfigurationItemUI(
                    modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                    item = ConfigurationItem(
                        enabled = canceled.enabled,
                        title = message("configure.build.finish.canceled"),
                        selection = canceled.tone,
                        options = SuccessToneKey.values().map { it.tone }
                    ),
                    onToneSelected = {
                        settings.canceledTone = it
                        canceled = canceled.copy(tone = settings.canceledTone)
                    },
                    onTonePlayClicked = { ring(settings.canceledTone) },
                    onToneToggleClicked = {
                        settings.canceledEnabled = settings.canceledEnabled.not()
                        canceled = canceled.copy(enabled = settings.canceledEnabled)
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
