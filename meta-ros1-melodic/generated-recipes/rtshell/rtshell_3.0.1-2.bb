# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "<p>Shell commands for managing RT-Middleware running on OpenRTM-aist.</p>"
AUTHOR = "Kei Okada <k-okada@jsk.t.u-tokyo.ac.jp>"
ROS_AUTHOR = "Geoffrey Biggs <git@killbots.net>"
HOMEPAGE = "http://ros.org/wiki/openrtm_tools"
SECTION = "devel"
LICENSE = "EPL"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=b1456987590b6d6fb15d36f398651b8b"

ROS_CN = "rtshell"
ROS_BPN = "rtshell"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_python-omniorb} \
    python-setuptools \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    rtctree \
    rtsprofile \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    rtctree \
    rtsprofile \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/tork-a/rtshell-release/archive/release/melodic/rtshell/3.0.1-2.tar.gz
ROS_BRANCH ?= "branch=release/melodic/rtshell"
SRC_URI = "git://github.com/tork-a/rtshell-release;${ROS_BRANCH};protocol=https"
SRCREV = "97c8d4bb1d0ac6af58e2cbef446e84efe915a37d"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "cmake"

inherit ros_${ROS_BUILD_TYPE}
