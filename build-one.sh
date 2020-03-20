#!/bin/bash

if [ $# -ne 1 ] ; then
    echo "Usage: $0 directory to build"
    exit
fi
ID=$1
shift
if [ ! -d $ID ] ; then
    echo "$ID is not a directory"
    exit
fi

export MCF_META_ROS_REPO_URL=git://github.com/shr-project/meta-ros.git
export MCF_META_ROS_WEBOS_REPO_URL=git://github.com/shr-project/meta-ros-webos.git

OE_DISTRO=`echo $ID | cut -d- -f1`
ROS_DISTRO=`echo $ID | cut -d- -f2`
OE_RELEASE=`echo $ID | cut -d- -f3`

case "${OE_DISTRO}" in
    ros1|ros2|webos)
        ;;
    *)
        echo "ERROR: unknown OE_DISTRO ${OE_DISTRO} in ID $ID"
        exit 1
        ;;
esac

case "${ROS_DISTRO}" in
    melodic|crystal|dashing|eloquent|foxy)
        ;;
    *)
        echo "ERROR: unknown ROS_DISTRO ${ROS_DISTRO} in ID $ID"
        exit 1
        ;;
esac

case "${OE_RELEASE}" in
    thud|warrior|zeus|dunfell|gatesgarth)
        ;;
    *)
        echo "ERROR: unknown OE_RELEASE ${OE_RELEASE} in ID $ID"
        exit 1
        ;;
esac

export MACHINES="raspberrypi4-64 qemux86-64"
[ "${OE_DISTRO}" = "webos" ] && MACHINES="raspberrypi4 qemux86"
#export MACHINES="raspberrypi4-64"
#[ "${OE_DISTRO}" = "webos" ] && MACHINES="raspberrypi4"
#export MACHINES="qemux86-64"
#[ "${OE_DISTRO}" = "webos" ] && MACHINES="qemux86"
[ "${OE_DISTRO}" != "webos" -a "${OE_RELEASE}" = "thud" ] && MACHINES="raspberrypi3-64 qemux86-64"

export IMAGES="core"
export IMAGES="world"
#[ "${ROS_DISTRO}" = "melodic" ] && IMAGES="turtlebot3-all"

export MACHINE

cd $ID
echo "Building ${ID} OE_DISTRO ${OE_DISTRO} ROS_DISTRO ${ROS_DISTRO} OE_RELEASE ${OE_RELEASE} MACHINES ${MACHINES} IMAGES ${IMAGES}"
. openembedded-core/oe-init-build-env
cd ..
../build/scripts/mcf -f ../build/files*/$ID.mcf --clean 2>&1 | tee -a log.mcf

for MACHINE in ${MACHINES}; do
    for I in ${IMAGES}; do
        IM="ros-image-${I}"
        echo $ID | grep -q ^webos && IM="webos-image-ros-${I}"
        bitbake -k $IM 2>&1 | tee -a log.$I.$MACHINE
    done
    bitbake -k world 2>&1 | tee log.world-all.$MACHINE
done
