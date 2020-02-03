# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Locomotor is an extensible path planning coordination engine that replaces move_base. The goal is to provide a mechanism for controlling what happens when the global and local planners succeed and fail. It leverages ROS callback queues to coordinate multiple threads."
AUTHOR = "David V. Lu!! <davidvlu@gmail.com>"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "robot_navigation"
ROS_BPN = "locomotor"

ROS_BUILD_DEPENDS = " \
    actionlib \
    geometry-msgs \
    locomotor-msgs \
    nav-2d-msgs \
    nav-2d-utils \
    nav-core2 \
    nav-msgs \
    pluginlib \
    roscpp \
    rospy \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib \
    geometry-msgs \
    locomotor-msgs \
    nav-2d-msgs \
    nav-2d-utils \
    nav-core2 \
    nav-msgs \
    pluginlib \
    roscpp \
    rospy \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib \
    geometry-msgs \
    locomotor-msgs \
    nav-2d-msgs \
    nav-2d-utils \
    nav-core2 \
    nav-msgs \
    pluginlib \
    roscpp \
    rospy \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    roslint \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/DLu/robot_navigation-release/archive/release/melodic/locomotor/0.2.5-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/locomotor"
SRC_URI = "git://github.com/DLu/robot_navigation-release;${ROS_BRANCH};protocol=https"
SRCREV = "4d363a7130469adafc65745a426327c58f9d0e69"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
