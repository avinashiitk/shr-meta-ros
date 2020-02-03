# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_dashing
inherit ros_superflore_generated

DESCRIPTION = "Foonathan/memory vendor package for Fast-RTPS."
AUTHOR = "Miguel Company <miguelcompany@eprosima.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0 & zlib-License"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=401a7342a877608092ef332b6948eb03"

ROS_CN = "foonathan_memory_vendor"
ROS_BPN = "foonathan_memory_vendor"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    cmake-native \
    git-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = " \
    cmake-native \
"

ROS_EXEC_DEPENDS = ""

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/foonathan_memory_vendor-release/archive/release/dashing/foonathan_memory_vendor/0.3.0-1.tar.gz
ROS_BRANCH ?= "branch=release/dashing/foonathan_memory_vendor"
SRC_URI = "git://github.com/ros2-gbp/foonathan_memory_vendor-release;${ROS_BRANCH};protocol=https"
SRCREV = "885c0f609a3b23abc948ada6cb0e7180c1c7bd0e"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "cmake"

inherit ros_${ROS_BUILD_TYPE}
