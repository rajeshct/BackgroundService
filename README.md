# BackgroundService


EnqueueWork (Context context, Class cls, int jobId, Intent work)

Added the work to be executed into the queue.

On Android O and later, the deadline is set to 0, but it can be started at any time, due to issues such as doze state or running out of memory.
On pre-O, the background service will start by calling to startService(). Since it operates irrespective of the doze, the network timeout caused by Doze should be managed by yourself.
All jobIds targeted to the same class (cls) must all have the same value. If you want to assign a different jobId, you need to define it as a new class. If you do not follow this rule, you will not see any problem on pre-O, but Android O and later will throw IllegalArgumentException .
Of course, the work argument can not be null. If null, an IllegalArgumentException is thrown.


Things to Note

    When running on Android Oreo devices the JobIntentService uses the JobScheduler. This will handle the Wake Locks for you. On any device pre Android Oreo, the JobIntentService will set up Wake Locks through the PowerManager, so make sure you require the `WAKE_LOCK` permission in your manifest.

` <uses-permission android:name=”android.permission.WAKE_LOCK” />`

    When running on anything less than Android Oreo the service will start almost instantly.
    
    On Android Oreo it will be subject to JobScheduler policies, in other words it will not run while the device is dozing and may get delayed more than a usual service when the system is under heavy load.
    
    On pre Android Oreo the service can run indefinitely but on Android Oreo it will adhere to the usual JobService execution type limits. At which point it will stop (not the process) and continue execution at a later time.

 
