# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "The trac_ik_python package contains a python wrapper using SWIG   for trac_ik_lib"
AUTHOR = "Sam Pfeiffer <Sammy.Pfeiffer@student.uts.edu.au>"
ROS_AUTHOR = "Sam Pfeiffer"
HOMEPAGE = "https://wiki.ros.org"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "trac_ik"
ROS_BPN = "trac_ik_python"

ROS_BUILD_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_swig} \
    rospy \
    tf-conversions \
    trac-ik-lib \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_swig} \
    rospy \
    tf \
    tf-conversions \
    trac-ik-lib \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ${ROS_UNRESOLVED_PLATFORM_PKG_swig} \
    rospy \
    tf \
    tf-conversions \
    trac-ik-lib \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/traclabs/trac_ik-release/archive/release/melodic/trac_ik_python/1.5.0-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/trac_ik_python"
SRC_URI = "git://github.com/traclabs/trac_ik-release;${ROS_BRANCH};protocol=https"
SRCREV = "abe27c51f22f12b1b4b68295af172ed8bf9e2705"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}