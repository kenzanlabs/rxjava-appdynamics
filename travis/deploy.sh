#!/usr/bin/env bash
COMMIT_MSG=`git show $TRAVIS_COMMIT --quiet --pretty=format:%s`
COMMIT_MSG_UPPER=`echo $COMMIT_MSG | awk '{print toupper($0)}'`
if [[ $COMMIT_MSG_UPPER == RELEASE:* ]]; then
    RELEASE_VERSION=`expr "$COMMIT_MSG_UPPER" : '.*RELEASEVERSION=\(.*\)[[:space:]]'`
    DEVELOPMENT_VERSION=`expr "$COMMIT_MSG_UPPER" : '.*DEVELOPMENTVERSION=\(.*\)$'`
    if [ -z $RELEASE_VERSION ]; then
        RELEASE_VERSION=`expr "$COMMIT_MSG_UPPER" : '.*RELEASEVERSION=\(.*\)$'`
        DEVELOPMENT_VERSION=`expr "$COMMIT_MSG_UPPER" : '.*DEVELOPMENTVERSION=\(.*\)[[:space:]]'`
    fi

    if [ -z $RELEASE_VERSION ] || [ -z $DEVELOPMENT_VERSION ]; then
        echo "releaseVersion or developmentVersion not specified in commit msg"
        echo "example: RELEASE: releaseVersion=0.0.1 developmentVersion=0.0.2-SNAPSHOT"
        exit 1
    fi

    mvn verify -P sign,build-extras --settings travis/settings.xml
    mvn release:clean release:prepare -DreleaseVersion=$RELEASE_VERSION -Dtag=$RELEASE_VERSION -DdevelopmentVersion=$DEVELOPMENT_VERSION
    mvn release:perform
elif [ "$TRAVIS_BRANCH" = 'master' ] && [ "$TRAVIS_PULL_REQUEST" == 'false' ]; then
    mvn deploy -P sign,build-extras --settings travis/settings.xml
fi
