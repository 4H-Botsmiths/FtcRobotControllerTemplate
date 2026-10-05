# The Deploy Process

This document outlines the deploy process that takes place after you merge changes into the `master` branch. If you want to learn how to make changes to merge into `master`, check out [Deploying Your Code](./DEPLOY%20YOUR%20CODE.md)

## The build process

There are two things that trigger your code to be built:

- `Opening a pull request` - This build process is not just to make sure that your code can compile, but it is actually cached to use in the deploy if you merge the branch
- `Manually requesting a build` - You can go to `Github>Repo>Action>build>Run Workflow` and request a build from there
  Both of these options run the same build process, and you should never need to run a manual build, but the option is there.

## The deploy process

Like the build process, there are two ways to trigger the deploy process

- `Merging a pull request` - When you merge a pull request, it will trigger a deploy to run using the latest build artifact from opening the request (which will always be present since that is a required step to merge a pull request)
- `Manually requesting a deploy` - Just as you can manually request a build, you can also manually request a deploy. To do this you will need to have the id of the build run you want to deploy (the easiest way to find this is to open up the build you want to deploy, and copy the id in the url at `https://github.com/4H-Botsmiths/REPO/actions/runs/BUILD_RUN_ID`)

This will trigger a deploy on the first runner available

### The deploy runner

The code is compiled in the cloud, but when it is time to deploy that compiled code it must be done on something connected to the robot. This is where a "Runner" comes in.

A runner is just like the servers that Github Actions typically uses, except rather than being somewhere in the cloud it is kept locally. Typically for our team, we use a Raspberry Pi because it is cheaper, small, and uses very little power.

So what does this mean for you? It's actually pretty simple:

1. Connect the Raspberry Pi to power (Typically we do this either by plugging it into a battery pack or using one of the USB-A ports on the Robot Controller - Just know that if you are powering the pi off of the robot and the battery gets too low, the pi will shut down)
2. Use an A to C cable to connect one of the Raspberry Pi's USB-A ports to the Control Hubs USB-C port
3. Merge a pull request/manually request a deploy (if you already did this since the last deploy and Github's Actions page shows the job as "waiting for a runner", then it should pick it up automatically)
> - Note that only the latest deploy request is used. If you merge two pull requests since the last merge the `deploy` of all the pull requests other than the latest one will be ignored
> - If the Pi is on, but the deploy job is not being picked up, try pinging it. Currently the Pi's hostname is `robot-deployer`, so try running `ping robot-deployer.local`
>   - If this succeeds, the pi is online and connected to Wifi, but it's possible that the runner service failed to start. Reboot the Pi or check the [Troubleshooting Guide](./ADMIN.README.md#troubleshooting) for more info
>   - If this fails, the Pi is not connected to the network. Make sure that your phone can see the wifi and that the password has not changed. If you can see the wifi, try rebooting the Pi to reconnect it to the network.
4. Through the Actions tab on the github repo, you will be able to track the progress of the deploy process. 
5. Once the deploy process is complete, the robot will reboot to apply the changes. (So you can also just watch for the robot to reboot to know that the deploy was successful)