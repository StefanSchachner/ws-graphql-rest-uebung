#!/bin/bash
set -e

DIR="./db"
if [ -d "$DIR" ]; then
  echo "${DIR} already exists, the installation has exited ..."
  exit 1
fi
echo "Installing h2-database in ${DIR} ..."
mkdir db
cd db
curl -L https://repo1.maven.org/maven2/com/h2database/h2/2.4.240/h2-2.4.240.jar -o h2.jar

ls -l
#unzip derbydb.zip
