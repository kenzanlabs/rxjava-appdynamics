#!/usr/bin/env bash
if [ "$TRAVIS_BRANCH" = 'master' ] && [ "$TRAVIS_PULL_REQUEST" == 'false' ]; then
    openssl aes-256-cbc -K $encrypted_34b5aec44fbc_key -iv $encrypted_34b5aec44fbc_iv -in codesigning.asc.enc -out codesigning.asc -d
    gpg --fast-import travis/codesigning.asc
fi
