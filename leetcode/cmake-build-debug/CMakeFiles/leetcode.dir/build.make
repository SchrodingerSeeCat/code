# CMAKE generated file: DO NOT EDIT!
# Generated by "MinGW Makefiles" Generator, CMake Version 3.19

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Disable VCS-based implicit rules.
% : %,v


# Disable VCS-based implicit rules.
% : RCS/%


# Disable VCS-based implicit rules.
% : RCS/%,v


# Disable VCS-based implicit rules.
% : SCCS/s.%


# Disable VCS-based implicit rules.
% : s.%


.SUFFIXES: .hpux_make_needs_suffix_list


# Command-line flag to silence nested $(MAKE).
$(VERBOSE)MAKESILENT = -s

#Suppress display of executed commands.
$(VERBOSE).SILENT:

# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

SHELL = cmd.exe

# The CMake executable.
CMAKE_COMMAND = "D:\utils\CLion 2020.3.1\bin\cmake\win\bin\cmake.exe"

# The command to remove a file.
RM = "D:\utils\CLion 2020.3.1\bin\cmake\win\bin\cmake.exe" -E rm -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = D:\code\leetcode

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = D:\code\leetcode\cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/leetcode.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/leetcode.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/leetcode.dir/flags.make

CMakeFiles/leetcode.dir/main.cpp.obj: CMakeFiles/leetcode.dir/flags.make
CMakeFiles/leetcode.dir/main.cpp.obj: ../main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=D:\code\leetcode\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/leetcode.dir/main.cpp.obj"
	D:\env\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\leetcode.dir\main.cpp.obj -c D:\code\leetcode\main.cpp

CMakeFiles/leetcode.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/leetcode.dir/main.cpp.i"
	D:\env\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E D:\code\leetcode\main.cpp > CMakeFiles\leetcode.dir\main.cpp.i

CMakeFiles/leetcode.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/leetcode.dir/main.cpp.s"
	D:\env\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S D:\code\leetcode\main.cpp -o CMakeFiles\leetcode.dir\main.cpp.s

CMakeFiles/leetcode.dir/src/stack/P_1006.cpp.obj: CMakeFiles/leetcode.dir/flags.make
CMakeFiles/leetcode.dir/src/stack/P_1006.cpp.obj: ../src/stack/P_1006.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=D:\code\leetcode\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Building CXX object CMakeFiles/leetcode.dir/src/stack/P_1006.cpp.obj"
	D:\env\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\leetcode.dir\src\stack\P_1006.cpp.obj -c D:\code\leetcode\src\stack\P_1006.cpp

CMakeFiles/leetcode.dir/src/stack/P_1006.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/leetcode.dir/src/stack/P_1006.cpp.i"
	D:\env\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E D:\code\leetcode\src\stack\P_1006.cpp > CMakeFiles\leetcode.dir\src\stack\P_1006.cpp.i

CMakeFiles/leetcode.dir/src/stack/P_1006.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/leetcode.dir/src/stack/P_1006.cpp.s"
	D:\env\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S D:\code\leetcode\src\stack\P_1006.cpp -o CMakeFiles\leetcode.dir\src\stack\P_1006.cpp.s

CMakeFiles/leetcode.dir/src/array/P_1143.cpp.obj: CMakeFiles/leetcode.dir/flags.make
CMakeFiles/leetcode.dir/src/array/P_1143.cpp.obj: ../src/array/P_1143.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=D:\code\leetcode\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_3) "Building CXX object CMakeFiles/leetcode.dir/src/array/P_1143.cpp.obj"
	D:\env\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\leetcode.dir\src\array\P_1143.cpp.obj -c D:\code\leetcode\src\array\P_1143.cpp

CMakeFiles/leetcode.dir/src/array/P_1143.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/leetcode.dir/src/array/P_1143.cpp.i"
	D:\env\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E D:\code\leetcode\src\array\P_1143.cpp > CMakeFiles\leetcode.dir\src\array\P_1143.cpp.i

