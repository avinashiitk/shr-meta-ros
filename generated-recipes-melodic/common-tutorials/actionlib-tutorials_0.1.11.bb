# Generated by superflore -- DO NOT EDIT
#
# Copyright 2019 Open Source Robotics Foundation

inherit ros_distro_${ROS_DISTRO}
inherit ros_superflore_generated

DESCRIPTION = "The actionlib_tutorials package"
AUTHOR = "Daniel Stonier <d.stonier@gmail.com>"
ROS_AUTHOR = "Melonee Wise"
HOMEPAGE = "http://www.ros.org/wiki/actionlib/Tutorials"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "common_tutorials"
ROS_BPN = "actionlib_tutorials"

ROS_BUILD_DEPENDS = " \
    actionlib \
    actionlib-msgs \
    message-generation \
    roscpp \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    actionlib \
    message-runtime \
    roscpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    actionlib \
    message-runtime \
    roscpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "https://github.com/ros-gbp/common_tutorials-release/archive/release/melodic/actionlib_tutorials/0.1.11-0.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "8dfebaaa39515873ea0abab78178897d"
SRC_URI[sha256sum] = "202b1bd5a2d7cde96dcd20fa54fb6fc017ec6e1252575b5413618310c536163e"
S = "${WORKDIR}/common_tutorials-release-release-melodic-actionlib_tutorials-0.1.11-0"

ROS_COMPONENT_TYPE = "${@ros_distro__get_component_type('common-tutorials', d)}"
ROS_BUILD_TYPE = "catkin"

# Allow the above settings to be overridden.
ROS_INCLUDES_TREE := "${@ros_superflore_generated__get_includes_tree('common-tutorials', d)}"
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/common-tutorials/common-tutorials_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/common-tutorials/common-tutorials-${PV}_common.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/common-tutorials/${BPN}.inc
include ${ROS_LAYERDIR}/${ROS_INCLUDES_TREE}/common-tutorials/${BPN}-${PV}.inc

inherit ${ROS_COMPONENT_TYPE}_component
inherit ros_${ROS_BUILD_TYPE}
