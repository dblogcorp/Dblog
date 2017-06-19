#!/bin/bash
set -eo pipefail

cd ./$1
mkdir -p src/{main,test}/{java,resources}
echo "SUCCESS"
