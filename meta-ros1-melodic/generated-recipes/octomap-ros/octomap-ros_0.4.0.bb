# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "octomap_ros provides conversion functions between ROS and OctoMap's native types.     This enables a convenvient use of the octomap package in ROS."
AUTHOR = "Armin Hornung <HornungA@informatik.uni-freiburg.de>"
ROS_AUTHOR = "Armin Hornung <HornungA@informatik.uni-freiburg.de>"
HOMEPAGE = "http://ros.org/wiki/octomap_ros"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "octomap_ros"
ROS_BPN = "octomap_ros"

ROS_BUILD_DEPENDS = " \
    catkin \
    octomap \
    octomap-msgs \
    sensor-msgs \
    tf \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    octomap \
    octomap-msgs \
    sensor-msgs \
    tf \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    octomap \
    octomap-msgs \
    sensor-msgs \
    tf \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/octomap_ros-release/archive/release/melodic/octomap_ros/0.4.0-0.tar.gz
ROS_BRANCH ?= "branch=release/melodic/octomap_ros"
SRC_URI = "git://github.com/ros-gbp/octomap_ros-release;${ROS_BRANCH};protocol=https"
SRCREV = "1263fa11926ea21a574bdca7e7d1ae0a59134dca"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
