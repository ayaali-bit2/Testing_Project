# Python Setup Helper

The Python setup helper ensures that the directory structure and metadata expected by the Testing_Project automation workflows are available.

## Usage

1. Enter the helper directory:
   ```bash
   cd python
   ```
2. Run the helper to initialize the default layout inside the current repository:
   ```bash
   python -m project_setup --target ..
   ```
3. Preview the changes without writing files:
   ```bash
   python -m project_setup --target .. --dry-run
   ```
4. Customize the layout by supplying explicit relative paths:
   ```bash
   python -m project_setup --target .. --layout artifacts assets/config
   ```
5. Adjust the logging level for troubleshooting:
   ```bash
   python -m project_setup --target .. --log-level DEBUG
   ```

## Generated layout

By default, the helper ensures the following directories exist under the provided target:

- `artifacts`
- `artifacts/screenshots`
- `artifacts/videos`
- `logs`
- `reports`
- `reports/allure`
- `temp`
- `config`

## Metadata

Each run writes (or reports) a `project_setup_status.json` file at the target location. The JSON file records the directories inspected, when the helper ran, and platform information so future tooling can validate that the layout was provisioned.
