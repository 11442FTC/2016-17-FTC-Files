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
    public DcMotor  lift        = null;
    public DcMotor  spin        = null;
    public Servo    lefthand        = null;
    public DcMotor  flick;


    public final static double LEFTHAND_HOME = 1.0;
    public final static double LEFTHAND_MIN_RANGE  = 0.0;
    public final static double LEFTHAND_MAX_RANGE  = 1.0;



    HardwareMap hwMap  = null;
    private ElapsedTime period  = new ElapsedTime();

    public BBHardware() {

    }
    public void init(HardwareMap ahwMap) {

        hwMap = ahwMap;

        leftMotor   = hwMap.dcMotor.get("left");
        rightMotor  = hwMap.dcMotor.get("right");
        leftMotor.setDirection(DcMotor.Direction.REVERSE);
        flick  = hwMap.dcMotor.get("flick");

        lift = hwMap.dcMotor.get("lift");
        spin = hwMap.dcMotor.get("spin");




        leftMotor.setPower(0);
        rightMotor.setPower(0);
        lift.setPower(0);
        spin.setPower(0);
        flick.setPower(0);



        leftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        lift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        flick.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        lefthand = hwMap.servo.get("lefthand");



    }


}