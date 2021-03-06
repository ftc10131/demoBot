package ftc10131.demoBot.robot.movers;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveTrain {

    public DcMotor frontLeft;
    public DcMotor frontRight;
    public DcMotor backLeft;
    public DcMotor backRight;

    int headingOffset;

    public DriveTrain(HardwareMap hardwareMap){
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");


    }

    public void init(){
        frontLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);

        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        headingOffset = 0;

        stop();
    }

    public void holoDrive(double x, double y, double turny){
        frontLeft.setPower(-y-x-turny);
        frontRight.setPower(-y+x+turny);
        backLeft.setPower(-y+x-turny);
        backRight.setPower(-y-x+turny);
    }
    public void holoGyro(double x, double y, double turny, int heading){
        heading += headingOffset;
        double headingX = x * Math.cos(((double)heading)/180.0*Math.PI)+ y * Math.sin(((double)heading)/180.0*Math.PI);
        double headingY = y * Math.cos(((double)heading)/180.0*Math.PI)- x * Math.sin(((double)heading)/180.0*Math.PI);
        holoDrive(headingX,headingY,turny);
    }
    public void stop(){
        holoDrive(0,0,0);
    }

    public void setHeadingOffset(int h){
        headingOffset = h;
    }







}
