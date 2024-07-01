DESCRIPTION = "Standard OpenGL bindings for Python"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "BSD"
SRCNAME = "PyOpenGL"
LIC_FILES_CHKSUM = "file://license.txt;md5=603fc14206e108ce9cd85ef7fc7d3025"

SRC_URI = "\
  https://pypi.python.org/packages/source/P/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools3

SRC_URI[md5sum] = "b6c4ca4c3321be7a1ace35c7b4db1751"
SRC_URI[sha256sum] = "8ea6c8773927eda7405bffc6f5bb93be81569a7b05c8cac50cd94e969dce5e27"
