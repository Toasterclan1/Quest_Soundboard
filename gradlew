#!/usr/bin/env sh

# Gradle startup script
# DO NOT TOUCH THIS IF YOU DON'T KNOW SHELL LOL

##############################################################################
# YOU DO NOT NEED TO EDIT THIS FILE UNLESS YOU KNOW WHAT YOU ARE DOING!     #
##############################################################################

# Locate java
if [ -n "$JAVA_HOME" ] ; then
    JAVA="$JAVA_HOME/bin/java"
else
    JAVA="java"
fi

# Execute Gradle wrapper
exec "$JAVA" -Xmx64m -cp "$APP_HOME/gradle/wrapper/gradle-wrapper.jar" org.gradle.wrapper.GradleWrapperMain "$@"

