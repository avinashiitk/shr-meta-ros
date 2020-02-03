# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_dashing
inherit ros_superflore_generated

DESCRIPTION = "A robot-agnostic teleoperation node to convert keyboard commands to Twist     messages."
AUTHOR = "Chris Lalancette <clalancette@openrobotics.org>"
ROS_AUTHOR = "Austin Hendrix <namniart@gmail.com>"
HOMEPAGE = "http://wiki.ros.org/teleop_twist_keyboard"
SECTION = "devel"
LICENSE = "BSD-2"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=1e0ab6366e5108a0da760802f538e6ed"

ROS_CN = "teleop_twist_keyboard"
ROS_BPN = "teleop_twist_keyboard"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = ""

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    geometry-msgs \
    rclpy \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    ament-copyright \
    ament-flake8 \
    ament-pep257 \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros2-gbp/teleop_twist_keyboard-release/archive/release/dashing/teleop_twist_keyboard/2.3.1-1.tar.gz
ROS_BRANCH ?= "branch=release/dashing/teleop_twist_keyboard"
SRC_URI = "git://github.com/ros2-gbp/teleop_twist_keyboard-release;${ROS_BRANCH};protocol=https"
SRCREV = "f10e46fb9164732898a38ab42f12dfa654034252"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_python"

inherit ros_${ROS_BUILD_TYPE}
