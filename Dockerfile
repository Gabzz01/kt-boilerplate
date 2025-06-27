FROM eclipse-temurin:23-jre

# See https://app.datadoghq.eu/source-code/setup/apm
ARG DD_GIT_REPOSITORY_URL
ARG DD_GIT_COMMIT_SHA
ENV DD_GIT_REPOSITORY_URL=${DD_GIT_REPOSITORY_URL}
ENV DD_GIT_COMMIT_SHA=${DD_GIT_COMMIT_SHA}

# Set a non-root user
ARG USER_NAME=app
ARG USER_ID=10001

# Create a non-root user and group
RUN groupadd --gid $USER_ID $USER_NAME && \
    useradd --uid $USER_ID --gid $USER_ID --shell /bin/bash --create-home $USER_NAME

# Set working directory
WORKDIR /app

# Copy application JAR file
COPY build/libs/app-fat.jar /app/app.jar

# Change ownership of the application directory
RUN chown -R $USER_NAME:$USER_NAME /app

# Switch to the non-root user
USER $USER_NAME

# Expose application port (if needed)
EXPOSE 8080

# Set the entry point to run the Java application
CMD ["java", "-jar", "/app/app.jar"]