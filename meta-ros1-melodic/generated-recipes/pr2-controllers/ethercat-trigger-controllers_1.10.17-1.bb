# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Controllers to operate the digital output of the motor controller     boards and the projector board. This package has not been reviewed and     should be considered unstable."
AUTHOR = "ROS Orphaned Package Maintainers <ros-orphaned-packages@googlegroups.com>"
ROS_AUTHOR = "Blaise Gassend"
HOMEPAGE = "http://www.ros.org/wiki/ethercat_trigger_controllers"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "pr2_controllers"
ROS_BPN = "ethercat_trigger_controllers"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_libtool} \
    diagnostic-msgs \
    message-generation \
    pluginlib \
    pr2-controller-interface \
    realtime-tools \
    roscpp \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_libtool} \
    diagnostic-msgs \
    message-runtime \
    pluginlib \
    pr2-controller-interface \
    realtime-tools \
    roscpp \
    rospy \
    std-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_libtool} \
    diagnostic-msgs \
    message-runtime \
    pluginlib \
    pr2-controller-interface \
    realtime-tools \
    roscpp \
    rospy \
    std-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/pr2-gbp/pr2_controllers-release/archive/release/melodic/ethercat_trigger_controllers/1.10.17-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/ethercat_trigger_controllers"
SRC_URI = "git://github.com/pr2-gbp/pr2_controllers-release;${ROS_BRANCH};protocol=https"
SRCREV = "c45e0aae639557fb4a8e2fb9bdff37026da76cb1"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
