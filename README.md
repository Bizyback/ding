
## Template ToDo list
- [x] Create a new [IntelliJ Platform Plugin Template][template] project.
- [ ] Get familiar with the [template documentation][template].
- [ ] Adjust the [pluginGroup](./gradle.properties), [plugin ID](./src/main/resources/META-INF/plugin.xml) and [sources package](./src/main/kotlin).
- [ ] Adjust the plugin description in `README` (see [Tips][docs:plugin-description])
- [ ] Review the [Legal Agreements](https://plugins.jetbrains.com/docs/marketplace/legal-agreements.html?from=IJPluginTemplate).
- [ ] [Publish a plugin manually](https://plugins.jetbrains.com/docs/intellij/publishing-plugin.html?from=IJPluginTemplate) for the first time.
- [ ] Set the `PLUGIN_ID` in the above README badges.
- [ ] Set the [Plugin Signing](https://plugins.jetbrains.com/docs/intellij/plugin-signing.html?from=IJPluginTemplate) related [secrets](https://github.com/JetBrains/intellij-platform-plugin-template#environment-variables).
- [ ] Set the [Deployment Token](https://plugins.jetbrains.com/docs/marketplace/plugin-upload.html?from=IJPluginTemplate).
- [ ] Click the <kbd>Watch</kbd> button on the top of the [IntelliJ Platform Plugin Template][template] to be notified about releases containing new features and fixes.
<div align="center">

<p align="center"><img width=12% src="/.github/images/logo.png" alt="Ding Logo"></p>

# Ding
![Build](https://github.com/Bizyback/ding/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/23147.svg)](https://plugins.jetbrains.com/plugin/23147)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/23147.svg)](https://plugins.jetbrains.com/plugin/23147)
![GitHub Repo stars](https://img.shields.io:/github/stars/bizyback/ding)
![GitHub branch checks state](https://img.shields.io:/github/checks-status/bizyback/ding/main)

<!-- Plugin description -->
This is a minimal IntelliJ Platform Plugin that makes a notification sound for some selected project tasks e.g Build and Test.

<!-- Plugin description end -->
[Installation](#installation) •
[Usage](#usage) •
[Download](#download) •
[Contributing](#contributing)

</div>

## Installation

- Using the IDE built-in plugin system:

  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "ding"</kbd> >
  <kbd>Install</kbd>

- Manually:

  Download the [latest release](https://github.com/Bizyback/ding/releases/latest) and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>

## Usage

- Add a usage guide here

# Download
<iframe width="384px" height="319px" src="https://plugins.jetbrains.com/embeddable/card/23147"></iframe>

<iframe width="245px" height="48px" src="https://plugins.jetbrains.com/embeddable/install/23147"></iframe>

## Contributing

![GitHub tag (latest by date)](https://img.shields.io:/github/v/tag/bizyback/hatch?style=for-the-badge)
![GitHub contributors](https://img.shields.io:/github/contributors/bizyback/hatch?style=for-the-badge) ![GitHub last commit](https://img.shields.io:/github/last-commit/bizyback/hatch?style=for-the-badge) [![Good first issues](https://img.shields.io/github/issues/bizyback/hatch/good%20first%20issue?style=for-the-badge)](https://github.com/bizyback/hatch/issues?q=is%3Aissue+is%3Aopen+label%3A%22good+first+issue%22)![GitHub issues](https://img.shields.io:/github/issues-raw/bizyback/hatch?style=for-the-badge) ![GitHub pull requests](https://img.shields.io:/github/issues-pr/bizyback/hatch?style=for-the-badge)

Your contributions are especially welcome.
Whether it comes in the form of code patches, ideas, discussion, bug reports, encouragement or criticism, your input is needed.

Visit [issues](https://github.com/bizyback/ding/issues) to get started.

---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
[docs:plugin-description]: https://plugins.jetbrains.com/docs/intellij/plugin-user-experience.html#plugin-description-and-presentation
