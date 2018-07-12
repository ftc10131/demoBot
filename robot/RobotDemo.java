package ftc10131.demoBot.robot;

import com.qualcomm.robotcore.hardware.HardwareMap;

import ftc10131.demoBot.robot.movers.DriveTrain;
import ftc10131.demoBot.robot.movers.PhoneBranch;

public class RobotDemo {
    public DriveTrain driveTrain;
    public PhoneBranch phoneBranch;

    public RobotDemo(HardwareMap hardwareMap){
        driveTrain = new DriveTrain(hardwareMap);
        phoneBranch = new PhoneBranch(hardwareMap);
    }

    public void init(){

        phoneBranch.init();
        driveTrain.init();
    }

}