CMakeFiles/leetcode.dir/src/array/P_1143.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/leetcode.dir/src/array/P_1143.cpp.s"
	D:\env\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S D:\code\leetcode\src\array\P_1143.cpp -o CMakeFiles\leetcode.dir\src\array\P_1143.cpp.s

CMakeFiles/leetcode.dir/src/array/P_88.cpp.obj: CMakeFiles/leetcode.dir/flags.make
CMakeFiles/leetcode.dir/src/array/P_88.cpp.obj: ../src/array/P_88.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=D:\code\leetcode\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_4) "Building CXX object CMakeFiles/leetcode.dir/src/array/P_88.cpp.obj"
	D:\env\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\leetcode.dir\src\array\P_88.cpp.obj -c D:\code\leetcode\src\array\P_88.cpp

CMakeFiles/leetcode.dir/src/array/P_88.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/leetcode.dir/src/array/P_88.cpp.i"
	D:\env\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E D:\code\leetcode\src\array\P_88.cpp > CMakeFiles\leetcode.dir\src\array\P_88.cpp.i

CMakeFiles/leetcode.dir/src/array/P_88.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/leetcode.dir/src/array/P_88.cpp.s"
	D:\env\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S D:\code\leetcode\src\array\P_88.cpp -o CMakeFiles\leetcode.dir\src\array\P_88.cpp.s

CMakeFiles/leetcode.dir/src/array/P_80.cpp.obj: CMakeFiles/leetcode.dir/flags.make
CMakeFiles/leetcode.dir/src/array/P_80.cpp.obj: ../src/array/P_80.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=D:\code\leetcode\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_5) "Building CXX object CMakeFiles/leetcode.dir/src/array/P_80.cpp.obj"
	D:\env\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\leetcode.dir\src\array\P_80.cpp.obj -c D:\code\leetcode\src\array\P_80.cpp

CMakeFiles/leetcode.dir/src/array/P_80.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/leetcode.dir/src/array/P_80.cpp.i"
	D:\env\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E D:\code\leetcode\src\array\P_80.cpp > CMakeFiles\leetcode.dir\src\array\P_80.cpp.i

CMakeFiles/leetcode.dir/src/array/P_80.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/leetcode.dir/src/array/P_80.cpp.s"
	D:\env\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S D:\code\leetcode\src\array\P_80.cpp -o CMakeFiles\leetcode.dir\src\array\P_80.cpp.s

CMakeFiles/leetcode.dir/src/array/P_81.cpp.obj: CMakeFiles/leetcode.dir/flags.make
CMakeFiles/leetcode.dir/src/array/P_81.cpp.obj: ../src/array/P_81.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=D:\code\leetcode\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_6) "Building CXX object CMakeFiles/leetcode.dir/src/array/P_81.cpp.obj"
	D:\env\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\leetcode.dir\src\array\P_81.cpp.obj -c D:\code\leetcode\src\array\P_81.cpp

CMakeFiles/leetcode.dir/src/array/P_81.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/leetcode.dir/src/array/P_81.cpp.i"
	D:\env\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E D:\code\leetcode\src\array\P_81.cpp > CMakeFiles\leetcode.dir\src\array\P_81.cpp.i

CMakeFiles/leetcode.dir/src/array/P_81.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/leetcode.dir/src/array/P_81.cpp.s"
	D:\env\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S D:\code\leetcode\src\array\P_81.cpp -o CMakeFiles\leetcode.dir\src\array\P_81.cpp.s

CMakeFiles/leetcode.dir/src/array/P_153.cpp.obj: CMakeFiles/leetcode.dir/flags.make
CMakeFiles/leetcode.dir/src/array/P_153.cpp.obj: ../src/array/P_153.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=D:\code\leetcode\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_7) "Building CXX object CMakeFiles/leetcode.dir/src/array/P_153.cpp.obj"
	D:\env\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\leetcode.dir\src\array\P_153.cpp.obj -c D:\code\leetcode\src\array\P_153.cpp

