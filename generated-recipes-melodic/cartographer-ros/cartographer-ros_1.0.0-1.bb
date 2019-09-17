# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "Cartographer is a system that provides real-time simultaneous localization     and mapping (SLAM) in 2D and 3D across multiple platforms and sensor     configurations. This package provides Cartographer's ROS integration."
AUTHOR = "The Cartographer Authors <cartographer-owners@googlegroups.com>"
ROS_AUTHOR = "The Cartographer Authors <google-cartographer@googlegroups.com>"
HOMEPAGE = "https://github.com/googlecartographer/cartographer_ros"
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=b73cebba72f83c5afebf178817283e37"

ROS_CN = "cartographer_ros"
ROS_BPN = "cartographer_ros"

ROS_BUILD_DEPENDS = " \
    cartographer \
    cartographer-ros-msgs \
    eigen-conversions \
    geometry-msgs \
    gflags \
    glog \
    gtest \
    message-runtime \
    nav-msgs \
    pcl \
    pcl-conversions \
    protobuf \
    python-sphinx \
    robot-state-publisher \
    rosbag \
    roscpp \
    roslaunch \
    roslib \
    sensor-msgs \
    std-msgs \
    tf2 \
    tf2-eigen \
    tf2-ros \
    urdf \
    visualization-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    cartographer \
    cartographer-ros-msgs \
    eigen-conversions \
    geometry-msgs \
    gflags \
    glog \
    message-runtime \
    nav-msgs \
    pcl \
    pcl-conversions \
    robot-state-publisher \
    rosbag \
    roscpp \
    roslaunch \
    roslib \
    sensor-msgs \
    std-msgs \
    tf2 \
    tf2-eigen \
    tf2-ros \
    urdf \
    visualization-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    cartographer \
    cartographer-ros-msgs \
    eigen-conversions \
    geometry-msgs \
    gflags \
    glog \
    message-runtime \
    nav-msgs \
    pcl \
    pcl-conversions \
    robot-state-publisher \
    rosbag \
    roscpp \
    roslaunch \
    roslib \
    sensor-msgs \
    std-msgs \
    tf2 \
    tf2-eigen \
    tf2-ros \
    urdf \
    visualization-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    rosunit \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros-gbp/cartographer_ros-release/archive/release/melodic/cartographer_ros/1.0.0-1.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "6e69b660ead435438058e3ef823e213d"
SRC_URI[sha256sum] = "9e734459067f4d18a9458ad47b0b647c937521e650865a9d68380d4adca57c3b"
S = "${WORKDIR}/cartographer_ros-release-release-melodic-cartographer_ros-1.0.0-1"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('cartographer-ros', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('cartographer-ros', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/cartographer-ros/cartographer-ros_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/cartographer-ros/cartographer-ros-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/cartographer-ros/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/cartographer-ros/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
