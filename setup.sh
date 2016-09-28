#!/bin/sh
./gradlew setupDecompWorkspace eclipse
#If you get a memery error use this
 #./gradlew setupDecompWorkspace eclipse -Dorg.gradle.jvmargs=-Xmx3072m 