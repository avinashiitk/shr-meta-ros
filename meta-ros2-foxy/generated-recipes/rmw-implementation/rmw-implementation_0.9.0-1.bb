# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_foxy
inherit ros_superflore_generated

DESCRIPTION = "The decision which ROS middleware implementation should be used for C++."
AUTHOR = "Dirk Thomas <dthomas@osrfoundation.org>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "rmw_implementation"
ROS_BPN = "rmw_implementation"

ROS_BUILD_DEPENDS = " \
    rcpputils \
    rcutils \
    rmw \
    rmw-connext-cpp \
    rmw-fastrtps-cpp \
    rmw-implementation-cmake \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    rmw-implementation-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    rcpputils \
    rcutils \
    rmw-implementation-cmake \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    rcpputils \
    rcutils \
    rmw-implementation-cmake \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/rmw_implementation-release/archive/release/foxy/rmw_implementation/0.9.0-1.tar.gz
ROS_BRANCH ?= "branch=release/foxy/rmw_implementation"
SRC_URI = "git://github.com/ros2-gbp/rmw_implementation-release;${ROS_BRANCH};protocol=https"
SRCREV = "7043898b00e7d19751910daf3e21590a4073d665"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
