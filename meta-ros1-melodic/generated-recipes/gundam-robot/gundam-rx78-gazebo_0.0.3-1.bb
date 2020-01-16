# Generated by superflore -- DO NOT EDIT

inherit ros_distro_melodic
inherit ros_superflore_generated

DESCRIPTION = "gundam_rx78_gazebo contains launch scripts for simulating the GUNDAM RX-78 robot in the gazebo simulation"
AUTHOR = "Kei Okada <kei.okada@gmail.com>"
ROS_AUTHOR = "Kei Okada <kei.okada@gmail.com>"
HOMEPAGE = "http://wiki.ros.org/gundam_rx78_gazebo"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

ROS_CN = "gundam_robot"
ROS_BPN = "gundam_rx78_gazebo"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    catkin-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    fake-localization \
    gazebo-plugins \
    gazebo-ros \
    gazebo-ros-control \
    gundam-rx78-control \
    gundam-rx78-description \
"

# Currently informational only -- see http://www.ros.org/reps/rep-0149.html#dependency-tags.
ROS_TEST_DEPENDS = " \
    roslaunch \
    roslint \
    rostest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
# Bitbake doesn't support the "export" concept, so build them as if we needed them to build this package (even though we actually
# don't) so that they're guaranteed to have been staged should this package appear in another's DEPENDS.
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS_${PN} += "${ROS_EXEC_DEPENDS}"

# matches with: https://github.com/gundam-global-challenge/gundam_robot-release/archive/release/melodic/gundam_rx78_gazebo/0.0.3-1.tar.gz
ROS_BRANCH ?= "branch=release/melodic/gundam_rx78_gazebo"
SRC_URI = "git://github.com/gundam-global-challenge/gundam_robot-release;${ROS_BRANCH};protocol=https"
SRCREV = "a06ba3ce1053d02a8aee39a991ef3beb40570581"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "catkin"

inherit ros_${ROS_BUILD_TYPE}