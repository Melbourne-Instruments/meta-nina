SUMMARY = "FPGA Configuration program for for NINA OS."
HOMEPAGE = "https://github.com/Melbourne-Instruments/fpga_config"

LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

# Note: Same as SRCREV; Overide in meta-<product>
PV = ""
SRC_URI = "git://github.com/Melbourne-Instruments/fpga_config.git"

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
    install -m 0755 fpga_config ${D}${bindir}
}

INSANE_SKIP_${PN} += "dev-deps"
