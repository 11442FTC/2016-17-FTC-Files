package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;


public class HardwareTest{


    public DcMotor  leftMotor   = null;
    public DcMotor  rightMotor  = null;
    public DcMotor  slide       = null;



    HardwareMap hwMap  = null;
    private ElapsedTime period  = new ElapsedTime();



    public HardwareTest() {

    }


    public void init(HardwareMap ahwMap) {

        hwMap = ahwMap;

        leftMotor   = hwMap.dcMotor.get("left");
        rightMotor  = hwMap.dcMotor.get("right");
        leftMotor.setDirection(DcMotor.Direction.REVERSE);
        slide     = hwMap.dcMotor.get("slide");


        leftMotor.setPower(0);
        rightMotor.setPower(0);
        slide.setPower(0);


        leftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        slide.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


    }


}






