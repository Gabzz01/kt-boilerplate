# Kotlin JVM Boilerplate

An opinionated boilerplate project for Kotlin JVM applications respecting the Onion Architecture that comes with a DevSecOps pipeline, designed to be simple, maintainable, and easy to extend.

## Libraries and tools

This project leverages the following libraries / tools :

- [kotlinx.serialization](https://github.com/Kotlin/kotlinx.serialization)
- [kotlinx.coroutines](https://github.com/Kotlin/kotlinx.coroutines)
- [kotlinx.datetime](https://github.com/Kotlin/kotlinx-datetime)

## Bootstrapping a project

1. Rename the `rootProject.name` in [settings.gradle.kts](./settings.gradle.kts) with the actual project name.
2. Rename the base package from `com.example.app` to the desired package name in the `src/main` and `src/test` folders.
3. Start coding !

## Building

Application is built using Gradle. To build the project, run:

```sh
./gradlew build
```

## Running

To run the application, use:

```sh
./gradlew run
```

## DevSecOps pipeline

### Required secrets

- `ANSIBLE_VAULT_PSSWD`
- `ANSIBLE_SSH_KEY`

### Continuous Integration

### Security scans

This project includes a DevSecOps pipeline that integrates with GitHub Actions that offers the following capabilities:

- SAST using Semgrep Open Source
- Dependency Scanning using OWASP Dependency-Check grade plugin
- Container Scanning using Trivy

### Continuous Delivery

This setup implements the GitOps model and relies on Ansible for automated deployments.

You'll need a server with Docker installed and SSH key authentication configured.

To generate a ssh key run :
```sh
ssh-keygen -t rsa -b 4096 -f ~/.ssh/id_rsa_cicd
# Enter your passphrase when propmpted
```

Then add the generated public key to the authorized keys on the remote machine.
Head onto the [Github repository settings page and create a Action secret](./settings/secrets/actions) and :
* create a `DEPLOYMENT_SSH_KEY` secret with the contents of the generated private key (*e.g. ~/.ssh/id_rsa_cicd*) 
* create a `DEPLOYMENT_SSH_KEY_PASSPHRASE` secret with the key passphrase.