# P2PChatClient
I modifed the existing code from Ferrer. Each client will have two thread running at the same time: server and talker ( one for receiving and one for sending)

The Starter file will run the server thread wait 10000ms then run the talker thread( the message/port/host are currenly hardcoded, but we can easily integrated the UI into changing it)
I will create another class that will wait for user prompt to start the talker thread.
