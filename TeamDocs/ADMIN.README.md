# Admin Instructions for Maintaining this template and its forks

## How to use this template

This template it what you will use to create a new repo for each season. It will also serve as a bridge to get mid-season updates from FIRST onto the robot.
At the start of each season, you will fork this repo. This will copy over the necessary configuration files that are absent in FIRST's repo.
Throughout the season you will sync this repo with the parent FtcRobotController repo, Once you have synced this repo with the upstream one, you will sync your fork with this repo.
**NOTE: This repo has heavy restrictions on it to prevent accidental changes.** If this needs to be changed in the future, it can be done so via this repo's [Rulesets](https://github.com/4H-Botsmiths/FtcRobotControllerTemplate/settings/rules)

## How to configure the forks

Although this repo contains all of the necessary devcontainer and ci configurations, some setup will still be required post-fork, including:

<details>
  <summary> Create branch protection rules</summary>

> 1. Download the ruleset from https://github.com/4H-Botsmiths/FtcRobotControllerTemplate/blob/master/TeamCode/ruleset.json
> 2. Go to `Repo > Settings > Rulesets > Rulesets > New Ruleset > Import a Ruleset`
> 3. Select the downloaded ruleset file and import it.

</details>
<details>
  <summary> Enable Github Actions</summary>

> 1. Go to `Repo > Actions > Enable GitHub Actions`

</details>
<details>
  <summary> Register deploy runner(s)</summary>

> 1. Go to `Repo > Settings > Actions > Runners > New self-hosted runner`
> 2. Configure the self-hosted runner (use the following settings for a Raspberry Pi runner)
>    - OS: `Linux`
>    - Architecture: `ARM64`
> 3. Follow the Download and Configure steps
> 4. During the runner setup, accept all the default options (they will work and modifying them can cause issues during setup)

</details>

## Troubleshooting

<details>
  <summary> The Runner was removed from the repo due to inactivity</summary>

> If a runner does not connect to Actions for 14 days, github may remove it from the repository. To prevent this, try to turn the runner on once a week long enough to connect to the GitHub Actions service.
> If you are unsure whether your runner has been removed, check the Repo > Settings > Actions > Runners page.
> To reconnect a removed runner, be sure to follow the steps below as just re-running the configure steps will not work:
>
> 1. On the runner, `cd` into the runner's directory (usually `actions-runner`).
> 2. Run `rm -rf .runner` to remove the old runner configuration.
> 3. Run `./config.sh remove` to remove any remaining configuration.
> 4. Re-run the configure steps for the self-hosted runner.
>    > 1. Go to `Repo > Settings > Actions > Runners > New self-hosted runner`
>    > 2. Configure the self-hosted runner (use the following settings for a Raspberry Pi runner)
>    >
>    > - OS: `Linux`
>    > - Architecture: `ARM64`
>    >
>    > 3. Follow the Configure steps

</details>

<details>
  <summary> The runner is plugged in, but it's not picking up any jobs</summary>

> 1. Remote into the runner
> 2. `cd` into the runner's directory (usually `actions-runner`).
> 3. Run `./svc.sh status` (you may need to run with `sudo`).
>    > - If the service is running without errors, check the Github status page for any ongoing issues.
>    > - If the service was running and looks like it lost internet causing it to disconnect, run `./svc.sh start` to restart the service.
>    > - If the service emitted and error during it's startup that it is not registered with the repo, check out **The Runner was removed from the repo due to inactivity**

</details>
