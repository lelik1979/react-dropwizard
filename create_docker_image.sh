#!/bin/bash

#CHANGE VERSION to what you need.
ARTIFACT_VERSION=0.0.1
ARTIFACT_NAME=dropwizard-react-server-$ARTIFACT_VERSION.jar

ARTIFACT=dropwizard-react-server/target/$ARTIFACT_NAME
if [ ! -f "$ARTIFACT" ]; then
    echo "Artifact $ARTIFACT doesn't exist";
    exit 1;
fi

DOCKER_CONTEXT_DIRECTORY=docker;

if [ ! -d "$DOCKER_CONTEXT_DIRECTORY" ]; then
    echo "Docker context directory $DOCKER_CONTEXT_DIRECTORY doesn't exist";
    exit 1;
fi

cp $ARTIFACT $DOCKER_CONTEXT_DIRECTORY/$ARTIFACT_NAME

docker build -f $DOCKER_CONTEXT_DIRECTORY/Dockerfile \
            --build-arg ARTIFACT=$ARTIFACT_NAME \
            -t lelik/dropwizard-react:$ARTIFACT_VERSION \
            $DOCKER_CONTEXT_DIRECTORY
