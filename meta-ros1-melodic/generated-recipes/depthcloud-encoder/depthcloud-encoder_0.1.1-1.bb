# Generated by superflore -- DO NOT EDIT
#
# Copyright Open Source Robotics Foundation

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "Point Cloud Encoder for Web-Based Streaming"
AUTHOR = "Russell Toris <rctoris@wpi.edu>"
ROS_AUTHOR = "Julius Kammer <jkammerl@willowgarage.com>"
HOMEPAGE = "http://ros.org/wiki/depthcloud_encoder"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "depthcloud_encoder"
ROS_BPN = "depthcloud_encoder"

ROS_BUILD_DEPENDS = " \
    cv-bridge \
    dynamic-reconfigure \
    image-transport \
    message-filters \
    pcl-conversions \
    pcl-ros \
    roscpp \
    sensor-msgs \
    tf-conversions \
"

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = " \
    cv-bridge \
    dynamic-reconfigure \
    image-transport \
    message-filters \
    pcl-conversions \
    pcl-ros \
    roscpp \
    sensor-msgs \
    tf-conversions \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    cv-bridge \
    dynamic-reconfigure \
    image-transport \
    message-filters \
    pcl-conversions \
    pcl-ros \
    roscpp \
    sensor-msgs \
    tf-conversions \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/RobotWebTools-release/depthcloud_encoder-release/archive/release/melodic/depthcloud_encoder/0.1.1-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/depthcloud_encoder"
SRC_URI = "git://github.com/RobotWebTools-release/depthcloud_encoder-release;${ROS_BRANCH};protocol=https"
SRCREV = "f016fa054dad892a70da2bbda395e3c422afc9f4"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}