CMakeFiles/leetcode.dir/src/array/P_153.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/leetcode.dir/src/array/P_153.cpp.i"
	D:\env\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E D:\code\leetcode\src\array\P_153.cpp > CMakeFiles\leetcode.dir\src\array\P_153.cpp.i

CMakeFiles/leetcode.dir/src/array/P_153.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/leetcode.dir/src/array/P_153.cpp.s"
	D:\env\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S D:\code\leetcode\src\array\P_153.cpp -o CMakeFiles\leetcode.dir\src\array\P_153.cpp.s

CMakeFiles/leetcode.dir/src/linkllist/ListNode.cpp.obj: CMakeFiles/leetcode.dir/flags.make
CMakeFiles/leetcode.dir/src/linkllist/ListNode.cpp.obj: ../src/linkllist/ListNode.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=D:\code\leetcode\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_8) "Building CXX object CMakeFiles/leetcode.dir/src/linkllist/ListNode.cpp.obj"
	D:\env\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\leetcode.dir\src\linkllist\ListNode.cpp.obj -c D:\code\leetcode\src\linkllist\ListNode.cpp

CMakeFiles/leetcode.dir/src/linkllist/ListNode.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/leetcode.dir/src/linkllist/ListNode.cpp.i"
	D:\env\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E D:\code\leetcode\src\linkllist\ListNode.cpp > CMakeFiles\leetcode.dir\src\linkllist\ListNode.cpp.i

CMakeFiles/leetcode.dir/src/linkllist/ListNode.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/leetcode.dir/src/linkllist/ListNode.cpp.s"
	D:\env\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S D:\code\leetcode\src\linkllist\ListNode.cpp -o CMakeFiles\leetcode.dir\src\linkllist\ListNode.cpp.s

CMakeFiles/leetcode.dir/src/linkllist/P_2.cpp.obj: CMakeFiles/leetcode.dir/flags.make
CMakeFiles/leetcode.dir/src/linkllist/P_2.cpp.obj: ../src/linkllist/P_2.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=D:\code\leetcode\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_9) "Building CXX object CMakeFiles/leetcode.dir/src/linkllist/P_2.cpp.obj"
	D:\env\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\leetcode.dir\src\linkllist\P_2.cpp.obj -c D:\code\leetcode\src\linkllist\P_2.cpp

CMakeFiles/leetcode.dir/src/linkllist/P_2.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/leetcode.dir/src/linkllist/P_2.cpp.i"
	D:\env\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E D:\code\leetcode\src\linkllist\P_2.cpp > CMakeFiles\leetcode.dir\src\linkllist\P_2.cpp.i

CMakeFiles/leetcode.dir/src/linkllist/P_2.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/leetcode.dir/src/linkllist/P_2.cpp.s"
	D:\env\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S D:\code\leetcode\src\linkllist\P_2.cpp -o CMakeFiles\leetcode.dir\src\linkllist\P_2.cpp.s

CMakeFiles/leetcode.dir/src/array/P_263.cpp.obj: CMakeFiles/leetcode.dir/flags.make
CMakeFiles/leetcode.dir/src/array/P_263.cpp.obj: ../src/array/P_263.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=D:\code\leetcode\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_10) "Building CXX object CMakeFiles/leetcode.dir/src/array/P_263.cpp.obj"
	D:\env\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\leetcode.dir\src\array\P_263.cpp.obj -c D:\code\leetcode\src\array\P_263.cpp

CMakeFiles/leetcode.dir/src/array/P_263.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/leetcode.dir/src/array/P_263.cpp.i"
	D:\env\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E D:\code\leetcode\src\array\P_263.cpp > CMakeFiles\leetcode.dir\src\array\P_263.cpp.i

CMakeFiles/leetcode.dir/src/array/P_263.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/leetcode.dir/src/array/P_263.cpp.s"
	D:\env\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S D:\code\leetcode\src\array\P_263.cpp -o CMakeFiles\leetcode.dir\src\array\P_263.cpp.s

