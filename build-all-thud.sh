#!/bin/bash

export MCFFILES="build/files*/*thud.mcf"

for i in ${MCFFILES}; do
    ID=`basename ${i/.mcf/}`
    ./build-one.sh $ID
done
