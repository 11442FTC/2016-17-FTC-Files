package org.firstinspires.ftc.teamcode;

/**
 * Created by laura.denney on 11/9/2016.
 */
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;


public class BBHardware{


    public DcMotor  leftMotor;
    public DcMotor  rightMotor;
    public DcMotor  lift;
    public DcMotor  spin;
    public Servo    lefthand;
    public DcMotor  flick;
    public Servo    beacon;


    public final static double LEFTHAND_HOME = 1.0;
    public final static double LEFTHAND_MIN_RANGE  = 0.0;
    public final static double LEFTHAND_MAX_RANGE  = 1.0;

    public final static double BEACON_HOME = 0.7;
    public final static double BEACON_MIN_RANGE  = 0.0;
    public final static double BEACON_MAX_RANGE  = 1.0;



    HardwareMap hwMap  = null;
    private ElapsedTime period  = new ElapsedTime();

    public BBHardware() {

    }
    public void init(HardwareMap ahwMap) {

        hwMap = ahwMap;

        leftMotor   = hwMap.dcMotor.get("left");
        rightMotor  = hwMap.dcMotor.get("right");
        rightMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        flick  = hwMap.dcMotor.get("flick");

        lift = hwMap.dcMotor.get("lift");
        spin = hwMap.dcMotor.get("spin");

        lefthand = hwMap.servo.get("lefthand");
        beacon   = hwMap.servo.get("beacon");




        leftMotor.setPower(0);
        rightMotor.setPower(0);
        lift.setPower(0);
        spin.setPower(0);
        flick.setPower(0);



        leftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        lift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        flick.setMode(DcMotor.RunMode.RUN_USING_ENCODER);





    }


}