#!/bin/bash

PWD=`pwd`
SUFFIX=tags/RELEASE_400/final/
#SUFFIX=trunk
DESTINATION=src_400
BUILD_DIR=build_400

svn co $REVISION http://llvm.org/svn/llvm-project/llvm/$SUFFIX $DESTINATION

cd $DESTINATION/tools
svn co $REVISION http://llvm.org/svn/llvm-project/cfe/$SUFFIX clang
cd ../..

cd $DESTINATION/tools
svn co $REVISION http://llvm.org/svn/llvm-project/lldb/$SUFFIX lldb
cd ../..

cd $DESTINATION/tools/clang/tools
svn co $REVISION http://llvm.org/svn/llvm-project/clang-tools-extra/$SUFFIX extra
cd ../../../..

cd $DESTINATION/projects
svn co $REVISION http://llvm.org/svn/llvm-project/compiler-rt/$SUFFIX compiler-rt
cd ../..

cd $DESTINATION/projects
svn co $REVISION http://llvm.org/svn/llvm-project/libcxx/$SUFFIX libcxx
cd ../..

cd $DESTINATION/projects
svn co $REVISION http://llvm.org/svn/llvm-project/libcxxabi/$SUFFIX libcxxabi
cd ../..

cd $DESTINATION/projects
svn co http://llvm.org/svn/llvm-project/openmp/$SUFFIX openmp
cd ../..

echo "SVN checkout complete."

### Compilation
mkdir -p $BUILD_DIR
cd $BUILD_DIR
cmake -G "Unix Makefiles" -DCMAKE_BUILD_TYPE=Release -DLLVM_ENABLE_CXX1Y=ON -DLLVM_TARGETS_TO_BUILD="X86" ../$DESTINATION
make -j4
cd ..

### PATH
echo "Add the following line to your bash profile."
echo "export PATH=\$PATH:$PWD/$BUILD_DIR/bin"

