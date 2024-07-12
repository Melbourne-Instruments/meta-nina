SUMMARY = "NINA UI program for NINA OS."
HOMEPAGE = "https://github.com/Melbourne-Instruments/nina_ui"

LICENSE = "AGPL-3.0"
LIC_FILES_CHKSUM = "\
    file://COPYING;md5=3db23ab95801691a1b98ff9ddb8dc98b \
"

DEPENDS = "\
    xenomai-lib \
    alsa-utils \
    elkcpp \
"

KERNEL_MODULE_AUTOLOAD += "i2c_dev"

# Note: Same as SRCREV; Overide in meta-<product>
PV = ""
SRC_URI = "gitsm://github.com/Melbourne-Instruments/nina_ui.git"

# NOTE: Override this in the meta-<product> layer with a
# .bbappend recipe choosing the specific commit required
SRCREV = ""

S = "${WORKDIR}/git"

inherit cmake python3native

OECMAKE_C_FLAGS_RELEASE += "-O3"
OECMAKE_CXX_FLAGS_RELEASE += "-O3"

do_compile() {
    cmake \
    ${OECMAKE_GENERATOR_ARGS} \
    $oecmake_sitefile \
    ${OECMAKE_SOURCEPATH}

    cmake_runcmake_build --target ${OECMAKE_TARGET_COMPILE}
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 nina_ui ${D}${bindir}
}

RDEPENDS_{PN} = "\
    xenomai-lib \
    elkcpp \
"

INSANE_SKIP_${PN} += "dev-deps"
