from __future__ import annotations

import argparse
import json
import logging
import platform
from datetime import datetime
from pathlib import Path
from typing import Sequence, Tuple

DEFAULT_LAYOUT: tuple[str, ...] = (
    "artifacts",
    "artifacts/screenshots",
    "artifacts/videos",
    "logs",
    "reports",
    "reports/allure",
    "temp",
    "config",
)

LOG_LEVELS = ("DEBUG", "INFO", "WARNING", "ERROR", "CRITICAL")


def parse_arguments(argv: Sequence[str] | None = None) -> argparse.Namespace:
    parser = argparse.ArgumentParser(
        prog="project_setup",
        description="Prepare directory scaffolding and metadata for Testing_Project automation.",
    )
    parser.add_argument(
        "-t",
        "--target",
        default=".",
        help="Root directory that should host the project layout.",
    )
    parser.add_argument(
        "--dry-run",
        action="store_true",
        help="Report the directories that would be created without writing anything.",
    )
    parser.add_argument(
        "--layout",
        nargs="*",
        metavar="DIR",
        help="Override the default directory layout (provide relative paths).",
    )
    parser.add_argument(
        "--log-level",
        default="INFO",
        choices=LOG_LEVELS,
        help="Set the logging level for this run.",
    )
    return parser.parse_args(argv)


def configure_logging(level: str) -> None:
    numeric_level = getattr(logging, level.upper(), logging.INFO)
    logging.basicConfig(
        level=numeric_level,
        format="PROJECT SETUP - %(levelname)s - %(message)s",
    )


def ensure_directories(
    base: Path, layout: Sequence[str], dry_run: bool
) -> list[Tuple[Path, bool]]:
    results: list[Tuple[Path, bool]] = []
    for relative_path in layout:
        target_path = base / relative_path
        already_exists = target_path.exists()
        results.append((target_path, already_exists))
        if not dry_run:
            target_path.mkdir(parents=True, exist_ok=True)
    return results


def write_metadata(
    base: Path,
    actions: Sequence[Tuple[Path, bool]],
    layout: Sequence[str],
    dry_run: bool,
) -> Path:
    metadata_path = base / "project_setup_status.json"
    if dry_run:
        logging.debug("Dry run enabled; metadata file would be created at %s", metadata_path)
        return metadata_path
    payload = {
        "created_at": datetime.utcnow().isoformat() + "Z",
        "platform": platform.platform(),
        "target": str(base),
        "layout": list(layout),
        "directories": [
            {
                "path": str(path.relative_to(base)),
                "already_existed": existed,
            }
            for path, existed in actions
        ],
    }
    metadata_path.write_text(json.dumps(payload, indent=2))
    return metadata_path


def display_summary(
    base: Path,
    actions: Sequence[Tuple[Path, bool]],
    metadata_path: Path,
    dry_run: bool,
) -> None:
    total = len(actions)
    pending = [path for path, existed in actions if not existed]
    status = "Dry run" if dry_run else "Completed"
    logging.info("%s project setup for %s", status, base)
    logging.info("Verified %d directories (%d require creation).", total, len(pending))
    if pending:
        verb = "Would create" if dry_run else "Created"
        logging.info(
            "%s:\n%s",
            verb,
            "\n".join(f" - {path.relative_to(base)}" for path in pending),
        )
    suffix = "would be generated" if dry_run else "has been written"
    logging.info("Metadata %s at %s", suffix, metadata_path)


def setup_project(
    target: Path | str | None = None,
    layout: Sequence[str] | None = None,
    dry_run: bool = False,
) -> Tuple[Path, list[Tuple[Path, bool]], Path]:
    base = Path(target or ".").expanduser().resolve()
    base.mkdir(parents=True, exist_ok=True)
    resolved_layout: Sequence[str] = tuple(layout) if layout else DEFAULT_LAYOUT
    actions = ensure_directories(base, resolved_layout, dry_run)
    metadata_path = write_metadata(base, actions, resolved_layout, dry_run)
    return base, actions, metadata_path


def main(argv: Sequence[str] | None = None) -> None:
    args = parse_arguments(argv)
    configure_logging(args.log_level)
    base, actions, metadata_path = setup_project(
        target=args.target,
        layout=args.layout,
        dry_run=args.dry_run,
    )
    display_summary(base, actions, metadata_path, args.dry_run)


if __name__ == "__main__":
    main()
