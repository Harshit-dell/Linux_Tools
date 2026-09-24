# Test_logging_learn

Small Linux-focused experiment: a CLI-style Java app that loads a path from `config.properties` and saves credentials (and/or opens an editor workflow) using that configured location.

## Folder structure
- `src/main/java/org/example/` — app code (Main, stores, models)
- `src/main/resources/config.properties` — config (e.g. `secret.file.path`)
- `bin/save` — bash wrapper to run the built jar as a CLI command
- `src/main/resources/` uses `secret.file.path` to determine where to write data

# How to run

- Just run Script  Credential_Save/bin/save
