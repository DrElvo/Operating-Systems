@echo off

//THIS FILE IS ALREADY INSIDE THE MAIN os-coursework11 FILE UNDER src AS REQUESTED

set jpath=.

set experiment=experiment1 experiment2 experiment3 experimentControl

set experimentSeeds=3

set schedulers=RR IdealSJF FeedbackRR SJF Fcfs



for %%i in (%experiment%) do (

    for /l %%j in (1, 1, %experimentSeeds%) do (

        for %%k in (%schedulers%) do (

            java -cp .\target\os-coursework1-1.0-SNAPSHOT.jar InputGenerator "%jpath%\%%i\seed%%j\%%k\input_parameters.prp" "%jpath%\%%i\seed%%j\%%k\inputs.in"
            java -cp .\target\os-coursework1-1.0-SNAPSHOT.jar Simulator "%jpath%\%%i\seed%%j\%%k\simulator_parameters.prp" "%jpath%\%%i\seed%%j\%%k\output.out" "%jpath%\%%i\seed%%j\%%k\inputs.in"

		)

    )

)


