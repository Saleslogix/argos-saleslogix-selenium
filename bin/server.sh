#!/usr/bin/env bash

# exit immediately on non-zero commands
set -e

# debugging
set -x

CURRENT_DIR="$(dirname "${BASH_SOURCE[0]}")" # bin/server.sh
ROOT="$( cd $CURRENT_DIR && pwd)" # Absolute path to the directory that contains this script

java \
    -Dwebdriver.chrome.driver=$ROOT/drivers/OSX/chromedriver \
    -Dwebdriver.gecko.driver=$ROOT/drivers/OSX/geckodriver \
    -jar $ROOT/selenium-server-standalone-3.3.1.jar -role standalone