@echo off
echo ===================================================
echo   Forts of Swarajya - Spring Boot Runner
echo ===================================================

REM Check for Java
where java >nul 2>nul
if %errorlevel% neq 0 (
    echo [ERROR] Java is not installed or not in your PATH.
    echo Please install Java 17+ and try again.
    pause
    exit /b
)

REM Check for Maven
where mvn >nul 2>nul
if %errorlevel% neq 0 (
    echo [WARNING] Maven is not in your PATH. 
    echo We will try to use the Maven Wrapper (mvnw) if available.
    
    if exist "mvnw.cmd" (
        echo Using Maven Wrapper...
        call mvnw.cmd spring-boot:run
    ) else (
        echo [ERROR] Maven Wrapper (mvnw) not found.
        echo Please install Maven or open this project in IntelliJ IDEA/Eclipse.
        pause
        exit /b
    )
) else (
    echo Maven found! Starting the application...
    call mvn spring-boot:run
)

pause
