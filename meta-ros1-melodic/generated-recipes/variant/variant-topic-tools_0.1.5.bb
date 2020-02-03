# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Topic tools for treating messages as variant types."
AUTHOR = "Ralf Kaestner <ralf.kaestner@gmail.com>"
ROS_AUTHOR = "Ralf Kaestner"
HOMEPAGE = "http://github.com/ethz-asl/ros-topic-variant"
SECTION = "devel"
LICENSE = "LGPL-2"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=146ba316845cfe6058c8baebd902a726"

ROS_CN = "variant"
ROS_BPN = "variant_topic_tools"

ROS_BUILD_DEPENDS = " \
    roscpp \
    roslib \
    variant-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    roscpp \
    roslib \
    variant-msgs \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    roscpp \
    roslib \
    variant-msgs \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/anybotics/variant-release/archive/release/melodic/variant_topic_tools/0.1.5-0.tar.gz
ROS_BRANCH ?= "branch=release/melodic/variant_topic_tools"
SRC_URI = "git://github.com/anybotics/variant-release;${ROS_BRANCH};protocol=https"
SRCREV = "c341df3f58f717d3bd58c5e757e8a7aa36a68bc1"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
