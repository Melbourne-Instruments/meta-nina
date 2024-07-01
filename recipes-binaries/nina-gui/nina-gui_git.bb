SUMMARY = "NINA GUI proram for NINA OS."
HOMEPAGE = "https://github.com/Melbourne-Instruments/nina_gui"
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""
DEPENDS = "qtbase"
DEPENDS = "qtcharts"

# Note: Same as SRCREV; Overide in meta-<product>
PV = ""
SRC_URI = "https://github.com/Melbourne-Instruments/nina_gui.git"

# NOTE: Override this in the meta-<product> layer with a
# .bbappend recipe choosing the specific commit required
SRCREV = ""

S = "${WORKDIR}/git"

inherit qmake5 python3native

OECMAKE_C_FLAGS_RELEASE += "-O3"
OECMAKE_CXX_FLAGS_RELEASE += "-O3"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/build/build/release/nina_gui ${D}${bindir}
}

INSANE_SKIP_${PN} += "dev-deps"
