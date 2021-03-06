# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Outputs audio to a speaker from a source node."
AUTHOR = "Austin Hendrix <namniart@gmail.com>"
ROS_AUTHOR = "Nate Koenig"
HOMEPAGE = "http://ros.org/wiki/audio_play"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=a3ae2ba3f0f44e61270955e8cd98afcf"

ROS_CN = "audio_common"
ROS_BPN = "audio_play"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_libgstreamer-plugins-base1.0-dev} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_libgstreamer1.0-dev} \
    audio-common-msgs \
    roscpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_gstreamer1.0-plugins-base} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_gstreamer1.0-plugins-good} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_gstreamer1.0-plugins-ugly} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_gstreamer1.0} \
    audio-common-msgs \
    roscpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_gstreamer1.0-plugins-base} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_gstreamer1.0-plugins-good} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_gstreamer1.0-plugins-ugly} \
    ${ROS_UNRESOLVED_PLATFORM_PKG_gstreamer1.0} \
    audio-common-msgs \
    roscpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/audio_common-release/archive/release/melodic/audio_play/0.3.3-0.tar.gz
ROS_BRANCH ?= "branch=release/melodic/audio_play"
SRC_URI = "git://github.com/ros-gbp/audio_common-release;${ROS_BRANCH};protocol=https"
SRCREV = "89b09b877007e5d2c2be6ff3196e4b96196ae366"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
