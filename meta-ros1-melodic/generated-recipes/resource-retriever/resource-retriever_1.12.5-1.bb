# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "This package retrieves data from url-format files such as http://,    ftp://, package:// file://, etc., and loads the data into memory.    The package:// url for ros packages is translated into a local    file:// url.  The resourse retriever was initially designed to load    mesh files into memory, but it can be used for any type of    data. The resource retriever is based on the the libcurl library."
AUTHOR = "Chris Lalancette <clalancette@osrfoundation.org>"
ROS_AUTHOR = "Josh Faust <jfaust@willowgarage.com>"
HOMEPAGE = "http://ros.org/wiki/resource_retriever"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=22;endline=22;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "resource_retriever"
ROS_BPN = "resource_retriever"

ROS_BUILD_DEPENDS = " \
    boost \
    curl \
    rosconsole \
    roslib \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    boost \
    curl \
    rosconsole \
    roslib \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    boost \
    curl \
    python-rospkg \
    rosconsole \
    roslib \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/ros-gbp/resource_retriever-release/archive/release/melodic/resource_retriever/1.12.5-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/resource_retriever"
SRC_URI = "git://github.com/ros-gbp/resource_retriever-release;${ROS_BRANCH};protocol=https"
SRCREV = "c00f6383a9a954cb36e2952db251330761089092"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