CMakeFiles/leetcode.dir/src/array/P_264.cpp.obj: CMakeFiles/leetcode.dir/flags.make
CMakeFiles/leetcode.dir/src/array/P_264.cpp.obj: ../src/array/P_264.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=D:\code\leetcode\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_11) "Building CXX object CMakeFiles/leetcode.dir/src/array/P_264.cpp.obj"
	D:\env\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\leetcode.dir\src\array\P_264.cpp.obj -c D:\code\leetcode\src\array\P_264.cpp

CMakeFiles/leetcode.dir/src/array/P_264.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/leetcode.dir/src/array/P_264.cpp.i"
	D:\env\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E D:\code\leetcode\src\array\P_264.cpp > CMakeFiles\leetcode.dir\src\array\P_264.cpp.i

CMakeFiles/leetcode.dir/src/array/P_264.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/leetcode.dir/src/array/P_264.cpp.s"
	D:\env\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S D:\code\leetcode\src\array\P_264.cpp -o CMakeFiles\leetcode.dir\src\array\P_264.cpp.s

CMakeFiles/leetcode.dir/src/array/P_179.cpp.obj: CMakeFiles/leetcode.dir/flags.make
CMakeFiles/leetcode.dir/src/array/P_179.cpp.obj: ../src/array/P_179.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=D:\code\leetcode\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_12) "Building CXX object CMakeFiles/leetcode.dir/src/array/P_179.cpp.obj"
	D:\env\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\leetcode.dir\src\array\P_179.cpp.obj -c D:\code\leetcode\src\array\P_179.cpp

CMakeFiles/leetcode.dir/src/array/P_179.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/leetcode.dir/src/array/P_179.cpp.i"
	D:\env\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E D:\code\leetcode\src\array\P_179.cpp > CMakeFiles\leetcode.dir\src\array\P_179.cpp.i

CMakeFiles/leetcode.dir/src/array/P_179.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/leetcode.dir/src/array/P_179.cpp.s"
	D:\env\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S D:\code\leetcode\src\array\P_179.cpp -o CMakeFiles\leetcode.dir\src\array\P_179.cpp.s

CMakeFiles/leetcode.dir/src/binarytree/P_783.cpp.obj: CMakeFiles/leetcode.dir/flags.make
CMakeFiles/leetcode.dir/src/binarytree/P_783.cpp.obj: ../src/binarytree/P_783.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=D:\code\leetcode\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_13) "Building CXX object CMakeFiles/leetcode.dir/src/binarytree/P_783.cpp.obj"
	D:\env\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\leetcode.dir\src\binarytree\P_783.cpp.obj -c D:\code\leetcode\src\binarytree\P_783.cpp

CMakeFiles/leetcode.dir/src/binarytree/P_783.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/leetcode.dir/src/binarytree/P_783.cpp.i"
	D:\env\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E D:\code\leetcode\src\binarytree\P_783.cpp > CMakeFiles\leetcode.dir\src\binarytree\P_783.cpp.i

CMakeFiles/leetcode.dir/src/binarytree/P_783.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/leetcode.dir/src/binarytree/P_783.cpp.s"
	D:\env\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S D:\code\leetcode\src\binarytree\P_783.cpp -o CMakeFiles\leetcode.dir\src\binarytree\P_783.cpp.s

CMakeFiles/leetcode.dir/src/str/P_9.cpp.obj: CMakeFiles/leetcode.dir/flags.make
CMakeFiles/leetcode.dir/src/str/P_9.cpp.obj: ../src/str/P_9.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=D:\code\leetcode\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_14) "Building CXX object CMakeFiles/leetcode.dir/src/str/P_9.cpp.obj"
	D:\env\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\leetcode.dir\src\str\P_9.cpp.obj -c D:\code\leetcode\src\str\P_9.cpp

CMakeFiles/leetcode.dir/src/str/P_9.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/leetcode.dir/src/str/P_9.cpp.i"
	D:\env\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E D:\code\leetcode\src\str\P_9.cpp > CMakeFiles\leetcode.dir\src\str\P_9.cpp.i

