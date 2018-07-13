package ftc10131.demoBot.robot;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IntegratingGyroscope;

import ftc10131.demoBot.robot.movers.DriveTrain;
import ftc10131.demoBot.robot.movers.PhoneBranch;

public class RobotDemo {
    public DriveTrain driveTrain;
    public PhoneBranch phoneBranch;
    public ModernRoboticsI2cGyro gyro;

    public RobotDemo(HardwareMap hardwareMap){
        driveTrain = new DriveTrain(hardwareMap);
        phoneBranch = new PhoneBranch(hardwareMap);

        gyro = hardwareMap.get(ModernRoboticsI2cGyro.class, "gyro");
        // If you're only interested int the IntegratingGyroscope interface, the following will suffice.
        // gyro = hardwareMap.get(IntegratingGyroscope.class, "gyro");
        // A similar approach will work for the Gyroscope interface, if that's all you need.

        // Start calibrating the gyro. This takes a few seconds and is worth performing
        // during the initialization phase at the start of each opMode.

    }

    public void init(){

        phoneBranch.init();
        driveTrain.init();

        gyro.calibrate();
    }

}
