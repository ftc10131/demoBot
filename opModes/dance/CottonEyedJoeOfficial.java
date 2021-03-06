/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package ftc10131.demoBot.opModes.dance;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import ftc10131.demoBot.robot.RobotDemo;
import ftc10131.demoBot.robot.util.AudioPlayer;


/**
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot
 * It includes all the skeletal structure that all linear OpModes contain.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@Autonomous(name="CottonEyedJoe", group="Dance")
//@Disabled
public class CottonEyedJoeOfficial extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    public RobotDemo demoBot;
    double timeTarget;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        demoBot = new RobotDemo(hardwareMap);
        demoBot.init();

        demoBot.phoneBranch.sitUp();
        demoBot.phoneBranch.lookForward();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        AudioPlayer.init(hardwareMap.appContext, "cottoneyedjoeonbeat.mp3");
        AudioPlayer.start(hardwareMap.appContext);
        runtime.reset();
        timeTarget = 0;

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            /////A step is 455 ms
            /////////Kick///////////////////////////////
            demoBot.phoneBranch.lookForward();
            demoBot.phoneBranch.spine.setPosition(0.85);
            wait(227);
            demoBot.phoneBranch.spine.setPosition(0.70);
            wait(227);
            demoBot.phoneBranch.spine.setPosition(0.85);
            wait(227);
            demoBot.phoneBranch.spine.setPosition(0.70);
            wait(227);
            /////
            demoBot.phoneBranch.spine.setPosition(0.35);
            wait(227);
            demoBot.phoneBranch.spine.setPosition(0.50);
            wait(227);
            demoBot.phoneBranch.spine.setPosition(0.35);
            wait(227);
            demoBot.phoneBranch.spine.setPosition(0.50);
            wait(227);

            ////////////////////////////////////////////
            /////////Side Kick//////////////////////////

            demoBot.phoneBranch.spine.setPosition(0.85);
            demoBot.phoneBranch.neck.setPosition(0.2);
            wait(455);
            demoBot.phoneBranch.neck.setPosition(0.7);
            wait(455);
            demoBot.phoneBranch.spine.setPosition(0.35);
            demoBot.phoneBranch.neck.setPosition(0.2);
            wait(455);
            demoBot.phoneBranch.neck.setPosition(0.7);
            wait(455);

            ////////////////////////////////////////////
            ////////Move Normally///////////////////////

            demoBot.driveTrain.holoDrive(1,0,0);
            demoBot.phoneBranch.sitUp();
            demoBot.phoneBranch.lookForward();
            wait(1820);

            ////////////////////////////////////////////
            ////////Move and Spin///////////////////////

            demoBot.driveTrain.holoDrive(-1,0,0);
            wait(1820);
            demoBot.driveTrain.stop();

        }
        AudioPlayer.stop();
    }

    public void wait(int milliseconds){
        timeTarget+= milliseconds;
        while(opModeIsActive()&& (timeTarget > runtime.milliseconds())){
            sleep(10);
        }
    }

}
