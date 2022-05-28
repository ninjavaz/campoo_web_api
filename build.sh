#!/bin/bash

APP_NAME=$(cat pom.xml | grep -oPm1 "(?<=<name>)[^<]+")
echo ${APP_NAME}


if [[ -z $1 ]]
then
  APP_VERSION=$(cat pom.xml | grep -oPm2 "(?<=<version>)[^<]+" | tail -1 | sed 's/-SNAPSHOT//' )
else
  APP_VERSION=$1
fi

docker build --network host -t campoo/${APP_NAME}:${APP_VERSION} .
