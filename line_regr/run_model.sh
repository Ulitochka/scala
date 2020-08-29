#!/usr/bin/env bash
set -e

SCRIPT=$(readlink -f "$0")
SCRIPT_PATH=$(dirname "$SCRIPT")
PIPELINE_PATH=$(realpath "${SCRIPT_PATH}"/)
cd "${PIPELINE_PATH}"/

sbt "run analitic"
sbt "run grad"
