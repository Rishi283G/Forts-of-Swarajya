@echo off
set "JAVA_CMD=%JAVA_HOME%\bin\java.exe"
if not exist "%JAVA_CMD%" set "JAVA_CMD=java"

echo Compiling...
"%JAVA_CMD%" -version
javac -d bin -cp "src/main/resources;src/main/java" src/main/java/com/forts/FortsOfSwarajyaApplication.java
if errorlevel 1 (
    echo Compilation failed.
    pause
    exit /b 1
)

echo Running...
"%JAVA_CMD%" -cp "bin;src/main/resources" com.forts.FortsOfSwarajyaApplication
pause
