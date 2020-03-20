#!/bin/bash

if [ $# -ne 1 ] ; then
    echo "Usage: $0 directory to build"
    exit
fi
ID=`basename $1`
shift

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

export MACHINES="raspberrypi4-64 qemux86-64" # consider adding raspberrypi4 qemux86 qemuarm qemuarm64"
[ "${OE_DISTRO}" = "webos" ] && MACHINES="raspberrypi4 qemux86"
[ "${OE_DISTRO}" != "webos" -a "${OE_RELEASE}" = "thud" ] && MACHINES="raspberrypi3-64 qemux86-64"

export IMAGES="core world"
#[ "${ROS_DISTRO}" = "melodic" ] && IMAGES="turtlebot3-all"

export MACHINE

echo "Building ${ID} OE_DISTRO ${OE_DISTRO} ROS_DISTRO ${ROS_DISTRO} OE_RELEASE ${OE_RELEASE} MACHINES ${MACHINES} IMAGES ${IMAGES}"
[ -d ${ID} ] || mkdir ${ID}
cd ${ID}

[ -d conf ] || mkdir conf
[ -d build ] || mkdir build
ln -snf ../conf build/conf
rm -f log.mcf

if [ ! -e openembedded-core/oe-init-build-env ] ; then
    ../build/scripts/mcf -f ../build/files*/$ID.mcf --clean 2>&1 | tee -a log.mcf
fi
if [ ! -e openembedded-core/oe-init-build-env ] ; then
    echo "ERROR: `pwd`/openembedded-core/oe-init-build-env doesn't exist, did the mcf update fail?"
    exit 1
fi

. openembedded-core/oe-init-build-env
cd ..

../build/scripts/mcf -f ../build/files*/$ID.mcf --clean 2>&1 | tee -a log.mcf

echo "Create or re-create local.conf"
cp openembedded-core/meta/conf/local.conf.sample conf/local.conf
# Add local.conf additions from https://github.com/ros/meta-ros/wiki/OpenEmbedded-Build-Instructions
# with some modifications to ROS_COMMON_ARTIFACTS, TCLIBCAPPEND, BB_NUMBER_THREADS, PARALLEL_AMEK

ARTIFACTS_DIR="/mnt/mirror-write-ros/jansa/webos"
ARTIFACTS_SSTATE_DIR="ros-${OE_RELEASE}/sstate-cache"
[ "${OE_DISTRO}" = "webos" ] && ARTIFACTS_SSTATE_DIR="ose-${OE_RELEASE}/sstate-cache"

cat >> conf/local.conf << EOF
# ROS-ADDITIONS-BEGIN
# ^^^^^^^^^^^^^^^^^^^ In the future, tools will expect to find this line.

# Increment the minor version whenever you add or change a setting in this file.
ROS_LOCAL_CONF_SETTINGS_VERSION = "2.1"

# If not using mcf, replace \${MCF_DISTRO} with the DISTRO being used.
DISTRO = "\${MCF_DISTRO}"

# If not using mcf, set ROS_DISTRO in conf/bblayers.conf .

# The list of supported values of MACHINE is found in the Machines[] array in the .mcf file for the selected configuration.
# Use ?= so that a value set in the environment will override the one set here.
#MACHINE ?= "<SUPPORTED-MACHINE>"

# Can remove if DISTRO is "webos". If not using mcf, replace \${MCF_OPENEMBEDDED_VERSION} with the version of OpenEmbedded
# being used. See the comments in files/ros*.mcf for its format.
ROS_DISTRO_VERSION_APPEND = "+\${MCF_OPENEMBEDDED_VERSION}"

# Can remove if DISTRO is not "webos". If not using mcf, replace \${MCF_WEBOS_BUILD_NUMBER} with the build number of webOS OSE
# being used.
ROS_WEBOS_DISTRO_VERSION_APPEND = ".\${MCF_WEBOS_BUILD_NUMBER}"

# If not using mcf, replace \${MCF_OE_RELEASE_SERIES} with the OpenEmbedded release series being used.
ROS_OE_RELEASE_SERIES_SUFFIX = "-\${MCF_OE_RELEASE_SERIES}"

# Because of a bug in OpenEmbedded, <ABSOLUTE-PATH-TO-DIRECTORY-ON-SEPARATE-DISK> can not be a symlink.
#ROS_COMMON_ARTIFACTS = "<ABSOLUTE-PATH-TO-DIRECTORY-ON-SEPARATE-DISK>"

# Set the directories where downloads, shared-state, and the output from the build are placed to be on the separate disk.
#DL_DIR = "\${ROS_COMMON_ARTIFACTS}/downloads"
DL_DIR = "${ARTIFACTS_DIR}/downloads"
#SSTATE_DIR = "\${ROS_COMMON_ARTIFACTS}/sstate-cache\${ROS_OE_RELEASE_SERIES_SUFFIX}"
SSTATE_DIR = "${ARTIFACTS_DIR}/${ARTIFACTS_SSTATE_DIR}"
#TMPDIR = "\${ROS_COMMON_ARTIFACTS}/BUILD-\${DISTRO}-\${ROS_DISTRO}\${ROS_OE_RELEASE_SERIES_SUFFIX}"
# Don't add the libc variant suffix to TMPDIR.
#TCLIBCAPPEND := ""

# As recommended by https://www.yoctoproject.org/docs/latest/mega-manual/mega-manual.html#var-BB_NUMBER_THREADS
# and https://www.yoctoproject.org/docs/latest/mega-manual/mega-manual.html#var-PARALLEL_MAKE:
#BB_NUMBER_THREADS = "\${@min(int(bb.utils.cpu_count()), 20)}"
BB_NUMBER_THREADS = "6"
#PARALLEL_MAKE = "-j \${BB_NUMBER_THREADS}"

# Reduce the size of the build artifacts by removing the working files under TMPDIR/work. Comment this out to preserve them
# (see https://www.yoctoproject.org/docs/latest/mega-manual/mega-manual.html#ref-classes-rm-work).
INHERIT += "rm_work"


# Any other additions to the file go here.

# EXTRA_IMAGE_FEATURES is just one of the many settings that can be placed in this file. You can find them all by searching
# https://www.yoctoproject.org/docs/latest/mega-manual/mega-manual.html#ref-variables-glossary for "local.conf".

# Uncomment to allow "root" to ssh into the device. Not needed for images with webOS OSE because it implicitly adds this
# feature.
# EXTRA_IMAGE_FEATURES += "ssh-server-dropbear"

# Uncomment to include the package management utilities in the image ("opkg", by default). Not needed for images with
# webOS OSE because it implicitly adds this feature.
# EXTRA_IMAGE_FEATURES += "package-management"

# Uncomment to have all interactive shells implicitly source "setup.sh" (ROS 1) or "ros_setup.sh" (ROS 2).
# EXTRA_IMAGE_FEATURES += "ros-implicit-workspace"

# Uncomment to display additional useful variables in the build configuration output.
# require conf/distro/include/ros-useful-buildcfg-vars.inc

# vvvvvvvvvvvvvvvvv In the future, tools will expect to find this line.
# ROS-ADDITIONS-END

#IMAGE_FSTYPES_forcevariable = "tar.gz"
WEBOS_DISTRO_BUILD_ID = "0"
EOF

if [ "${OE_DISTRO}" != "webos" -o "${OE_RELEASE}" = "thud" ] ; then
  # before PLAT-102385 CCC: Various webos.inc fixes and cleanups
  # is public on github
  cat >> conf/local.conf << EOF
require conf/distro/include/yocto-uninative.inc
INHERIT += "uninative"
EOF
fi

cat >> conf/local.conf << EOF
# To make DL_DIR usable for others as PREMIRROR
BB_GENERATE_MIRROR_TARBALLS = "1"
EOF

if [ "${OE_DISTRO}" != "webos" ] ; then
  # These are already enabled in default webOS builds
  cat >> conf/local.conf << EOF
INHERIT += "buildstats"
INHERIT += "buildstats-summary"
INHERIT += "buildhistory"
INHERIT += "image-buildinfo"
EOF
fi

echo "Using SSTATE_DIR: `grep ^SSTATE_DIR conf/local.conf`"
echo "Using DL_DIR: `grep ^DL_DIR conf/local.conf`"

echo "Deleting the TMPDIR"
rm -rf tmp-glibc

declare -i RESULT=0

for MACHINE in ${MACHINES}; do
    for I in ${IMAGES}; do
        IM="ros-image-${I}"	
        echo $ID | grep -q ^webos && IM="webos-image-ros-${I}"
        bitbake -k $IM 2>&1 | tee log.$I.$MACHINE
	RESULT+=${PIPESTATUS[0]}
    done
    bitbake -k world 2>&1 | tee log.world-all.$MACHINE
    RESULT+=${PIPESTATUS[0]}
done

echo "Storing the deploy/images dir on fileserver"
mkdir -p /mnt/mirror-write-artifacts/${JOB_NAME}/${BUILD_NUMBER}
rsync -r tmp-glibc/deploy/images /mnt/mirror-write-artifacts/${JOB_NAME}/${BUILD_NUMBER}

echo "Deleting the TMPDIR"
rm -rf tmp-glibc

echo "WARNING messages:"
grep ^WARNING: log.*

echo "ERROR messages:"
grep -i "error[: ]" log.*

exit ${RESULT}
