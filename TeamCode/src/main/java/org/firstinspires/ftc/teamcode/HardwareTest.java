package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;


public class HardwareTest{


    public DcMotor  leftMotor   = null;
    public DcMotor  rightMotor  = null;



    HardwareMap hwMap  = null;
    private ElapsedTime period  = new ElapsedTime();


    public HardwareTest() {

    }


    public void init(HardwareMap ahwMap) {

        hwMap = ahwMap;

        leftMotor   = hwMap.dcMotor.get("left motor");
        rightMotor  = hwMap.dcMotor.get("right motor");
        leftMotor.setDirection(DcMotor.Direction.REVERSE);


        leftMotor.setPower(0);
        rightMotor.setPower(0);


        leftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


    }


}






