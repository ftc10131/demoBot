package ftc10131.demoBot.robot.movers;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class PhoneBranch {
   public Servo neck, spine;

   public PhoneBranch(HardwareMap hardwareMap){
       neck = hardwareMap.get(Servo.class, "neck");
       spine = hardwareMap.get(Servo.class, "spine");
   }
    public void init() {

       lookForward();

       layBack();
    }

    public void layBack() {
        spine.setPosition(0.2);
    }

    public void sitUp() {
        spine.setPosition(0.65);
    }

    public void lookLeft() {
        neck.setPosition(0);
    }
    public void lookRight (){
        neck.setPosition(0.9);
    }
    public void lookForward (){
        neck.setPosition(0.45);
    }
}

