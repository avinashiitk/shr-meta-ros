# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "plugins for filtering trajectories."
AUTHOR = "F-ROSROBO <F-ROSROBO@fsi.co.jp>"
ROS_AUTHOR = "F-ROSROBO <F-ROSROBO@fsi.co.jp>"
HOMEPAGE = "http://wiki.ros.org/fsrobo_r_trajectory_filters"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "fsrobo_r"
ROS_BPN = "fsrobo_r_trajectory_filters"

ROS_BUILD_DEPENDS = " \
    moveit-core \
    moveit-ros-planning \
    orocos-kdl \
    pluginlib \
    trajectory-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    moveit-core \
    moveit-ros-planning \
    orocos-kdl \
    pluginlib \
    trajectory-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    moveit-core \
    moveit-ros-planning \
    orocos-kdl \
    pluginlib \
    trajectory-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/FUJISOFT-Robotics/fsrobo_r-release/archive/release/melodic/fsrobo_r_trajectory_filters/0.7.1-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/fsrobo_r_trajectory_filters"
SRC_URI = "git://github.com/FUJISOFT-Robotics/fsrobo_r-release;${ROS_BRANCH};protocol=https"
SRCREV = "9f54a0a01429a04e2b2836cda5700a1865e87df8"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
