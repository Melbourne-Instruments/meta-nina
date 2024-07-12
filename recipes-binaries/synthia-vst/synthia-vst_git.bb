SUMMARY = "NINA VST (VST3) for NINA OS."
HOMEPAGE = "https://github.com/Melbourne-Instruments/nina_vst"

LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

DEPENDS = "\
    gsl \
    libsndfile1 \
    fftw \
"

# Note: Same as SRCREV; Overide in meta-<product>
PV = ""
SRC_URI = "gitsm://github.com/Melbourne-Instruments/nina_vst.git"

# NOTE: Override this in the meta-<product> layer with a
# .bbappend recipe choosing the specific commit required
SRCREV = ""

S = "${WORKDIR}/git"

inherit cmake python3native

export CROSS_COMPILE="${TARGET_PREFIX}"
OECMAKE_C_FLAGS_RELEASE += "-O3"
OECMAKE_CXX_FLAGS_RELEASE += "-O3"

ROOT_HOME_DIR = "/home/root"

do_compile() {
    cmake \
    ${OECMAKE_GENERATOR_ARGS} \
    $oecmake_sitefile \
    ${OECMAKE_SOURCEPATH}

    cmake_runcmake_build --target ${OECMAKE_TARGET_COMPILE}
}

do_install() {
    install -d ${D}${ROOT_HOME_DIR}
    install -d ${D}${ROOT_HOME_DIR}/nina
    install -d ${D}${ROOT_HOME_DIR}/nina/synthia_vst.vst3/Contents/${TARGET_ARCH}-linux
    cp "${WORKDIR}/build/VST3/Debug/synthia_vst.vst3/Contents/aarch64-linux/synthia_vst.so" "${D}${ROOT_HOME_DIR}/nina/synthia_vst.vst3/Contents/${TARGET_ARCH}-linux/"
    cp ${WORKDIR}/build/VST3/Debug/synthia_vst.vst3/Contents/*.py ${D}${ROOT_HOME_DIR}/nina/synthia_vst.vst3/Contents/
    cp "${WORKDIR}/build/VST3/Debug/synthia_vst.vst3/Contents/version.txt" "${D}${ROOT_HOME_DIR}/nina/synthia_vst.vst3/Contents/"
}

FILES_${PN} += "${ROOT_HOME_DIR}/nina/synthia_vst.vst3/*"

INSANE_SKIP_${PN} += "ldflags"
