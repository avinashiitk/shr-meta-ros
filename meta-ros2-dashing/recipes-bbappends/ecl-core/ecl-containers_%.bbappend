# Copyright (c) 2020 LG Electronics, Inc.

# ERROR: ecl-containers-1.0.4-1-r0 do_package_qa: QA Issue: /opt/ros/dashing/lib/ecl_containers/demo_formatters contained in package ecl-containers requires libecl_exceptions.so.1.0.4()(64bit), but no providers found in RDEPENDS_ecl-containers? [file-rdeps]
INSANE_SKIP_${PN} += "file-rdeps"
