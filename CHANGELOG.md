<!-- Keep a Changelog guide -> https://keepachangelog.com -->

# PonylangPlugin Changelog

## [0.7.4]

### Added
- Limited support for reference resolution of variables  
- Fixed issue causing code to incorrectly be interpreted as erroneous
- Improved indexing of types and variables
- Improved annotations for unresolved references

### Known Issues
- Imported variable references will often resolve to the incorrect definition
- Local variables declared after usage are not seen as errors

#### Note: This plugin is under active development (Q1 2025) and many features are missing or incomplete

This plugin was developed using the [IntelliJ Platform Plugin Template](https://github.com/JetBrains/intellij-platform-plugin-template)

