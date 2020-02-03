# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Position feedback controller for simple linear motion of the fetch robot's end-effector."
AUTHOR = "David Kent <dekent@gatech.edu>"
ROS_AUTHOR = "David Kent <dekent@gatech.edu>"
HOMEPAGE = "http://ros.org/wiki/fetch_simple_linear_controller"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "fetch_simple_linear_controller"
ROS_BPN = "fetch_simple_linear_controller"

ROS_BUILD_DEPENDS = " \
    actionlib \
    control-msgs \
    geometry-msgs \
    message-generation \
    roscpp \
    sensor-msgs \
    tf2 \
    tf2-geometry-msgs \
    tf2-ros \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib \
    control-msgs \
    geometry-msgs \
    message-runtime \
    roscpp \
    sensor-msgs \
    tf2 \
    tf2-geometry-msgs \
    tf2-ros \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib \
    control-msgs \
    geometry-msgs \
    message-runtime \
    roscpp \
    sensor-msgs \
    tf2 \
    tf2-geometry-msgs \
    tf2-ros \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/gt-rail-release/fetch_simple_linear_controller-release/archive/release/melodic/fetch_simple_linear_controller/0.0.1-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/fetch_simple_linear_controller"
SRC_URI = "git://github.com/gt-rail-release/fetch_simple_linear_controller-release;${ROS_BRANCH};protocol=https"
SRCREV = "9ae168a3bac8682feee0ca0ad2e04645f1f613c6"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
