# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "This package implements the Care-O-bot mimic"
AUTHOR = "Felix Messmer <felixmessmer@gmail.com>"
ROS_AUTHOR = "Nadia Hammoudeh Garcia <nhg@ipa.fhg.de>"
HOMEPAGE = "http://ros.org/wiki/cob_mimic"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=6;endline=6;md5=3dce4ba60d7e51ec64f3c3dc18672dd3"

ROS_CN = "cob_driver"
ROS_BPN = "cob_mimic"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_libvlc-dev} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_vlc} \
    actionlib \
    actionlib-msgs \
    boost \
    diagnostic-msgs \
    diagnostic-updater \
    message-generation \
    roscpp \
    roslib \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_libvlc-dev} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_vlc} \
    actionlib \
    actionlib-msgs \
    boost \
    diagnostic-msgs \
    diagnostic-updater \
    roscpp \
    roslib \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_libvlc-dev} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_vlc} \
    actionlib \
    actionlib-msgs \
    boost \
    diagnostic-msgs \
    diagnostic-updater \
    message-runtime \
    roscpp \
    roslib \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ipa320/cob_driver-release/archive/release/melodic/cob_mimic/0.7.1-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/cob_mimic"
SRC_URI = "git://github.com/ipa320/cob_driver-release;${ROS_BRANCH};protocol=https"
SRCREV = "9516c11f64719ef6848fc2cf629e5657f7fa0ebb"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
