# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[rqt-gui-py] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', 'Requires qt-gui which depends on qtbase which requires meta-qt5 to be included', '', d)}"