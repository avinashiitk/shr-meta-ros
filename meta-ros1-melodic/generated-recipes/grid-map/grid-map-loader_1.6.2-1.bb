# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Loading and publishing grid maps from bag files."
AUTHOR = "Péter Fankhauser <pfankhauser@anybotics.com>"
ROS_AUTHOR = "Péter Fankhauser <pfankhauser@anybotics.com>"
HOMEPAGE = "http://github.com/anybotics/grid_map"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "grid_map"
ROS_BPN = "grid_map_loader"

ROS_BUILD_DEPENDS = " \
    grid-map-msgs \
    grid-map-ros \
    roscpp \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    grid-map-msgs \
    grid-map-ros \
    roscpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    grid-map-msgs \
    grid-map-ros \
    roscpp \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/anybotics/grid_map-release/archive/release/melodic/grid_map_loader/1.6.2-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/grid_map_loader"
SRC_URI = "git://github.com/anybotics/grid_map-release;${ROS_BRANCH};protocol=https"
SRCREV = "228b75d6a204f3e53c0448ae47769464a17551b8"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
