---
layout: cs544default
---

## Setup for LLVM

* You have to have SVN and CMake available on your machine.
  So install these before your proceed, if your system does not have them already.

* Create a folder named, say, `llvm` in a proper place (e.g. in `~`)..
  Then, inside this folder, run [this script](setup_llvm.sh).
  The script will fetch LLVM 4.0.0 files from its SVN repository,
  and then will build the files. Building will take a **long** time.

* The script will create two folders: `src_400` and `build_400`.
  Inside the `build_400` there is a `bin` folder that includes
  clang and llvm tools. Put that `bin` folder into your PATH.
  E.g. Append the following file to your `~/.bashrc` or `~/.bash_profile`:
  `export PATH=~/llvm/build_400/bin:$PATH` 

* To check that your installation is OK, open up a new terminal
window, and run the following command: `llvm-config --version`
You should see `4.0.0` printed.
