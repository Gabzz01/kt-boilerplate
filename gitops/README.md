# GitOps

This folder follows a once folder per environment structure, where each folder contains the necessary manifests and
configurations for that environment.

This approach enables the creation of dedicated configuration files (such as Ansible Vaults and more ...) for each environment.

The `deploy_playbook.yaml` can be run using the following command :
```sh
ansible-playbook -i inventory.ini deploy_playbook.yaml --vault-password-file ~/.ansible-vault-pass -e "target_env=staging"
```

## Ansible Vault

As environments `.env` file may contain passwords and api keys, their content is encrypted using ansible vault :

```sh
# Initial encryption
ansible-vault encrypt gitops/staging/.env

# Visualize content
ansible-vault view gitops/staging/.env

# Further editing
ansible-vault edit gitops/staging/.env
```

The used password should be stored as a `ANSIBLE_VAULT_PSSWD` Github secret to make it available to Github Actions jobs.