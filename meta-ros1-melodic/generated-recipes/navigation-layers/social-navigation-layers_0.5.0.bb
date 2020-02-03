# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Plugin-based layers for the navigation stack that   implement various social navigation contraints, like proxemic distance."
AUTHOR = "David V. Lu!! <davidvlu@gmail.com>"
ROS_AUTHOR = "David V. Lu!! <davidvlu@gmail.com>"
HOMEPAGE = "http://ros.org/wiki/social_navigation_layers"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "navigation_layers"
ROS_BPN = "social_navigation_layers"

ROS_BUILD_DEPENDS = " \
    angles \
    costmap-2d \
    dynamic-reconfigure \
    geometry-msgs \
    people-msgs \
    pluginlib \
    roscpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    angles \
    costmap-2d \
    dynamic-reconfigure \
    geometry-msgs \
    people-msgs \
    pluginlib \
    roscpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    angles \
    costmap-2d \
    dynamic-reconfigure \
    geometry-msgs \
    people-msgs \
    pluginlib \
    roscpp \
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

# matches with: https://github.com/wu-robotics/navigation_layers_release/archive/release/melodic/social_navigation_layers/0.5.0-0.tar.gz
ROS_BRANCH ?= "branch=release/melodic/social_navigation_layers"
SRC_URI = "git://github.com/wu-robotics/navigation_layers_release;${ROS_BRANCH};protocol=https"
SRCREV = "0e5ab7b1ece1a6c6bf2318e337552062e2581fd8"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
