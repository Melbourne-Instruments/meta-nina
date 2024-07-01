SUMMARY = "Basic system packages deployed in NINA OS devices"
HOMEPAGE = "https://github.com/elk-audio/meta-elk"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

inherit packagegroup

RDEPENDS_packagegroup-nina-system-basic = " \
    kernel-modules \
    nina-custom-user \
    elk-systemd-services \
    bash \
    connman \
    avahi-daemon \
    nano \
    connman-client \
    raspi-gpio \
    rpi-gpio \    
"
