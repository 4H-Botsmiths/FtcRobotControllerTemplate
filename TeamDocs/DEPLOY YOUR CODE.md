# Deploying Your Code

Once you have [set up your editor](./SETTING%20UP%20YOUR%20EDITOR.md), you're ready to start coding

## Switching to your branch

This is what will allow you to code without modifying what's already on the robot.

1. In your editor, locate the button in the bottom left corner of your screen that shows your current "branch" (likely `master`)
   ![Changing your branch](./uploads/Change%20Branch.png)
2. This will open up a dialog to choose a branch. You are going to select `Create new branch from...`
   ![Creating a new branch](./uploads/Creating%20a%20Branch.png)
3. This will prompt you to choose the base branch. You are going to select `origin/master` (note that this is different from the plain `master` option, as it will include any potential changes in the cloud)
   ![Selecting a base branch](./uploads/Selecting%20Base%20Branch.png)
4. Now enter the name of your branch. It is recommended that you do it in the form of `your-username/what-you-are-doing` (ex. `username/basic-teleop`)
   ![Naming a branch](./uploads/Naming%20a%20branch.png)

You are now ready to start coding away! Note that this is your branch. Until you hit `Publish Branch`, no one else can even see your changes. However, if you are programming at the same time as someone else, make sure that you are editing different files. You will thank me later when you are not having to merge the edits of these two files into the `master` branch

## Merge your changes

So up until now you've been programming away, but none of these changes are on the robot yet. Even if you hit `Publish Branch` and `Sync` thereafter (**Which is highly recommended**), these changes will be pushed to the cloud, but not the robot.

1. Make sure that you hit `Publish Branch` if you haven't already already (and have synced any changes since then) - **it is recommended that you just build the habit to do this as you code so that it can be picked up on another device if needed**
   ![Publish Branch](./uploads/Publish%20Branch.png)
2. Navigate to the repo on github.com
3. Select the `Pull Requests` tab
   ![Pull Requests Tab](./uploads/Pull%20Request%20Tab.png)
4. Click `New Pull Request`
   ![New Pull Request Button](./uploads/Pull%20Request%20Button.png)
5. Make sure to change the repo for the base branch to the repo that you are programming in (in this case, `FtcBioBuzz`)
   ![Change Base Repo](./uploads/Change%20Base%20Repo.png)
6. At this point, fill out the template with what you have changed, optionally add someone as a reviewer (people can still review even if not assigned), and create the pull request
   ![Create Pull Request](./uploads/Create%20Pull%20Request.png)

### Merging you pull request

This part will vary slightly depending on the repositories rules for the year, but for the most part the following will be required:

- The `build` action **_ALWAYS_** needs to pass. This ensures that the code can compile to be deployed
- A reviewer is **_TYPICALLY_** required. This is a person who looks at what code you have changed and makes sure it looks good
  - To speed this up, there are a few things you can do:
    a) **Write a _clear_ summary of what you changed in the pull request description** - This lets the reviewer know what to expect when they look through your changes
    b) **Document your programs under the `TeamCode` folder** - ex. if you have a program at `TeamCode/src/main/java/org/firstinspires/ftc/teamcode/teleop/MyTeleopProgram.java`, you should have a corresponding documentation file at `TeamDocs/teleop/MyTeleopProgram.md` describing its behavior
    c) **Make clear code changes** - clear function & variable names; [JavaDoc Comments](https://www.geeksforgeeks.org/java/comments-in-java#3-documentation-comments) describing function inputs, outputs, and behaviors; [inline comments](https://www.geeksforgeeks.org/java/comments-in-java#1-singleline-comments) describing complex lines or math; and [multi-line comments](https://www.geeksforgeeks.org/java/comments-in-java#2-multiline-comments) for really complex lines or for chunks of code that you want temporarily suppressed

Once all of these requirements are met, you should see a green `Merge changes` button. If possible, use the dropdown to change this to `Rebase and merge` - this keeps a cleaner history. However, standard merges will not hurt the master branch
![Rebase and Merge Button](./uploads/Rebase%20and%20Merge.png)
