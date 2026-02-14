@echo off
rem Wrapper to use built-in maven if available or error out nicely

if exist "%JAVA_HOME%\bin\java.exe" (
    set "JAVA_CMD=%JAVA_HOME%\bin\java"
) else (
    set "JAVA_CMD=java"
)

"%JAVA_CMD%" -version >nul 2>&1
if errorlevel 1 (
    echo Error: JAVA_HOME is not defined correctly or java is not on the PATH.
    echo Please install Java 17+ and set JAVA_HOME.
    exit /b 1
)

if not exist "mvnw" (
    echo "mvnw" wrapper not found. Please install Maven or run from an IDE.
    echo detailed instructions: https://maven.apache.org/install.html
    exit /b 1
)

call mvnw %*
