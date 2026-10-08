# Camera

The `Camera` class provides functionality for interacting with the robot's camera, including pausing and resuming the camera stream, and detecting April Tags. It includes custom exceptions for handling camera-related errors such as when the camera is not attached or not streaming.

## Functions

- `initAprilTag()` - Initializes the April Tag detection system for the camera. (Will be called automatically when reading April Tags)
- `pause()` - Pauses the camera stream if it is currently streaming. This saves computing resources when the camera is not needed.
- `resume()` - Resumes the camera stream if it was previously paused. IMPORTANT: This process is not immediate; although it is fast it is recommended to not constantly pause and resume the stream as the resources saved are not beneficial.
- `getAprilTags()` - Retrieves the currently detected April Tags from the camera. Returns a list of `AprilTag` objects representing the detected tags.
- `getAprilTags(TeamColor teamColor)` - Retrieves the currently detected April Tags from the camera that match the specified team color. Returns a list of `AprilTag` objects representing the detected tags.

## Exceptions

- `CameraNotStreamingException` - Thrown when the camera is not currently streaming.
- `CameraNotAttachedException` - Thrown when the camera is not attached.
- `TagNotFoundException` - Thrown when the specified April Tag is not found.
