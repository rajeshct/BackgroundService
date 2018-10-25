# BackgroundService


EnqueueWork (Context context, Class cls, int jobId, Intent work)

Added the work to be executed into the queue.

On Android O and later, the deadline is set to 0, but it can be started at any time, due to issues such as doze state or running out of memory.
On pre-O, the background service will start by calling to startService(). Since it operates irrespective of the doze, the network timeout caused by Doze should be managed by yourself.
All jobIds targeted to the same class (cls) must all have the same value. If you want to assign a different jobId, you need to define it as a new class. If you do not follow this rule, you will not see any problem on pre-O, but Android O and later will throw IllegalArgumentException .
Of course, the work argument can not be null. If null, an IllegalArgumentException is thrown.

 
