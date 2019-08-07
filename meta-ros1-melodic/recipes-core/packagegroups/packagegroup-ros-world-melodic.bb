DESCRIPTION = "All non-test packages for the target from files/${ROS_DISTRO}/cache.yaml"
LICENSE = "MIT"

inherit packagegroup
inherit ros_distro_melodic

PACKAGES = "${PN}"

RDEPENDS_${PN} = "${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES}"

RDEPENDS_${PN}_remove = "${@ '${ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_META_QT}' if 'qt5-layer' not in BBFILE_COLLECTIONS.split() else '' }"

ROS_SUPERFLORE_GENERATED_WORLD_PACKAGES_DEPENDING_ON_META_QT = " \
    python-qt-binding \
    dataspeed-pds-rqt \
    qt-gui-py-common \
    node-manager-fkie \
    qt-dotgraph \
    rqt-py-common \
    qt-gui-core \
    multimaster-fkie \
    rqt-py-trees \
    rqt-common-plugins \
    rqt-action \
    rqt-ez-publisher \
    rqt-service-caller \
    rqt-bag \
    rqt-console \
    rqt-dep \
    rqt-graph \
    rqt-launch \
    rqt-logger-level \
    rqt-moveit \
    rqt-msg \
    rqt-nav-view \
    rqt-plot \
    rqt-pose-view \
    rqt-publisher \
    rqt-py-console \
    rqt-reconfigure \
    rqt-robot-dashboard \
    rqt-robot-monitor \
    rqt-robot-steering \
    rqt-runtime-monitor \
    rqt-shell \
    rqt-tf-tree \
    rqt-topic \
    rqt-top \
    rqt-web \
    rviz \
"
