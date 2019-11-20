# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_crystal
inherit ros_superflore_generated

DESCRIPTION = "C API providing common interface to a shared library wrapping 3rd party loggers."
AUTHOR = "Amazon B9 <amazon-b9-ros@amazon.com>"
ROS_AUTHOR = "Nick Burek <amazon-b9-ros@amazon.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=12c26a18c7f493fdc7e8a93b16b7c04f"

ROS_CN = "rcl_logging"
ROS_BPN = "rcl_logging_log4cxx"

ROS_BUILD_DEPENDS = " \
    log4cxx \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-ros-native \
    python3-empy-native \
"

ROS_EXPORT_DEPENDS = " \
    log4cxx \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    log4cxx \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-cmake-gmock \
    ament-cmake-gtest \
    ament-cmake-pytest \
    ament-lint-auto \
    ament-lint-common \
    launch-testing \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/rcl_logging-release/archive/release/crystal/rcl_logging_log4cxx/0.2.0-0.tar.gz
ROS_BRANCH ?= "branch=release/crystal/rcl_logging_log4cxx"
SRC_URI = "git://github.com/ros2-gbp/rcl_logging-release;${ROS_BRANCH};protocol=https"
SRCREV = "ba4b689c1d95499406cfcb492a1469f7acf134ad"
S = "${WORKDIR}/git"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('rcl-logging', d)}"
ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