CMakeFiles/leetcode.dir/src/str/P_9.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/leetcode.dir/src/str/P_9.cpp.s"
	D:\env\mingw64\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S D:\code\leetcode\src\str\P_9.cpp -o CMakeFiles\leetcode.dir\src\str\P_9.cpp.s

# Object files for target leetcode
leetcode_OBJECTS = \
"CMakeFiles/leetcode.dir/main.cpp.obj" \
"CMakeFiles/leetcode.dir/src/stack/P_1006.cpp.obj" \
"CMakeFiles/leetcode.dir/src/array/P_1143.cpp.obj" \
"CMakeFiles/leetcode.dir/src/array/P_88.cpp.obj" \
"CMakeFiles/leetcode.dir/src/array/P_80.cpp.obj" \
"CMakeFiles/leetcode.dir/src/array/P_81.cpp.obj" \
"CMakeFiles/leetcode.dir/src/array/P_153.cpp.obj" \
"CMakeFiles/leetcode.dir/src/linkllist/ListNode.cpp.obj" \
"CMakeFiles/leetcode.dir/src/linkllist/P_2.cpp.obj" \
"CMakeFiles/leetcode.dir/src/array/P_263.cpp.obj" \
"CMakeFiles/leetcode.dir/src/array/P_264.cpp.obj" \
"CMakeFiles/leetcode.dir/src/array/P_179.cpp.obj" \
"CMakeFiles/leetcode.dir/src/binarytree/P_783.cpp.obj" \
"CMakeFiles/leetcode.dir/src/str/P_9.cpp.obj"

# External object files for target leetcode
leetcode_EXTERNAL_OBJECTS =

leetcode.exe: CMakeFiles/leetcode.dir/main.cpp.obj
leetcode.exe: CMakeFiles/leetcode.dir/src/stack/P_1006.cpp.obj
leetcode.exe: CMakeFiles/leetcode.dir/src/array/P_1143.cpp.obj
leetcode.exe: CMakeFiles/leetcode.dir/src/array/P_88.cpp.obj
leetcode.exe: CMakeFiles/leetcode.dir/src/array/P_80.cpp.obj
leetcode.exe: CMakeFiles/leetcode.dir/src/array/P_81.cpp.obj
leetcode.exe: CMakeFiles/leetcode.dir/src/array/P_153.cpp.obj
leetcode.exe: CMakeFiles/leetcode.dir/src/linkllist/ListNode.cpp.obj
leetcode.exe: CMakeFiles/leetcode.dir/src/linkllist/P_2.cpp.obj
leetcode.exe: CMakeFiles/leetcode.dir/src/array/P_263.cpp.obj
leetcode.exe: CMakeFiles/leetcode.dir/src/array/P_264.cpp.obj
leetcode.exe: CMakeFiles/leetcode.dir/src/array/P_179.cpp.obj
leetcode.exe: CMakeFiles/leetcode.dir/src/binarytree/P_783.cpp.obj
leetcode.exe: CMakeFiles/leetcode.dir/src/str/P_9.cpp.obj
leetcode.exe: CMakeFiles/leetcode.dir/build.make
leetcode.exe: CMakeFiles/leetcode.dir/linklibs.rsp
leetcode.exe: CMakeFiles/leetcode.dir/objects1.rsp
leetcode.exe: CMakeFiles/leetcode.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=D:\code\leetcode\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_15) "Linking CXX executable leetcode.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\leetcode.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/leetcode.dir/build: leetcode.exe

.PHONY : CMakeFiles/leetcode.dir/build

CMakeFiles/leetcode.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\leetcode.dir\cmake_clean.cmake
.PHONY : CMakeFiles/leetcode.dir/clean

CMakeFiles/leetcode.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" D:\code\leetcode D:\code\leetcode D:\code\leetcode\cmake-build-debug D:\code\leetcode\cmake-build-debug D:\code\leetcode\cmake-build-debug\CMakeFiles\leetcode.dir\DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/leetcode.dir/depend

