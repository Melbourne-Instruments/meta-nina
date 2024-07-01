DESCRIPTION = "ST-Link Tools"
HOMEPAGE = "https://github.com/stlink-org/stlink/"
SECTION = ""
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=3374725a40df7047d33d627811b8149e"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

DEPENDS = "libusb"
TAG = "v1.7.0"
SRC_URI = "git://github.com/stlink-org/stlink.git;protocol=https;tag=${TAG}"
SRC_URI += "file://0001-CMakeLists.txt-patch-get-version.cmake-and-c-flags.c.patch"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

EXTRA_OECMAKE = " \
    -DSTLINK_UDEV_RULES_DIR=${sysconfdir}/udev/rules.d \
    -DSTLINK_MODPROBED_DIR=${sysconfdir}/modprobe.d \
    -DLIB_INSTALL_DIR:PATH="${@os.path.relpath(d.getVar('libdir'), d.getVar('prefix'))}" \
    "
