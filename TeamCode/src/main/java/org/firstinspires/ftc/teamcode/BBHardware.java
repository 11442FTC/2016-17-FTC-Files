package org.firstinspires.ftc.teamcode;

/**
 * Created by laura.denney on 11/9/2016.
 */
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;


public class BBHardware{


    public DcMotor  leftMotor   = null;
    public DcMotor  rightMotor  = null;

    public Servo clawRight   = null;
    public Servo clawLeft    = null;



    final static double CLAWRIGHT_MIN_RANGE  = 0.00;
    final static double CLAWRIGHT_MAX_RANGE  = 1.00;
    final static double CLAWLEFT_MIN_RANGE  = 0.00;
    final static double CLAWLEFT_MAX_RANGE  = 1.00;

    double clawRightPosition;
    double clawRightDelta = 0.1;

    double clawLeftPosition;
    double clawLeftDelta = 0.1;


    HardwareMap hwMap  = null;
    private ElapsedTime period  = new ElapsedTime();



    public BBHardware() {

    }


    public void init(HardwareMap ahwMap) {

        hwMap = ahwMap;

        leftMotor   = hwMap.dcMotor.get("left");
        rightMotor  = hwMap.dcMotor.get("right");
        leftMotor.setDirection(DcMotor.Direction.REVERSE);

        clawRight   = hwMap.servo.get("clawR");
        clawLeft    = hwMap.servo.get("clawL");


        clawRightPosition = 0.0;
        clawLeftPosition = 0.0;

        leftMotor.setPower(0);
        rightMotor.setPower(0);


        leftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


    }


}